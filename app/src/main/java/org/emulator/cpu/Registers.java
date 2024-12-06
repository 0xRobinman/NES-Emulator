package org.emulator.cpu;

public class Registers {
    public static byte acc;
    public static byte x;
    public static byte y;
    public static byte status;
    public static byte sp = (byte)0xFF;
    public static short pc;
    public static final int CARRY_MASK =        0x00000001;
    public static final int ZERO_MASK =         0x00000010;
    public static final int INTERRUPT_MASK =    0x00000100;
    public static final int DECIMAL_MASK =      0x00001000;
    public static final int BREAK_MASK =        0x00010000;
    public static final int UNUSED_MASK =       0x00100000;
    public static final int OVERFLOW_MASK =     0x01000000;
    public static final int NEGATIVE_MASK =     0x10000000;
    public static void setCarryFlag(boolean carry) {
        if (carry) 
            status |= CARRY_MASK;
        else 
            status &= ~CARRY_MASK;
    }
    public static void setZeroFlag(boolean zero_flag) {
        if (zero_flag)
            status |= ZERO_MASK;
        else 
            status &= ~ZERO_MASK;
    }
    public static void setInterruptFlag(boolean interrupt) {
        if (interrupt) 
            status |= INTERRUPT_MASK;
        else 
            status &= ~INTERRUPT_MASK;
    }

    public static void setDecimalFlag(boolean decimal) {
        if (decimal) 
            status |= DECIMAL_MASK;
        else 
            status &= ~DECIMAL_MASK;
    }

    public static void setBreakFlag(boolean break_flag) {
        if (break_flag) 
            status |= BREAK_MASK;
        else 
            status &= ~BREAK_MASK;
    }

    public static void setOverflowFlag(boolean overflow) {
        if (overflow) 
            status |= OVERFLOW_MASK;
        else 
            status &= ~OVERFLOW_MASK;
    }

    public static void setNegativeFlag(boolean negative) {
        if (negative) 
            status |= NEGATIVE_MASK;
        else 
            status &= ~NEGATIVE_MASK;
    }
    
}
