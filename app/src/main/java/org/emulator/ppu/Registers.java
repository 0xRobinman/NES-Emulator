package org.emulator.ppu;

import org.emulator.memory.Ram;

public class Registers {

    private final static short CONTROL_ADDRESS = 0x2000;
    private final static short MASK_ADDRESS = 0x2001;
    private final static short STATUS_ADDRESS = 0x2002;
    private final static short OAM_ADDRESS_ADDRESS = 0x2003;
    private final static short OAM_DATA_ADDRESS = 0x2004;
    private final static short SCROLL_ADDRESS = 0x2005;
    private final static short VRAM_ADDRESS_ADDRESS = 0x2006;
    private final static short VRAM_DATA_ADDRESS = 0x2007; 
    private final static short OAM_DMA_ADDRESS = 0x4014;

    private final static byte V_BLANK_MASK = (byte)0x80;
    
    public static void setVBlank(boolean vBlank) {
        byte status = Ram.read(STATUS_ADDRESS);
        if (vBlank) 
            status |= V_BLANK_MASK;
        else 
            status &= ~V_BLANK_MASK;

        Ram.write(STATUS_ADDRESS, status);
    }


    /**
     * Set all registers to 0x00
     */
    public static void reset() 
    {
        setControlRegister((byte)0x00);
        setMaskRegister((byte)0x00);
        setStatusRegister((byte)0x00);
        setOAMAddressRegister((byte)0x00);
        setOAMDataRegister((byte)0x00);
        setScrollRegister((byte)0x00);
        setVRAMAddressRegister((byte)0x00);
        setVRAMDataRegister((byte)0x00);
        setOAM_DMARegister((byte)0x00);
    }

    public static byte getControlRegister()
    {
        return Ram.read(CONTROL_ADDRESS);   
    }

    public static void setControlRegister(byte value)
    {
        Ram.write(CONTROL_ADDRESS, value);   
    }

    public static byte getMaskRegister() 
    {
        return Ram.read(MASK_ADDRESS);
    }
    
    public static void setMaskRegister(byte value) 
    {
        Ram.write(MASK_ADDRESS, value);
    }

    public static byte getStatusRegister() 
    {
        return Ram.read(STATUS_ADDRESS);
    }

    public static void setStatusRegister(byte value) 
    {
        Ram.write(STATUS_ADDRESS, value);
    }

    public static byte getOAMAddressRegister() 
    {
        return Ram.read(OAM_ADDRESS_ADDRESS);
    }

    public static void setOAMAddressRegister(byte value) 
    {
        Ram.write(OAM_ADDRESS_ADDRESS, value);
    }

    public static byte getOAMDataRegister() 
    {
        return Ram.read(OAM_DATA_ADDRESS);
    }

    public static void setOAMDataRegister(byte value) 
    {
        Ram.write(OAM_DATA_ADDRESS, value);
    }

    public static byte getScrollRegister() 
    {
        return Ram.read(SCROLL_ADDRESS);
    }

    public static void setScrollRegister(byte value) 
    {
        Ram.write(SCROLL_ADDRESS, value);
    }

    public static byte getVRAMAddressRegister() 
    {
        return Ram.read(VRAM_ADDRESS_ADDRESS);
    }

    public static void setVRAMAddressRegister(byte value) 
    {
        Ram.write(VRAM_ADDRESS_ADDRESS, value);
    }

    public static byte getVRAMDataRegister() 
    {
        return Ram.read(VRAM_DATA_ADDRESS);
    }

    public static void setVRAMDataRegister(byte value) 
    {
        Ram.write(VRAM_DATA_ADDRESS, value);
    }

    public static void setOAM_DMARegister(byte value) 
    {
        Ram.write(OAM_DMA_ADDRESS, value);
    }




}
