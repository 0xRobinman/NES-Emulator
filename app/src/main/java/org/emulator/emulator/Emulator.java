package org.emulator.emulator;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;

import org.emulator.apu.Apu;
import org.emulator.arg.ArgsHandler;
import org.emulator.cpu.Cpu;
import org.emulator.debug.Debug;
import org.emulator.memory.Ram;
import org.emulator.ppu.Ppu;


public class Emulator implements Runnable {

    private boolean verbose = false;
    private BufferedImage image;
    private Canvas gameCanvas;
    private Graphics g;
    private BufferStrategy bs;
    private final int FPS = 60;
    private final double FRAME_INTERVAL = 1.0 / FPS;
    private final static int WINDOW_WIDTH = 768, WINDOW_HEIGHT = 720;


    public Emulator() {}
    
    public Emulator(ArgsHandler argsHandler) {
        this.verbose = argsHandler.getVerbose();
    }
    

    private Canvas createCanvas() {
        Canvas canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        return canvas;
    }

    private void createGameWindow() {
        image = new BufferedImage(256, 240, BufferedImage.TYPE_INT_RGB);
        gameCanvas = createCanvas();
        JFrame window = new JFrame("NES Emulator");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(gameCanvas);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setResizable(true);
        window.setVisible(true);
    }

    private File getInputFile() {
        JFileChooser j = new JFileChooser("");
        j.setFileFilter(new FileFilter() {

            @Override
            public boolean accept(File file) {
                if (file.isDirectory()) {
                    return true;
                } else {
                    String filename = file.getName().toLowerCase();
                    return filename.endsWith(".nes");
                }
            }

            @Override
            public String getDescription() {
                return "NES Files (*.nes)";
            }
            
        });
        j.setAcceptAllFileFilterUsed(false);
       
        if (j.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            if (verbose)
                System.out.println(j.getSelectedFile().getAbsoluteFile());

            return j.getSelectedFile();
        }

        return null;
    }

    private void parseHeader(InputStream inputStream) throws IOException {
        // First 16 bytes of a NES file is 'NES + magic number'.
        byte[] header = new byte[16];
        byte[] magicString = {'N', 'E', 'S', 0x1A};

        if (inputStream.read(header) == 16) {
            // Check magic string
            for (int i = 0; i < magicString.length; i++) {
                if (header[i] != magicString[i])
                    throw new IOException("Not in '.NES' format");
            }

            int programROMSize = (header[4] << 14),
                characterRomSize = header[5] << 13;
            
            // Handle flags 6/7.
            
            int programRomSizeKB = programROMSize >> 10,
                characterRomSizeKB = characterRomSize >> 10;

            if (verbose) {
                Debug.printDebug("PGROM: " + programRomSizeKB + "kb", (programRomSizeKB == 16 || programRomSizeKB == 32));
                Debug.printDebug("CHROM: " + characterRomSizeKB + "kb", (characterRomSizeKB == 8));
            }

            byte[] programROM = new byte[programROMSize];
            byte[] characterROM = new byte[characterRomSize];

            // Mirror 
            if (inputStream.read(programROM) != programROMSize) 
                throw new IOException("Invalid file format.");

            if (verbose) 
                Debug.printDebug("Loaded PGROM", true);
            
            if (programRomSizeKB == 16) {
                Ram.write((short)0x8000, programROM);
                Ram.write((short)0xC000, programROM);
            } else {
                Ram.write((short)0x8000, programROM);
            }
            
            if (characterRomSizeKB != 0) {
                if (inputStream.read(characterROM) != characterRomSize) 
                    throw new IOException("Invalid file format.");
                Ram.write((short)0x0000, characterROM);
                if (verbose)
                    Debug.printDebug("Loaded CHROM", true);
            }


        } else {
            throw new IOException("Invalid file format.");
        }
          
    }

    private void loadIntoMemory(File inputFile) {

        try (InputStream inputStream = new FileInputStream(inputFile)) {
            
            parseHeader(inputStream);
            while (inputStream.read() != -1)
                ;
            inputStream.close();
        } 
        catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }
    
    @Override
    public void run() {
        File inputFile;
        if ((inputFile = getInputFile()) == null) 
            return;
        
        createGameWindow();
        
        gameCanvas.createBufferStrategy(2);
        bs = gameCanvas.getBufferStrategy();

        // Handle the input file and load game into memory
        loadIntoMemory(inputFile);

        Cpu cpu = new Cpu();
        Ppu ppu = new Ppu(image);
        Apu apu = new Apu();

        nesGameLoop(cpu, ppu, apu);
    
    }   

    /**
     * 60FPS Game loop
     */
    @SuppressWarnings("empty-statement")
    private void nesGameLoop(Cpu cpu, Ppu ppu, Apu apu) {

        cpu.readResetVector();

        boolean dropFrame = false;
        double currentTime = 0, previousTime = System.nanoTime() / 1e9, deltaTime = 0, accumulatedTime = 0;
        
        while(true) 
        {
            
            currentTime = System.nanoTime() / 1e9;
            deltaTime = currentTime - previousTime;
            previousTime = currentTime;
            accumulatedTime += deltaTime;
                                   
            for (dropFrame = !(accumulatedTime >= FRAME_INTERVAL); !dropFrame && accumulatedTime >= FRAME_INTERVAL; accumulatedTime -= FRAME_INTERVAL)
                ;

            handleFrame(cpu, ppu, apu, dropFrame);
        }
    }



    private void easeUsage() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) { }
    }

    private void handleFrame(Cpu cpu, Ppu ppu, Apu apu, boolean dropFrame) {
        if (!dropFrame)  
            renderFrame(cpu, ppu, apu);
        else
            easeUsage();
    }

    private void renderFrame(Cpu cpu, Ppu ppu, Apu apu) {
        while (!ppu.polFrame()) {
            executeTicks(cpu, ppu, apu);
        }
        update();
    }

    private void executeTicks(Cpu cpu, Ppu ppu, Apu apu)
    {
        int clockCycles = cpu.executeCycle();
        for (int i = 0; i < clockCycles * 3; i++)       // For each CPU tick, 3 PPU ticks occur
            ppu.ppuTick();
        for (int i = 0; i < clockCycles; i++)
            apu.tick();       
    }
    public void update() 
    {
        g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, gameCanvas.getWidth(), gameCanvas.getHeight(), null);
        bs.show();
    }
    public static void main(String[] args) 
    {
        ArgsHandler arguments = new ArgsHandler(args);
        Emulator emulator = new Emulator(arguments);
        Thread emulatorThread = new Thread(emulator);
        emulatorThread.start();
    }
}