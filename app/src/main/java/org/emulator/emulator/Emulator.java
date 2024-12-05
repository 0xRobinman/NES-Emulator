package org.emulator.emulator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;

import org.emulator.arg.ArgsHandler;
import org.emulator.cpu.Cpu;
import org.emulator.debug.Debug;
import org.emulator.memory.Ram;
import org.emulator.ppu.Ppu;


public class Emulator {

    private boolean verbose = false;
    
    public Emulator() {}
    
    public Emulator(ArgsHandler argsHandler) {
        this.verbose = argsHandler.getVerbose();
    }
    
    private JFrame createWindow() {
        JFrame window;
        window = new JFrame("NES Emulator");
        window.setSize(768, 720);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        return window;
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

            int data;
            while ((data = inputStream.read()) != -1) {
                // Process the read data
                //System.out.print(data);
            }
            inputStream.close();
        } 

        catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    public void startEmulator() {
        File inputFile;
        if ((inputFile = getInputFile()) == null) 
            return;
        
        JFrame window = createWindow();
        
        // Handle the input file and load game into memory
        loadIntoMemory(inputFile);

        Cpu cpu = new Cpu();
        cpu.readResetVector();

        // Start graphics processing
        Ppu ppu = new Ppu();
        window.add(ppu);
        window.setVisible(true);

        
        // Start CPU.
        while(true) {
            cpu.executeCycle();
            ppu.repaint();
        }
    }

    public static void main(String[] args) {
        ArgsHandler arguments = new ArgsHandler(args);
        Emulator emulator = new Emulator(arguments);
        emulator.startEmulator();

    }
}