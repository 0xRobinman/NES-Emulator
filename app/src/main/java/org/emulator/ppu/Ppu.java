package org.emulator.ppu;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 * Picture processing unit
 */
public class Ppu extends JPanel {
    private static final int LINES = 262;
    private static final int CYCLES = 341;
    private static final int VISIBLE_LINE_START = 0;
    private static final int VISIBLE_LINE_END = 240;
    private static final int SPRITE_START = 256;
    private static final int SPRITE_END = 240;
    private static final int VBLANK_START = 241;
    private static final int VBLANK_END = 262;
    private static final int SCREEN_HEIGHT = 240; // NES resolution height
    private static final int SCREEN_WIDTH = 256;
    
    private static final int[] COLOUR_PALLETTE = {
        0x757575, 0x271B8F, 0x0000AB, 0x47009F, 0x8F0077, 0xAB0013, 0xA70000, 0x7F0B00,
        0x432F00, 0x004700, 0x005100, 0x003F17, 0x1B3F5F, 0x000000, 0x000000, 0x000000,
        0xBCBCBC, 0x0073EF, 0x233BEF, 0x8300F3, 0xBF00BF, 0xE7005B, 0xDB2B00, 0xCB4F0F,
        0x8B7300, 0x009700, 0x00AB00, 0x00933B, 0x00838B, 0x000000, 0x000000, 0x000000,
        0xFFFFFF, 0x3FBFFF, 0x5F73FF, 0xA78BFD, 0xF77BFF, 0xFF77B7, 0xFF7763, 0xFF9B3B,
        0xF3BF3F, 0x83D313, 0x4FDF4B, 0x58F898, 0x00EBDB, 0x000000, 0x000000, 0x000000,
        0xFFFFFF, 0xABE7FF, 0xC7D7FF, 0xD7CBFF, 0xFFC7FF, 0xFFC7DB, 0xFFBFB3, 0xFFDBAB,
        0xFFE7A3, 0xE3FFA3, 0xABF3BF, 0xB3FFCF, 0x9FFFF3, 0x000000, 0x000000, 0x000000
    };

    private int[] screenBuffer;
    private BufferedImage screen;
    private int cycle = 0, line = 0, frame = 0;
    private Graphics2D g;
    public Ppu() {  
    }

    public void init() {
        screen = new BufferedImage(SCREEN_WIDTH, SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) screen.getGraphics();
        screenBuffer = new int[SCREEN_WIDTH * SCREEN_HEIGHT];
    }

    private void setPixel(int x, int y, int colour) {
        screenBuffer[y * SCREEN_WIDTH + x] = colour;
    }

    private byte fetchTile(int x, int y) {
        // Get tile coords
        int tileX = x / 8, tileY = y / 8;
        int offset = tileY * 32 + tileX;
        return Memory.readNameTableMemory((short)offset);
    }

    private byte fetchAttribute(int x, int y) {
        int tileX = x /16, tileY = y / 16;

        int quadX = (x % 16) / 8, quadY = (y % 16) / 8;
        int quadrant = quadY * 2 + quadX;

        int offset = tileY * 8 + tileX;

        byte attribute = Memory.readAttribute((short)offset);
        
        attribute >>= (quadrant * 2);
        attribute &= 0x03;
        return attribute;

    }   


    private int fetchColourIndex(int x, int y) {
        // Get tile
        int tile = fetchTile(x, y);
        int attribute = fetchAttribute(x, y);
        int colourIndex = 0;

        int offset = tile * 16;
        int tileYOffset = y % 8, tileXOffset = x % 8;
        offset += tileYOffset;


        byte lowerByte = Memory.readPatternMemory((short)offset);
        offset += 8;
        byte higherByte = Memory.readPatternMemory((short)offset);
        

        int bit = 7 - tileXOffset;


        int pixelLow = (lowerByte >> bit) & 0x01;
        int pixelHigh = (higherByte >> bit) & 0x01;
    
        // Combine to form the final palette index
        int paletteIndex = (attribute << 2) | (pixelHigh << 1) | pixelLow;


        return paletteIndex;
    }


    public void ppuTick() {

        // Clear VBLank
        if (line == 261 && cycle == 1) 
            Registers.setVBlank(false);
        
        // Set VBlank
        if (line == 241 && cycle == 1)
            Registers.setVBlank(true);
        
        // Render visible scanlines
        if (line >= 0 && line <= 239 && cycle >= 1 && cycle <= 256) {
            // Render pixel
            int x = cycle - 1, y = line;

            int colour = fetchColourIndex(x, y);
            colour = COLOUR_PALLETTE[colour];
            setPixel(x, y, colour);

        }

        // Render visible region
        if (cycle >= 1 && cycle <= 256) {

        }

        // Handle sprites
        if (cycle >= 257 && cycle <= 320) {

        }

        // Load data for next scanline
        if (cycle >= 321 && cycle <= 340) {

        }

        cycle++;
        if (cycle == 341) {

            cycle = 0;
            line++;
            if (line == 262) {
                line = 0;
                frame++;
                screen.setRGB(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, screenBuffer, 0, 256);
            }
        }
        
    }

    public void update()
    {
        Graphics g2 = this.getGraphics();
        g2.drawImage(screen, 0, 0, getWidth(), getHeight(), null);
        g2.dispose();
    }

}
