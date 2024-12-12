package org.emulator.cpu;

import org.emulator.arg.ArgsHandler;
import org.emulator.debug.Debug;
import org.emulator.memory.Ram;

public class Instructions {
    private static boolean ignoreBRK = true;
    public static final byte BRK_IMPLIED = (byte) 0x00;
    public static final byte NOP_ZERO_PAGE = (byte) 0x04;
    public static final byte PHP_IMPLIED = (byte) 0x08;
    public static final byte NOP_ABSOLUTE = (byte) 0x0C;
    public static final byte BPL_RELATIVE = (byte) 0x10;
    public static final byte NOP_ZERO_PAGE_X = (byte) 0x14;
    public static final byte CLC_IMPLIED = (byte) 0x18;
    public static final byte NOP_ABSOLUTE_X = (byte) 0x1C;
    public static final byte JSR_ABSOLUTE = (byte) 0x20;
    public static final byte BIT_ZERO_PAGE = (byte) 0x24;
    public static final byte PLP_IMPLIED = (byte) 0x28;
    public static final byte BIT_ABSOLUTE = (byte) 0x2C;
    public static final byte BMI_RELATIVE = (byte) 0x30;
    public static final byte SEC_IMPLIED = (byte) 0x38;
    public static final byte RTI_IMPLIED = (byte) 0x40;
    public static final byte PHA_IMPLIED = (byte) 0x48;
    public static final byte JMP_ABSOLUTE = (byte) 0x4C;
    public static final byte BVC_RELATIVE = (byte) 0x50;
    public static final byte CLI_IMPLIED = (byte) 0x58;
    public static final byte RTS_IMPLIED = (byte) 0x60;
    public static final byte PLA_IMPLIED = (byte) 0x68;
    public static final byte JMP_IND = (byte) 0x6C;
    public static final byte BVS_RELATIVE = (byte) 0x70;
    public static final byte SEI_IMPLIED = (byte) 0x78;
    public static final byte NOP = (byte) 0x80;
    public static final byte STY_ZERO_PAGE = (byte) 0x84;
    public static final byte DEY_IMPLIED = (byte) 0x88;
    public static final byte STY_ABSOLUTE = (byte) 0x8C;
    public static final byte BCC_RELATIVE = (byte) 0x90;
    public static final byte STY_ZERO_PAGE_X = (byte) 0x94;
    public static final byte TYA_IMPLIED = (byte) 0x98;
    public static final byte SHY_ABSOLUTE_X = (byte) 0x9C;
    public static final byte LDY = (byte) 0xA0;
    public static final byte LDY_ZERO_PAGE = (byte) 0xA4;
    public static final byte TAY_IMPLIED = (byte) 0xA8;
    public static final byte LDY_ABSOLUTE = (byte) 0xAC;
    public static final byte BCS_RELATIVE = (byte) 0xB0;
    public static final byte LDY_ZERO_PAGE_X = (byte) 0xB4;
    public static final byte CLV_IMPLIED = (byte) 0xB8;
    public static final byte LDY_ABSOLUTE_X = (byte) 0xBC;
    public static final byte CPY = (byte) 0xC0;
    public static final byte CPY_ZERO_PAGE = (byte) 0xC4;
    public static final byte INY_IMPLIED = (byte) 0xC8;
    public static final byte CPY_ABSOLUTE = (byte) 0xCC;
    public static final byte BNE_RELATIVE = (byte) 0xD0;
    public static final byte CLD_IMPLIED = (byte) 0xD8;
    public static final byte CPX = (byte) 0xE0;
    public static final byte CPX_ZERO_PAGE = (byte) 0xE4;
    public static final byte INX_IMPLIED = (byte) 0xE8;
    public static final byte CPX_ABSOLUTE = (byte) 0xEC;
    public static final byte BEQ_RELATIVE = (byte) 0xF0;
    public static final byte SED_IMPLIED = (byte) 0xF8;
    public static final byte ORA_X_IND = (byte) 0x01;
    public static final byte ORA_ZERO_PAGE = (byte) 0x05;
    public static final byte ORA = (byte) 0x09;
    public static final byte ORA_ABSOLUTE = (byte) 0x0D;
    public static final byte ORA_IND_Y = (byte) 0x11;
    public static final byte ORA_ZERO_PAGE_X = (byte) 0x15;
    public static final byte ORA_ABSOLUTE_Y = (byte) 0x19;
    public static final byte ORA_ABSOLUTE_X = (byte) 0x1D;
    public static final byte AND_X_IND = (byte) 0x21;
    public static final byte AND_ZERO_PAGE = (byte) 0x25;
    public static final byte AND = (byte) 0x29;
    public static final byte AND_ABSOLUTE = (byte) 0x2D;
    public static final byte AND_IND_Y = (byte) 0x31;
    public static final byte AND_ZERO_PAGE_X = (byte) 0x35;
    public static final byte AND_ABSOLUTE_Y = (byte) 0x39;
    public static final byte AND_ABSOLUTE_X = (byte) 0x3D;
    public static final byte EOR_X_IND = (byte) 0x41;
    public static final byte EOR_ZERO_PAGE = (byte) 0x45;
    public static final byte EOR = (byte) 0x49;
    public static final byte EOR_ABSOLUTE = (byte) 0x4D;
    public static final byte EOR_IND_Y = (byte) 0x51;
    public static final byte EOR_ZERO_PAGE_X = (byte) 0x55;
    public static final byte EOR_ABSOLUTE_Y = (byte) 0x59;
    public static final byte EOR_ABSOLUTE_X = (byte) 0x5D;
    public static final byte ADC_X_IND = (byte) 0x61;
    public static final byte ADC_ZERO_PAGE = (byte) 0x65;
    public static final byte ADC = (byte) 0x69;
    public static final byte ADC_ABSOLUTE = (byte) 0x6D;
    public static final byte ADC_IND_Y = (byte) 0x71;
    public static final byte ADC_ZERO_PAGE_X = (byte) 0x75;
    public static final byte ADC_ABSOLUTE_Y = (byte) 0x79;
    public static final byte ADC_ABSOLUTE_X = (byte) 0x7D;
    public static final byte STA_X_IND = (byte) 0x81;
    public static final byte STA_ZERO_PAGE = (byte) 0x85;
    public static final byte STA_ABSOLUTE = (byte) 0x8D;
    public static final byte STA_IND_Y = (byte) 0x91;
    public static final byte STA_ZERO_PAGE_X = (byte) 0x95;
    public static final byte STA_ABSOLUTE_Y = (byte) 0x99;
    public static final byte STA_ABSOLUTE_X = (byte) 0x9D;
    public static final byte LDA_X_IND = (byte) 0xA1;
    public static final byte LDA_ZERO_PAGE = (byte) 0xA5;
    public static final byte LDA = (byte) 0xA9;
    public static final byte LDA_ABSOLUTE = (byte) 0xAD;
    public static final byte LDA_IND_Y = (byte) 0xB1;
    public static final byte LDA_ZERO_PAGE_X = (byte) 0xB5;
    public static final byte LDA_ABSOLUTE_Y = (byte) 0xB9;
    public static final byte LDA_ABSOLUTE_X = (byte) 0xBD;
    public static final byte CMP_X_IND = (byte) 0xC1;
    public static final byte CMP_ZERO_PAGE = (byte) 0xC5;
    public static final byte CMP = (byte) 0xC9;
    public static final byte CMP_ABSOLUTE = (byte) 0xCD;
    public static final byte CMP_IND_Y = (byte) 0xD1;
    public static final byte CMP_ZERO_PAGE_X = (byte) 0xD5;
    public static final byte CMP_ABSOLUTE_Y = (byte) 0xD9;
    public static final byte CMP_ABSOLUTE_X = (byte) 0xDD;
    public static final byte SBC_X_IND = (byte) 0xE1;
    public static final byte SBC_ZERO_PAGE = (byte) 0xE5;
    public static final byte SBC = (byte) 0xE9;
    public static final byte SBC_ABSOLUTE = (byte) 0xED;
    public static final byte SBC_IND_Y = (byte) 0xF1;
    public static final byte SBC_ZERO_PAGE_X = (byte) 0xF5;
    public static final byte SBC_ABSOLUTE_Y = (byte) 0xF9;
    public static final byte SBC_ABSOLUTE_X = (byte) 0xFD;
    public static final byte JAM = (byte) 0x02;
    public static final byte ASL_ZERO_PAGE = (byte) 0x06;
    public static final byte ASL = (byte) 0x0A;
    public static final byte ASL_ABSOLUTE = (byte) 0x0E;
    public static final byte ASL_ZERO_PAGE_X = (byte) 0x16;
    public static final byte NOP_IMPLIED = (byte) 0x1A;
    public static final byte ASL_ABSOLUTE_X = (byte) 0x1E;
    public static final byte ROL_ZERO_PAGE = (byte) 0x26;
    public static final byte ROL = (byte) 0x2A;
    public static final byte ROL_ABSOLUTE = (byte) 0x2E;
    public static final byte ROL_ZERO_PAGE_X = (byte) 0x36;
    public static final byte ROL_ABSOLUTE_X = (byte) 0x3E;
    public static final byte LSR_ZERO_PAGE = (byte) 0x46;
    public static final byte LSR = (byte) 0x4A;
    public static final byte LSR_ABSOLUTE = (byte) 0x4E;
    public static final byte LSR_ZERO_PAGE_X = (byte) 0x56;
    public static final byte LSR_ABSOLUTE_X = (byte) 0x5E;
    public static final byte ROR_ZERO_PAGE = (byte) 0x66;
    public static final byte ROR = (byte) 0x6A;
    public static final byte ROR_ABSOLUTE = (byte) 0x6E;
    public static final byte ROR_ZERO_PAGE_X = (byte) 0x76;
    public static final byte ROR_ABSOLUTE_X = (byte) 0x7E;
    public static final byte STX_ZERO_PAGE = (byte) 0x86;
    public static final byte TXA_IMPLIED = (byte) 0x8A;
    public static final byte STX_ABSOLUTE = (byte) 0x8E;
    public static final byte STX_ZERO_PAGE_Y = (byte) 0x96;
    public static final byte TXS_IMPLIED = (byte) 0x9A;
    public static final byte SHX_ABSOLUTE_Y = (byte) 0x9E;
    public static final byte LDX = (byte) 0xA2;
    public static final byte LDX_ZERO_PAGE = (byte) 0xA6;
    public static final byte TAX_IMPLIED = (byte) 0xAA;
    public static final byte LDX_ABSOLUTE = (byte) 0xAE;
    public static final byte LDX_ZERO_PAGE_Y = (byte) 0xB6;
    public static final byte TSX_IMPLIED = (byte) 0xBA;
    public static final byte LDX_ABSOLUTE_Y = (byte) 0xBE;
    public static final byte DEC_ZERO_PAGE = (byte) 0xC6;
    public static final byte DEX_IMPLIED = (byte) 0xCA;
    public static final byte DEC_ABSOLUTE = (byte) 0xCE;
    public static final byte DEC_ZERO_PAGE_X = (byte) 0xD6;
    public static final byte DEC_ABSOLUTE_X = (byte) 0xDE;
    public static final byte INC_ZERO_PAGE = (byte) 0xE6;
    public static final byte INC_ABSOLUTE = (byte) 0xEE;
    public static final byte INC_ZERO_PAGE_X = (byte) 0xF6;
    public static final byte INC_ABSOLUTE_X = (byte) 0xFE;
    public static final byte SLO_X_IND = (byte) 0x03;
    public static final byte SLO_ZERO_PAGE = (byte) 0x07;
    public static final byte ANC = (byte) 0x0B;
    public static final byte SLO_ABSOLUTE = (byte) 0x0F;
    public static final byte SLO_IND_Y = (byte) 0x13;
    public static final byte SLO_ZERO_PAGE_X = (byte) 0x17;
    public static final byte SLO_ABSOLUTE_Y = (byte) 0x1B;
    public static final byte SLO_ABSOLUTE_X = (byte) 0x1F;
    public static final byte RLA_X_IND = (byte) 0x23;
    public static final byte RLA_ZERO_PAGE = (byte) 0x27;
    public static final byte RLA_ABSOLUTE = (byte) 0x2F;
    public static final byte RLA_IND_Y = (byte) 0x33;
    public static final byte RLA_ZERO_PAGE_X = (byte) 0x37;
    public static final byte RLA_ABSOLUTE_Y = (byte) 0x3B;
    public static final byte RLA_ABSOLUTE_X = (byte) 0x3F;
    public static final byte SRE_X_IND = (byte) 0x43;
    public static final byte SRE_ZERO_PAGE = (byte) 0x47;
    public static final byte ALR = (byte) 0x4B;
    public static final byte SRE_ABSOLUTE = (byte) 0x4F;
    public static final byte SRE_IND_Y = (byte) 0x53;
    public static final byte SRE_ZERO_PAGE_X = (byte) 0x57;
    public static final byte SRE_ABSOLUTE_Y = (byte) 0x5B;
    public static final byte SRE_ABSOLUTE_X = (byte) 0x5F;
    public static final byte RRA_X_IND = (byte) 0x63;
    public static final byte RRA_ZERO_PAGE = (byte) 0x67;
    public static final byte ARR = (byte) 0x6B;
    public static final byte RRA_ABSOLUTE = (byte) 0x6F;
    public static final byte RRA_IND_Y = (byte) 0x73;
    public static final byte RRA_ZERO_PAGE_X = (byte) 0x77;
    public static final byte RRA_ABSOLUTE_Y = (byte) 0x7B;
    public static final byte RRA_ABSOLUTE_X = (byte) 0x7F;
    public static final byte SAX_X_IND = (byte) 0x83;
    public static final byte SAX_ZERO_PAGE = (byte) 0x87;
    public static final byte ANE = (byte) 0x8B;
    public static final byte SAX_ABSOLUTE = (byte) 0x8F;
    public static final byte SHA_IND_Y = (byte) 0x93;
    public static final byte SAX_ZERO_PAGE_Y = (byte) 0x97;
    public static final byte TAS_ABSOLUTE_Y = (byte) 0x9B;
    public static final byte SHA_ABSOLUTE_Y = (byte) 0x9F;
    public static final byte LAX_X_IND = (byte) 0xA3;
    public static final byte LAX_ZERO_PAGE = (byte) 0xA7;
    public static final byte LXA = (byte) 0xAB;
    public static final byte LAX_ABSOLUTE = (byte) 0xAF;
    public static final byte LAX_IND_Y = (byte) 0xB3;
    public static final byte LAX_ZERO_PAGE_Y = (byte) 0xB7;
    public static final byte LAS_ABSOLUTE_Y = (byte) 0xBB;
    public static final byte LAX_ABSOLUTE_Y = (byte) 0xBF;
    public static final byte DCP_X_IND = (byte) 0xC3;
    public static final byte DCP_ZERO_PAGE = (byte) 0xC7;
    public static final byte SBX = (byte) 0xCB;
    public static final byte DCP_ABSOLUTE = (byte) 0xCF;
    public static final byte DCP_IND_Y = (byte) 0xD3;
    public static final byte DCP_ZERO_PAGE_X = (byte) 0xD7;
    public static final byte DCP_ABSOLUTE_Y = (byte) 0xDB;
    public static final byte DCP_ABSOLUTE_X = (byte) 0xDF;
    public static final byte ISC_X_IND = (byte) 0xE3;
    public static final byte ISC_ZERO_PAGE = (byte) 0xE7;
    public static final byte USBC = (byte) 0xEB;
    public static final byte ISC_ABSOLUTE = (byte) 0xEF;
    public static final byte ISC_IND_Y = (byte) 0xF3;
    public static final byte ISC_ZERO_PAGE_X = (byte) 0xF7;
    public static final byte ISC_ABSOLUTE_Y = (byte) 0xFB;
    public static final byte ISC_ABSOLUTE_X = (byte) 0xFF;
    private static int pageCrossed = 0;

    public static void nmi_interrupt() {

        System.out.println("---------------------------------INTERRUPT---------------------------------");

        byte higherByte = (byte) ((Registers.pc >> 8));
        byte lowerByte = (byte) (Registers.pc);

        Ram.writeToStack(Registers.sp, lowerByte);
        Registers.sp--;
        Ram.writeToStack(Registers.sp, higherByte);
        Registers.sp--;
        Ram.writeToStack(Registers.sp, Registers.status);
        Registers.sp--;

        Registers.setInterruptFlag(true);

        lowerByte = Ram.read((short) 0xFFFA);
        higherByte = Ram.read((short) 0xFFFB);

        Registers.pc = (short) (lowerByte | (higherByte << 8));

    }

    /**
     * ADD operation with carry
     */
    public static int adc() {
        int clockCycles = 2;

        Registers.pc++;
        byte value = Cpu.fetchNextValue();
        int carry = (Registers.status & Registers.CARRY_MASK) != 0 ? 1 : 0;

        int result = (Registers.acc + value + carry);
        Registers.acc = (byte) result;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setCarryFlag(result > 0xFF);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);
        Registers.setOverflowFlag(((Registers.acc ^ result) & (value ^ result) & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(ADC, "ADC");
        return clockCycles;
    }

    public static int adc_zero_page() {
        int clockCycles = 3;

        byte address = fetchZeroPageAddress();
        byte value = Ram.read(address);

        int carry = (Registers.status & Registers.CARRY_MASK) != 0 ? 1 : 0;

        int result = (Registers.acc + value + carry);
        Registers.acc = (byte) result;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setCarryFlag(result > 0xFF);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);
        Registers.setOverflowFlag(((Registers.acc ^ result) & (value ^ result) & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(ADC_ZERO_PAGE, "ADC");
        return clockCycles;
    }

    public static int adc_zero_page_x() {
        int clockCycles = 4;

        byte address = fetchZeroPageXAddress();
        byte value = Ram.read(address);

        int carry = (Registers.status & Registers.CARRY_MASK) != 0 ? 1 : 0;

        int result = (Registers.acc + value + carry);
        Registers.acc = (byte) result;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setCarryFlag(result > 0xFF);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);
        Registers.setOverflowFlag(((Registers.acc ^ result) & (value ^ result) & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(ADC_ZERO_PAGE_X, "ADC");
        return clockCycles;
    }

    public static int adc_absolute() {
        int clockCycles = 4;

        short address = fetchAddress();
        byte value = Ram.read(address);

        int carry = (Registers.status & Registers.CARRY_MASK) != 0 ? 1 : 0;

        int result = (Registers.acc + value + carry);
        Registers.acc = (byte) result;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setCarryFlag(result > 0xFF);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);
        Registers.setOverflowFlag(((Registers.acc ^ result) & (value ^ result) & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(ADC_ABSOLUTE, "ADC");
        return clockCycles;
    }

    public static int adc_absolute_x() {
        int clockCycles = 4;

        short address = fetchAbsoluteXAddress();
        byte value = Ram.read(address);

        int carry = (Registers.status & Registers.CARRY_MASK) != 0 ? 1 : 0;

        int result = (Registers.acc + value + carry);
        Registers.acc = (byte) result;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setCarryFlag(result > 0xFF);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);
        Registers.setOverflowFlag(((Registers.acc ^ result) & (value ^ result) & 0x80) != 0);

        clockCycles += pageCrossed;
        if (ArgsHandler.debug)
            Debug.printASM(ADC_ABSOLUTE_X, "ADC");
        return clockCycles;
    }

    public static int adc_absolute_y() {
        int clockCycles = 4;

        short address = fetchAbsoluteYAddress();
        byte value = Ram.read(address);

        int carry = (Registers.status & Registers.CARRY_MASK) != 0 ? 1 : 0;

        int result = (Registers.acc + value + carry);
        Registers.acc = (byte) result;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setCarryFlag(result > 0xFF);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);
        Registers.setOverflowFlag(((Registers.acc ^ result) & (value ^ result) & 0x80) != 0);

        clockCycles += pageCrossed;
        if (ArgsHandler.debug)
            Debug.printASM(ADC_ABSOLUTE_Y, "ADC");
        return clockCycles;
    }

    public static int adc_x_ind() {
        int clockCycles = 6;

        short address = fetchXindAddress();
        byte value = Ram.read(address);

        int carry = (Registers.status & Registers.CARRY_MASK) != 0 ? 1 : 0;

        int result = (Registers.acc + value + carry);
        Registers.acc = (byte) result;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setCarryFlag(result > 0xFF);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);
        Registers.setOverflowFlag(((Registers.acc ^ result) & (value ^ result) & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(ADC_X_IND, "ADC");
        return clockCycles;
    }

    public static int adc_ind_y() {
        int clockCycles = 5;
        short address = fetchIndYAddress();
        byte value = Ram.read(address);

        int carry = (Registers.status & Registers.CARRY_MASK) != 0 ? 1 : 0;

        int result = (Registers.acc + value + carry);
        Registers.acc = (byte) result;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setCarryFlag(result > 0xFF);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);
        Registers.setOverflowFlag(((Registers.acc ^ result) & (value ^ result) & 0x80) != 0);

        clockCycles += pageCrossed;
        if (ArgsHandler.debug)
            Debug.printASM(ADC_IND_Y, "ADC");
        return clockCycles;
    }

    /**
     * AND
     */
    public static int and() {
        int clockCycles = 2;
        Registers.pc++;
        byte value = Cpu.fetchNextValue();

        Registers.acc &= value;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(AND, "AND 1");
        return clockCycles;
    }

    public static int and_zero_page() {
        int clockCycles = 3;
        byte address = fetchZeroPageAddress();
        byte value = Ram.read(address);

        Registers.acc &= value;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(AND_ZERO_PAGE, "AND 2");
        return clockCycles;
    }

    public static int and_zero_page_x() {
        int clockCycles = 4;
        byte address = fetchZeroPageXAddress();
        byte value = Ram.read(address);

        Registers.acc &= value;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);
        if (ArgsHandler.debug)
            Debug.printASM(AND_ZERO_PAGE_X, "AND 3");
        return clockCycles;
    }

    public static int and_absolute() {
        int clockCycles = 4;
        short address = fetchAddress();
        byte value = Ram.read(address);

        Registers.acc &= value;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(AND_ABSOLUTE, "AND 4");
        return clockCycles;
    }

    public static int and_absolute_x() {
        int clockCycles = 4;
        short address = fetchAbsoluteXAddress();
        byte value = Ram.read(address);

        Registers.acc &= value;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        clockCycles += pageCrossed;

        if (ArgsHandler.debug)
            Debug.printASM(AND_ABSOLUTE_X, "AND 5");
        return clockCycles;
    }

    public static int and_absolute_y() {
        int clockCycles = 4;
        short address = fetchAbsoluteYAddress();
        byte value = Ram.read(address);

        Registers.acc &= value;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        clockCycles += pageCrossed;
        if (ArgsHandler.debug)
            Debug.printASM(AND_ABSOLUTE_Y, "AND 6");
        return clockCycles;
    }

    public static int and_x_ind() {
        int clockCycles = 6;
        short address = fetchXindAddress();
        byte value = Ram.read(address);
        Registers.acc &= value;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(AND_X_IND, "AND 7");
        return clockCycles;
    }

    public static int and_ind_y() {
        int clockCycles = 5;

        short address = fetchIndYAddress();
        byte value = Ram.read(address);
        Registers.acc &= value;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        clockCycles += pageCrossed;
        if (ArgsHandler.debug)
            Debug.printASM(AND_IND_Y, "AND 8");
        return clockCycles;
    }

    /**
     * Arithmetic shift left.
     */
    public static int asl() {
        int clockCycles = 2;
        Registers.setCarryFlag(Registers.acc > 0xFF);
        Registers.acc <<= 1;
        Registers.acc &= 0xFF;
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & Registers.NEGATIVE_MASK) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(ASL, "ASL 1");
        return clockCycles;
    }

    public static int asl_zero_page() {

        byte address = fetchZeroPageAddress();
        int value = Ram.read(address);
        Registers.setCarryFlag(value > 0xFF);
        byte bValue = (byte) value;
        bValue <<= 1;
        Ram.write(address, bValue);

        Registers.setZeroFlag(bValue == 0);
        Registers.setNegativeFlag((bValue & Registers.NEGATIVE_MASK) != 0);

        int clockCycles = 5;
        if (ArgsHandler.debug)
            Debug.printASM(ASL_ZERO_PAGE, "ASL 2");
        return clockCycles;
    }

    public static int asl_zero_page_x() {
        int clockCycles = 6;

        byte address = fetchZeroPageXAddress();
        int value = Ram.read(address);
        Registers.setCarryFlag(value > 0xFF);
        byte bValue = (byte) value;
        bValue <<= 1;
        Ram.write(address, bValue);

        Registers.setZeroFlag(bValue == 0);
        Registers.setNegativeFlag((bValue & Registers.NEGATIVE_MASK) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(ASL_ZERO_PAGE_X, "ASL 3");
        return clockCycles;
    }

    public static int asl_absolute() {
        int clockCycles = 6;

        short address = fetchAddress();
        int value = Ram.read(address);
        Registers.setCarryFlag(value > 0xFF);
        byte bValue = (byte) value;
        bValue <<= 1;
        Ram.write(address, bValue);

        Registers.setZeroFlag(bValue == 0);
        Registers.setNegativeFlag((bValue & Registers.NEGATIVE_MASK) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(ASL_ABSOLUTE, "ASL 4");
        return clockCycles;
    }

    public static int asl_absolute_x() {
        int clockCycles = 7;

        short address = fetchAbsoluteXAddress();
        int value = Ram.read(address);
        Registers.setCarryFlag(value > 0xFF);
        byte bValue = (byte) value;
        bValue <<= 1;
        Ram.write(address, bValue);

        Registers.setZeroFlag(bValue == 0);
        Registers.setNegativeFlag((bValue & Registers.NEGATIVE_MASK) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(ASL_ABSOLUTE_X, "ASL 5");
        return clockCycles;
    }

    /**
     * Branch if carry clear
     */
    public static int bcc() {
        int clockCycles = 2;

        // Check for carry being clear
        if ((Registers.status & Registers.CARRY_MASK) == 0) {
            clockCycles++;
            short currentAddress = Registers.pc;
            Registers.pc++;
            byte offset = Cpu.fetchNextValue();
            // Registers.pc++;
            Registers.pc += offset;
            pageCrossed = ((currentAddress & 0xFF00) != (Registers.pc & 0xFF00)) ? 1 : 0;
            clockCycles += pageCrossed;
            Registers.pc--;
        }
        if (ArgsHandler.debug)
            Debug.printASM(BCC_RELATIVE, "BCC");
        return clockCycles;
    }

    /**
     * Branch if carry set
     */
    public static int bcs() {
        int clockCycles = 2;

        if ((Registers.status & Registers.CARRY_MASK) != 0) {
            clockCycles++;
            short currentAddress = Registers.pc;
            Registers.pc++;
            byte offset = Cpu.fetchNextValue();
            // Registers.pc++;
            Registers.pc += offset;
            pageCrossed = ((currentAddress & 0xFF00) != (Registers.pc & 0xFF00)) ? 1 : 0;
            clockCycles += pageCrossed;
            Registers.pc--;
        }
        if (ArgsHandler.debug)
            Debug.printASM(BCS_RELATIVE, "BCS");
        return clockCycles;
    }

    /**
     * Branch equals
     */
    public static int beq() {
        int clockCycles = 2;
        if ((Registers.status & Registers.ZERO_MASK) == 1) {
            short currentAddress = Registers.pc;
            Registers.pc++;
            byte offset = Cpu.fetchNextValue();
            // Registers.pc++;
            Registers.pc += offset;
            pageCrossed = ((currentAddress & 0xFF00) != (Registers.pc & 0xFF00)) ? 1 : 0;
            clockCycles += pageCrossed;
            Registers.pc--;
        }
        if (ArgsHandler.debug)
            Debug.printASM(BEQ_RELATIVE, "BEQ");

        return clockCycles;

    }

    /**
     * Bit Zeropage
     */
    public static int bit() {
        int clockCycles = 3;

        // Convert them to little endian
        byte address = fetchZeroPageAddress();

        byte testValue = Ram.read(address);

        Registers.setZeroFlag((testValue & Registers.acc) == 0);
        Registers.setNegativeFlag((testValue & 0x80) != 0);
        Registers.setOverflowFlag((testValue & 0x40) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(BIT_ZERO_PAGE, "BIT i");
        return clockCycles;
    }

    /**
     * Bit test
     */
    public static int bit_absolute() {
        int clockCycles = 4;

        // Convert them to little endian
        short address = fetchAddress();

        byte testValue = Ram.read(address);

        Registers.setZeroFlag((testValue & Registers.acc) == 0);
        Registers.setNegativeFlag((testValue & 0x80) != 0);
        Registers.setOverflowFlag((testValue & 0x40) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(BIT_ABSOLUTE, "BIT a");
        return clockCycles;
    }

    /**
     * Branch if minus
     */
    public static int bmi() {
        int clockCycles = 2;

        if ((Registers.status & Registers.NEGATIVE_MASK) != 0) {
            clockCycles++;
            short currentAddress = Registers.pc;
            Registers.pc++;
            byte offset = Cpu.fetchNextValue();
            // Registers.pc++;
            Registers.pc += offset;
            pageCrossed = ((currentAddress & 0xFF00) != (Registers.pc & 0xFF00)) ? 1 : 0;
            clockCycles += pageCrossed;
            Registers.pc--;
        }

        if (ArgsHandler.debug)
            Debug.printASM(BMI_RELATIVE, "BMI");
        return clockCycles;
    }

    /**
     * Branch not equals
     */
    public static int bne() {
        int clockCycles = 2;

        if ((Registers.status & Registers.ZERO_MASK) == 0) {
            short currentAddress = Registers.pc;
            clockCycles++;
            Registers.pc++;
            byte offset = Cpu.fetchNextValue();
            // Registers.pc++;
            Registers.pc += offset;
            pageCrossed = ((currentAddress & 0xFF00) != (Registers.pc & 0xFF00)) ? 1 : 0;
            clockCycles += pageCrossed;
            Registers.pc--;
        }

        if (ArgsHandler.debug)
            Debug.printASM(BNE_RELATIVE, "BNE");
        return clockCycles;

    }

    /**
     * Branch on plus. If the N flag is 0, then we branch.
     */
    public static int bpl() {
        int clockCycles = 2;

        // Branch by the relative address.
        if ((Registers.status & Registers.NEGATIVE_MASK) == 0) {
            short currentAddress = Registers.pc;
            clockCycles++;
            Registers.pc++;
            byte offset = Cpu.fetchNextValue();
            // Registers.pc++;
            Registers.pc += offset;
            pageCrossed = ((currentAddress & 0xFF00) != (Registers.pc & 0xFF00)) ? 1 : 0;
            clockCycles += pageCrossed;
            Registers.pc--;
        }

        if (ArgsHandler.debug)
            Debug.printASM(BPL_RELATIVE, "BPL");
        return clockCycles;

    }

    /**
     * Force a break
     */
    public static int brk() {
        int clockCycles = 7;

        Registers.pc++;

        if (ignoreBRK) {
            return clockCycles;
        }

        // Return to BRK + 2 but + 1 since opcode ( next instruction )
        short returnAddress = (short) (Registers.pc);

        // Push return address for routine on the stack
        byte higherByte = (byte) ((returnAddress >> 8));
        byte lowerByte = (byte) (returnAddress);

        // Set interrupt flag
        sei();

        byte status = Registers.status;
        status |= Registers.UNUSED_MASK;
        status |= Registers.BREAK_MASK;

        // Store the return address of next instruction onto the stack
        Ram.writeToStack(Registers.sp, lowerByte);
        Registers.sp--;
        Ram.writeToStack(Registers.sp, higherByte);
        Registers.sp--;
        Ram.writeToStack(Registers.sp, status);
        Registers.sp--;

        // Get interrupt vector
        lowerByte = Ram.read((short) 0xFFFE);
        higherByte = Ram.read((short) 0xFFFF);

        // Set PC to new address (little endian)
        Registers.pc = (short) ((higherByte << 8) | lowerByte);
        Registers.pc--;

        // Clear interrupt flag
        Registers.setInterruptFlag(false);

        if (ArgsHandler.debug)
            Debug.printASM(BRK_IMPLIED, "BRK");

        return clockCycles;
    }

    /**
     * Branch if overflow flag is clear
     */
    public static int bvc() {
        int clockCycles = 2;

        if ((Registers.status & Registers.OVERFLOW_MASK) == 0) {
            short currentAddress = Registers.pc;
            clockCycles++;
            Registers.pc++;
            byte offset = Cpu.fetchNextValue();
            // Registers.pc++;
            Registers.pc += offset;
            pageCrossed = ((currentAddress & 0xFF00) != (Registers.pc & 0xFF00)) ? 1 : 0;
            clockCycles += pageCrossed;
            Registers.pc--;
        }

        if (ArgsHandler.debug)
            Debug.printASM(BVC_RELATIVE, "BVC");
        return clockCycles;
    }

    /**
     * Branch if overflow set
     */
    public static int bvs() {
        int clockCycles = 2;

        if ((Registers.status & Registers.OVERFLOW_MASK) != 0) {
            short currentAddress = Registers.pc;
            clockCycles++;
            Registers.pc++;
            byte offset = Cpu.fetchNextValue();
            // Registers.pc++;
            Registers.pc += offset;
            pageCrossed = ((currentAddress & 0xFF00) != (Registers.pc & 0xFF00)) ? 1 : 0;
            clockCycles += pageCrossed;
            Registers.pc--;
        }

        if (ArgsHandler.debug)
            Debug.printASM(BVS_RELATIVE, "BVS");
        return clockCycles;
    }

    /**
     * Clear the carry flag
     */
    public static int clc() {
        int clockCycles = 2;

        Registers.setCarryFlag(false);

        if (ArgsHandler.debug)
            Debug.printASM(CLC_IMPLIED, "CLC");
        return clockCycles;
    }

    /**
     * CLear decimal flag
     */
    public static int cld() {
        int clockCycles = 2;

        Registers.setDecimalFlag(false);

        if (ArgsHandler.debug)
            Debug.printASM(CLD_IMPLIED, "CLD");
        return clockCycles;
    }

    /**
     * Clear interrupt
     */
    public static int cli() {
        int clockCycles = 2;

        Registers.setInterruptFlag(false);

        if (ArgsHandler.debug)
            Debug.printASM(CLI_IMPLIED, "CLI");
        return clockCycles;
    }

    /**
     * Clear overflow flag
     */
    public static int clv() {
        int clockCycles = 2;

        Registers.setOverflowFlag(false);

        if (ArgsHandler.debug)
            Debug.printASM(CLV_IMPLIED, "CLV");
        return clockCycles;
    }

    /**
     * Compare
     */
    public static int cmp() {
        int clockCycles = 2;

        Registers.pc++;
        byte value = Cpu.fetchNextValue();
        byte result = (byte) (Registers.acc - value);

        Registers.setCarryFlag(Registers.acc >= value);

        Registers.setZeroFlag(Registers.acc == value);
        Registers.setNegativeFlag((result & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(CMP, "CMP");
        return clockCycles;
    }

    public static int cmp_zero_page() {
        int clockCycles = 3;
        byte address = fetchZeroPageAddress();
        byte value = Ram.read(address);
        byte result = (byte) (Registers.acc - value);
        Registers.setCarryFlag(Registers.acc >= value);
        Registers.setZeroFlag(Registers.acc == value);
        Registers.setNegativeFlag((result & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(CMP_ZERO_PAGE, "CMP 2");
        return clockCycles;
    }

    public static int cmp_zero_page_x() {
        int clockCycles = 4;
        byte address = fetchZeroPageXAddress();
        byte value = Ram.read(address);
        byte result = (byte) (Registers.acc - value);
        Registers.setCarryFlag(Registers.acc >= value);
        Registers.setZeroFlag(Registers.acc == value);
        Registers.setNegativeFlag((result & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(CMP_ZERO_PAGE_X, "CMP 3");
        return clockCycles;
    }

    public static int cmp_absolute() {
        int clockCycles = 4;

        short address = fetchAddress();
        byte value = Ram.read(address);
        byte result = (byte) (Registers.acc - value);
        Registers.setCarryFlag(Registers.acc >= value);
        Registers.setZeroFlag(Registers.acc == value);
        Registers.setNegativeFlag((result & 0x80) != 0);
        System.out.println(String.format("Address: 0x%04X", address));

        if (ArgsHandler.debug)
            Debug.printASM(CMP_ABSOLUTE, "CMP 4");
        return clockCycles;
    }

    public static int cmp_absolute_x() {
        int clockCycles = 4;

        short address = fetchAbsoluteXAddress();
        byte value = Ram.read(address);
        byte result = (byte) (Registers.acc - value);
        Registers.setCarryFlag(Registers.acc >= value);
        Registers.setZeroFlag(Registers.acc == value);
        Registers.setNegativeFlag((result & 0x80) != 0);
        System.out.println(String.format("Address: 0x%04X", address));

        clockCycles += pageCrossed;

        if (ArgsHandler.debug)
            Debug.printASM(CMP_ABSOLUTE_X, "CMP 5");
        return clockCycles;
    }

    public static int cmp_absolute_y() {
        int clockCycles = 4;

        short address = fetchAbsoluteYAddress();
        byte value = Ram.read(address);
        byte result = (byte) (Registers.acc - value);
        Registers.setCarryFlag(Registers.acc >= value);
        Registers.setZeroFlag(Registers.acc == value);
        Registers.setNegativeFlag((result & 0x80) != 0);
        System.out.println(String.format("Address: 0x%04X", address));

        clockCycles += pageCrossed;

        if (ArgsHandler.debug)
            Debug.printASM(CMP_ABSOLUTE_Y, "CMP 6");
        return clockCycles;
    }

    public static int cmp_x_ind() {
        int clockCycles = 6;

        short address = fetchXindAddress();
        byte value = Ram.read(address);
        byte result = (byte) (Registers.acc - value);
        Registers.setCarryFlag(Registers.acc >= value);
        Registers.setZeroFlag(Registers.acc == value);
        Registers.setNegativeFlag((result & 0x80) != 0);
        System.out.println(String.format("Address: 0x%04X", address));

        if (ArgsHandler.debug)
            Debug.printASM(CMP_X_IND, "CMP 7");
        return clockCycles;
    }

    public static int cmp_ind_y() {
        int clockCycles = 5;

        short address = fetchIndYAddress();
        byte value = Ram.read(address);
        byte result = (byte) (Registers.acc - value);
        Registers.setCarryFlag(Registers.acc >= value);
        Registers.setZeroFlag(Registers.acc == value);
        Registers.setNegativeFlag((result & 0x80) != 0);
        System.out.println(String.format("Address: 0x%04X", address));

        clockCycles += pageCrossed;

        if (ArgsHandler.debug)
            Debug.printASM(CMP_IND_Y, "CMP 8");
        return clockCycles;
    }

    /**
     * Compare X
     */
    public static int cpx() {
        int clockCycles = 2;

        Registers.pc++;
        byte value = Cpu.fetchNextValue();

        int result = Registers.x - value;

        Registers.setCarryFlag(Registers.x >= value);
        Registers.setZeroFlag(Registers.x == value);
        Registers.setNegativeFlag((result & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(CPX, "CPX");
        return clockCycles;
    }

    public static int cpx_zero_page() {
        int clockCycles = 3;

        byte address = fetchZeroPageAddress();
        byte value = Ram.read(address);

        int result = Registers.x - value;

        Registers.setCarryFlag(Registers.x >= value);
        Registers.setZeroFlag(Registers.x == value);
        Registers.setNegativeFlag((result & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(CPX_ZERO_PAGE, "CPX");
        return clockCycles;
    }

    public static int cpx_absolute() {
        int clockCycles = 4;

        short address = fetchAddress();
        byte value = Ram.read(address);

        int result = Registers.x - value;

        Registers.setCarryFlag(Registers.x >= value);
        Registers.setZeroFlag(Registers.x == value);
        Registers.setNegativeFlag((result & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(CPX_ABSOLUTE, "CPX");
        return clockCycles;
    }

    /**
     * Compare Y
     */
    public static int cpy() {
        int clockCycles = 2;

        Registers.pc++;
        byte value = Cpu.fetchNextValue();

        int result = Registers.y - value;

        Registers.setCarryFlag(Registers.y >= value);
        Registers.setZeroFlag(Registers.y == value);
        Registers.setNegativeFlag((result & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(CPY, "CPY");
        return clockCycles;
    }

    public static int cpy_zero_page() {
        int clockCycles = 3;
        byte address = fetchZeroPageAddress();
        byte value = Ram.read(address);

        int result = Registers.y - value;

        Registers.setCarryFlag(Registers.y >= value);
        Registers.setZeroFlag(Registers.y == value);
        Registers.setNegativeFlag((result & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(CPY_ZERO_PAGE, "CPY");
        return clockCycles;
    }

    public static int cpy_absolute() {
        int clockCycles = 4;

        short address = fetchAddress();
        byte value = Ram.read(address);

        int result = Registers.y - value;

        Registers.setCarryFlag(Registers.y >= value);
        Registers.setZeroFlag(Registers.y == value);
        Registers.setNegativeFlag((result & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(CPY_ABSOLUTE, "CPY");
        return clockCycles;
    }

    /**
     * Decrement value stored.
     */
    public static int dec_zero_page() {
        int clockCycles = 5;

        byte address = fetchZeroPageAddress();

        byte value = Ram.read(address);

        value = (byte) ((value - 1) & 0xFF);

        Ram.write(address, value);

        Registers.setZeroFlag(value == 0);
        Registers.setNegativeFlag((value & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(DEC_ZERO_PAGE, "DEC");
        return clockCycles;
    }

    public static int dec_zero_page_x() {
        int clockCycles = 6;

        byte address = fetchZeroPageXAddress();

        byte value = Ram.read(address);

        value = (byte) ((value - 1) & 0xFF);

        Ram.write(address, value);

        Registers.setZeroFlag(value == 0);
        Registers.setNegativeFlag((value & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(DEC_ZERO_PAGE_X, "DEC");
        return clockCycles;
    }

    public static int dec_absolute() {
        int clockCycles = 6;

        short address = fetchAddress();

        byte value = Ram.read(address);

        value = (byte) ((value - 1) & 0xFF);

        Ram.write(address, value);

        Registers.setZeroFlag(value == 0);
        Registers.setNegativeFlag((value & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(DEC_ABSOLUTE, "DEC");
        return clockCycles;
    }

    public static int dec_absolute_x() {
        int clockCycles = 7;

        short address = fetchAbsoluteXAddress();

        byte value = Ram.read(address);

        value = (byte) ((value - 1) & 0xFF);

        Ram.write(address, value);

        Registers.setZeroFlag(value == 0);
        Registers.setNegativeFlag((value & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(DEC_ABSOLUTE_X, "DEC");
        return clockCycles;
    }

    /**
     * Decrement X
     */
    public static int dex() {
        int clockCycles = 2;

        Registers.x = (byte) ((Registers.x - 1) & 0xFF);

        Registers.setZeroFlag(Registers.x == 0);
        Registers.setNegativeFlag((Registers.x & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(DEX_IMPLIED, "DEX");
        return clockCycles;
    }

    /**
     * Decerement Y
     */
    public static int dey() {
        int clockCycles = 2;

        Registers.y = (byte) ((Registers.y - 1) & 0xFF);
        Registers.setZeroFlag(Registers.y == 0);
        Registers.setNegativeFlag((Registers.y & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(DEY_IMPLIED, "DEY");
        return clockCycles;
    }

    /**
     * Exclusive OR (XOR)
     */
    public static int eor() {
        int clockCycles = 2;

        Registers.pc++;
        byte value = Cpu.fetchNextValue();
        Registers.acc ^= value;
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(EOR, "EOR 1");
        return clockCycles;
    }

    public static int eor_zero_page() {
        int clockCycles = 3;
        byte address = fetchZeroPageAddress();
        byte value = Ram.read(address);
        Registers.acc ^= value;
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(EOR_ZERO_PAGE, "EOR 2");
        return clockCycles;
    }

    public static int eor_zero_page_x() {
        int clockCycles = 4;

        byte address = fetchZeroPageXAddress();
        byte value = Ram.read(address);
        Registers.acc ^= value;
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(EOR_ZERO_PAGE_X, "EOR 3");
        return clockCycles;
    }

    public static int eor_absolute() {
        int clockCycles = 4;

        short address = fetchAddress();
        byte value = Ram.read(address);
        Registers.acc ^= value;
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(EOR_ABSOLUTE, "EOR 4");
        return clockCycles;
    }

    public static int eor_absolute_x() {
        int clockCycles = 4;

        short address = fetchAbsoluteXAddress();
        byte value = Ram.read(address);
        Registers.acc ^= value;
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        clockCycles += pageCrossed;

        if (ArgsHandler.debug)
            Debug.printASM(EOR_ABSOLUTE_X, "EOR 5");
        return clockCycles;
    }

    public static int eor_absolute_y() {
        int clockCycles = 4;

        short address = fetchAbsoluteYAddress();
        byte value = Ram.read(address);
        Registers.acc ^= value;
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        clockCycles += pageCrossed;

        if (ArgsHandler.debug)
            Debug.printASM(EOR_ABSOLUTE_Y, "EOR 6");
        return clockCycles;
    }

    public static int eor_x_ind() {
        int clockCycles = 6;

        short address = fetchXindAddress();
        byte value = Ram.read(address);
        Registers.acc ^= value;
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(EOR_X_IND, "EOR 7");
        return clockCycles;
    }

    public static int eor_ind_y() {
        int clockCycles = 5;

        short address = fetchIndYAddress();
        byte value = Ram.read(address);
        Registers.acc ^= value;
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        clockCycles += pageCrossed;

        if (ArgsHandler.debug)
            Debug.printASM(EOR_IND_Y, "EOR 8");
        return clockCycles;
    }

    /**
     * Increment value in memory
     */
    public static int inc_zero_page() {
        int clockCycles = 5;
        // Fetch address
        byte address = fetchZeroPageAddress();

        // Read and increment value in memory
        byte value = Ram.read(address);
        value = (byte) ((value + 1) & 0xFF);

        Ram.write(address, value);

        Registers.setZeroFlag(value == 0);
        Registers.setNegativeFlag((value & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(INC_ZERO_PAGE, "INC 1");
        return clockCycles;
    }

    public static int inc_zero_page_x() {
        int clockCycles = 6;

        byte address = fetchZeroPageXAddress();

        byte value = Ram.read(address);
        value = (byte) ((value + 1) & 0xFF);

        Ram.write(address, value);
        Registers.setZeroFlag(value == 0);
        Registers.setNegativeFlag((value & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(INC_ZERO_PAGE_X, "INC 2");
        return clockCycles;
    }

    public static int inc_absolute() {
        int clockCycles = 6;

        // Fetch address
        short address = fetchAddress();

        // Read and increment value in memory
        byte value = Ram.read(address);
        value = (byte) ((value + 1) & 0xFF);

        Ram.write(address, value);

        Registers.setZeroFlag(value == 0);
        Registers.setNegativeFlag((value & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(INC_ABSOLUTE, "INC 3");
        return clockCycles;
    }

    public static int inc_absolute_x() {
        int clockCycles = 7;

        // Convert them to little endian
        short address = fetchAbsoluteXAddress();

        // Read and increment value in memory
        byte value = Ram.read(address);
        value = (byte) ((value + 1) & 0xFF);
        Ram.write(address, value);

        Registers.setZeroFlag(value == 0);
        Registers.setNegativeFlag((value & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(INC_ABSOLUTE_X, "INC 4");
        return clockCycles;
    }

    /**
     * Increment X
     */
    public static int inx() {
        int clockCycles = 2;

        Registers.x = (byte) ((Registers.x + 1) & 0xFF);

        Registers.setZeroFlag(Registers.x == 0);
        Registers.setNegativeFlag((Registers.x & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(INX_IMPLIED, "INX");
        return clockCycles;
    }

    public static int iny() {
        int clockCycles = 2;
        Registers.y = (byte) ((Registers.y + 1) & 0xFF);

        Registers.setZeroFlag(Registers.y == 0);
        Registers.setNegativeFlag((Registers.y & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(INY_IMPLIED, "INY");
        return clockCycles;
    }

    /**
     * Jump
     */
    public static int jmp() {
        int clockCycles = 3;

        short address = fetchAddress();
        Registers.pc = (short) (address);
        Registers.pc--;
        if (ArgsHandler.debug)
            Debug.printASM(JMP_ABSOLUTE, "JMP");
        return clockCycles;
    }

    public static int jmp_indirect() {
        int clockCycles = 5;

        short pointer = fetchAddress();
        byte higherByte = (byte) Ram.read(pointer);
        byte lowerByte = (byte) Ram.read((short) (pointer + 1));

        short address = (short) ((higherByte << 8) | lowerByte);

        Registers.pc = address;
        Registers.pc--;

        if (ArgsHandler.debug)
            Debug.printASM(JMP_IND, "JMP I");
        return clockCycles;
    }

    /**
     * Jump to subroutine
     */
    public static int jsr() {
        int clockCycles = 6;

        short address = fetchAddress();

        // Get the subroutine address to jump to.
        short returnAddress = (short) (Registers.pc + 1);

        // Push return address for routine on the stack
        byte higherByte = (byte) ((returnAddress >> 8));
        byte lowerByte = (byte) (returnAddress);

        // Store the return address
        Ram.writeToStack(Registers.sp, lowerByte);
        Registers.sp--;
        Ram.writeToStack(Registers.sp, higherByte);
        Registers.sp--;

        // Set program counter to the subroutine location
        Registers.pc = (short) (address);
        Registers.pc--;

        if (ArgsHandler.debug)
            Debug.printASM(JSR_ABSOLUTE, address, "JSR", "$");

        return clockCycles;
    }

    /**
     * Load accumulator
     */
    public static int lda() {
        int clockCycles = 2;

        Registers.pc++;
        // Fetch the value from memory
        byte value = Cpu.fetchNextValue();

        // Set accumulator value
        Registers.acc = value;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(LDA, "LDA 1");
        return clockCycles;
    }

    public static int lda_zero_page() {
        int clockCycles = 3;

        // Convert them to little endian
        byte address = fetchZeroPageAddress();

        // Fetch the value from memory
        byte value = Ram.read(address);

        // Set accumulator value
        Registers.acc = value;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(address, address, "LDA", "$");
        return clockCycles;
    }

    public static int lda_zero_page_x() {
        int clockCycles = 4;

        byte address = fetchZeroPageXAddress();

        byte value = Ram.read(address);

        Registers.acc = value;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(LDA_ZERO_PAGE_X, "LDA33");
        return clockCycles;
    }

    public static int lda_absolute() {
        int clockCycles = 4;

        // Convert them to little endian
        short address = fetchAddress();

        // Fetch the value from memory
        byte value = Ram.read(address);

        // Set accumulator value
        Registers.acc = value;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(LDA_ABSOLUTE, "LDA 2");
        return clockCycles;
    }

    public static int lda_absolute_x() {
        int clockCycles = 4;
        // Convert them to little endian
        short address = fetchAbsoluteXAddress();

        // Fetch the value from memory
        byte value = Ram.read(address);

        // Set accumulator value
        Registers.acc = value;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        clockCycles += pageCrossed;

        if (ArgsHandler.debug)
            Debug.printASM(LDA_ABSOLUTE_X, "LDA 4");
        return clockCycles;
    }

    public static int lda_absolute_y() {
        int clockCycles = 4;
        // Convert them to little endian
        short address = fetchAbsoluteYAddress();

        // Fetch the value from memory
        byte value = Ram.read(address);

        // Set accumulator value
        Registers.acc = value;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        clockCycles += pageCrossed;

        if (ArgsHandler.debug)
            Debug.printASM(LDA_ABSOLUTE_Y, "LDA 5");
        return clockCycles;
    }

    public static int lda_x_ind() {
        int clockCycles = 6;

        // Convert them to little endian
        short address = fetchXindAddress();

        // Fetch the value from memory
        byte value = Ram.read(address);

        // Set accumulator value
        Registers.acc = value;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(LDA_X_IND, "LDA 7");
        return clockCycles;
    }

    public static int lda_ind_y() {
        int clockCycles = 5;

        // Convert them to little endian
        short address = fetchIndYAddress();

        // Fetch the value from memory
        byte value = Ram.read(address);

        // Set accumulator value
        Registers.acc = value;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        clockCycles += pageCrossed;

        if (ArgsHandler.debug)
            Debug.printASM(LDA_IND_Y, "LDA 9");
        return clockCycles;
    }

    /**
     * Load the X register (Immediate)
     */
    public static int ldx() {
        int clockCycles = 2;
        // Get the next instruction
        Registers.pc++;
        Registers.x = Cpu.fetchNextValue();

        Registers.setZeroFlag(Registers.x == 0);
        Registers.setNegativeFlag((Registers.x & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(LDX, Registers.x, "LDX", "#");

        return clockCycles;
    }

    public static int ldx_zero_page() {
        int clockCycles = 3;

        // Get the next instruction
        byte address = fetchZeroPageAddress();
        Registers.x = Ram.read(address);

        Registers.setZeroFlag(Registers.x == 0);
        Registers.setNegativeFlag((Registers.x & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(LDX_ZERO_PAGE, "LDXs");
        return clockCycles;
    }

    public static int ldx_zero_page_y() {
        int clockCycles = 4;

        byte address = fetchZeroPageYAddress();
        Registers.x = Ram.read(address);

        Registers.setZeroFlag(Registers.x == 0);
        Registers.setNegativeFlag((Registers.x & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(LDX_ZERO_PAGE_Y, "LDXb");
        return clockCycles;
    }

    public static int ldx_absolute() {
        int clockCycles = 4;

        short address = fetchAddress();
        Registers.x = Ram.read(address);

        Registers.setZeroFlag(Registers.x == 0);
        Registers.setNegativeFlag((Registers.x & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(LDX_ABSOLUTE, "LDXa");
        return clockCycles;
    }

    public static int ldx_absolute_y() {
        int clockCycles = 4;

        short address = fetchAbsoluteYAddress();
        Registers.x = Ram.read(address);

        Registers.setZeroFlag(Registers.x == 0);
        Registers.setNegativeFlag((Registers.x & 0x80) != 0);
        clockCycles += pageCrossed;

        if (ArgsHandler.debug)
            Debug.printASM(LDX_ABSOLUTE_Y, "LDXb");
        return clockCycles;
    }

    /**
     * Load Y Register
     */
    public static int ldy() {
        int clockCycles = 2;

        // Get the next instruction
        Registers.pc++;
        Registers.y = Cpu.fetchNextValue();

        Registers.setZeroFlag(Registers.y == 0);
        Registers.setNegativeFlag((Registers.y & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(LDY, "LDY");
        return clockCycles;
    }

    public static int ldy_zero_page() {
        int clockCycles = 3;

        // Get the next instruction
        byte address = fetchZeroPageAddress();
        Registers.y = Ram.read(address);

        Registers.setZeroFlag(Registers.y == 0);
        Registers.setNegativeFlag((Registers.y & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(LDY_ZERO_PAGE, "LDY");
        return clockCycles;
    }

    public static int ldy_zero_page_x() {
        int clockCycles = 4;

        byte address = fetchZeroPageXAddress();
        Registers.y = Ram.read(address);

        Registers.setZeroFlag(Registers.y == 0);
        Registers.setNegativeFlag((Registers.y & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(LDY_ZERO_PAGE_X, "LDY");
        return clockCycles;
    }

    public static int ldy_absolute() {
        int clockCycles = 4;

        short address = fetchAddress();
        Registers.y = Ram.read(address);

        Registers.setZeroFlag(Registers.y == 0);
        Registers.setNegativeFlag((Registers.y & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(LDY_ABSOLUTE, "LDY");
        return clockCycles;
    }

    public static int ldy_absolute_x() {
        int clockCycles = 4;

        short address = fetchAbsoluteXAddress();
        Registers.y = Ram.read(address);

        Registers.setZeroFlag(Registers.y == 0);
        Registers.setNegativeFlag((Registers.y & 0x80) != 0);

        clockCycles += pageCrossed;

        if (ArgsHandler.debug)
            Debug.printASM(LDY_ABSOLUTE_X, "LDY");
        return clockCycles;
    }

    /**
     * Logical shift right
     */
    public static int lsr() {
        int clockCycles = 2;

        Registers.pc++;
        byte value = Cpu.fetchNextValue();
        value >>= 1;

        Registers.acc = value;

        Registers.setCarryFlag((value & 0x01) != 0);
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag(false);

        if (ArgsHandler.debug)
            Debug.printASM(LSR, "LSR");
        return clockCycles;
    }

    public static int lsr_zero_page() {
        int clockCycles = 5;

        byte address = fetchZeroPageAddress();
        byte value = Ram.read(address);

        byte result = (byte) (value >> 1);

        Ram.write(address, result);

        Registers.setCarryFlag((value & 0x01) != 0);
        Registers.setZeroFlag(result == 0);
        Registers.setNegativeFlag(false);

        if (ArgsHandler.debug)
            Debug.printASM(LSR_ZERO_PAGE, "LSR");
        return clockCycles;
    }

    public static int lsr_zero_page_x() {
        int clockCycles = 6;

        byte address = fetchZeroPageXAddress();
        byte value = Ram.read(address);

        byte result = (byte) (value >> 1);

        Ram.write(address, result);

        Registers.setCarryFlag((value & 0x01) != 0);
        Registers.setZeroFlag(result == 0);
        Registers.setNegativeFlag(false);

        if (ArgsHandler.debug)
            Debug.printASM(LSR_ZERO_PAGE_X, "LSR");
        return clockCycles;
    }

    public static int lsr_absolute() {
        int clockCycles = 6;

        short address = fetchAddress();
        byte value = Ram.read(address);

        byte result = (byte) (value >> 1);

        Ram.write(address, result);

        Registers.setCarryFlag((value & 0x01) != 0);
        Registers.setZeroFlag(result == 0);
        Registers.setNegativeFlag(false);

        if (ArgsHandler.debug)
            Debug.printASM(LSR_ABSOLUTE, "LSR");
        return clockCycles;
    }

    public static int lsr_absolute_x() {
        int clockCycles = 6;

        short address = fetchAbsoluteXAddress();
        byte value = Ram.read(address);

        byte result = (byte) (value >> 1);

        Ram.write(address, result);

        Registers.setCarryFlag((value & 0x01) != 0);
        Registers.setZeroFlag(result == 0);
        Registers.setNegativeFlag(false);

        if (ArgsHandler.debug)
            Debug.printASM(LSR_ABSOLUTE_X, "LSR");
        return clockCycles;
    }

    /**
     * No Operation
     */
    public static int nop() {
        int clockCycles = 2;
        if (ArgsHandler.debug)
            Debug.printASM(NOP, "NOP");
        return clockCycles;
    }

    /**
     * OR with accumulator
     */
    public static int ora() {
        int clockCycles = 2;

        Registers.pc++;
        byte value = Cpu.fetchNextValue();

        Registers.acc |= value;
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(ORA, "ORA1");
        return clockCycles;
    }

    public static int ora_zero_page() {
        int clockCycles = 3;

        byte address = fetchZeroPageAddress();
        byte value = Ram.read(address);

        Registers.acc |= value;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);
        if (ArgsHandler.debug)
            Debug.printASM(ORA_ZERO_PAGE, "ORA2");
        return clockCycles;
    }

    public static int ora_zero_page_x() {
        int clockCycles = 4;

        byte address = fetchZeroPageXAddress();
        byte value = Ram.read(address);

        Registers.acc |= value;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(ORA_ZERO_PAGE_X, "ORA3");
        return clockCycles;
    }

    public static int ora_absolute() {
        int clockCycles = 4;

        short address = fetchAddress();
        byte value = Ram.read(address);

        Registers.acc |= value;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(ORA_ABSOLUTE, "ORA4");
        return clockCycles;
    }

    public static int ora_absolute_x() {
        int clockCycles = 4;

        short address = fetchAbsoluteXAddress();
        byte value = Ram.read(address);

        Registers.acc |= value;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);
        clockCycles += pageCrossed;

        if (ArgsHandler.debug)
            Debug.printASM(ORA_ABSOLUTE_X, "ORA");
        return clockCycles;
    }

    public static int ora_absolute_y() {
        int clockCycles = 4;

        short address = fetchAbsoluteYAddress();
        byte value = Ram.read(address);

        Registers.acc |= value;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        clockCycles += pageCrossed;

        if (ArgsHandler.debug)
            Debug.printASM(ORA_ABSOLUTE_Y, "ORA5");
        return clockCycles;
    }

    public static int ora_x_ind() {
        int clockCycles = 6;

        short address = fetchXindAddress();
        byte value = Ram.read(address);

        Registers.acc |= value;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(ORA_X_IND, "ORA6");
        return clockCycles;
    }

    public static int ora_ind_y() {
        int clockCycles = 5;

        short address = fetchIndYAddress();
        byte value = Ram.read(address);

        Registers.acc |= value;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        clockCycles += pageCrossed;

        if (ArgsHandler.debug)
            Debug.printASM(ORA_IND_Y, "ORA7");
        return clockCycles;
    }

    /**
     * Push accumulator to stack
     */
    public static int pha() {
        int clockCycles = 3;

        // Store the return address
        Ram.writeToStack(Registers.sp, Registers.acc);
        Registers.sp--;

        if (ArgsHandler.debug)
            Debug.printASM(PHA_IMPLIED, "PHA");
        return clockCycles;
    }

    /**
     * Push processor status
     */
    public static int php() {
        int clockCycles = 3;

        // Store the return address
        Ram.writeToStack(Registers.status, Registers.acc);
        Registers.sp--;

        if (ArgsHandler.debug)
            Debug.printASM(PHP_IMPLIED, "PHP");
        return clockCycles;
    }

    /**
     * Pull accumulator from stack
     */
    public static int pla() {
        int clockCycles = 4;
        Registers.sp++;
        byte acc = Ram.popFromStack(Registers.sp);

        Registers.acc = acc;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(PLA_IMPLIED, "PLA");
        return clockCycles;
    }

    /**
     * Pull the status of the processor
     * Restore the status register from the stack.
     * Bit 5 of the status register stays the same
     */
    public static int plp() {
        int clockCycles = 4;

        byte statusRegister = Ram.read((short) (0x0100 + (++Registers.sp)));

        Registers.status = (byte) ((statusRegister & ~Registers.BREAK_MASK) | Registers.UNUSED_MASK);

        if (ArgsHandler.debug)
            Debug.printASM(PLP_IMPLIED, "PLP");
        return clockCycles;
    }

    /**
     * Rotate left
     */
    public static int rol() {
        int clockCycles = 2;

        Registers.pc++;
        byte value = Cpu.fetchNextValue();
        boolean mostSignificantBit = (value & 0x80) != 0;

        int carry = ((Registers.status & Registers.CARRY_MASK) != 0) ? 1 : 0;
        value = (byte) ((value << 1) | (carry));
        Registers.acc = value;

        Registers.setCarryFlag(mostSignificantBit);
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(ROL, "ROL 1");
        return clockCycles;
    }

    public static int rol_zero_page() {
        int clockCycles = 5;

        byte address = fetchZeroPageAddress();
        byte value = Ram.read(address);
        boolean mostSignificantBit = (value & 0x80) != 0;

        int carry = ((Registers.status & Registers.CARRY_MASK) != 0) ? 1 : 0;
        value = (byte) ((value << 1) | (carry));
        Ram.write(address, value);

        Registers.setCarryFlag(mostSignificantBit);
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(ROL_ZERO_PAGE, "ROL 2");
        return clockCycles;
    }

    public static int rol_zero_page_x() {
        int clockCycles = 6;

        byte address = fetchZeroPageXAddress();
        byte value = Ram.read(address);
        boolean mostSignificantBit = (value & 0x80) != 0;

        int carry = ((Registers.status & Registers.CARRY_MASK) != 0) ? 1 : 0;
        value = (byte) ((value << 1) | (carry));
        Ram.write(address, value);

        Registers.setCarryFlag(mostSignificantBit);
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(ROL_ZERO_PAGE_X, "ROL 3");
        return clockCycles;
    }

    public static int rol_absolute() {
        int clockCycles = 6;

        short address = fetchAddress();
        byte value = Ram.read(address);
        boolean mostSignificantBit = (value & 0x80) != 0;

        int carry = ((Registers.status & Registers.CARRY_MASK) != 0) ? 1 : 0;
        value = (byte) ((value << 1) | (carry));
        Ram.write(address, value);

        Registers.setCarryFlag(mostSignificantBit);
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(ROL_ABSOLUTE, "ROL 4");
        return clockCycles;
    }

    public static int rol_absolute_x() {
        int clockCycles = 7;

        short address = fetchAbsoluteXAddress();
        byte value = Ram.read(address);
        boolean mostSignificantBit = (value & 0x80) != 0;

        int carry = ((Registers.status & Registers.CARRY_MASK) != 0) ? 1 : 0;
        value = (byte) ((value << 1) | (carry));
        Ram.write(address, value);

        Registers.setCarryFlag(mostSignificantBit);
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(ROL_ABSOLUTE_X, "ROL 5");
        return clockCycles;
    }

    /**
     * Rotate right
     */
    public static int ror() {
        int clockCycles = 2;

        Registers.pc++;
        byte value = Cpu.fetchNextValue();
        boolean mostSignificantBit = (value & 0x80) != 0;

        int carry = ((Registers.status & Registers.CARRY_MASK) != 0) ? 1 : 0;
        value = (byte) ((value >> 1) | (carry));
        Registers.acc = value;

        Registers.setCarryFlag(mostSignificantBit);
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(ROR, "ROR");
        return clockCycles;
    }

    public static int ror_zero_page() {
        int clockCycles = 5;

        byte address = fetchZeroPageAddress();
        byte value = Ram.read(address);
        boolean mostSignificantBit = (value & 0x80) != 0;

        int carry = ((Registers.status & Registers.CARRY_MASK) != 0) ? 1 : 0;
        value = (byte) ((value >> 1) | (carry));
        Registers.acc = value;

        Registers.setCarryFlag(mostSignificantBit);
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(ROR_ZERO_PAGE, "ROR");
        return clockCycles;
    }

    public static int ror_zero_page_x() {
        int clockCycles = 6;

        byte address = fetchZeroPageXAddress();
        byte value = Ram.read(address);
        boolean mostSignificantBit = (value & 0x80) != 0;

        int carry = ((Registers.status & Registers.CARRY_MASK) != 0) ? 1 : 0;
        value = (byte) ((value >> 1) | (carry));
        Registers.acc = value;

        Registers.setCarryFlag(mostSignificantBit);
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(ROR_ZERO_PAGE_X, "ROR");
        return clockCycles;
    }

    public static int ror_absolute() {
        int clockCycles = 6;

        short address = fetchAddress();
        byte value = Ram.read(address);
        boolean mostSignificantBit = (value & 0x80) != 0;

        int carry = ((Registers.status & Registers.CARRY_MASK) != 0) ? 1 : 0;
        value = (byte) ((value >> 1) | (carry));
        Registers.acc = value;

        Registers.setCarryFlag(mostSignificantBit);
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(ROR_ABSOLUTE, "ROR");
        return clockCycles;
    }

    public static int ror_absolute_x() {
        int clockCycles = 7;

        short address = fetchAbsoluteXAddress();
        byte value = Ram.read(address);
        boolean mostSignificantBit = (value & 0x80) != 0;

        int carry = ((Registers.status & Registers.CARRY_MASK) != 0) ? 1 : 0;
        value = (byte) ((value >> 1) | (carry));
        Registers.acc = value;

        Registers.setCarryFlag(mostSignificantBit);
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(ROR_ABSOLUTE_X, "ROR");
        return clockCycles;
    }

    /**
     * Return from interrupt
     */
    public static int rti() {
        int clockCycles = 6;

        // Fetch address off the stack
        Registers.sp++;
        byte status = Ram.popFromStack(Registers.sp);
        Registers.status = status;
        Registers.sp++;
        byte higherByte = Ram.popFromStack(Registers.sp);
        Registers.sp++;
        byte lowerByte = Ram.popFromStack(Registers.sp);
        short address = (short) ((higherByte << 8) | (lowerByte & 0xFF));

        // Return to previous address
        Registers.pc = address;

        if (ArgsHandler.debug)
            Debug.printASM(RTI_IMPLIED, "RTI");
        return clockCycles;
    }

    /**
     * Return to sub routine.
     * 
     */
    public static int rts() {
        int clockCycles = 6;

        // Fetch address off the stack
        Registers.sp++;
        byte higherByte = Ram.popFromStack(Registers.sp);
        Registers.sp++;
        byte lowerByte = Ram.popFromStack(Registers.sp);
        short address = (short) ((higherByte << 8) | (lowerByte & 0xFF));

        // Return to previous address
        Registers.pc = address;

        if (ArgsHandler.debug)
            Debug.printASM(RTS_IMPLIED, "RTS");
        return clockCycles;
    }

    /**
     * Two's compliment subtraction
     */
    public static int sbc() {
        int clockCycles = 2;
        Registers.pc++;
        byte value = Cpu.fetchNextValue();
        int carry = (Registers.status & Registers.CARRY_MASK) != 0 ? 1 : 0;
        int temp_acc = Registers.acc;

        if ((Registers.status & Registers.DECIMAL_MASK) == Registers.DECIMAL_MASK) {
            int lowerNibble = (Registers.acc & 0x0F) - (value & 0x0F) - (1 - carry);
            if (lowerNibble < 0) {
                lowerNibble += 10;
                Registers.acc -= 0x10;
            }
            int higherNibble = (Registers.acc >> 4) - (value >> 4);
            if (higherNibble < 0) {
                higherNibble += 10;
                Registers.status &= ~Registers.CARRY_MASK; // Clear carry (borrow occurred)
            } else {
                Registers.status |= Registers.CARRY_MASK; // Set carry (no borrow)
            }
            Registers.acc = (byte) ((higherNibble << 4) | (lowerNibble & 0x0F));
        } else {
            value = (byte) (~value);
            Registers.acc += value + (carry);

            Registers.setCarryFlag((Registers.acc & 0xFF) >= (value & 0xFF));
            Registers.setZeroFlag(Registers.acc == 0);
            Registers.setNegativeFlag((Registers.acc & 0x80) != 0);
            Registers.setOverflowFlag(((temp_acc ^ Registers.acc) & (temp_acc ^ ~value) & 0x80) != 0);
        }

        if (ArgsHandler.debug)
            Debug.printASM(SBC, "SBC");

        return clockCycles;

    }

    public static int sbc_zero_page() {
        int clockCycles = 3;
        byte address = fetchZeroPageAddress();
        byte value = Ram.read(address);
        int carry = (Registers.status & Registers.CARRY_MASK) != 0 ? 1 : 0;
        int temp_acc = Registers.acc;

        if ((Registers.status & Registers.DECIMAL_MASK) == Registers.DECIMAL_MASK) {
            int lowerNibble = (Registers.acc & 0x0F) - (value & 0x0F) - (1 - carry);
            if (lowerNibble < 0) {
                lowerNibble += 10;
                Registers.acc -= 0x10;
            }
            int higherNibble = (Registers.acc >> 4) - (value >> 4);
            if (higherNibble < 0) {
                higherNibble += 10;
                Registers.status &= ~Registers.CARRY_MASK; // Clear carry (borrow occurred)
            } else {
                Registers.status |= Registers.CARRY_MASK; // Set carry (no borrow)
            }
            Registers.acc = (byte) ((higherNibble << 4) | (lowerNibble & 0x0F));
        } else {
            value = (byte) (~value);
            Registers.acc += value + (carry);

            Registers.setCarryFlag((Registers.acc & 0xFF) >= (value & 0xFF));
            Registers.setZeroFlag(Registers.acc == 0);
            Registers.setNegativeFlag((Registers.acc & 0x80) != 0);
            Registers.setOverflowFlag(((temp_acc ^ Registers.acc) & (temp_acc ^ ~value) & 0x80) != 0);
        }

        if (ArgsHandler.debug)
            Debug.printASM(SBC_ZERO_PAGE, "SBC 1");
        return clockCycles;

    }

    public static int sbc_zero_page_x() {
        int clockCycles = 4;

        byte address = fetchZeroPageXAddress();
        byte value = Ram.read(address);
        int carry = (Registers.status & Registers.CARRY_MASK) != 0 ? 1 : 0;
        int temp_acc = Registers.acc;

        if ((Registers.status & Registers.DECIMAL_MASK) == Registers.DECIMAL_MASK) {
            int lowerNibble = (Registers.acc & 0x0F) - (value & 0x0F) - (1 - carry);
            if (lowerNibble < 0) {
                lowerNibble += 10;
                Registers.acc -= 0x10;
            }
            int higherNibble = (Registers.acc >> 4) - (value >> 4);
            if (higherNibble < 0) {
                higherNibble += 10;
                Registers.status &= ~Registers.CARRY_MASK; // Clear carry (borrow occurred)
            } else {
                Registers.status |= Registers.CARRY_MASK; // Set carry (no borrow)
            }
            Registers.acc = (byte) ((higherNibble << 4) | (lowerNibble & 0x0F));
        } else {
            value = (byte) (~value);
            Registers.acc += value + (carry);

            Registers.setCarryFlag((Registers.acc & 0xFF) >= (value & 0xFF));
            Registers.setZeroFlag(Registers.acc == 0);
            Registers.setNegativeFlag((Registers.acc & 0x80) != 0);
            Registers.setOverflowFlag(((temp_acc ^ Registers.acc) & (temp_acc ^ ~value) & 0x80) != 0);
        }

        if (ArgsHandler.debug)
            Debug.printASM(SBC_ZERO_PAGE_X, "SBC 2");
        return clockCycles;
    }

    public static int sbc_absolute() {
        int clockCycles = 4;

        short address = fetchAddress();
        byte value = Ram.read(address);
        int carry = (Registers.status & Registers.CARRY_MASK) != 0 ? 1 : 0;
        int temp_acc = Registers.acc;

        if ((Registers.status & Registers.DECIMAL_MASK) == Registers.DECIMAL_MASK) {
            int lowerNibble = (Registers.acc & 0x0F) - (value & 0x0F) - (1 - carry);
            if (lowerNibble < 0) {
                lowerNibble += 10;
                Registers.acc -= 0x10;
            }
            int higherNibble = (Registers.acc >> 4) - (value >> 4);
            if (higherNibble < 0) {
                higherNibble += 10;
                Registers.status &= ~Registers.CARRY_MASK; // Clear carry (borrow occurred)
            } else {
                Registers.status |= Registers.CARRY_MASK; // Set carry (no borrow)
            }
            Registers.acc = (byte) ((higherNibble << 4) | (lowerNibble & 0x0F));
        } else {
            value = (byte) (~value);
            Registers.acc += value + (carry);

            Registers.setCarryFlag((Registers.acc & 0xFF) >= (value & 0xFF));
            Registers.setZeroFlag(Registers.acc == 0);
            Registers.setNegativeFlag((Registers.acc & 0x80) != 0);
            Registers.setOverflowFlag(((temp_acc ^ Registers.acc) & (temp_acc ^ ~value) & 0x80) != 0);
        }

        if (ArgsHandler.debug)
            Debug.printASM(SBC_ABSOLUTE, "SBC 3");

        return clockCycles;

    }

    public static int sbc_absolute_x() {
        int clockCycles = 4;

        short address = fetchAbsoluteXAddress();
        byte value = Ram.read(address);
        int carry = (Registers.status & Registers.CARRY_MASK) != 0 ? 1 : 0;
        int temp_acc = Registers.acc;

        if ((Registers.status & Registers.DECIMAL_MASK) == Registers.DECIMAL_MASK) {
            int lowerNibble = (Registers.acc & 0x0F) - (value & 0x0F) - (1 - carry);
            if (lowerNibble < 0) {
                lowerNibble += 10;
                Registers.acc -= 0x10;
            }
            int higherNibble = (Registers.acc >> 4) - (value >> 4);
            if (higherNibble < 0) {
                higherNibble += 10;
                Registers.status &= ~Registers.CARRY_MASK; // Clear carry (borrow occurred)
            } else {
                Registers.status |= Registers.CARRY_MASK; // Set carry (no borrow)
            }
            Registers.acc = (byte) ((higherNibble << 4) | (lowerNibble & 0x0F));
        } else {
            value = (byte) (~value);
            Registers.acc += value + (carry);

            Registers.setCarryFlag((Registers.acc & 0xFF) >= (value & 0xFF));
            Registers.setZeroFlag(Registers.acc == 0);
            Registers.setNegativeFlag((Registers.acc & 0x80) != 0);
            Registers.setOverflowFlag(((temp_acc ^ Registers.acc) & (temp_acc ^ ~value) & 0x80) != 0);
        }

        clockCycles += pageCrossed;

        if (ArgsHandler.debug)
            Debug.printASM(SBC_ABSOLUTE_X, "SBC 4");
        return clockCycles;
    }

    public static int sbc_absolute_y() {
        int clockCycles = 4;

        short address = fetchAbsoluteYAddress();
        byte value = Ram.read(address);
        int carry = (Registers.status & Registers.CARRY_MASK) != 0 ? 1 : 0;
        int temp_acc = Registers.acc;

        if ((Registers.status & Registers.DECIMAL_MASK) == Registers.DECIMAL_MASK) {
            int lowerNibble = (Registers.acc & 0x0F) - (value & 0x0F) - (1 - carry);
            if (lowerNibble < 0) {
                lowerNibble += 10;
                Registers.acc -= 0x10;
            }
            int higherNibble = (Registers.acc >> 4) - (value >> 4);
            if (higherNibble < 0) {
                higherNibble += 10;
                Registers.status &= ~Registers.CARRY_MASK; // Clear carry (borrow occurred)
            } else {
                Registers.status |= Registers.CARRY_MASK; // Set carry (no borrow)
            }
            Registers.acc = (byte) ((higherNibble << 4) | (lowerNibble & 0x0F));
        } else {
            value = (byte) (~value);
            Registers.acc += value + (carry);

            Registers.setCarryFlag((Registers.acc & 0xFF) >= (value & 0xFF));
            Registers.setZeroFlag(Registers.acc == 0);
            Registers.setNegativeFlag((Registers.acc & 0x80) != 0);
            Registers.setOverflowFlag(((temp_acc ^ Registers.acc) & (temp_acc ^ ~value) & 0x80) != 0);
        }

        clockCycles += pageCrossed;

        if (ArgsHandler.debug)
            Debug.printASM(SBC_ABSOLUTE_Y, "SBC 5");
        return clockCycles;
    }

    public static int sbc_x_ind() {
        int clockCycles = 6;

        short address = fetchXindAddress();
        byte value = Ram.read(address);
        int carry = (Registers.status & Registers.CARRY_MASK) != 0 ? 1 : 0;
        int temp_acc = Registers.acc;

        if ((Registers.status & Registers.DECIMAL_MASK) == Registers.DECIMAL_MASK) {
            int lowerNibble = (Registers.acc & 0x0F) - (value & 0x0F) - (1 - carry);
            if (lowerNibble < 0) {
                lowerNibble += 10;
                Registers.acc -= 0x10;
            }
            int higherNibble = (Registers.acc >> 4) - (value >> 4);
            if (higherNibble < 0) {
                higherNibble += 10;
                Registers.status &= ~Registers.CARRY_MASK; // Clear carry (borrow occurred)
            } else {
                Registers.status |= Registers.CARRY_MASK; // Set carry (no borrow)
            }
            Registers.acc = (byte) ((higherNibble << 4) | (lowerNibble & 0x0F));
        } else {
            value = (byte) (~value);
            Registers.acc += value + (carry);

            Registers.setCarryFlag((Registers.acc & 0xFF) >= (value & 0xFF));
            Registers.setZeroFlag(Registers.acc == 0);
            Registers.setNegativeFlag((Registers.acc & 0x80) != 0);
            Registers.setOverflowFlag(((temp_acc ^ Registers.acc) & (temp_acc ^ ~value) & 0x80) != 0);
        }

        if (ArgsHandler.debug)
            Debug.printASM(SBC_X_IND, "SBC 6");
        return clockCycles;
    }

    public static int sbc_ind_y() {
        int clockCycles = 5;

        short address = fetchIndYAddress();
        byte value = Ram.read(address);
        int carry = (Registers.status & Registers.CARRY_MASK) != 0 ? 1 : 0;
        int temp_acc = Registers.acc;

        if ((Registers.status & Registers.DECIMAL_MASK) == Registers.DECIMAL_MASK) {
            int lowerNibble = (Registers.acc & 0x0F) - (value & 0x0F) - (1 - carry);
            if (lowerNibble < 0) {
                lowerNibble += 10;
                Registers.acc -= 0x10;
            }
            int higherNibble = (Registers.acc >> 4) - (value >> 4);
            if (higherNibble < 0) {
                higherNibble += 10;
                Registers.status &= ~Registers.CARRY_MASK; // Clear carry (borrow occurred)
            } else {
                Registers.status |= Registers.CARRY_MASK; // Set carry (no borrow)
            }
            Registers.acc = (byte) ((higherNibble << 4) | (lowerNibble & 0x0F));
        } else {
            value = (byte) (~value);
            Registers.acc += value + (carry);

            Registers.setCarryFlag((Registers.acc & 0xFF) >= (value & 0xFF));
            Registers.setZeroFlag(Registers.acc == 0);
            Registers.setNegativeFlag((Registers.acc & 0x80) != 0);
            Registers.setOverflowFlag(((temp_acc ^ Registers.acc) & (temp_acc ^ ~value) & 0x80) != 0);
        }

        clockCycles += pageCrossed;

        if (ArgsHandler.debug)
            Debug.printASM(SBC_IND_Y, "SBC 7");
        return clockCycles;
    }

    /**
     * Shift right XOR
     */
    public static int sre_x_ind() {
        int clockCycles = 8;
        if (ArgsHandler.debug)
            Debug.printASM(SRE_X_IND, "SRE 1");
        return clockCycles;
    }

    public static int sre_zero_page() {
        int clockCycles = 5;

        byte address = fetchZeroPageAddress();
        byte value = Ram.read(address);
        Registers.status &= (value & Registers.CARRY_MASK);
        Registers.setCarryFlag((value & 0x01) != 0);
        value >>= 1;
        Ram.write(address, value);
        Registers.acc ^= value;
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);
        if (ArgsHandler.debug)
            Debug.printASM(SRE_ZERO_PAGE, "SRE 2");
        return clockCycles;
    }

    public static int sre_absolute() {
        int clockCycles = 6;

        short address = fetchAddress();
        byte value = Ram.read(address);
        Registers.setCarryFlag((value & 0x01) != 0);
        value >>= 1;
        Ram.write(address, value);
        Registers.acc ^= value;
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(SRE_ABSOLUTE, "SRE3 ");
        return clockCycles;
    }

    public static int sre_ind_y() {
        int clockCycles = 8;

        short address = fetchIndYAddress();
        byte value = Ram.read(address);
        Registers.setCarryFlag((value & 0x01) != 0);
        value >>= 1;
        Ram.write(address, value);
        Registers.acc ^= value;
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(SRE_IND_Y, "SRE4");
        return clockCycles;
    }

    public static int sre_zero_page_x() {
        int clockCycles = 6;

        byte address = fetchZeroPageXAddress();
        byte value = Ram.read(address);
        Registers.setCarryFlag((value & 0x01) != 0);
        value >>= 1;
        Ram.write(address, value);
        Registers.acc ^= value;
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(SRE_ZERO_PAGE_X, "SRE5");
        return clockCycles;
    }

    public static int sre_absolute_y() {
        int clockCycles = 7;

        short address = fetchAbsoluteYAddress();
        byte value = Ram.read(address);
        Registers.setCarryFlag((value & 0x01) != 0);
        value >>= 1;
        Ram.write(address, value);
        Registers.acc ^= value;
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(SRE_ABSOLUTE_Y, "SRE6");
        return clockCycles;
    }

    public static int sre_absolute_x() {
        int clockCycles = 7;

        short address = fetchAbsoluteXAddress();
        byte value = Ram.read(address);
        Registers.setCarryFlag((value & 0x01) != 0);
        value >>= 1;
        Ram.write(address, value);
        Registers.acc ^= value;
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(SRE_ABSOLUTE_X, "SRE7");
        return clockCycles;
    }

    /**
     * Set carry flag
     */
    public static int sec() {
        int clockCycles = 2;

        Registers.setCarryFlag(true);

        if (ArgsHandler.debug)
            Debug.printASM(SEC_IMPLIED, "SEC");
        return clockCycles;
    }

    /**
     * Set Decimal flag
     */
    public static int sed() {
        int clockCycles = 2;

        Registers.setDecimalFlag(true);

        if (ArgsHandler.debug)
            Debug.printASM(SED_IMPLIED, "SED");
        return clockCycles;
    }

    /**
     * Set interrupt disable status
     */
    public static int sei() {
        int clockCycles = 2;

        Registers.setInterruptFlag(true);

        if (ArgsHandler.debug)
            Debug.printASM(SEI_IMPLIED, "SEI");

        return clockCycles;
    }

    /**
     * Store accumulator
     */
    public static int sta_zero_page() {
        int clockCycles = 3;

        byte address = fetchZeroPageAddress();
        Ram.write(address, Registers.acc);

        if (ArgsHandler.debug)
            Debug.printASM(STA_ZERO_PAGE, "STA 1");
        return clockCycles;
    }

    public static int sta_zero_page_x() {
        int clockCycles = 4;
        byte address = fetchZeroPageXAddress();
        Ram.write(address, Registers.acc);

        if (ArgsHandler.debug)
            Debug.printASM(STA_ZERO_PAGE_X, "STA 2");
        return clockCycles;
    }

    public static int sta_absolute() {
        int clockCycles = 4;
        short address = fetchAddress();
        Ram.write(address, Registers.acc);

        if (ArgsHandler.debug)
            Debug.printASM(STA_ABSOLUTE, "STA 3");
        return clockCycles;
    }

    public static int sta_absolute_x() {
        int clockCycles = 5;
        short address = fetchAbsoluteXAddress();
        Ram.write(address, Registers.acc);

        if (ArgsHandler.debug)
            Debug.printASM(STA_ABSOLUTE_X, "STA 4");
        return clockCycles;
    }

    public static int sta_absolute_y() {
        int clockCycles = 5;

        short address = fetchAbsoluteYAddress();
        Ram.write(address, Registers.acc);

        if (ArgsHandler.debug)
            Debug.printASM(STA_ABSOLUTE_Y, "STA 5");
        return clockCycles;
    }

    public static int sta_x_ind() {
        int clockCycles = 6;

        short address = fetchXindAddress();
        Ram.write(address, Registers.acc);

        if (ArgsHandler.debug)
            Debug.printASM(STA_X_IND, "STA 6");
        return clockCycles;
    }

    public static int sta_ind_y() {
        int clockCycles = 6;

        short address = fetchIndYAddress();
        Ram.write(address, Registers.acc);

        if (ArgsHandler.debug)
            Debug.printASM(STA_IND_Y, "STA 7");
        return clockCycles;
    }

    /**
     * Store X
     */
    public static int stx_zero_page() {
        int clockCycles = 3;

        // Get the address
        byte address = fetchZeroPageAddress();

        Ram.write(address, Registers.x);

        if (ArgsHandler.debug)
            Debug.printASM(STX_ZERO_PAGE, "STX");
        return clockCycles;
    }

    public static int stx_zero_page_y() {
        int clockCycles = 4;
        byte address = fetchZeroPageYAddress();

        Ram.write(address, Registers.x);

        if (ArgsHandler.debug)
            Debug.printASM(STX_ZERO_PAGE_Y, "STX");
        return clockCycles;
    }

    public static int stx_absolute() {
        int clockCycles = 4;

        // Get the address
        short address = fetchAddress();

        Ram.write(address, Registers.x);

        if (ArgsHandler.debug)
            Debug.printASM(Registers.pc, address, "STX", "$");

        return clockCycles;
    }

    /**
     * Store Y
     */
    public static int sty_zero_page() {
        int clockCycles = 3;

        byte address = fetchZeroPageAddress();

        Ram.write(address, Registers.y);

        if (ArgsHandler.debug)
            Debug.printASM(STY_ZERO_PAGE, "STY");
        return clockCycles;
    }

    public static int sty_zero_page_x() {
        int clockCycles = 4;

        byte address = fetchZeroPageXAddress();

        Ram.write(address, Registers.y);

        if (ArgsHandler.debug)
            Debug.printASM(STY_ZERO_PAGE_X, "STY");
        return clockCycles;
    }

    public static int sty_absolute() {
        int clockCycles = 4;

        short address = fetchAddress();

        Ram.write(address, Registers.y);

        if (ArgsHandler.debug)
            Debug.printASM(STY_ABSOLUTE, "STY");
        return clockCycles;
    }

    /**
     * Transfer Accumulator to X
     */
    public static int tax() {
        int clockCycles = 2;

        Registers.x = Registers.acc;

        Registers.setZeroFlag(Registers.x == 0);
        Registers.setNegativeFlag((Registers.x & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(TAX_IMPLIED, "TAX");
        return clockCycles;
    }

    /**
     * Transfer accumulator to Y
     */
    public static int tay() {
        int clockCycles = 2;
        Registers.y = Registers.acc;

        Registers.setZeroFlag(Registers.y == 0);
        Registers.setNegativeFlag((Registers.y & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(TAY_IMPLIED, "TAY");
        return clockCycles;
    }

    /**
     * Transfer Stack Pointer to X
     */
    public static int tsx() {
        int clockCycles = 2;

        Registers.x = Registers.sp;

        Registers.setZeroFlag(Registers.x == 0);
        Registers.setNegativeFlag((Registers.x & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(TSX_IMPLIED, "TSX");
        return clockCycles;
    }

    /**
     * Transfer X to accumulator
     */
    public static int txa() {
        int clockCycles = 2;

        Registers.acc = Registers.x;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(TXA_IMPLIED, "TXA");
        return clockCycles;
    }

    /**
     * Transfer X to Stack Pointer
     */
    public static int txs() {
        int clockCycles = 2;

        Registers.sp = Registers.x;

        if (ArgsHandler.debug)
            Debug.printASM(TXS_IMPLIED, "TXS");
        return clockCycles;
    }

    /**
     * Transfer Y to accumulator
     */
    public static int tya() {
        int clockCycles = 2;

        Registers.acc = Registers.y;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(TYA_IMPLIED, "TYA");
        return clockCycles;
    }

    /**
     * Rotate AND
     */
    public static int rla_zero_page() {
        int clockCycles = 5;
        byte address = fetchZeroPageAddress();
        byte value = Ram.read(address);

        // Rotate value
        int carry = (Registers.status & Registers.CARRY_MASK) != 0 ? 1 : 0;
        value = (byte) (((value << 1) | carry) & 0xFF);

        // Store value
        Ram.write(address, value);

        Registers.acc &= value;

        Registers.setCarryFlag((value & 0x80) != 0);
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(RLA_ZERO_PAGE, "RLA 1 ");
        return clockCycles;
    }

    public static int rla_zero_page_x() {
        int clockCycles = 6;
        byte address = fetchZeroPageXAddress();
        byte value = Ram.read(address);

        // Rotate value
        int carry = (Registers.status & Registers.CARRY_MASK) != 0 ? 1 : 0;
        value = (byte) (((value << 1) | carry) & 0xFF);

        // Store value
        Ram.write(address, value);

        Registers.acc &= value;

        Registers.setCarryFlag((value & 0x80) != 0);
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(RLA_ZERO_PAGE_X, "RLA 2");
        return clockCycles;
    }

    public static int rla_absolute() {
        int clockCycles = 6;
        short address = fetchAddress();
        byte value = Ram.read(address);

        // Rotate value
        int carry = (Registers.status & Registers.CARRY_MASK) != 0 ? 1 : 0;
        value = (byte) (((value << 1) | carry) & 0xFF);

        // Store value
        Ram.write(address, value);

        Registers.acc &= value;

        Registers.setCarryFlag((value & 0x80) != 0);
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(RLA_ABSOLUTE, "RLA 3");
        return clockCycles;
    }

    public static int rla_absolute_x() {
        int clockCycles = 7;
        short address = fetchAbsoluteXAddress();
        byte value = Ram.read(address);

        // Rotate value
        int carry = (Registers.status & Registers.CARRY_MASK) != 0 ? 1 : 0;
        value = (byte) (((value << 1) | carry) & 0xFF);

        // Store value
        Ram.write(address, value);

        Registers.acc &= value;

        Registers.setCarryFlag((value & 0x80) != 0);
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(RLA_ABSOLUTE_X, "RLA 4");
        return clockCycles;
    }

    public static int rla_absolute_y() {
        int clockCycles = 7;
        short address = fetchAbsoluteYAddress();
        byte value = Ram.read(address);

        // Rotate value
        int carry = (Registers.status & Registers.CARRY_MASK) != 0 ? 1 : 0;
        value = (byte) (((value << 1) | carry) & 0xFF);

        // Store value
        Ram.write(address, value);

        Registers.acc &= value;

        Registers.setCarryFlag((value & 0x80) != 0);
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(RLA_ABSOLUTE_Y, "RLA 5");
        return clockCycles;
    }

    public static int rla_x_ind() {
        int clockCycles = 8;
        short address = fetchXindAddress();
        byte value = Ram.read(address);

        // Rotate value
        int carry = (Registers.status & Registers.CARRY_MASK) != 0 ? 1 : 0;
        value = (byte) (((value << 1) | carry) & 0xFF);

        // Store value
        Ram.write(address, value);

        Registers.acc &= value;

        Registers.setCarryFlag((value & 0x80) != 0);
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(RLA_X_IND, "RLA 6");
        return clockCycles;
    }

    public static int rla_ind_y() {
        int clockCycles = 8;
        short address = fetchIndYAddress();
        byte value = Ram.read(address);

        // Rotate value
        int carry = (Registers.status & Registers.CARRY_MASK) != 0 ? 1 : 0;
        value = (byte) (((value << 1) | carry) & 0xFF);

        // Store value
        Ram.write(address, value);

        Registers.acc &= value;

        Registers.setCarryFlag((value & 0x80) != 0);
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(RLA_IND_Y, "RLA 7");
        return clockCycles;
    }

    /**
     * 
     */
    public static int rra_x_ind() {
        int clockCycles = 0;
        if (ArgsHandler.debug)
            Debug.printASM(RRA_X_IND, "RRA");
        return clockCycles;
    }

    public static int rra_zero_page() {
        int clockCycles = 0;
        if (ArgsHandler.debug)
            Debug.printASM(RRA_ZERO_PAGE, "RRA");
        return clockCycles;
    }

    public static int rra_absolute() {
        int clockCycles = 0;
        if (ArgsHandler.debug)
            Debug.printASM(RRA_ABSOLUTE, "RRA");
        return clockCycles;
    }

    public static int rra_ind_y() {
        int clockCycles = 0;
        if (ArgsHandler.debug)
            Debug.printASM(RRA_IND_Y, "RRA");
        return clockCycles;
    }

    public static int rra_zero_page_x() {
        int clockCycles = 0;
        if (ArgsHandler.debug)
            Debug.printASM(RRA_ZERO_PAGE_X, "RRA");
        return clockCycles;
    }

    public static int rra_absolute_y() {
        int clockCycles = 0;
        if (ArgsHandler.debug)
            Debug.printASM(RRA_ABSOLUTE_Y, "RRA");
        return clockCycles;
    }

    public static int rra_absolute_x() {
        int clockCycles = 0;
        if (ArgsHandler.debug)
            Debug.printASM(RRA_ABSOLUTE_X, "RRA");
        return clockCycles;
    }

    /**
     * Homebrew function
     * Combination between ASL and ORA
     */
    public static int slo_zero_page() {
        int clockCycles = 5;
        // Get the address parts zero page wrap around
        byte address = fetchZeroPageAddress();

        // Get value at address
        byte value = Ram.read(address);
        Registers.setCarryFlag((value & 0x80) != 0);

        // Perform ASL on value
        value <<= 1;

        // ORA
        Registers.acc |= value;

        Ram.write(address, value);

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(SLO_ZERO_PAGE, "SLO1");
        return clockCycles;
    }

    public static int slo_zero_page_x() {
        int clockCycles = 6;
        // Get the address parts zero page wrap around
        byte address = fetchZeroPageXAddress();

        // Get value at address
        byte value = Ram.read(address);
        Registers.setCarryFlag((value & 0x80) != 0);

        // Perform ASL on value
        value <<= 1;

        // ORA
        Registers.acc |= value;

        Ram.write(address, value);
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(SLO_ZERO_PAGE_X, "SLO2");
        return clockCycles;
    }

    public static int slo_absolute() {
        int clockCycles = 6;

        // Get the address parts zero page wrap around
        short address = fetchAddress();

        // Get value at address
        byte value = Ram.read(address);
        Registers.setCarryFlag((value & 0x80) != 0);

        // Perform ASL on value
        value <<= 1;

        // ORA
        Registers.acc |= value;

        Ram.write(address, value);
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(SLO_ABSOLUTE, "SLO3");
        return clockCycles;
    }

    public static int slo_absolute_x() {
        int clockCycles = 7;

        // Get the address parts zero page wrap around
        short address = fetchAbsoluteXAddress();

        // Get value at address
        byte value = Ram.read(address);
        Registers.setCarryFlag((value & 0x80) != 0);

        // Perform ASL on value
        value <<= 1;

        // ORA
        Registers.acc |= value;

        Ram.write(address, value);
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(SLO_ABSOLUTE_X, "SLO4");
        return clockCycles;
    }

    public static int slo_absolute_y() {
        int clockCycles = 7;

        // Get the address parts zero page wrap around
        short address = fetchAbsoluteYAddress();

        // Get value at address
        byte value = Ram.read(address);
        Registers.setCarryFlag((value & 0x80) != 0);

        // Perform ASL on value
        value <<= 1;

        // ORA
        Registers.acc |= value;

        Ram.write(address, value);
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(SLO_ABSOLUTE_Y, "SLO5");
        return clockCycles;
    }

    /**
     * ASL + ORA
     */
    public static int slo_x_ind() {
        int clockCycles = 8;

        short address = fetchXindAddress();
        address += Registers.x;

        byte value = Ram.read(address);
        Registers.setCarryFlag((value & Registers.CARRY_MASK) != 0);
        value <<= 1;
        Registers.acc = (byte) (Registers.acc | value);

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(SLO_X_IND, "SLO6");
        return clockCycles;
    }

    public static int slo_ind_y() {
        int clockCycles = 8;

        short address = fetchIndYAddress();
        address += Registers.x;

        byte value = Ram.read(address);
        Registers.setCarryFlag((value & Registers.CARRY_MASK) != 0);
        value <<= 1;
        Registers.acc = (byte) (Registers.acc | value);

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);

        if (ArgsHandler.debug)
            Debug.printASM(SLO_IND_Y, "SLO7");
        return clockCycles;
    }

    /**
     * LOAD A and X
     */
    public static int lax_zero_page() {
        int clockCycles = 3;
        if (ArgsHandler.debug)
            Debug.printASM(LAX_ZERO_PAGE, "LAX");
        return clockCycles;
    }

    public static int lax_absolute() {
        int clockCycles = 4;
        if (ArgsHandler.debug)
            Debug.printASM(LAX_ABSOLUTE, "LAX");
        return clockCycles;
    }

    public static int lax_ind_y() {
        int clockCycles = 5;

        clockCycles += pageCrossed;

        if (ArgsHandler.debug)
            Debug.printASM(LAX_IND_Y, "LAX");
        return clockCycles;
    }

    public static int lax_zero_page_y() {
        int clockCycles = 4;
        if (ArgsHandler.debug)
            Debug.printASM(LAX_ZERO_PAGE_Y, "LAX");
        return clockCycles;
    }

    public static int lax_absolute_y() {
        int clockCycles = 4;

        clockCycles += pageCrossed;

        if (ArgsHandler.debug)
            Debug.printASM(LAX_ABSOLUTE_Y, "LAX");
        return clockCycles;
    }

    public static int lax_x_ind() {
        int clockCycles = 0;

        return clockCycles;
    }

    /**
     * 
     */
    public static int dcp_x_ind() {
        int clockCycles = 8;

        return clockCycles;
    }

    public static int dcp_zero_page() {
        int clockCycles = 5;

        return clockCycles;
    }

    public static int dcp_absolute() {
        int clockCycles = 6;

        return clockCycles;
    }

    public static int dcp_ind_y() {
        int clockCycles = 8;

        return clockCycles;
    }

    public static int dcp_zero_page_x() {
        int clockCycles = 6;

        return clockCycles;
    }

    public static int dcp_absolute_y() {
        int clockCycles = 7;

        return clockCycles;
    }

    public static int dcp_absolute_x() {
        int clockCycles = 7;

        return clockCycles;
    }

    /**
     * ACC and X
     */
    public static int sax_zero_page() {
        int clockCycles = 3;
        byte address = fetchZeroPageAddress();
        byte value = (byte) (Registers.acc & Registers.x);
        Ram.write(address, value);
        if (ArgsHandler.debug)
            Debug.printASM(SAX_ZERO_PAGE, "SAX 1");
        return clockCycles;
    }

    public static int sax_absolute() {
        int clockCycles = 4;
        if (ArgsHandler.debug)
            Debug.printASM(SAX_ABSOLUTE, "SAX 2");
        return clockCycles;
    }

    public static int sax_zero_page_y() {
        int clockCycles = 4;
        if (ArgsHandler.debug)
            Debug.printASM(SAX_ZERO_PAGE_Y, "SAX 3");
        return clockCycles;
    }

    public static int sax_x_ind() {
        int clockCycles = 6;

        return clockCycles;
    }

    public static int sbc_immediate() {
        int clockCycles = 0;
        if (ArgsHandler.debug)
            Debug.printASM(SBC, "SBC");
        return clockCycles;
    }

    public static int shy_absolute_x() {
        int clockCycles = 5;
        if (ArgsHandler.debug)
            Debug.printASM(SHY_ABSOLUTE_X, "SHY");
        return clockCycles;
    }

    public static int shx_absolute_y() {
        int clockCycles = 5;
        if (ArgsHandler.debug)
            Debug.printASM(SHX_ABSOLUTE_Y, "SHX");
        return clockCycles;
    }

    public static int las_absolute_y() {
        int clockCycles = 4;

        clockCycles += pageCrossed;

        return clockCycles;
    }

    public static int xaa_immediate() {
        int clockCycles = 0;
        Registers.pc++;
        byte value = Cpu.fetchNextValue();
        Registers.acc = (byte) ((Registers.acc & Registers.x) & value);
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & 0x80) != 0);
        if (ArgsHandler.debug)
            Debug.printASM(ANE, "XAA");
        return clockCycles;
    }

    public static int nop_zero_page() {
        int clockCycles = 3;
        fetchZeroPageAddress();
        return clockCycles;
    }

    public static int nop_zero_page_x() {
        int clockCycles = 4;
        fetchZeroPageXAddress();
        return clockCycles;
    }

    public static int nop_absolute() {
        int clockCycles = 4;
        fetchAddress();
        return clockCycles;
    }

    public static int nop_absolute_x() {
        int clockCycles = 4;
        fetchAbsoluteXAddress();
        clockCycles += pageCrossed;

        return clockCycles;
    }

    public static int jam() {
        int clockCycles = 0;

        return clockCycles;
    }

    public static int anc() {
        int clockCycles = 2;

        return clockCycles;
    }

    public static int alr() {
        int clockCycles = 2;

        return clockCycles;
    }

    public static int arr() {
        int clockCycles = 2;

        return clockCycles;
    }

    public static int ane() {
        int clockCycles = 2;

        return clockCycles;
    }

    public static int sha_ind_y() {
        int clockCycles = 6;

        return clockCycles;
    }

    public static int tas_absolute_y() {
        int clockCycles = 0;

        return clockCycles;
    }

    public static int sha_absolute_y() {
        int clockCycles = 5;

        return clockCycles;
    }

    public static int lxa() {
        int clockCycles = 2;

        return clockCycles;
    }

    public static int sbx() {
        int clockCycles = 2;

        return clockCycles;
    }

    public static int isc_x_ind() {
        int clockCycles = 8;

        return clockCycles;
    }

    public static int isc_zero_page() {
        int clockCycles = 5;

        return clockCycles;
    }

    public static int isc_absolute() {
        int clockCycles = 6;

        return clockCycles;
    }

    public static int isc_ind_y() {
        int clockCycles = 8;

        return clockCycles;
    }

    public static int isc_zero_page_x() {
        int clockCycles = 6;

        return clockCycles;
    }

    public static int isc_absolute_y() {
        int clockCycles = 7;

        return clockCycles;
    }

    public static int isc_absolute_x() {
        int clockCycles = 7;

        return clockCycles;
    }

    public static int usbc() {
        int clockCycles = 2;

        return clockCycles;
    }

    private static short fetchIndYAddress() {
        byte address = fetchZeroPageAddress();
        address = (byte) ((address + Registers.y) & 0xFF);
        // Fetch the address
        byte lowerByte = Ram.read(address);
        byte higherByte = Ram.read((byte) ((address + 1) & 0xFF));
        short return_address = (short) ((higherByte << 8) | (lowerByte & 0xFF));
        return return_address;
    }

    private static short fetchXindAddress() {
        byte address = fetchZeroPageAddress();
        address = (byte) ((address + Registers.x) & 0xFF);
        // Fetch the address
        byte lowerByte = Ram.read(address);
        byte higherByte = Ram.read((byte) ((address + 1) & 0xFF));
        short return_address = (short) ((higherByte << 8) | (lowerByte & 0xFF));
        return return_address;
    }

    private static short fetchAbsoluteYAddress() {
        short address = fetchAddress();
        address += Registers.y;
        return address;
    }

    private static short fetchAbsoluteXAddress() {
        short address = fetchAddress();
        address += Registers.x;
        return address;
    }

    private static byte fetchZeroPageAddress() {
        // Get the address
        Registers.pc++;
        byte address = (byte) (Cpu.fetchNextValue() & 0xFF);
        return address;
    }

    private static byte fetchZeroPageXAddress() {
        byte zero_page_address = fetchZeroPageAddress();
        zero_page_address = (byte) ((zero_page_address + Registers.x) & 0xFF);
        return zero_page_address;
    }

    private static byte fetchZeroPageYAddress() {
        byte zero_page_address = fetchZeroPageAddress();
        zero_page_address = (byte) ((zero_page_address + Registers.y) & 0xFF);
        return zero_page_address;
    }

    private static short fetchAddress() {
        short currentAddress = Registers.pc;

        // Get the address parts
        Registers.pc++;
        byte lowerByte = (byte) (Cpu.fetchNextValue());
        Registers.pc++;
        byte higherByte = (byte) (Cpu.fetchNextValue());

        // Convert them to little endian
        short address = (short) ((higherByte << 8) | lowerByte);

        pageCrossed = ((currentAddress & 0xFF00) != (address & 0xFF00)) ? 1 : 0;

        return address;
    }

    public static void resetPageCrossed() {
        pageCrossed = 0;
    }

}
