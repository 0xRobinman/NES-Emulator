package org.emulator.ppu;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import org.emulator.cpu.Cpu;

/**
 * Picture processing unit
 */
public class Ppu {
    private static final int MAX_LINES = 262;
    private static final int MAX_CYCLES = 341;
    private static final int CYCLE_START = 1;
    private static final int VISIBLE_LINE_START = 0;
    private static final int VISIBLE_LINE_END = 239;
    private static final int SPRITE_START = 257;
    private static final int SPRITE_END = 230;
    private static final int VBLANK_START = 241;
    private static final int VBLANK_END = 261;
    private static final int SCREEN_HEIGHT = 240;
    private static final int SCREEN_WIDTH = 256;
    private static final int SPRITE_COUNT = 64;
    private static final int SPRITE_SIZE = 4;
    private static final int SPRITE_WIDTH = 8;
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
    private byte[] oam;
    private BufferedImage screen;
    private int cycle = 0, line = 0;
    private boolean frameComplete = false;

    public Ppu(BufferedImage image) {
        screen = image;
        screenBuffer = new int[SCREEN_WIDTH * SCREEN_HEIGHT];
        oam = new byte[256];
    }

    private void setPixel(int x, int y, int colour) {
        screenBuffer[y * SCREEN_WIDTH + x] = colour;
    }

    private byte fetchTile(int x, int y) {
        // Get tile coords
        int tileX = x / 8, tileY = y / 8;
        int offset = tileY * 32 + tileX;
        return Memory.readNameTableMemory((short) offset);
    }

    private byte fetchAttribute(int x, int y) {
        int tileX = x / 16, tileY = y / 16;

        int quadX = (x % 16) / 8, quadY = (y % 16) / 8;
        int quadrant = quadY * 2 + quadX;

        int offset = tileY * 8 + tileX;

        byte attribute = Memory.readAttribute((short) offset);

        attribute >>= (quadrant * 2);
        attribute &= 0x03;
        return attribute;

    }

    private int fetchColourIndex(int x, int y) {
        int tile = fetchTile(x, y);
        int attribute = fetchAttribute(x, y);

        int offset = tile * 16;
        int tileYOffset = y % 8, tileXOffset = x % 8;
        offset += tileYOffset;

        byte lowerByte = Memory.readPatternMemory((short) offset);
        offset++;
        byte higherByte = Memory.readPatternMemory((short) offset);

        int bit = 7 - tileXOffset;

        int pixelLow = (lowerByte >> bit) & 0x01;
        int pixelHigh = (higherByte >> bit) & 0x01;

        // Combine to form the final palette index
        return (attribute << 2) | (pixelHigh << 1) | pixelLow;
    }

    private int fetchSpriteColourIndex(int x, int y) {

        int height = Registers.getSize();

        return 0;
    }

    /**
     * Everything performed on a PPU tick
     */
    public void ppuTick() {

        if (line >= VBLANK_START && line <= VBLANK_END) {
            // Write OAM Data
            int index = Registers.getOAMAddressRegister();
            byte value = Registers.getOAMDataRegister();

            if (index >= 0 && index < oam.length) {
                oam[index] = value;
                Registers.setOAMAddressRegister((byte) ((index + 1) % 256));
            }
        }

        // Clear VBLank
        if (line == VBLANK_END && cycle == CYCLE_START)
            Registers.setVBlank(false);

        // Set VBlank
        if (line == VBLANK_START && cycle == CYCLE_START) {
            Registers.setVBlank(true);
            if (Registers.isNMIMaskEnabled()) {
                Cpu.NmiInterrupt();
            }
        }

        // Render visible scanlines
        if (line >= VISIBLE_LINE_START && line <= VISIBLE_LINE_END && cycle >= CYCLE_START && cycle <= SCREEN_WIDTH) {
            // Render pixel
            int x = cycle - 1, y = line;
            int colour = fetchColourIndex(x, y);

            if (fetchSpriteColourIndex(x, y) != 0)
                colour = fetchSpriteColourIndex(x, y);

            colour = COLOUR_PALLETTE[colour];
            setPixel(x, y, colour);

        }

        // Handle sprites
        if (cycle >= SPRITE_START && cycle <= SPRITE_END) {
            handleSprites();
        }

        // Load data for next scanline
        if (cycle >= 321 && cycle <= 340) {

        }

        cycle++;
        if (cycle == MAX_CYCLES) {
            cycle = 0;
            line++;
            if (line == MAX_LINES) {
                line = 0;
                frameComplete = true;
                screen.setRGB(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, screenBuffer, 0, 256);
            }
        }

    }

    /**
     * Handle the sprites
     */
    private void handleSprites() {

        int height = Registers.getSize();

        for (int i = 0; i < SPRITE_COUNT; i++) {
            int spritePosition = i * SPRITE_SIZE;

            int y = oam[spritePosition] & 0xFF,
                    x = oam[spritePosition + 3] & 0xFF,
                    tile = oam[spritePosition + 1] & 0xFF,
                    attribute = oam[spritePosition + 2] & 0xFF;

            // Check if we are in the bounds of the sprite
            if (line >= y && line < (y + height)) {
                int spriteRow = line - y;

                // If vertical flipping
                if ((attribute & 0x80) != 0) {
                    spriteRow = height - 1 - spriteRow;
                }

                int tilePos = (tile * 16) + spriteRow;

                byte lowerByte = Memory.readPatternMemory((short) tilePos);
                byte higherByte = Memory.readPatternMemory((short) (tilePos + 1));

                for (int j = 0; j < SPRITE_WIDTH; j++) {
                    int bit = (attribute & 0x40) != 0 ? j : (7 - j); // Horizontal flipping
                    int pixelLow = (lowerByte >> bit) & 0x01;
                    int pixelHigh = (higherByte >> bit) & 0x01;
                    int paletteIndex = (pixelHigh << 1) | pixelLow;

                    if (paletteIndex == 0)
                        continue; // Transparent pixel

                    int screenX = x + j;
                    if (screenX >= 0 && screenX < SCREEN_WIDTH && line >= 0 && line < SCREEN_HEIGHT) {
                        // int paletteBase = 0x3F10 + ((attribute & 0x03) << 2);
                        int color = Memory.readPaletteMemory(((short) (((attribute & 0x03) << 2) + paletteIndex)));

                        // Priority handling (e.g., background vs. sprite)
                        if ((attribute & 0x20) == 0 || screenBuffer[line * SCREEN_WIDTH + screenX] == 0) {
                            screenBuffer[line * SCREEN_WIDTH + screenX] = COLOUR_PALLETTE[color];
                        }
                    }
                }

            }

        }
    }

    /**
     * Determine if the whole canvas has rendered or not.
     */
    public boolean polFrame() {
        if (frameComplete) {
            frameComplete = false;

            return true;
        }
        return false;
    }

    protected void paintComponent(Graphics g) {
        if (screen != null)
            g.drawImage(screen, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, null);
    }

}
