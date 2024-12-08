package org.emulator.ppu;

import java.awt.Graphics;
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

    BufferedImage frameBuffer;
    private int cycle = 0, line = 0;

    public Ppu() {
        frameBuffer = new BufferedImage(SCREEN_WIDTH, SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);
    }

    private void handleScanLineEnd() {

    }

    private void handleVisibleScanLines() {
    }


    private void handlePreRenderLine() {

    }
    
    private void handleVBlank() {

    }


    private void ppuTick() {
        cycle++;
        renderPixel();
        handleVBlank();
        handleScanLineEnd();
        handleVisibleScanLines();
        handlePreRenderLine();
    }

    private int fetchSpritePixel(int x, int y) {
        
        return 0;
    }

    private int fetchBackgroundPixel(int x, int y) {
        return 0;
    }

    private void renderPixel() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(frameBuffer, 0, 0, getWidth(), getHeight(), null);
        ppuTick();
    }



    
}
