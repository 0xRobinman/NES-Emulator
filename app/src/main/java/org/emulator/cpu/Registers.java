package org.emulator.cpu;

public class Registers {
    public static byte acc;
    public static byte x;
    public static byte y;
    public static byte status;
    public static byte sp = (byte)0xFF;
    public static short pc;
    public static final byte CARRY_MASK =        0x01;
    public static final byte ZERO_MASK =         0x02;
    public static final byte INTERRUPT_MASK =    0x04;
    public static final byte DECIMAL_MASK =      0x08;
    public static final byte BREAK_MASK =        0x10;
    public static final byte UNUSED_MASK =       0x20;
    public static final byte OVERFLOW_MASK =     0x40;
    public static final byte NEGATIVE_MASK =     (byte) 0x80;
    
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
