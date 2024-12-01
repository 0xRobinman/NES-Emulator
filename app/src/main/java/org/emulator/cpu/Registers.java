package org.emulator.cpu;

public class Registers {
    public static byte acc;
    public static byte x;
    public static byte y;
    public static byte status;
    public static byte sp;
    public static short pc;
    public static final int CARRY_MASK =        0x00000001;
    public static final int ZERO_MASK =         0x00000010;
    public static final int INTERRUPT_MASK =    0x00000100;
    public static final int DECIMAL_MASK =      0x00001000;
    public static final int BREAK_MASK =        0x00010000;
    public static final int UNUSED_MASK =       0x00100000;
    public static final int OVERFLOW_MASK =     0x01000000;
    public static final int NEGATIVE_MASK =     0x10000000;
}
