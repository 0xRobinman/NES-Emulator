package org.emulator.cpu;

import org.emulator.arg.ArgsHandler;
import org.emulator.debug.Debug;
import org.emulator.memory.Ram;

public class Instructions {
    
    public static final byte ADC = (byte) 0x69;
    public static final byte ADC_ZERO_PAGE = (byte) 0x65;
    public static final byte ADC_ZERO_PAGE_X = (byte) 0x75;
    public static final byte ADC_ABSOLUTE = (byte) 0x6D;
    public static final byte ADC_ABSOLUTE_X = (byte) 0x7D;
    public static final byte ADC_ABSOLUTE_Y = (byte) 0x79;
    public static final byte ADC_INDEXED_INDIRECT = (byte) 0x61;
    public static final byte ADC_INDIRECT_INDEXED = (byte) 0x71;
    public static final byte AND = (byte) 0x29;
    public static final byte AND_ZERO_PAGE = (byte) 0x25;
    public static final byte AND_ZERO_PAGE_X = (byte) 0x35;
    public static final byte AND_ABSOLUTE = (byte) 0x2D;
    public static final byte AND_ABSOLUTE_X = (byte) 0x3D;
    public static final byte AND_ABSOLUTE_Y = (byte) 0x39;
    public static final byte AND_INDEXED_INDIRECT = (byte) 0x21;
    public static final byte AND_INDIRECT_INDEXED = (byte) 0x31;
    public static final byte ASL = (byte) 0x0A;
    public static final byte ASL_ZERO_PAGE = (byte) 0x06;
    public static final byte ASL_ZERO_PAGE_X = (byte) 0x16;
    public static final byte ASL_ABSOLUTE = (byte) 0x0E;
    public static final byte ASL_ABSOLUTE_X = (byte) 0x1E;
    public static final byte BCC = (byte) 0x90;
    public static final byte BCS = (byte) 0xB0;
    public static final byte BEQ = (byte) 0xF0;
    public static final byte BIT = (byte) 0x24;
    public static final byte BIT_ABSOLUTE = (byte) 0x2C;
    public static final byte BMI = (byte) 0x30;
    public static final byte BNE = (byte) 0xD0;
    public static final byte BPL = (byte) 0x10;
    public static final byte BRK = (byte) 0x00;
    public static final byte BVC = (byte) 0x50;
    public static final byte BVS = (byte) 0x70;
    public static final byte CLC = (byte) 0x18;
    public static final byte CLD = (byte) 0xD8;
    public static final byte CLI = (byte) 0x58;
    public static final byte CLV = (byte) 0xB8;
    public static final byte CMP = (byte) 0xC9;
    public static final byte CMP_ZERO_PAGE = (byte) 0xC5;
    public static final byte CMP_ZERO_PAGE_X = (byte) 0xD5;
    public static final byte CMP_ABSOLUTE = (byte) 0xCD;
    public static final byte CMP_ABSOLUTE_X = (byte) 0xDD;
    public static final byte CMP_ABSOLUTE_Y = (byte) 0xD9;
    public static final byte CMP_INDEXED_INDIRECT = (byte) 0xC1;
    public static final byte CMP_INDIRECT_INDEXED = (byte) 0xD1;
    public static final byte CPX = (byte) 0xE0;
    public static final byte CPX_ZERO_PAGE = (byte) 0xE4;
    public static final byte CPX_ABSOLUTE = (byte) 0xEC;
    public static final byte CPY = (byte) 0xC0;
    public static final byte CPY_ZERO_PAGE = (byte) 0xC4;
    public static final byte CPY_ABSOLUTE = (byte) 0xCC;
    public static final byte DEC = (byte) 0xC6;
    public static final byte DEC_ZERO_PAGE_X = (byte) 0xD6;
    public static final byte DEC_ABSOLUTE = (byte) 0xCE;
    public static final byte DEC_ABSOLUTE_X = (byte) 0xDE;
    public static final byte DEX = (byte) 0xCA;
    public static final byte DEY = (byte) 0x88;
    public static final byte EOR = (byte) 0x49;
    public static final byte EOR_ZERO_PAGE = (byte) 0x45;
    public static final byte EOR_ZERO_PAGE_X = (byte) 0x55;
    public static final byte EOR_ABSOLUTE = (byte) 0x4D;
    public static final byte EOR_ABSOLUTE_X = (byte) 0x5D;
    public static final byte EOR_ABSOLUTE_Y = (byte) 0x59;
    public static final byte EOR_INDEXED_INDIRECT = (byte) 0x41;
    public static final byte EOR_INDIRECT_INDEXED = (byte) 0x51;
    public static final byte INC = (byte) 0xE6;
    public static final byte INC_ZERO_PAGE_X = (byte) 0xF6;
    public static final byte INC_ABSOLUTE = (byte) 0xEE;
    public static final byte INC_ABSOLUTE_X = (byte) 0xFE;
    public static final byte INX = (byte) 0xE8;
    public static final byte INY = (byte) 0xC8;
    public static final byte JMP = (byte) 0x4C;
    public static final byte JMP_INDIRECT = (byte) 0x6C;
    public static final byte JSR = (byte) 0x20;
    public static final byte LDA = (byte) 0xA9;
    public static final byte LDA_ZERO_PAGE = (byte) 0xA5;
    public static final byte LDA_ZERO_PAGE_X = (byte) 0xB5;
    public static final byte LDA_ABSOLUTE = (byte) 0xAD;
    public static final byte LDA_ABSOLUTE_X = (byte) 0xBD;
    public static final byte LDA_ABSOLUTE_Y = (byte) 0xB9;
    public static final byte LDA_INDEXED_INDIRECT = (byte) 0xA1;
    public static final byte LDA_INDIRECT_INDEXED = (byte) 0xB1;
    public static final byte LDX = (byte) 0xA2;
    public static final byte LDX_ZERO_PAGE = (byte) 0xA6;
    public static final byte LDX_ZERO_PAGE_Y = (byte) 0xB6;
    public static final byte LDX_ABSOLUTE = (byte) 0xAE;
    public static final byte LDX_ABSOLUTE_Y = (byte) 0xBE;
    public static final byte LDY = (byte) 0xA0;
    public static final byte LDY_ZERO_PAGE = (byte) 0xA4;
    public static final byte LDY_ZERO_PAGE_X = (byte) 0xB4;
    public static final byte LDY_ABSOLUTE = (byte) 0xAC;
    public static final byte LDY_ABSOLUTE_X = (byte) 0xBC;
    public static final byte LSR = (byte) 0x4A;
    public static final byte LSR_ZERO_PAGE = (byte) 0x46;
    public static final byte LSR_ZERO_PAGE_X = (byte) 0x56;
    public static final byte LSR_ABSOLUTE = (byte) 0x4E;
    public static final byte LSR_ABSOLUTE_X = (byte) 0x5E;
    public static final byte NOP = (byte) 0xEA;
    public static final byte ORA = (byte) 0x09;
    public static final byte ORA_ZERO_PAGE = (byte) 0x05;
    public static final byte ORA_ZERO_PAGE_X = (byte) 0x15;
    public static final byte ORA_ABSOLUTE = (byte) 0x0D;
    public static final byte ORA_ABSOLUTE_X = (byte) 0x1D;
    public static final byte ORA_ABSOLUTE_Y = (byte) 0x19;
    public static final byte ORA_INDEXED_INDIRECT = (byte) 0x01;
    public static final byte ORA_INDIRECT_INDEXED = (byte) 0x11;
    public static final byte PHA = (byte) 0x48;
    public static final byte PHP = (byte) 0x08;
    public static final byte PLA = (byte) 0x68;
    public static final byte PLP = (byte) 0x28;
    public static final byte RLA_ZERO_PAGE = (byte) 0x27;
    public static final byte RLA_ZERO_PAGE_X = (byte) 0x37;
    public static final byte RLA_ABSOLUTE = (byte) 0x2F;
    public static final byte RLA_ABSOLUTE_X = (byte) 0x3F;
    public static final byte RLA_ABSOLUTE_Y = (byte) 0x3B;
    public static final byte RLA_INDEXED_INDIRECT = (byte) 0x23;
    public static final byte RLA_INDIRECT_INDEXED = (byte) 0x33;
    public static final byte ROL = (byte) 0x2A;
    public static final byte ROL_ZERO_PAGE = (byte) 0x26;
    public static final byte ROL_ZERO_PAGE_X = (byte) 0x36;
    public static final byte ROL_ABSOLUTE = (byte) 0x2E;
    public static final byte ROL_ABSOLUTE_X = (byte) 0x3E;
    public static final byte ROR = (byte) 0x6A;
    public static final byte ROR_ZERO_PAGE = (byte) 0x66;
    public static final byte ROR_ZERO_PAGE_X = (byte) 0x76;
    public static final byte ROR_ABSOLUTE = (byte) 0x6E;
    public static final byte ROR_ABSOLUTE_X = (byte) 0x7E;
    public static final byte RTI = (byte) 0x40;
    public static final byte RTS = (byte) 0x60;
    public static final byte SBC = (byte) 0xE9;
    public static final byte SBC_ZERO_PAGE = (byte) 0xE5;
    public static final byte SBC_ZERO_PAGE_X = (byte) 0xF5;
    public static final byte SBC_ABSOLUTE = (byte) 0xED;
    public static final byte SBC_ABSOLUTE_X = (byte) 0xFD;
    public static final byte SBC_ABSOLUTE_Y = (byte) 0xF9;
    public static final byte SBC_INDEXED_INDIRECT = (byte) 0xE1;
    public static final byte SBC_INDIRECT_INDEXED = (byte) 0xF1;
    public static final byte SEC = (byte) 0x38;
    public static final byte SED = (byte) 0xF8;
    public static final byte SEI = (byte) 0x78;
    public static final byte SLO_ZERO_PAGE = (byte) 0x07;
    public static final byte SLO_ZERO_PAGE_X = (byte) 0x17;
    public static final byte SLO_ABSOLUTE = (byte) 0x0F;
    public static final byte SLO_ABSOLUTE_X = (byte) 0x1F;
    public static final byte SLO_ABSOLUTE_Y = (byte) 0x1B;
    public static final byte SLO_INDEXED_INDIRECT = (byte) 0x03;
    public static final byte SLO_INDIRECT_INDEXED = (byte) 0x13;
    public static final byte STA = (byte) 0x85;
    public static final byte STA_ZERO_PAGE_X = (byte) 0x95;
    public static final byte STA_ABSOLUTE = (byte) 0x8D;
    public static final byte STA_ABSOLUTE_X = (byte) 0x9D;
    public static final byte STA_ABSOLUTE_Y = (byte) 0x99;
    public static final byte STA_INDEXED_INDIRECT = (byte) 0x81;
    public static final byte STA_INDIRECT_INDEXED = (byte) 0x91;
    public static final byte STX = (byte) 0x86;
    public static final byte STX_ZERO_PAGE_Y = (byte) 0x96;
    public static final byte STX_ABSOLUTE = (byte) 0x8E;
    public static final byte STY = (byte) 0x84;
    public static final byte STY_ZERO_PAGE_X = (byte) 0x94;
    public static final byte STY_ABSOLUTE = (byte) 0x8C;
    public static final byte TAX = (byte) 0xAA;
    public static final byte TAY = (byte) 0xA8;
    public static final byte TSX = (byte) 0xBA;
    public static final byte TXA = (byte) 0x8A;
    public static final byte TXS = (byte) 0x9A;
    public static final byte TYA = (byte) 0x98;

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
    public static void adc_indexed_indirect() {
        if (ArgsHandler.debug) 
            Debug.printASM(ADC_INDEXED_INDIRECT, "ADC");
    }
    public static void adc_indirect_indexed() {
        if (ArgsHandler.debug) 
            Debug.printASM(ADC_INDIRECT_INDEXED, "ADC");
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
    public static void and_indexed_indirect() {
        if (ArgsHandler.debug) 
            Debug.printASM(AND_INDEXED_INDIRECT, "AND");
    }
    public static void and_indirect_indexed() {
        if (ArgsHandler.debug) 
            Debug.printASM(AND_INDIRECT_INDEXED, "AND");
    }

    public static void asl() {
        if (ArgsHandler.debug) 
            Debug.printASM(ASL, "ASL");
    }
    public static void asl_zero_page() {
        if (ArgsHandler.debug) 
            Debug.printASM(ASL_ZERO_PAGE, "ASL");
    }
    public static void asl_zero_page_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(ASL_ZERO_PAGE_X, "ASL");
    }
    public static void asl_absolute() {
        if (ArgsHandler.debug) 
            Debug.printASM(ASL_ABSOLUTE, "ASL");
    }
    public static void asl_absolute_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(ASL_ABSOLUTE_X, "ASL");
    }


    public static void bcc() {
        if (ArgsHandler.debug) 
            Debug.printASM(BCC, "BCC");
    }
    public static void bcs() {
        if (ArgsHandler.debug) 
            Debug.printASM(BCS, "BCS");
    }
    public static void beq() {
        if (ArgsHandler.debug) 
            Debug.printASM(BEQ, "BEQ");
    }


    public static void bit() {
        if (ArgsHandler.debug) 
            Debug.printASM(BIT, "BIT i");
    }   

    /**
     * Bit test
     */
    public static void bit_absolute() {
        // Get the address parts
        Registers.pc++;
        byte lowerByte = (byte) (Cpu.fetchNextValue() & 0xFF);
        Registers.pc++; 
        byte higherByte = (byte) (Cpu.fetchNextValue() & 0xFF);

        // Convert them to little endian
        short address = (short) ((higherByte << 8) | lowerByte);

        byte testValue = Ram.read(address);

        // Set Zero Flag to 0 if test & acc = 0
        if ((testValue & Registers.acc) == 0) {
            Registers.status |= Registers.ZERO_MASK;
        } else {
            Registers.status &= ~Registers.ZERO_MASK;
        }

        // Set N flag based on the 7th bit of the value
        if ((testValue & Registers.NEGATIVE_MASK) != 0) {
            Registers.status |= Registers.NEGATIVE_MASK;
        } else {
            Registers.status &= ~Registers.NEGATIVE_MASK;
        }

        // Set overflow flag based on the 6th bit of the value
        if ((testValue & Registers.OVERFLOW_MASK) != 0) {
            Registers.status |= Registers.OVERFLOW_MASK;
        } else {
            Registers.status &= ~Registers.OVERFLOW_MASK;
        }
        
        if (ArgsHandler.debug) 
            Debug.printASM(BIT_ABSOLUTE, "BIT a");
    }

    public static void bmi() {
        if (ArgsHandler.debug) 
            Debug.printASM(BMI, "BMI");
    }
    public static void bne() {
        if (ArgsHandler.debug) 
            Debug.printASM(BNE, "BNE");
    }

    /**
     * Branch on plus. If the N flag is 0, then we branch.
     */
    public static void bpl() {
        Registers.pc++;
        byte relativeAddress = Cpu.fetchNextValue();

        // Branch by the relative address.
        if ((Registers.status & Registers.NEGATIVE_MASK) == 0) {
            Registers.pc += relativeAddress & 0xFF;
        }

        Registers.pc--;

        if (ArgsHandler.debug) 
            Debug.printASM(BPL, "BPL");
    }
    public static void brk() {

        if (ArgsHandler.debug) 
            Debug.printASM(BRK, "BRK");
    }
    public static void bvc() {
        if (ArgsHandler.debug) 
            Debug.printASM(BVC, "BVC");
    }
    public static void bvs() {
        if (ArgsHandler.debug) 
            Debug.printASM(BVS, "BVS");
    }
    public static void clc() {
        if (ArgsHandler.debug) 
            Debug.printASM(CLC, "CLC");
    }
    public static void cld() {
        if (ArgsHandler.debug) 
            Debug.printASM(CLD, "CLD");
    }
    public static void cli() {
        if (ArgsHandler.debug) 
            Debug.printASM(CLI, "CLI");
    }
    public static void clv() {
        if (ArgsHandler.debug) 
            Debug.printASM(CLV, "CLV");
    }
    
    
    public static void cmp() {
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
    public static void cmp_indexed_indirect() {
        if (ArgsHandler.debug) 
            Debug.printASM(CMP_INDEXED_INDIRECT, "CMP");
    }
    public static void cmp_indirect_indexed() {
        if (ArgsHandler.debug) 
            Debug.printASM(CMP_INDIRECT_INDEXED, "CMP");
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




    public static void dec() {
        if (ArgsHandler.debug) 
            Debug.printASM(DEC, "DEC");
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
            Debug.printASM(DEX, "DEX");
    }
    public static void dey() {
        if (ArgsHandler.debug) 
            Debug.printASM(DEY, "DEY");
    }


    public static void eor() {
        if (ArgsHandler.debug) 
            Debug.printASM(EOR, "EOR");
    }
    public static void eor_zero_page() {
        if (ArgsHandler.debug) 
            Debug.printASM(EOR_ZERO_PAGE, "EOR");
    }
    public static void eor_zero_page_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(EOR_ZERO_PAGE_X, "EOR");
    }
    public static void eor_absolute() {
        if (ArgsHandler.debug) 
            Debug.printASM(EOR_ABSOLUTE, "EOR");
    }
    public static void eor_absolute_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(EOR_ABSOLUTE_X, "EOR");
    }
    public static void eor_absolute_y() {
        if (ArgsHandler.debug) 
            Debug.printASM(EOR_ABSOLUTE_Y, "EOR");
    }
    public static void eor_indexed_indirect() {
        if (ArgsHandler.debug) 
            Debug.printASM(EOR_INDEXED_INDIRECT, "EOR");
    }
    public static void eor_indirect_indexed() {
        if (ArgsHandler.debug) 
            Debug.printASM(EOR_INDIRECT_INDEXED, "EOR");
    }



    public static void inc() {
        if (ArgsHandler.debug) 
            Debug.printASM(INC, "INC");
    }
    public static void inc_zero_page_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(INC_ZERO_PAGE_X, "INC");
    }
    public static void inc_absolute() {
        if (ArgsHandler.debug) 
            Debug.printASM(INC_ABSOLUTE, "INC");
    }
    public static void inc_absolute_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(INC_ABSOLUTE_X, "INC");
    }

    /**
     * Increment X
     */
    public static void inx() {

        Registers.x++;

        if (Registers.x == 0x00)
            Registers.status |= 0x00000010; // Set Zero flag to 0
        else
            Registers.status &= 0x11111101; // Set Zero flag to 0

        if ((Registers.x & 0x80) != 0x00)
            Registers.status |= 0x10000000; // Set N Register
        else
            Registers.status &= 0x01111111; // Clear N Register


        if (ArgsHandler.debug) 
            Debug.printASM(INX, "INX");
    }


    public static void iny() {
        if (ArgsHandler.debug) 
            Debug.printASM(INY, "INY");
    }
    public static void jmp() {
        if (ArgsHandler.debug) 
            Debug.printASM(JMP, "JMP");
    }
    public static void jmp_indirect() {
        if (ArgsHandler.debug) 
            Debug.printASM(JMP_INDIRECT, "JMP");
    }

    /**
     * Jump to subroutine
     */
    public static void jsr() {
        // Get the address parts
        Registers.pc++;
        byte lowerByte = (byte) (Cpu.fetchNextValue() & 0xFF);
        Registers.pc++; 
        byte higherByte = (byte) (Cpu.fetchNextValue() & 0xFF);

        // Convert them to little endian
        short address = (short) ((higherByte << 8) | lowerByte);
        
        // Get the subroutine address to jump to.
        short returnAddress = (short) (Registers.pc - 2);
        
        // Push return address for routine on the stack
        higherByte =  (byte) ((returnAddress >> 8) & 0xFF);
        lowerByte = (byte) (returnAddress & 0xFF);
        
        // Store the return address 
        Ram.write((short) (0x0100 + Registers.sp), lowerByte);
        Registers.sp--;
        Ram.write((short) (0x0100 + Registers.sp), higherByte);
        Registers.sp--;
        
        // Set program counter to the subroutine location
        Registers.pc = (short) (address & 0xFFFF);
        
        // Decrement program counter as each loop increments
        Registers.pc--;

        if (ArgsHandler.debug) 
            Debug.printASM(JSR, address, "JSR", "$");
    }
    
    
    public static void lda() {
        if (ArgsHandler.debug) 
            Debug.printASM(LDA, "LDA");
    }
    public static void lda_zero_page() {
        if (ArgsHandler.debug) 
            Debug.printASM(LDA_ZERO_PAGE, "LDA");
    }
    public static void lda_zero_page_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(LDA_ZERO_PAGE_X, "LDA");
    }
    public static void lda_absolute() {
        if (ArgsHandler.debug) 
            Debug.printASM(LDA_ABSOLUTE, "LDA");
    }
    public static void lda_absolute_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(LDA_ABSOLUTE_X, "LDA");
    }
    public static void lda_absolute_y() {
        if (ArgsHandler.debug) 
            Debug.printASM(LDA_ABSOLUTE_Y, "LDA");
    }
    public static void lda_indexed_indirect() {
        if (ArgsHandler.debug) 
            Debug.printASM(LDA_INDEXED_INDIRECT, "LDA");
    }
    public static void lda_indirect_indexed() {
        if (ArgsHandler.debug) 
            Debug.printASM(LDA_INDIRECT_INDEXED, "LDA");
    }



    /**
     * Load the X register (Immediate)
     */
    public static void ldx() {
        if (ArgsHandler.debug) 
            Debug.printASM(LDX, Registers.x, "LDX", "#");

        // Get the next instruction
        Registers.pc++;
        Registers.x = Cpu.fetchNextValue();
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

        Registers.pc++;
        byte lowerByte = Cpu.fetchNextValue();
        Registers.pc++;
        byte higherByte = Cpu.fetchNextValue();

        // Convert them to little endian
        short address = (short) ((higherByte << 8) | lowerByte);        
        address = (short) ((address + Registers.acc) & 0xFFFF);

        // Fetch the value from memory 
        byte value = Ram.read(address);

        Registers.acc |= value;

        if (Registers.acc == 0) {
            Registers.status |= Registers.ZERO_MASK;
        } else {
            Registers.status &= ~Registers.ZERO_MASK;
        }

        if ((Registers.acc & Registers.NEGATIVE_MASK) != 0) {
            Registers.status |= Registers.NEGATIVE_MASK;
        } else {
            Registers.status &= ~Registers.NEGATIVE_MASK;
        }

        if (ArgsHandler.debug) 
            Debug.printASM(ORA_ABSOLUTE_X, "ORA");
    }


    public static void ora_absolute_y() {
        if (ArgsHandler.debug) 
            Debug.printASM(ORA_ABSOLUTE_Y, "ORA5");
    }
    public static void ora_indexed_indirect() {
        if (ArgsHandler.debug) 
            Debug.printASM(ORA_INDEXED_INDIRECT, "ORA6");
    }
    public static void ora_indirect_indexed() {
        if (ArgsHandler.debug) 
            Debug.printASM(ORA_INDIRECT_INDEXED, "ORA7");
    }




    public static void pha() {
        if (ArgsHandler.debug) 
            Debug.printASM(PHA, "PHA");
    }
    public static void php() {
        if (ArgsHandler.debug) 
            Debug.printASM(PHP, "PHP");
    }
    public static void pla() {
        if (ArgsHandler.debug) 
            Debug.printASM(PLA, "PLA");
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
            Debug.printASM(PLP, "PLP");
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
            Debug.printASM(RTI, "RTI");
    }
    public static void rts() {
        if (ArgsHandler.debug) 
            Debug.printASM(RTS, "RTS");
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
    public static void sbc_indexed_indirect() {
        if (ArgsHandler.debug) 
            Debug.printASM(SBC_INDEXED_INDIRECT, "SBC");
    }
    public static void sbc_indirect_indexed() {
        if (ArgsHandler.debug) 
            Debug.printASM(SBC_INDIRECT_INDEXED, "SBC");
    }
    

    public static void sec() {
        if (ArgsHandler.debug) 
            Debug.printASM(SEC, "SEC");
    }
    public static void sed() {
        if (ArgsHandler.debug) 
            Debug.printASM(SED, "SED");
    }

    /**
     * Set interrupt disable status
     */
    public static void sei() {
        Registers.status |= 0x04;
        if (ArgsHandler.debug)
            Debug.printASM(SEI, "SEI");
        
    }

    public static void sta() {
        if (ArgsHandler.debug) 
            Debug.printASM(STA, "STA");
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
    public static void sta_indexed_indirect() {
        if (ArgsHandler.debug) 
            Debug.printASM(STA_INDEXED_INDIRECT, "STA");
    }
    public static void sta_indirect_indexed() {
        if (ArgsHandler.debug) 
            Debug.printASM(STA_INDIRECT_INDEXED, "STA");
    }

    /**
     * 
     */
    public static void stx() {
        if (ArgsHandler.debug) 
            Debug.printASM(STX, "STX");
    }

    public static void stx_zero_page_y() {
        if (ArgsHandler.debug) 
            Debug.printASM(STX_ZERO_PAGE_Y, "STX");
    }

    /**
     * Store X Register. 
     */
    public static void stx_absolute() {

        // Get the address parts
        Registers.pc++;
        byte lowerByte = Cpu.fetchNextValue();
        Registers.pc++;
        byte higherByte = Cpu.fetchNextValue();

        // Convert them to little endian
        short address = (short) ((higherByte << 8) | lowerByte);
        
        Ram.write(address, Registers.x);

        if (ArgsHandler.debug) 
            Debug.printASM(Registers.pc, address, "STX", "$");

    }
    
    public static void sty() {
        if (ArgsHandler.debug) 
        Debug.printASM(STY, "STY");
    }
    public static void sty_zero_page_x() {
        if (ArgsHandler.debug) 
            Debug.printASM(STY_ZERO_PAGE_X, "STY");
    }
    public static void sty_absolute() {
        if (ArgsHandler.debug) 
            Debug.printASM(STY_ABSOLUTE, "STY");
    }

    public static void tax() {
        if (ArgsHandler.debug) 
            Debug.printASM(TAX, "TAX");
    }
    public static void tay() {
        if (ArgsHandler.debug) 
            Debug.printASM(TAY, "TAY");
    }
    public static void tsx() {
        if (ArgsHandler.debug) 
            Debug.printASM(TSX, "TSX");
    }
    public static void txa() {
        if (ArgsHandler.debug) 
            Debug.printASM(TXA, "TXA");
    }

    /**
     * Transfer the stack pointer to X
     */
    public static void txs() {

        Registers.sp = Registers.x;

        if (Registers.x == 0x00)
            Registers.status |= 0x00000010; // Set Zero flag to 1
        else
            Registers.status &= 0x11111101; // Set Zero flag to 0

        if ((Registers.x & 0x80) != 0x00)
            Registers.status |= 0x10000000; // Set N Register
        else
            Registers.status &= 0x01111111; // Clear N Register

        if (ArgsHandler.debug) 
            Debug.printASM(TXS, "TXS");
    }
    public static void tya() {
        if (ArgsHandler.debug) 
            Debug.printASM(TYA, "TYA");
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
    
    public static void rla_indexed_indirect() {
        if (ArgsHandler.debug) 
            Debug.printASM(RLA_INDEXED_INDIRECT, "RLA");
    }
    
    public static void rla_indirect_indexed() {
        if (ArgsHandler.debug) 
            Debug.printASM(RLA_INDIRECT_INDEXED, "RLA");
    }
    
    public static void slo_zero_page() {
        if (ArgsHandler.debug) 
            Debug.printASM(SLO_ZERO_PAGE, "SLO1");
    }
    

    /**
     * 
     */
    public static void slo_zero_page_x() {
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
    
    public static void slo_indexed_indirect() {
        if (ArgsHandler.debug) 
            Debug.printASM(SLO_INDEXED_INDIRECT, "SLO6");
    }
    
    public static void slo_indirect_indexed() {
        if (ArgsHandler.debug) 
            Debug.printASM(SLO_INDIRECT_INDEXED, "SLO7");
    }
    
}
