package org.emulator.memory;

public class Ram {
    private static byte memory[] = new byte[65536];
    
    public static byte read(short address) {
        return memory[address & 0xFFFF];
    }

    public static byte read(byte address) {
        return memory[address & 0xFF];
    }

    public static void write(short address, byte value) {
        memory[address & 0xFFFF] = value;
    }

    public static void write(byte address, byte value) {
        memory[address & 0xFF] = value;
    }

    public static void write(short address, byte[] values) {
        System.arraycopy(values, 0, memory, address & 0xFFFF, values.length);
    }

    public static void writeToStack(short address, byte value) {
        memory[0x0100 + address] = value;
    }
    public static byte popFromStack(short address) {
        return (memory[0x0100 + address]);
    }
}
