package org.emulator.cpu;

import java.util.HashMap;

import org.emulator.debug.Debug;
import org.emulator.memory.Ram;

/**
 * CPU is based on 6502 CPU.
 */
public class Cpu {

    private final HashMap<Byte, Runnable> opcodeToInstruction = new HashMap<>();

    public Cpu()
    {
        opcodeToInstruction.put(Instructions.ADC, Instructions::adc);
        opcodeToInstruction.put(Instructions.ADC_ZERO_PAGE, Instructions::adc_zero_page);
        opcodeToInstruction.put(Instructions.ADC_ZERO_PAGE_X, Instructions::adc_zero_page_x);
        opcodeToInstruction.put(Instructions.ADC_ABSOLUTE, Instructions::adc_absolute);
        opcodeToInstruction.put(Instructions.ADC_ABSOLUTE_X, Instructions::adc_absolute_x);
        opcodeToInstruction.put(Instructions.ADC_ABSOLUTE_Y, Instructions::adc_absolute_y);
        opcodeToInstruction.put(Instructions.ADC_INDEXED_INDIRECT, Instructions::adc_indexed_indirect);
        opcodeToInstruction.put(Instructions.ADC_INDIRECT_INDEXED, Instructions::adc_indirect_indexed);
        
        opcodeToInstruction.put(Instructions.AND, Instructions::and);
        opcodeToInstruction.put(Instructions.AND_ZERO_PAGE, Instructions::and_zero_page);
        opcodeToInstruction.put(Instructions.AND_ZERO_PAGE_X, Instructions::and_zero_page_x);
        opcodeToInstruction.put(Instructions.AND_ABSOLUTE, Instructions::and_absolute);
        opcodeToInstruction.put(Instructions.AND_ABSOLUTE_X, Instructions::and_absolute_x);
        opcodeToInstruction.put(Instructions.AND_ABSOLUTE_Y, Instructions::and_absolute_y);
        opcodeToInstruction.put(Instructions.AND_INDEXED_INDIRECT, Instructions::and_indexed_indirect);
        opcodeToInstruction.put(Instructions.AND_INDIRECT_INDEXED, Instructions::and_indirect_indexed);
        
        opcodeToInstruction.put(Instructions.ASL, Instructions::asl);
        opcodeToInstruction.put(Instructions.ASL_ZERO_PAGE, Instructions::asl_zero_page);
        opcodeToInstruction.put(Instructions.ASL_ZERO_PAGE_X, Instructions::asl_zero_page_x);
        opcodeToInstruction.put(Instructions.ASL_ABSOLUTE, Instructions::asl_absolute);
        opcodeToInstruction.put(Instructions.ASL_ABSOLUTE_X, Instructions::asl_absolute_x);
        
        opcodeToInstruction.put(Instructions.BCC, Instructions::bcc);
        opcodeToInstruction.put(Instructions.BCS, Instructions::bcs);
        opcodeToInstruction.put(Instructions.BEQ, Instructions::beq);
        
        opcodeToInstruction.put(Instructions.BIT, Instructions::bit);
        opcodeToInstruction.put(Instructions.BIT_ABSOLUTE, Instructions::bit_absolute);
        
        opcodeToInstruction.put(Instructions.BMI, Instructions::bmi);
        opcodeToInstruction.put(Instructions.BNE, Instructions::bne);
        opcodeToInstruction.put(Instructions.BPL, Instructions::bpl);
        opcodeToInstruction.put(Instructions.BRK, Instructions::brk);
        opcodeToInstruction.put(Instructions.BVC, Instructions::bvc);
        opcodeToInstruction.put(Instructions.BVS, Instructions::bvs);
        opcodeToInstruction.put(Instructions.CLC, Instructions::clc);
        opcodeToInstruction.put(Instructions.CLD, Instructions::cld);
        opcodeToInstruction.put(Instructions.CLI, Instructions::cli);
        opcodeToInstruction.put(Instructions.CLV, Instructions::clv);
        
        opcodeToInstruction.put(Instructions.CMP, Instructions::cmp);
        opcodeToInstruction.put(Instructions.CMP_ZERO_PAGE, Instructions::cmp_zero_page);
        opcodeToInstruction.put(Instructions.CMP_ZERO_PAGE_X, Instructions::cmp_zero_page_x);
        opcodeToInstruction.put(Instructions.CMP_ABSOLUTE, Instructions::cmp_absolute);
        opcodeToInstruction.put(Instructions.CMP_ABSOLUTE_X, Instructions::cmp_absolute_x);
        opcodeToInstruction.put(Instructions.CMP_ABSOLUTE_Y, Instructions::cmp_absolute_y);
        opcodeToInstruction.put(Instructions.CMP_INDEXED_INDIRECT, Instructions::cmp_indexed_indirect);
        opcodeToInstruction.put(Instructions.CMP_INDIRECT_INDEXED, Instructions::cmp_indirect_indexed);
        
        opcodeToInstruction.put(Instructions.CPX, Instructions::cpx);
        opcodeToInstruction.put(Instructions.CPX_ZERO_PAGE, Instructions::cpx_zero_page);
        opcodeToInstruction.put(Instructions.CPX_ABSOLUTE, Instructions::cpx_absolute);
        
        opcodeToInstruction.put(Instructions.CPY, Instructions::cpy);
        opcodeToInstruction.put(Instructions.CPY_ZERO_PAGE, Instructions::cpy_zero_page);
        opcodeToInstruction.put(Instructions.CPY_ABSOLUTE, Instructions::cpy_absolute);
        
        opcodeToInstruction.put(Instructions.DEC, Instructions::dec);
        opcodeToInstruction.put(Instructions.DEC_ZERO_PAGE_X, Instructions::dec_zero_page_x);
        opcodeToInstruction.put(Instructions.DEC_ABSOLUTE, Instructions::dec_absolute);
        opcodeToInstruction.put(Instructions.DEC_ABSOLUTE_X, Instructions::dec_absolute_x);
        
        opcodeToInstruction.put(Instructions.DEX, Instructions::dex);
        opcodeToInstruction.put(Instructions.DEY, Instructions::dey);
        
        opcodeToInstruction.put(Instructions.EOR, Instructions::eor);
        opcodeToInstruction.put(Instructions.EOR_ZERO_PAGE, Instructions::eor_zero_page);
        opcodeToInstruction.put(Instructions.EOR_ZERO_PAGE_X, Instructions::eor_zero_page_x);
        opcodeToInstruction.put(Instructions.EOR_ABSOLUTE, Instructions::eor_absolute);
        opcodeToInstruction.put(Instructions.EOR_ABSOLUTE_X, Instructions::eor_absolute_x);
        opcodeToInstruction.put(Instructions.EOR_ABSOLUTE_Y, Instructions::eor_absolute_y);
        opcodeToInstruction.put(Instructions.EOR_INDEXED_INDIRECT, Instructions::eor_indexed_indirect);
        opcodeToInstruction.put(Instructions.EOR_INDIRECT_INDEXED, Instructions::eor_indirect_indexed);
        
        opcodeToInstruction.put(Instructions.INC, Instructions::inc);
        opcodeToInstruction.put(Instructions.INC_ZERO_PAGE_X, Instructions::inc_zero_page_x);
        opcodeToInstruction.put(Instructions.INC_ABSOLUTE, Instructions::inc_absolute);
        opcodeToInstruction.put(Instructions.INC_ABSOLUTE_X, Instructions::inc_absolute_x);
        
        opcodeToInstruction.put(Instructions.INX, Instructions::inx);
        opcodeToInstruction.put(Instructions.INY, Instructions::iny);
        
        opcodeToInstruction.put(Instructions.JMP, Instructions::jmp);
        opcodeToInstruction.put(Instructions.JMP_INDIRECT, Instructions::jmp_indirect);
        
        opcodeToInstruction.put(Instructions.JSR, Instructions::jsr);
        
        opcodeToInstruction.put(Instructions.LDA, Instructions::lda);
        opcodeToInstruction.put(Instructions.LDA_ZERO_PAGE, Instructions::lda_zero_page);
        opcodeToInstruction.put(Instructions.LDA_ZERO_PAGE_X, Instructions::lda_zero_page_x);
        opcodeToInstruction.put(Instructions.LDA_ABSOLUTE, Instructions::lda_absolute);
        opcodeToInstruction.put(Instructions.LDA_ABSOLUTE_X, Instructions::lda_absolute_x);
        opcodeToInstruction.put(Instructions.LDA_ABSOLUTE_Y, Instructions::lda_absolute_y);
        opcodeToInstruction.put(Instructions.LDA_INDEXED_INDIRECT, Instructions::lda_indexed_indirect);
        opcodeToInstruction.put(Instructions.LDA_INDIRECT_INDEXED, Instructions::lda_indirect_indexed);
        
        opcodeToInstruction.put(Instructions.LDX, Instructions::ldx);
        opcodeToInstruction.put(Instructions.LDX_ZERO_PAGE, Instructions::ldx_zero_page);
        opcodeToInstruction.put(Instructions.LDX_ZERO_PAGE_Y, Instructions::ldx_zero_page_y);
        opcodeToInstruction.put(Instructions.LDX_ABSOLUTE, Instructions::ldx_absolute);
        opcodeToInstruction.put(Instructions.LDX_ABSOLUTE_Y, Instructions::ldx_absolute_y);
        
        opcodeToInstruction.put(Instructions.LDY, Instructions::ldy);
        opcodeToInstruction.put(Instructions.LDY_ZERO_PAGE, Instructions::ldy_zero_page);
        opcodeToInstruction.put(Instructions.LDY_ZERO_PAGE_X, Instructions::ldy_zero_page_x);
        opcodeToInstruction.put(Instructions.LDY_ABSOLUTE, Instructions::ldy_absolute);
        opcodeToInstruction.put(Instructions.LDY_ABSOLUTE_X, Instructions::ldy_absolute_x);
        
        opcodeToInstruction.put(Instructions.LSR, Instructions::lsr);
        opcodeToInstruction.put(Instructions.LSR_ZERO_PAGE, Instructions::lsr_zero_page);
        opcodeToInstruction.put(Instructions.LSR_ZERO_PAGE_X, Instructions::lsr_zero_page_x);
        opcodeToInstruction.put(Instructions.LSR_ABSOLUTE, Instructions::lsr_absolute);
        opcodeToInstruction.put(Instructions.LSR_ABSOLUTE_X, Instructions::lsr_absolute_x);
        
        opcodeToInstruction.put(Instructions.NOP, Instructions::nop);
        opcodeToInstruction.put((byte)0x04, Instructions::nop);
        opcodeToInstruction.put((byte)0x0C, Instructions::nop);
        opcodeToInstruction.put((byte)0x14, Instructions::nop);
        opcodeToInstruction.put((byte)0x1A, Instructions::nop);
        opcodeToInstruction.put((byte)0x1C, Instructions::nop);
        opcodeToInstruction.put((byte)0x34, Instructions::nop);
        opcodeToInstruction.put((byte)0x3A, Instructions::nop);
        opcodeToInstruction.put((byte)0x3C, Instructions::nop);
        opcodeToInstruction.put((byte)0x44, Instructions::nop);
        opcodeToInstruction.put((byte)0x54, Instructions::nop);
        opcodeToInstruction.put((byte)0x5A, Instructions::nop);
        opcodeToInstruction.put((byte)0x5C, Instructions::nop);
        opcodeToInstruction.put((byte)0x64, Instructions::nop);
        opcodeToInstruction.put((byte)0x74, Instructions::nop);
        opcodeToInstruction.put((byte)0x7A, Instructions::nop);
        opcodeToInstruction.put((byte)0x7C, Instructions::nop);
        opcodeToInstruction.put((byte)0x80, Instructions::nop);
        opcodeToInstruction.put((byte)0x82, Instructions::nop);
        opcodeToInstruction.put((byte)0x89, Instructions::nop);
        opcodeToInstruction.put((byte)0xC2, Instructions::nop);
        opcodeToInstruction.put((byte)0xD4, Instructions::nop);
        opcodeToInstruction.put((byte)0xDA, Instructions::nop);
        opcodeToInstruction.put((byte)0xDC, Instructions::nop);
        opcodeToInstruction.put((byte)0xE2, Instructions::nop);
        opcodeToInstruction.put((byte)0xF4, Instructions::nop);
        opcodeToInstruction.put((byte)0xFA, Instructions::nop);
        opcodeToInstruction.put((byte)0xFC, Instructions::nop);
        opcodeToInstruction.put((byte)Instructions.PADDING, Instructions::nop);
        opcodeToInstruction.put((byte)Instructions.PADDING_ZERO, Instructions::nop);

        
        opcodeToInstruction.put(Instructions.ORA, Instructions::ora);
        opcodeToInstruction.put(Instructions.ORA_ZERO_PAGE, Instructions::ora_zero_page);
        opcodeToInstruction.put(Instructions.ORA_ZERO_PAGE_X, Instructions::ora_zero_page_x);
        opcodeToInstruction.put(Instructions.ORA_ABSOLUTE, Instructions::ora_absolute);
        opcodeToInstruction.put(Instructions.ORA_ABSOLUTE_X, Instructions::ora_absolute_x);
        opcodeToInstruction.put(Instructions.ORA_ABSOLUTE_Y, Instructions::ora_absolute_y);
        opcodeToInstruction.put(Instructions.ORA_INDEXED_INDIRECT, Instructions::ora_indexed_indirect);
        opcodeToInstruction.put(Instructions.ORA_INDIRECT_INDEXED, Instructions::ora_indirect_indexed);
        
        opcodeToInstruction.put(Instructions.PHA, Instructions::pha);
        opcodeToInstruction.put(Instructions.PHP, Instructions::php);
        opcodeToInstruction.put(Instructions.PLA, Instructions::pla);
        opcodeToInstruction.put(Instructions.PLP, Instructions::plp);
        
        opcodeToInstruction.put(Instructions.RLA_ZERO_PAGE, Instructions::rla_zero_page);
        opcodeToInstruction.put(Instructions.RLA_ZERO_PAGE_X, Instructions::rla_zero_page_x);
        opcodeToInstruction.put(Instructions.RLA_ABSOLUTE, Instructions::rla_absolute);
        opcodeToInstruction.put(Instructions.RLA_ABSOLUTE_X, Instructions::rla_absolute_x);
        opcodeToInstruction.put(Instructions.RLA_ABSOLUTE_Y, Instructions::rla_absolute_y);
        opcodeToInstruction.put(Instructions.RLA_INDEXED_INDIRECT, Instructions::rla_indexed_indirect);
        opcodeToInstruction.put(Instructions.RLA_INDIRECT_INDEXED, Instructions::rla_indirect_indexed);


        opcodeToInstruction.put(Instructions.ROL, Instructions::rol);
        opcodeToInstruction.put(Instructions.ROL_ZERO_PAGE, Instructions::rol_zero_page);
        opcodeToInstruction.put(Instructions.ROL_ZERO_PAGE_X, Instructions::rol_zero_page_x);
        opcodeToInstruction.put(Instructions.ROL_ABSOLUTE, Instructions::rol_absolute);
        opcodeToInstruction.put(Instructions.ROL_ABSOLUTE_X, Instructions::rol_absolute_x);
        
        opcodeToInstruction.put(Instructions.ROR, Instructions::ror);
        opcodeToInstruction.put(Instructions.ROR_ZERO_PAGE, Instructions::ror_zero_page);
        opcodeToInstruction.put(Instructions.ROR_ZERO_PAGE_X, Instructions::ror_zero_page_x);
        opcodeToInstruction.put(Instructions.ROR_ABSOLUTE, Instructions::ror_absolute);
        opcodeToInstruction.put(Instructions.ROR_ABSOLUTE_X, Instructions::ror_absolute_x);
        
        opcodeToInstruction.put(Instructions.RTI, Instructions::rti);
        opcodeToInstruction.put(Instructions.RTS, Instructions::rts);
        
        opcodeToInstruction.put(Instructions.SBC, Instructions::sbc);
        opcodeToInstruction.put(Instructions.SBC_ZERO_PAGE, Instructions::sbc_zero_page);
        opcodeToInstruction.put(Instructions.SBC_ZERO_PAGE_X, Instructions::sbc_zero_page_x);
        opcodeToInstruction.put(Instructions.SBC_ABSOLUTE, Instructions::sbc_absolute);
        opcodeToInstruction.put(Instructions.SBC_ABSOLUTE_X, Instructions::sbc_absolute_x);
        opcodeToInstruction.put(Instructions.SBC_ABSOLUTE_Y, Instructions::sbc_absolute_y);
        opcodeToInstruction.put(Instructions.SBC_INDEXED_INDIRECT, Instructions::sbc_indexed_indirect);
        opcodeToInstruction.put(Instructions.SBC_INDIRECT_INDEXED, Instructions::sbc_indirect_indexed);
        
        opcodeToInstruction.put(Instructions.SEC, Instructions::sec);
        opcodeToInstruction.put(Instructions.SED, Instructions::sed);
        opcodeToInstruction.put(Instructions.SEI, Instructions::sei);
        
        opcodeToInstruction.put(Instructions.SLO_ZERO_PAGE, Instructions::slo_zero_page);
        opcodeToInstruction.put(Instructions.SLO_ZERO_PAGE_X, Instructions::slo_zero_page_x);
        opcodeToInstruction.put(Instructions.SLO_ABSOLUTE, Instructions::slo_absolute);
        opcodeToInstruction.put(Instructions.SLO_ABSOLUTE_X, Instructions::slo_absolute_x);
        opcodeToInstruction.put(Instructions.SLO_ABSOLUTE_Y, Instructions::slo_absolute_y);
        opcodeToInstruction.put(Instructions.SLO_INDEXED_INDIRECT, Instructions::slo_indexed_indirect);
        opcodeToInstruction.put(Instructions.SLO_INDIRECT_INDEXED, Instructions::slo_indirect_indexed);
        
        opcodeToInstruction.put(Instructions.STA, Instructions::sta);
        opcodeToInstruction.put(Instructions.STA_ZERO_PAGE_X, Instructions::sta_zero_page_x);
        opcodeToInstruction.put(Instructions.STA_ABSOLUTE, Instructions::sta_absolute);
        opcodeToInstruction.put(Instructions.STA_ABSOLUTE_X, Instructions::sta_absolute_x);
        opcodeToInstruction.put(Instructions.STA_ABSOLUTE_Y, Instructions::sta_absolute_y);
        opcodeToInstruction.put(Instructions.STA_INDEXED_INDIRECT, Instructions::sta_indexed_indirect);
        opcodeToInstruction.put(Instructions.STA_INDIRECT_INDEXED, Instructions::sta_indirect_indexed);
        
        opcodeToInstruction.put(Instructions.STX, Instructions::stx);
        opcodeToInstruction.put(Instructions.STX_ZERO_PAGE_Y, Instructions::stx_zero_page_y);
        opcodeToInstruction.put(Instructions.STX_ABSOLUTE, Instructions::stx_absolute);
        
        opcodeToInstruction.put(Instructions.STY, Instructions::sty);
        opcodeToInstruction.put(Instructions.STY_ZERO_PAGE_X, Instructions::sty_zero_page_x);
        opcodeToInstruction.put(Instructions.STY_ABSOLUTE, Instructions::sty_absolute);
        
        opcodeToInstruction.put(Instructions.TAX, Instructions::tax);
        opcodeToInstruction.put(Instructions.TAY, Instructions::tay);
        opcodeToInstruction.put(Instructions.TSX, Instructions::tsx);
        opcodeToInstruction.put(Instructions.TXA, Instructions::txa);
        opcodeToInstruction.put(Instructions.TXS, Instructions::txs);
        opcodeToInstruction.put(Instructions.TYA, Instructions::tya);

        opcodeToInstruction.put(Instructions.SRE_INDIRECT_X, Instructions::sre_indirect_x);
        opcodeToInstruction.put(Instructions.SRE_ZERO_PAGE, Instructions::sre_zero_page);
        opcodeToInstruction.put(Instructions.SRE_ABSOLUTE, Instructions::sre_absolute);
        opcodeToInstruction.put(Instructions.SRE_INDIRECT_Y, Instructions::sre_indirect_y);
        opcodeToInstruction.put(Instructions.SRE_ZERO_PAGE_X, Instructions::sre_zero_page_x);
        opcodeToInstruction.put(Instructions.SRE_ABSOLUTE_Y, Instructions::sre_absolute_y);
        opcodeToInstruction.put(Instructions.SRE_ABSOLUTE_X, Instructions::sre_absolute_x);
        
        opcodeToInstruction.put(Instructions.RRA_INDIRECT_X, Instructions::rra_indirect_x);
        opcodeToInstruction.put(Instructions.RRA_ZERO_PAGE, Instructions::rra_zero_page);
        opcodeToInstruction.put(Instructions.RRA_ABSOLUTE, Instructions::rra_absolute);
        opcodeToInstruction.put(Instructions.RRA_INDIRECT_Y, Instructions::rra_indirect_y);
        opcodeToInstruction.put(Instructions.RRA_ZERO_PAGE_X, Instructions::rra_zero_page_x);
        opcodeToInstruction.put(Instructions.RRA_ABSOLUTE_Y, Instructions::rra_absolute_y);
        opcodeToInstruction.put(Instructions.RRA_ABSOLUTE_X, Instructions::rra_absolute_x);
        
        
        opcodeToInstruction.put(Instructions.LAX_ZERO_PAGE, Instructions::lax_zero_page);
        opcodeToInstruction.put(Instructions.LAX_ABSOLUTE, Instructions::lax_absolute);
        opcodeToInstruction.put(Instructions.LAX_INDIRECT_Y, Instructions::lax_indirect_y);
        opcodeToInstruction.put(Instructions.LAX_ZERO_PAGE_Y, Instructions::lax_zero_page_y);
        opcodeToInstruction.put(Instructions.LAX_ABSOLUTE_Y, Instructions::lax_absolute_y);
        
        opcodeToInstruction.put(Instructions.SAX_ZERO_PAGE, Instructions::sax_zero_page);
        opcodeToInstruction.put(Instructions.SAX_ABSOLUTE, Instructions::sax_absolute);
        opcodeToInstruction.put(Instructions.SAX_ZERO_PAGE_Y, Instructions::sax_zero_page_y);
        
        opcodeToInstruction.put(Instructions.SBC_IMMEDIATE, Instructions::sbc_immediate);
        opcodeToInstruction.put(Instructions.AHX_ABSOLUTE_Y, Instructions::ahx_absolute_y);
        opcodeToInstruction.put(Instructions.AHX_INDIRECT_Y, Instructions::ahx_indirect_y);
        opcodeToInstruction.put(Instructions.SHY_ABSOLUTE_X, Instructions::shy_absolute_x);
        opcodeToInstruction.put(Instructions.SHX_ABSOLUTE_Y, Instructions::shx_absolute_y);
        
        opcodeToInstruction.put(Instructions.KIL_IMPLICIT_02, Instructions::kil_implicit_02);
        opcodeToInstruction.put(Instructions.KIL_IMPLICIT_12, Instructions::kil_implicit_12);
        opcodeToInstruction.put(Instructions.KIL_IMPLICIT_22, Instructions::kil_implicit_22);
        opcodeToInstruction.put(Instructions.KIL_IMPLICIT_32, Instructions::kil_implicit_32);
        opcodeToInstruction.put(Instructions.KIL_IMPLICIT_42, Instructions::kil_implicit_42);
        opcodeToInstruction.put(Instructions.KIL_IMPLICIT_92, Instructions::kil_implicit_92);
        
        opcodeToInstruction.put(Instructions.XAA_IMMEDIATE, Instructions::xaa_immediate);

    }


    /**
     * Read the current opcode, execute instruction.
     */
    private void executeInstruction(byte opcode) {
        try {
            Runnable instruction = opcodeToInstruction.get(opcode);
            instruction.run();

        } catch (NullPointerException e) {
            Debug.printDebug("Invalid opcode (" + String.format("0x%02X", opcode & 0xFF) + ")", false);
            System.exit(0);
        }

    }


    public static byte fetchNextValue() {
        return  Ram.read(Registers.pc);
    }

    public void readResetVector() {
        byte [] resetVector = { 
            Ram.read((short) 0xFFFC), 
            Ram.read((short) 0xFFFD)
        };
        // Convert to little endian
        Registers.pc = (short) ((resetVector[1] & 0xFF) << 8 | (resetVector[0] & 0xFF));
    }

    public void executeCycle() {
        executeInstruction(fetchNextValue());
        Registers.pc++;
    }

}
