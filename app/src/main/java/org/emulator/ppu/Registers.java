package org.emulator.ppu;

import org.emulator.memory.Ram;

public class Registers {

    private final short CONTROL_ADDRESS = 0x2000;
    private final short MASK_ADDRESS = 0x2001;
    private final short STATUS_ADDRESS = 0x2002;
    private final short OAM_ADDRESS_ADDRESS = 0x2003;
    private final short OAM_DATA_ADDRESS = 0x2004;
    private final short SCROLL_ADDRESS = 0x2005;
    private final short VRAM_ADDRESS_ADDRESS = 0x2006;
    private final short VRAM_DATA_ADDRESS = 0x2007; 

    public byte getControlRegister()
    {
        return Ram.read(CONTROL_ADDRESS);   
    }

    public void setControlRegister(byte value)
    {
        Ram.write(CONTROL_ADDRESS, value);   
    }

    public byte getMaskRegister() 
    {
        return Ram.read(MASK_ADDRESS);
    }
    
    public void setMaskRegister(byte value) 
    {
        Ram.write(MASK_ADDRESS, value);
    }

    public byte getStatusRegister() 
    {
        return Ram.read(STATUS_ADDRESS);
    }

    public void setStatusRegister(byte value) 
    {
        Ram.write(STATUS_ADDRESS, value);
    }

    public byte getOAMAddressRegister() 
    {
        return Ram.read(OAM_ADDRESS_ADDRESS);
    }

    public void setOAMAddressRegister(byte value) 
    {
        Ram.write(OAM_ADDRESS_ADDRESS, value);
    }

    public byte getOAMDataRegister() 
    {
        return Ram.read(OAM_DATA_ADDRESS);
    }

    public void setOAMDataRegister(byte value) 
    {
        Ram.write(OAM_DATA_ADDRESS, value);
    }

    public byte getScrollRegister() 
    {
        return Ram.read(SCROLL_ADDRESS);
    }

    public void setScrollRegister(byte value) 
    {
        Ram.write(SCROLL_ADDRESS, value);
    }

    public byte getVRAMAddressRegister() 
    {
        return Ram.read(VRAM_ADDRESS_ADDRESS);
    }

    public void setVRAMAddressRegister(byte value) 
    {
        Ram.write(VRAM_ADDRESS_ADDRESS, value);
    }

    public byte getVRAMDataRegister() 
    {
        return Ram.read(VRAM_DATA_ADDRESS);
    }

    public void setVRAMDataRegister(byte value) 
    {
        Ram.write(VRAM_DATA_ADDRESS, value);
    }


    /**
     * Set all registers to 0x00
     */
    public void reset() 
    {
        Ram.write(CONTROL_ADDRESS, (byte) 0x00);
        Ram.write(MASK_ADDRESS, (byte) 0x00);
        Ram.write(STATUS_ADDRESS, (byte) 0x00);
        Ram.write(OAM_ADDRESS_ADDRESS, (byte) 0x00);
        Ram.write(OAM_DATA_ADDRESS, (byte) 0x00);
        Ram.write(SCROLL_ADDRESS, (byte) 0x00);
        Ram.write(VRAM_ADDRESS_ADDRESS, (byte) 0x00);
        Ram.write(VRAM_DATA_ADDRESS, (byte) 0x00);
    }
}
