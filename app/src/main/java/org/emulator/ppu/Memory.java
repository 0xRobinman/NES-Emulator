package org.emulator.ppu;

import org.emulator.memory.Ram;

public class Memory {
    
    private final static int OAM_SIZE = 256;
    public static final int VRAM_SIZE = 0x4000;

    private final static short VRAM_START = 0x0000;
    private final static short VRAM_END = 0x3FFF;
    
    public static final short PATTERN_TABLE_START = 0x0000;
    public static final short PATTERN_TABLE_END = 0x1FFF;

    public static final short NAME_TABLE_0_START = 0x2000;
    public static final short NAME_TABLE_0_END = 0x23FF;
    
    public static final short NAME_TABLE_1_START = 0x2400;
    public static final short NAME_TABLE_1_END = 0x27FF;
    
    public static final short NAME_TABLE_2_START = 0x2800;
    public static final short NAME_TABLE_2_END = 0x2BFF;
    
    public static final short NAME_TABLE_3_START = 0x2C00;
    public static final short NAME_TABLE_3_END = 0x2FFF;
    
    public static final short PALETTE_START = 0x3F00;
    public static final short PALETTE_END = 0x3F1F;
    
    public static final short MIRRORED_PALETTE_START = 0x3F20;
    public static final short MIRRORED_PALETTE_END = 0x3FFF;
       
    public static final short NAME_TABLE_MIRROR_START = 0x3000;
    public static final short NAME_TABLE_MIRROR_END = 0x3EFF;
        
    private static byte [] vRam = new byte[0x3FFF];

    private static short attributeBase = 0x2000 + 0x03C0;


    public static byte readPatternMemory(short offset) {
        return Ram.read((short)(PATTERN_TABLE_START + offset));
    }

    public static byte readPatternMemory(byte offset) {
        return Ram.read((byte)(PATTERN_TABLE_START + offset));
    }


    public static byte readPaletteMemory(short offset) {
        return Ram.read((short)(PALETTE_START + offset));
    }

    public static byte readPaletteMemory(byte offset) {
        return Ram.read((byte)(PALETTE_START + offset));
    }


    public static byte readNameTableMemory(short offset) {
        return Ram.read((short)(NAME_TABLE_0_START + offset));
    }

    public static byte readNameTableMemory(byte offset) {
        return Ram.read((byte)(NAME_TABLE_0_START + offset));
    }
    
    public static byte[] getOAM() {
        byte [] oam = new byte[OAM_SIZE];
        byte oamAddress = Registers.getOAMAddressRegister();
        for (int i = 0; i < OAM_SIZE; i++) {
            oam[i] = Ram.read((short)(i+oamAddress));
        }
        return oam;
    }


    public static byte readNameTable(short offset) {
        return Ram.read((short)(NAME_TABLE_0_START + offset));
    }

    public static byte readAttribute(short offset) {
        return Ram.read((short)(attributeBase + offset));
    }

    public static byte[] getVRAM() {
        vRam = new byte[0x3FFF];
        for (short i = VRAM_START; i < VRAM_END; i++) {
            vRam[i] = Ram.read(i);
        }
        return vRam;
    }

}
