package org.emulator.ppu;

import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Picture processing unit
 */
public class Ppu extends JPanel {


    private final int MAX_ADDRESS = 0x3FFF;


    public Ppu() {}



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Ensures the panel is cleared before repainting
        
    }



    
}
