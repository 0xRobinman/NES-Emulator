package org.emulator.memory;

public class Ram {
    private static byte memory[] = new byte[65536];
    
    public static byte read(short address) {
        return memory[address & 0xFFFF];
    }

    public static void write(short address, byte value) {

    }

    public static void write(short address, byte[] values) {
        System.arraycopy(values, 0, memory, address & 0xFFFF, values.length);
    }

}