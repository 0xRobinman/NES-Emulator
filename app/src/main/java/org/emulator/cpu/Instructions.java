package org.emulator.cpu;

import org.emulator.arg.ArgsHandler;
import org.emulator.debug.Debug;
import org.emulator.memory.Ram;

public class Instructions {
    
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

    /**
     * ADD operation with carry
     */
    public static void adc() {
        if (ArgsHandler.debug) 
            Debug.printASM(ADC, "ADC");
    }

    public static void adc_zero_page() {
        if (ArgsHandler.debug) 
            Debug.printASM(ADC_ZERO_PAGE, "ADC");
    }
    public static void adc_zero_page_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(ADC_ZERO_PAGE_X, "ADC");
    }
    public static void adc_absolute() {
        if (ArgsHandler.debug) 
            Debug.printASM(ADC_ABSOLUTE, "ADC");
    }
    public static void adc_absolute_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(ADC_ABSOLUTE_X, "ADC");
    }
    public static void adc_absolute_y() {
        if (ArgsHandler.debug) 
            Debug.printASM(ADC_ABSOLUTE_Y, "ADC");
    }
    public static void adc_x_ind() {
        if (ArgsHandler.debug) 
            Debug.printASM(ADC_X_IND, "ADC");
    }
    public static void adc_ind_y() {
        if (ArgsHandler.debug) 
            Debug.printASM(ADC_IND_Y, "ADC");
    }


    public static void and() {
        if (ArgsHandler.debug) 
            Debug.printASM(AND, "AND");
    }

    public static void and_zero_page() {
        if (ArgsHandler.debug) 
            Debug.printASM(AND_ZERO_PAGE, "AND");
    }
    public static void and_zero_page_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(AND_ZERO_PAGE_X, "AND");
    }
    public static void and_absolute() {
        if (ArgsHandler.debug) 
            Debug.printASM(AND_ABSOLUTE, "AND");
    }
    public static void and_absolute_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(AND_ABSOLUTE_X, "AND");
    }
    public static void and_absolute_y() {
        if (ArgsHandler.debug) 
            Debug.printASM(AND_ABSOLUTE_Y, "AND");
    }
    public static void and_x_ind() {
        if (ArgsHandler.debug) 
            Debug.printASM(AND_X_IND, "AND");
    }
    public static void and_ind_y() {
        if (ArgsHandler.debug) 
            Debug.printASM(AND_IND_Y, "AND");
    }

    

    /**
     * Arithmetic shift left.
     */
    public static void asl() {


        if (ArgsHandler.debug) 
            Debug.printASM(ASL, "ASL 1");
    }
    public static void asl_zero_page() {
        if (ArgsHandler.debug) 
            Debug.printASM(ASL_ZERO_PAGE, "ASL 2");
    }
    public static void asl_zero_page_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(ASL_ZERO_PAGE_X, "ASL 3");
    }
    public static void asl_absolute() {

        short address = fetchAddress();
        byte value = Ram.read(address);
        Registers.setCarryFlag((value & Registers.NEGATIVE_MASK) != 0);
        value <<= 1;
        Ram.write(address, value);

        Registers.setZeroFlag(value == 0);
        Registers.setNegativeFlag((value & Registers.NEGATIVE_MASK) != 0);

        if (ArgsHandler.debug) 
            Debug.printASM(ASL_ABSOLUTE, "ASL 4");
    }
    public static void asl_absolute_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(ASL_ABSOLUTE_X, "ASL 5");
    }


    public static void bcc() {
        if (ArgsHandler.debug) 
            Debug.printASM(BCC_RELATIVE, "BCC");
    }
    public static void bcs() {
        if (ArgsHandler.debug) 
            Debug.printASM(BCS_RELATIVE, "BCS");
    }
    public static void beq() {
        if (ArgsHandler.debug) 
            Debug.printASM(BEQ_RELATIVE, "BEQ");
    }

    /**
     * 
     */
    public static void bit() {
        if (ArgsHandler.debug) 
            Debug.printASM(BIT_ZERO_PAGE, "BIT i");
    }   

    /**
     * Bit test
     */
    public static void bit_absolute() {

        // Convert them to little endian
        short address = fetchAddress();

        byte testValue = Ram.read(address);

        Registers.setZeroFlag((testValue & Registers.acc) == 0);
        Registers.setNegativeFlag((testValue & Registers.NEGATIVE_MASK) != 0);
        Registers.setOverflowFlag((testValue & Registers.OVERFLOW_MASK) != 0);


        if (ArgsHandler.debug) 
            Debug.printASM(BIT_ABSOLUTE, "BIT a");
    }

    public static void bmi() {
        if (ArgsHandler.debug) 
            Debug.printASM(BMI_RELATIVE, "BMI");
    }

    /**
     * Branch not equals
     */
    public static void bne() {
        if (ArgsHandler.debug) 
            Debug.printASM(BNE_RELATIVE, "BNE");
    }

    /**
     * Branch on plus. If the N flag is 0, then we branch.
     */
    public static void bpl() {
        Registers.pc++;
        byte relativeAddress = Cpu.fetchNextValue();

        // Branch by the relative address.
        if ((Registers.status & Registers.NEGATIVE_MASK) == 0) {
            System.out.println("Branching.");
            Registers.pc += relativeAddress;
            Registers.pc--;
        }


        if (ArgsHandler.debug) 
            Debug.printASM(BPL_RELATIVE, "BPL");
    }

    /**
     *  Force a break
     */
    public static void brk() {
        
        // Return to BRK + 2 but + 1 since opcode ( next instruction )
        short returnAddress = (short) (Registers.pc + 2);
        
        // Push return address for routine on the stack
        byte higherByte =  (byte) ((returnAddress >> 8));
        byte lowerByte = (byte) (returnAddress);
        
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
        
        // Set interrupt flag
        sei();

        // Get interrupt vector 
        lowerByte = Ram.read((short)0xFFFE);
        higherByte = Ram.read((short)0xFFFF);
        
        // Set PC to new address (little endian)
        Registers.pc = (short)((higherByte << 8) | lowerByte);
        Registers.pc--;

        if (ArgsHandler.debug) 
            Debug.printASM(BRK_IMPLIED, "BRK");
    }
    public static void bvc() {
        if (ArgsHandler.debug) 
            Debug.printASM(BVC_RELATIVE, "BVC");
    }

    public static void bvs() {
        if (ArgsHandler.debug) 
            Debug.printASM(BVS_RELATIVE, "BVS");
    }

    /**
     * Clear the carry flag
     */
    public static void clc() {

        Registers.setCarryFlag(false);

        if (ArgsHandler.debug) 
            Debug.printASM(CLC_IMPLIED, "CLC");
    }

    /**
     * CLear decimal flag
     */
    public static void cld() {

        Registers.setDecimalFlag(false);

        if (ArgsHandler.debug) 
            Debug.printASM(CLD_IMPLIED, "CLD");
    }

    /**
     * Clear interrupt 
     */
    public static void cli() {

        Registers.setInterruptFlag(false);

        if (ArgsHandler.debug) 
            Debug.printASM(CLI_IMPLIED, "CLI");
    }

    /**
     * Clear overflow flag
     */
    public static void clv() {

        Registers.setOverflowFlag(false);

        if (ArgsHandler.debug) 
            Debug.printASM(CLV_IMPLIED, "CLV");
    }
    
    /**
     * 
     */
    public static void cmp() {

        Registers.status &= ~Registers.OVERFLOW_MASK;

        if (ArgsHandler.debug) 
            Debug.printASM(CMP, "CMP");
    }

    public static void cmp_zero_page() {
        if (ArgsHandler.debug) 
            Debug.printASM(CMP_ZERO_PAGE, "CMP");
    }
    public static void cmp_zero_page_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(CMP_ZERO_PAGE_X, "CMP");
    }
    public static void cmp_absolute() {
        if (ArgsHandler.debug) 
            Debug.printASM(CMP_ABSOLUTE, "CMP");
    }
    public static void cmp_absolute_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(CMP_ABSOLUTE_X, "CMP");
    }
    public static void cmp_absolute_y() {
        if (ArgsHandler.debug) 
            Debug.printASM(CMP_ABSOLUTE_Y, "CMP");
    }
    public static void cmp_x_ind() {
        if (ArgsHandler.debug) 
            Debug.printASM(CMP_X_IND, "CMP");
    }
    public static void cmp_ind_y() {
        if (ArgsHandler.debug) 
            Debug.printASM(CMP_IND_Y, "CMP");
    }

    public static void cpx() {
        if (ArgsHandler.debug) 
            Debug.printASM(CPX, "CPX");
    }

    public static void cpx_zero_page() {
        if (ArgsHandler.debug) 
            Debug.printASM(CPX_ZERO_PAGE, "CPX");
    }
    public static void cpx_absolute() {
        if (ArgsHandler.debug) 
            Debug.printASM(CPX_ABSOLUTE, "CPX");
    }

    public static void cpy() {
        if (ArgsHandler.debug) 
            Debug.printASM(CPY, "CPY");
    }
    public static void cpy_zero_page() {
        if (ArgsHandler.debug) 
            Debug.printASM(CPY_ZERO_PAGE, "CPY");
    }
    public static void cpy_absolute() {
        if (ArgsHandler.debug) 
            Debug.printASM(CPY_ABSOLUTE, "CPY");
    }

    public static void dec_zero_page() {
        if (ArgsHandler.debug) 
            Debug.printASM(DEC_ZERO_PAGE, "DEC");
    }

    public static void dec_zero_page_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(DEC_ZERO_PAGE_X, "DEC");
    }
    public static void dec_absolute() {
        if (ArgsHandler.debug) 
            Debug.printASM(DEC_ABSOLUTE, "DEC");
    }
    public static void dec_absolute_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(DEC_ABSOLUTE_X, "DEC");
    }



    public static void dex() {
        if (ArgsHandler.debug) 
            Debug.printASM(DEX_IMPLIED, "DEX");
    }
    public static void dey() {
        if (ArgsHandler.debug) 
            Debug.printASM(DEY_IMPLIED, "DEY");
    }

    /**
     * Exclusive OR (XOR)
     */
    public static void eor() {
        if (ArgsHandler.debug) 
            Debug.printASM(EOR, "EOR 1");
    }
    public static void eor_zero_page() {       
        byte address = fetchZeroPageAddress();
        byte value = Ram.read(address);
        Registers.acc ^= value;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & Registers.OVERFLOW_MASK) != 0);

        if (ArgsHandler.debug) 
            Debug.printASM(EOR_ZERO_PAGE, "EOR 2");
    }
    public static void eor_zero_page_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(EOR_ZERO_PAGE_X, "EOR 3");
    }
    public static void eor_absolute() {
        if (ArgsHandler.debug) 
            Debug.printASM(EOR_ABSOLUTE, "EOR 4");
    }
    public static void eor_absolute_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(EOR_ABSOLUTE_X, "EOR 5");
    }
    public static void eor_absolute_y() {
        if (ArgsHandler.debug) 
            Debug.printASM(EOR_ABSOLUTE_Y, "EOR 6");
    }
    public static void eor_x_ind() {
        if (ArgsHandler.debug) 
            Debug.printASM(EOR_X_IND, "EOR 7");
    }
    public static void eor_ind_y() {
        if (ArgsHandler.debug) 
            Debug.printASM(EOR_IND_Y, "EOR 8");
    }


    /**
     * Increment value in memory
     */
    public static void inc_zero_page() { 
        // Fetch address
        short address = fetchAddress(); 

        // Read and increment value in memory
        byte value = Ram.read(address);
        value = (byte)((value + 1) & 0xFF);

        Ram.write(address, value);

        Registers.setZeroFlag(value == 0);
        Registers.setNegativeFlag((value & Registers.OVERFLOW_MASK) != 0);

        if (ArgsHandler.debug) 
            Debug.printASM(INC_ZERO_PAGE, "INC 1");
    }
    public static void inc_zero_page_x() {
        
        byte address = fetchZeroPageXAddress();

        byte value = Ram.read(address);
        value = (byte)((value + 1) & 0xFF);

        Ram.write(address, value);
        Registers.setZeroFlag(value == 0);
        Registers.setNegativeFlag((value & Registers.OVERFLOW_MASK) != 0);

        if (ArgsHandler.debug) 
            Debug.printASM(INC_ZERO_PAGE_X, "INC 2");
    }
    public static void inc_absolute() {
        if (ArgsHandler.debug) 
            Debug.printASM(INC_ABSOLUTE, "INC 3");
    }
    public static void inc_absolute_x() {
 
        // Convert them to little endian
        short address = fetchAddress();  
        address =  (short) ( (address + Registers.x) & 0xFFFF );
        
        // Read and increment value in memory
        byte value = Ram.read(address);
        value = (byte)((value + 1) & 0xFF);
        Ram.write(address, value);

        Registers.setZeroFlag(value == 0);
        Registers.setNegativeFlag((value & Registers.OVERFLOW_MASK) != 0);

        if (ArgsHandler.debug) 
            Debug.printASM(INC_ABSOLUTE_X, "INC 4");
    }

    /**
     * Increment X
     */
    public static void inx() {

        Registers.x = (byte)((Registers.x + 1) & 0xFF);

        Registers.setZeroFlag(Registers.x == 0);
        Registers.setNegativeFlag((Registers.x & Registers.OVERFLOW_MASK) != 0);

        if (ArgsHandler.debug) 
            Debug.printASM(INX_IMPLIED, "INX");
    }


    public static void iny() {
        Registers.y = (byte)((Registers.y + 1) & 0xFF);

        Registers.setZeroFlag(Registers.y == 0);
        Registers.setNegativeFlag((Registers.y & Registers.OVERFLOW_MASK) != 0);

        if (ArgsHandler.debug) 
            Debug.printASM(INY_IMPLIED, "INY");
    }


    public static void jmp() {
        if (ArgsHandler.debug) 
            Debug.printASM(JMP_ABSOLUTE, "JMP");
    }
    public static void jmp_indirect() {
        if (ArgsHandler.debug) 
            Debug.printASM(JMP_IND, "JMP");
    }

    /**
     * Jump to subroutine
     */
    public static void jsr() {

        short address = fetchAddress();
        
        // Get the subroutine address to jump to.
        short returnAddress = (short) (Registers.pc+1);
        
        // Push return address for routine on the stack
        byte higherByte =  (byte) ((returnAddress >> 8));
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

    }
    
    /**
     * 
     */
    public static void lda() {
        if (ArgsHandler.debug) 
            Debug.printASM(LDA, "LDA 1");
    }

    /**
     * Load a zero page
     */
    public static void lda_zero_page() {

        // Convert them to little endian
        byte address = fetchZeroPageAddress();

        // Fetch the value from memory 
        byte value = Ram.read(address);     

        // Set accumulator value
        Registers.acc = value;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & Registers.OVERFLOW_MASK) != 0);
        
        if (ArgsHandler.debug) 
            Debug.printASM(address, address, "LDA", "$");
    }
    public static void lda_zero_page_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(LDA_ZERO_PAGE_X, "LDA33");
    }
    public static void lda_absolute() {
        if (ArgsHandler.debug) 
            Debug.printASM(LDA_ABSOLUTE, "LDA 2");
    }
    public static void lda_absolute_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(LDA_ABSOLUTE_X, "LDA 4");
    }
    public static void lda_absolute_y() {
        if (ArgsHandler.debug) 
            Debug.printASM(LDA_ABSOLUTE_Y, "LDA 5");
    }
    public static void lda_x_ind() {
        if (ArgsHandler.debug) 
            Debug.printASM(LDA_X_IND, "LDA 7");
    }
    public static void lda_ind_y() {
        if (ArgsHandler.debug) 
            Debug.printASM(LDA_IND_Y, "LDA 9");
    }

    /**
     * Load the X register (Immediate)
     */
    public static void ldx() {
        // Get the next instruction
        Registers.pc++;
        Registers.x = Cpu.fetchNextValue();
        
        Registers.setZeroFlag(Registers.x == 0);
        Registers.setNegativeFlag((Registers.x & Registers.OVERFLOW_MASK) != 0);

        if (ArgsHandler.debug) 
            Debug.printASM(LDX, Registers.x, "LDX", "#");

    }
    public static void ldx_zero_page() {
        if (ArgsHandler.debug) 
            Debug.printASM(LDX_ZERO_PAGE, "LDXs");
    }
    public static void ldx_zero_page_y() {
        if (ArgsHandler.debug) 
            Debug.printASM(LDX_ZERO_PAGE_Y, "LDXb");
    }
    public static void ldx_absolute() {
        if (ArgsHandler.debug) 
            Debug.printASM(LDX_ABSOLUTE, "LDXa");
    }
    public static void ldx_absolute_y() {
        if (ArgsHandler.debug) 
            Debug.printASM(LDX_ABSOLUTE_Y, "LDXb");
    }


    public static void ldy() {
        if (ArgsHandler.debug) 
            Debug.printASM(LDY, "LDY");
    }
    public static void ldy_zero_page() {
        if (ArgsHandler.debug) 
            Debug.printASM(LDY_ZERO_PAGE, "LDY");
    }
    public static void ldy_zero_page_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(LDY_ZERO_PAGE_X, "LDY");
    }
    public static void ldy_absolute() {
        if (ArgsHandler.debug) 
            Debug.printASM(LDY_ABSOLUTE, "LDY");
    }
    public static void ldy_absolute_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(LDY_ABSOLUTE_X, "LDY");
    }


    public static void lsr() {
        if (ArgsHandler.debug) 
            Debug.printASM(LSR, "LSR");
    }
    public static void lsr_zero_page() {
        if (ArgsHandler.debug) 
            Debug.printASM(LSR_ZERO_PAGE, "LSR");
    }
    public static void lsr_zero_page_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(LSR_ZERO_PAGE_X, "LSR");
    }
    public static void lsr_absolute() {
        if (ArgsHandler.debug) 
            Debug.printASM(LSR_ABSOLUTE, "LSR");
    }
    public static void lsr_absolute_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(LSR_ABSOLUTE_X, "LSR");
    }


    public static void nop() {
        if (ArgsHandler.debug) 
            Debug.printASM(NOP, "NOP");
    }

    /**
     * OR with accumulator
     */
    public static void ora() {


        if (ArgsHandler.debug) 
            Debug.printASM(ORA, "ORA1");
    }
    public static void ora_zero_page() {
        if (ArgsHandler.debug) 
            Debug.printASM(ORA_ZERO_PAGE, "ORA2");
    }
    public static void ora_zero_page_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(ORA_ZERO_PAGE_X, "ORA3");
    }
    public static void ora_absolute() {
        if (ArgsHandler.debug) 
            Debug.printASM(ORA_ABSOLUTE, "ORA4");
    }

    /**
     * Bitwise OR with acc absolute X addressing.
     */
    public static void ora_absolute_x() {

        short address = fetchAddress();  
        address = (short) ((address + Registers.acc));

        // Fetch the value from memory 
        byte value = Ram.read(address);

        Registers.acc |= value;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & Registers.OVERFLOW_MASK) != 0);


        if (ArgsHandler.debug) 
            Debug.printASM(ORA_ABSOLUTE_X, "ORA");
    }

    public static void ora_absolute_y() {
        if (ArgsHandler.debug) 
            Debug.printASM(ORA_ABSOLUTE_Y, "ORA5");
    }
    public static void ora_x_ind() {


        if (ArgsHandler.debug) 
            Debug.printASM(ORA_X_IND, "ORA6");
    }
    public static void ora_ind_y() {
        if (ArgsHandler.debug) 
            Debug.printASM(ORA_IND_Y, "ORA7");
    }




    public static void pha() {
        if (ArgsHandler.debug) 
            Debug.printASM(PHA_IMPLIED, "PHA");
    }
    public static void php() {
        if (ArgsHandler.debug) 
            Debug.printASM(PHP_IMPLIED, "PHP");
    }
    public static void pla() {
        if (ArgsHandler.debug) 
            Debug.printASM(PLA_IMPLIED, "PLA");
    }

    /**
     * Pull the status of the processor
     * Restore the status register from the stack.
     * Bit 5 of the status register stays the same
     */
    public static void plp() {
        
        
        byte statusRegister = Ram.read((short) (0x0100 + (++Registers.sp)));

        Registers.status = (byte) ((statusRegister & ~Registers.BREAK_MASK) | Registers.UNUSED_MASK);

        if (ArgsHandler.debug) 
            Debug.printASM(PLP_IMPLIED, "PLP");
    }
    

    public static void rol() {
        if (ArgsHandler.debug) 
            Debug.printASM(ROL, "ROL");
    }
    public static void rol_zero_page() {
        if (ArgsHandler.debug) 
            Debug.printASM(ROL_ZERO_PAGE, "ROL");
    }
    public static void rol_zero_page_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(ROL_ZERO_PAGE_X, "ROL");
    }
    public static void rol_absolute() {
        if (ArgsHandler.debug) 
            Debug.printASM(ROL_ABSOLUTE, "ROL");
    }
    public static void rol_absolute_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(ROL_ABSOLUTE_X, "ROL");
    }


    public static void ror() {
        if (ArgsHandler.debug) 
            Debug.printASM(ROR, "ROR");
    }
    public static void ror_zero_page() {
        if (ArgsHandler.debug) 
            Debug.printASM(ROR_ZERO_PAGE, "ROR");
    }
    public static void ror_zero_page_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(ROR_ZERO_PAGE_X, "ROR");
    }
    public static void ror_absolute() {
        if (ArgsHandler.debug) 
            Debug.printASM(ROR_ABSOLUTE, "ROR");
    }
    public static void ror_absolute_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(ROR_ABSOLUTE_X, "ROR");
    }
    public static void rti() {
        if (ArgsHandler.debug) 
            Debug.printASM(RTI_IMPLIED, "RTI");
    }

    /**
     * Return to sub routine.
     *         
        // Store the return address of next instruction onto the stack
        Ram.writeToStack(Registers.sp, lowerByte);
        Registers.sp--;
        Ram.writeToStack(Registers.sp, higherByte);
        Registers.sp--;
     */
    public static void rts() {

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
    }
    public static void sbc() {
        if (ArgsHandler.debug) 
            Debug.printASM(SBC, "SBC");
    }
    public static void sbc_zero_page() {
        if (ArgsHandler.debug) 
            Debug.printASM(SBC_ZERO_PAGE, "SBC");
    }
    public static void sbc_zero_page_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(SBC_ZERO_PAGE_X, "SBC");
    }
    public static void sbc_absolute() {
        if (ArgsHandler.debug) 
            Debug.printASM(SBC_ABSOLUTE, "SBC");
    }
    public static void sbc_absolute_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(SBC_ABSOLUTE_X, "SBC");
    }
    public static void sbc_absolute_y() {
        if (ArgsHandler.debug) 
            Debug.printASM(SBC_ABSOLUTE_Y, "SBC");
    }
    public static void sbc_x_ind() {
        if (ArgsHandler.debug) 
            Debug.printASM(SBC_X_IND, "SBC");
    }
    public static void sbc_ind_y() {
        if (ArgsHandler.debug) 
            Debug.printASM(SBC_IND_Y, "SBC");
    }
    

    /**
     * Shift right XOR
     */
    public static void sre_x_ind() {
        if (ArgsHandler.debug)
            Debug.printASM(SRE_X_IND, "SRE 1");
    }
    
    public static void sre_zero_page() {

        byte address = fetchZeroPageAddress();
        byte value = Ram.read(address);
        Registers.status &= (value & Registers.CARRY_MASK);
        Registers.setCarryFlag((value & 0x01) != 0);
        value >>>= 1;
        Ram.write(address, value);
        Registers.acc ^= value;
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & Registers.OVERFLOW_MASK) != 0);
        if (ArgsHandler.debug)
            Debug.printASM(SRE_ZERO_PAGE, "SRE 2");
    }
    
    public static void sre_absolute() {
        if (ArgsHandler.debug)
            Debug.printASM(SRE_ABSOLUTE, "SRE3 ");
    }
    
    public static void sre_ind_y() {
        if (ArgsHandler.debug)
            Debug.printASM(SRE_IND_Y, "SRE4");
    }
    
    public static void sre_zero_page_x() {
        if (ArgsHandler.debug)
            Debug.printASM(SRE_ZERO_PAGE_X, "SRE5");
    }
    
    public static void sre_absolute_y() {
        if (ArgsHandler.debug)
            Debug.printASM(SRE_ABSOLUTE_Y, "SRE6");
    }
    
    public static void sre_absolute_x() {
        if (ArgsHandler.debug)
            Debug.printASM(SRE_ABSOLUTE_X, "SRE7");
    }
    


    public static void sec() {
        if (ArgsHandler.debug) 
            Debug.printASM(SEC_IMPLIED, "SEC");
    }  

    /**
     * Set Decimal flag
     */
    public static void sed() {

        Registers.setDecimalFlag(true);

        if (ArgsHandler.debug) 
            Debug.printASM(SED_IMPLIED, "SED");
    }

    /**
     * Set interrupt disable status
     */
    public static void sei() {
        
        Registers.setInterruptFlag(true);

        if (ArgsHandler.debug)
            Debug.printASM(SEI_IMPLIED, "SEI");
        
    }

    public static void sta_zero_page() {
        if (ArgsHandler.debug) 
            Debug.printASM(STA_ZERO_PAGE, "STA");
    }
    public static void sta_zero_page_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(STA_ZERO_PAGE_X, "STA");
    }
    public static void sta_absolute() {
        if (ArgsHandler.debug) 
            Debug.printASM(STA_ABSOLUTE, "STA");
    }
    public static void sta_absolute_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(STA_ABSOLUTE_X, "STA");
    }
    public static void sta_absolute_y() {
        if (ArgsHandler.debug) 
            Debug.printASM(STA_ABSOLUTE_Y, "STA");
    }
    public static void sta_x_ind() {
        if (ArgsHandler.debug) 
            Debug.printASM(STA_X_IND, "STA");
    }
    public static void sta_ind_y() {
        if (ArgsHandler.debug) 
            Debug.printASM(STA_IND_Y, "STA");
    }

    /**
     * 
     */
    public static void stx_zero_page() {
        if (ArgsHandler.debug) 
            Debug.printASM(STX_ZERO_PAGE, "STX");
    }

    public static void stx_zero_page_y() {
        if (ArgsHandler.debug) 
            Debug.printASM(STX_ZERO_PAGE_Y, "STX");
    }

    /**
     * Store X Register. 
     */
    public static void stx_absolute() {

        // Get the address 
        short address = fetchAddress();
        
        Ram.write(address, Registers.x);

        if (ArgsHandler.debug) 
            Debug.printASM(Registers.pc, address, "STX", "$");

    }
    
    public static void sty_zero_page() {
        if (ArgsHandler.debug) 
        Debug.printASM(STY_ZERO_PAGE, "STY");
    }
    public static void sty_zero_page_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(STY_ZERO_PAGE_X, "STY");
    }
    public static void sty_absolute() {
        if (ArgsHandler.debug) 
            Debug.printASM(STY_ABSOLUTE, "STY");
    }

    /**
     * Transfer Accumulator to X
     */
    public static void tax() {

        Registers.x = Registers.acc;
        
        Registers.setZeroFlag(Registers.x==0);
        Registers.setNegativeFlag((Registers.x & Registers.OVERFLOW_MASK) != 0);

        if (ArgsHandler.debug) 
            Debug.printASM(TAX_IMPLIED, "TAX");
    }

    /**
     * Transfer accumulator to Y
     */
    public static void tay() {
        Registers.y = Registers.acc;

        Registers.setZeroFlag(Registers.y==0);
        Registers.setNegativeFlag((Registers.y & Registers.OVERFLOW_MASK) != 0);

        if (ArgsHandler.debug) 
            Debug.printASM(TAY_IMPLIED, "TAY");
    }

    /**
     * Transfer X to stack pointer
     */
    public static void tsx() {

        Registers.x = Registers.sp;

        Registers.setZeroFlag(Registers.x == 0);
        Registers.setNegativeFlag((Registers.x & Registers.OVERFLOW_MASK) != 0);

        if (ArgsHandler.debug) 
            Debug.printASM(TSX_IMPLIED, "TSX");
    }

    /**
     * Transfer X to accumulator 
     */
    public static void txa() {

        Registers.acc = Registers.x;
        
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & Registers.OVERFLOW_MASK) != 0);

        if (ArgsHandler.debug) 
            Debug.printASM(TXA_IMPLIED, "TXA");
    }

    /**
     * Transfer the stack pointer to X
     */
    public static void txs() {

        Registers.sp = Registers.x;

        if (ArgsHandler.debug) 
            Debug.printASM(TXS_IMPLIED, "TXS");
    }

    /**
     * Transfer Y to accumulator
     */
    public static void tya() {

        Registers.acc = Registers.y;

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & Registers.OVERFLOW_MASK) != 0);

        if (ArgsHandler.debug) 
            Debug.printASM(TYA_IMPLIED, "TYA");
    }
    public static void rla_zero_page() {
        if (ArgsHandler.debug) 
            Debug.printASM(RLA_ZERO_PAGE, "RLA");
    }
    
    public static void rla_zero_page_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(RLA_ZERO_PAGE_X, "RLA");
    }
    
    public static void rla_absolute() {
        if (ArgsHandler.debug) 
            Debug.printASM(RLA_ABSOLUTE, "RLA");
    }
    
    public static void rla_absolute_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(RLA_ABSOLUTE_X, "RLA");
    }
    
    public static void rla_absolute_y() {
        if (ArgsHandler.debug) 
            Debug.printASM(RLA_ABSOLUTE_Y, "RLA");
    }
    
    public static void rla_x_ind() {
        if (ArgsHandler.debug) 
            Debug.printASM(RLA_X_IND, "RLA");
    }
    
    public static void rla_ind_y() {
        if (ArgsHandler.debug) 
            Debug.printASM(RLA_IND_Y, "RLA");
    }
    
    public static void rra_x_ind() {
        if (ArgsHandler.debug)
            Debug.printASM(RRA_X_IND, "RRA");
    }
    
    public static void rra_zero_page() {
        if (ArgsHandler.debug)
            Debug.printASM(RRA_ZERO_PAGE, "RRA");
    }
    
    public static void rra_absolute() {
        if (ArgsHandler.debug)
            Debug.printASM(RRA_ABSOLUTE, "RRA");
    }
    
    public static void rra_ind_y() {
        if (ArgsHandler.debug)
            Debug.printASM(RRA_IND_Y, "RRA");
    }
    
    public static void rra_zero_page_x() {
        if (ArgsHandler.debug)
            Debug.printASM(RRA_ZERO_PAGE_X, "RRA");
    }
    
    public static void rra_absolute_y() {
        if (ArgsHandler.debug)
            Debug.printASM(RRA_ABSOLUTE_Y, "RRA");
    }
    
    public static void rra_absolute_x() {
        if (ArgsHandler.debug)
            Debug.printASM(RRA_ABSOLUTE_X, "RRA");
    }
    

    /**
     * Homebrew function
     * Combination between ASL and ORA
     */
    public static void slo_zero_page() {
        // Get the address parts zero page wrap around
        byte address = fetchZeroPageAddress();
    
        // Get value at address
        byte value = Ram.read(address);
        Registers.setCarryFlag((value & Registers.OVERFLOW_MASK) != 0);

        // Perform ASL on value
        value <<= 1;

        // ORA
        Registers.acc |= value;

        Ram.write(address, value);

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & Registers.OVERFLOW_MASK) != 0);

        if (ArgsHandler.debug) 
            Debug.printASM(SLO_ZERO_PAGE, "SLO1");
    }

    public static void slo_zero_page_x() {
        // Get the address parts zero page wrap around
        byte address = fetchZeroPageXAddress();
        
        // Get value at address
        byte value = Ram.read(address);
        Registers.setCarryFlag((value & Registers.OVERFLOW_MASK) != 0);

        // Perform ASL on value
        value <<= 1;

        // ORA
        Registers.acc |= value;

        Ram.write(address, value);
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & Registers.OVERFLOW_MASK) != 0);
    
        if (ArgsHandler.debug) 
            Debug.printASM(SLO_ZERO_PAGE_X, "SLO2");
    }
    
    public static void slo_absolute() {
        if (ArgsHandler.debug) 
            Debug.printASM(SLO_ABSOLUTE, "SLO3");
    }
    
    /**
     * 
     */
    public static void slo_absolute_x() {


        if (ArgsHandler.debug) 
            Debug.printASM(SLO_ABSOLUTE_X, "SLO4");
    }
    
    public static void slo_absolute_y() {
        if (ArgsHandler.debug) 
            Debug.printASM(SLO_ABSOLUTE_Y, "SLO5");
    }
    
    /**
     * ASL + ORA
     */
    public static void slo_x_ind() {

        short address = fetchAddress();
        address += Registers.x;

        byte value = Ram.read(address);
        Registers.setCarryFlag((value & Registers.CARRY_MASK) != 0);
        value <<= 1;
        Registers.acc = (byte) (Registers.acc | value);

        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & Registers.OVERFLOW_MASK) != 0);
        
        if (ArgsHandler.debug) 
            Debug.printASM(SLO_X_IND, "SLO6");
    }
    
    public static void slo_ind_y() {
        if (ArgsHandler.debug) 
            Debug.printASM(SLO_IND_Y, "SLO7");
    }

    public static void lax_zero_page() {
        if (ArgsHandler.debug)
            Debug.printASM(LAX_ZERO_PAGE, "LAX");
    }
    
    public static void lax_absolute() {
        if (ArgsHandler.debug)
            Debug.printASM(LAX_ABSOLUTE, "LAX");
    }
    
    public static void lax_ind_y() {
        if (ArgsHandler.debug)
            Debug.printASM(LAX_IND_Y, "LAX");
    }
    
    public static void lax_zero_page_y() {
        if (ArgsHandler.debug)
            Debug.printASM(LAX_ZERO_PAGE_Y, "LAX");
    }
    
    public static void lax_absolute_y() {
        if (ArgsHandler.debug)
            Debug.printASM(LAX_ABSOLUTE_Y, "LAX");
    }
    
    public static void lax_x_ind() {

    }  


    public static void dcp_x_ind() {

    }  
    public static void dcp_zero_page() {

    }  
    public static void dcp_absolute() {

    }  
    public static void dcp_ind_y() {

    }  
    public static void dcp_zero_page_x() {

    }  
    public static void dcp_absolute_y() {

    }  
    public static void dcp_absolute_x() {

    }  


    /**
     *  ACC and X
     */
    public static void sax_zero_page() {
        byte address = fetchZeroPageAddress();
        byte value = (byte) (Registers.acc & Registers.x);
        Ram.write(address, value);
        if (ArgsHandler.debug)
            Debug.printASM(SAX_ZERO_PAGE, "SAX 1");
    }
    
    public static void sax_absolute() {
        if (ArgsHandler.debug)
            Debug.printASM(SAX_ABSOLUTE, "SAX 2");
    }
    
    public static void sax_zero_page_y() {
        if (ArgsHandler.debug)
            Debug.printASM(SAX_ZERO_PAGE_Y, "SAX 3");
    }
    public static void sax_x_ind() {

    }
    public static void sbc_immediate() {
        if (ArgsHandler.debug)
            Debug.printASM(SBC, "SBC");
    }
    
    public static void shy_absolute_x() {
        if (ArgsHandler.debug)
            Debug.printASM(SHY_ABSOLUTE_X, "SHY");
    }
    
    public static void shx_absolute_y() {
        if (ArgsHandler.debug)
            Debug.printASM(SHX_ABSOLUTE_Y, "SHX");
    }

    public static void las_absolute_y() {

    }

    public static void xaa_immediate() {
        Registers.pc++;
        byte value = Cpu.fetchNextValue();

        Registers.acc = (byte) ((Registers.acc & Registers.x) & value);
        Registers.setZeroFlag(Registers.acc == 0);
        Registers.setNegativeFlag((Registers.acc & Registers.OVERFLOW_MASK) != 0);
        if (ArgsHandler.debug)
            Debug.printASM(ANE, "XAA");
    }


    public static void nop_zero_page() {

    }

    public static void nop_zero_page_x() {
        
    }

    public static void nop_absolute() {
        
    }
    public static void nop_absolute_x() {
        
    }

    public static void jam() {

    }
    public static void anc() {
        
    }
    public static void alr() {
        
    }
    public static void arr() {

    }

    public static void ane() {
        
    }

    public static void sha_ind_y() {

    }

    public static void tas_absolute_y() {

    }
    
    public static void sha_absolute_y() {

    }

    public static void lxa() {

    }

    public static void sbx() {

    }

    public static void isc_x_ind() {
        
    }
    public static void isc_zero_page() {
        
    }
    public static void isc_absolute() {
        
    }
    public static void isc_ind_y() {
        
    }
    public static void isc_zero_page_x() {
        
    }
    public static void isc_absolute_y() {
        
    }
    public static void isc_absolute_x() {
        
    }

    public static void usbc() {

    }





    private static byte fetchZeroPageAddress() {
          // Get the address
          Registers.pc++;
          byte address = (byte) (Cpu.fetchNextValue() & 0xFF);  
          return address;    
    }


    private static byte fetchZeroPageXAddress() {
        byte zero_page_address = fetchZeroPageAddress();
        zero_page_address = (byte)((zero_page_address + Registers.x) & 0xFF);
        return zero_page_address;    
    }

    private static short fetchAddress() {
        // Get the address parts
        Registers.pc++;
        byte lowerByte = (byte) (Cpu.fetchNextValue());
        Registers.pc++; 
        byte higherByte = (byte) (Cpu.fetchNextValue());

        // Convert them to little endian
        short address = (short) ((higherByte << 8) | lowerByte);
        
        return address;
    }

}
