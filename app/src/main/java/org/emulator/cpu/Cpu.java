package org.emulator.cpu;

import java.util.HashMap;
import java.util.concurrent.Callable;

import org.emulator.debug.Debug;
import org.emulator.memory.Ram;

/**
 * CPU is based on 6502 CPU.
 */
public class Cpu {

    private final HashMap<Byte, Callable<Integer>> opcodeToInstruction = new HashMap<>();
    public Cpu()
    {
        opcodeToInstruction.put(Instructions.BRK_IMPLIED, Instructions::brk);
        opcodeToInstruction.put(Instructions.NOP_ZERO_PAGE, Instructions::nop_zero_page);
        opcodeToInstruction.put(Instructions.PHP_IMPLIED, Instructions::php);
        opcodeToInstruction.put(Instructions.NOP_ABSOLUTE, Instructions::nop_absolute);
        opcodeToInstruction.put(Instructions.BPL_RELATIVE, Instructions::bpl);
        opcodeToInstruction.put(Instructions.NOP_ZERO_PAGE_X, Instructions::nop_zero_page_x);
        opcodeToInstruction.put(Instructions.CLC_IMPLIED, Instructions::clc);
        opcodeToInstruction.put(Instructions.NOP_ABSOLUTE_X, Instructions::nop_absolute_x);
        opcodeToInstruction.put(Instructions.JSR_ABSOLUTE, Instructions::jsr);
        opcodeToInstruction.put(Instructions.BIT_ZERO_PAGE, Instructions::bit);
        opcodeToInstruction.put(Instructions.PLP_IMPLIED, Instructions::plp);
        opcodeToInstruction.put(Instructions.BIT_ABSOLUTE, Instructions::bit_absolute);
        opcodeToInstruction.put(Instructions.BMI_RELATIVE, Instructions::bmi);
        opcodeToInstruction.put(Instructions.SEC_IMPLIED, Instructions::sec);
        opcodeToInstruction.put(Instructions.RTI_IMPLIED, Instructions::rti);
        opcodeToInstruction.put(Instructions.PHA_IMPLIED, Instructions::pha);
        opcodeToInstruction.put(Instructions.JMP_ABSOLUTE, Instructions::jmp);
        opcodeToInstruction.put(Instructions.BVC_RELATIVE, Instructions::bvc);
        opcodeToInstruction.put(Instructions.CLI_IMPLIED, Instructions::cli);
        opcodeToInstruction.put(Instructions.RTS_IMPLIED, Instructions::rts);
        opcodeToInstruction.put(Instructions.PLA_IMPLIED, Instructions::pla);
        opcodeToInstruction.put(Instructions.JMP_IND, Instructions::jmp_indirect);
        opcodeToInstruction.put(Instructions.BVS_RELATIVE, Instructions::bvs);
        opcodeToInstruction.put(Instructions.SEI_IMPLIED, Instructions::sei);
        opcodeToInstruction.put(Instructions.NOP, Instructions::nop);
        opcodeToInstruction.put(Instructions.STY_ZERO_PAGE, Instructions::sty_zero_page);
        opcodeToInstruction.put(Instructions.DEY_IMPLIED, Instructions::dey);
        opcodeToInstruction.put(Instructions.STY_ABSOLUTE, Instructions::sty_absolute);
        opcodeToInstruction.put(Instructions.BCC_RELATIVE, Instructions::bcc);
        opcodeToInstruction.put(Instructions.STY_ZERO_PAGE_X, Instructions::sty_zero_page_x);
        opcodeToInstruction.put(Instructions.TYA_IMPLIED, Instructions::tya);
        opcodeToInstruction.put(Instructions.SHY_ABSOLUTE_X, Instructions::shy_absolute_x);
        opcodeToInstruction.put(Instructions.LDY, Instructions::ldy);
        opcodeToInstruction.put(Instructions.LDY_ZERO_PAGE, Instructions::ldy_zero_page);
        opcodeToInstruction.put(Instructions.TAY_IMPLIED, Instructions::tay);
        opcodeToInstruction.put(Instructions.LDY_ABSOLUTE, Instructions::ldy_absolute);
        opcodeToInstruction.put(Instructions.BCS_RELATIVE, Instructions::bcs);
        opcodeToInstruction.put(Instructions.LDY_ZERO_PAGE_X, Instructions::ldy_zero_page_x);
        opcodeToInstruction.put(Instructions.CLV_IMPLIED, Instructions::clv);
        opcodeToInstruction.put(Instructions.LDY_ABSOLUTE_X, Instructions::ldy_absolute_x);
        opcodeToInstruction.put(Instructions.CPY, Instructions::cpy);
        opcodeToInstruction.put(Instructions.CPY_ZERO_PAGE, Instructions::cpy_zero_page);
        opcodeToInstruction.put(Instructions.INY_IMPLIED, Instructions::iny);
        opcodeToInstruction.put(Instructions.CPY_ABSOLUTE, Instructions::cpy_absolute);
        opcodeToInstruction.put(Instructions.BNE_RELATIVE, Instructions::bne);
        opcodeToInstruction.put(Instructions.CLD_IMPLIED, Instructions::cld);
        opcodeToInstruction.put(Instructions.CPX, Instructions::cpx);
        opcodeToInstruction.put(Instructions.CPX_ZERO_PAGE, Instructions::cpx_zero_page);
        opcodeToInstruction.put(Instructions.INX_IMPLIED, Instructions::inx);
        opcodeToInstruction.put(Instructions.CPX_ABSOLUTE, Instructions::cpx_absolute);
        opcodeToInstruction.put(Instructions.BEQ_RELATIVE, Instructions::beq);
        opcodeToInstruction.put(Instructions.SED_IMPLIED, Instructions::sed);
        opcodeToInstruction.put(Instructions.ORA_X_IND, Instructions::ora_x_ind);
        opcodeToInstruction.put(Instructions.ORA_ZERO_PAGE, Instructions::ora_zero_page);
        opcodeToInstruction.put(Instructions.ORA, Instructions::ora);
        opcodeToInstruction.put(Instructions.ORA_ABSOLUTE, Instructions::ora_absolute);
        opcodeToInstruction.put(Instructions.ORA_IND_Y, Instructions::ora_ind_y);
        opcodeToInstruction.put(Instructions.ORA_ZERO_PAGE_X, Instructions::ora_zero_page_x);
        opcodeToInstruction.put(Instructions.ORA_ABSOLUTE_Y, Instructions::ora_absolute_y);
        opcodeToInstruction.put(Instructions.ORA_ABSOLUTE_X, Instructions::ora_absolute_x);
        opcodeToInstruction.put(Instructions.AND_X_IND, Instructions::and_x_ind);
        opcodeToInstruction.put(Instructions.AND_ZERO_PAGE, Instructions::and_zero_page);
        opcodeToInstruction.put(Instructions.AND, Instructions::and);
        opcodeToInstruction.put(Instructions.AND_ABSOLUTE, Instructions::and_absolute);
        opcodeToInstruction.put(Instructions.AND_IND_Y, Instructions::and_ind_y);
        opcodeToInstruction.put(Instructions.AND_ZERO_PAGE_X, Instructions::and_zero_page_x);
        opcodeToInstruction.put(Instructions.AND_ABSOLUTE_Y, Instructions::and_absolute_y);
        opcodeToInstruction.put(Instructions.AND_ABSOLUTE_X, Instructions::and_absolute_x);
        opcodeToInstruction.put(Instructions.EOR_X_IND, Instructions::eor_x_ind);
        opcodeToInstruction.put(Instructions.EOR_ZERO_PAGE, Instructions::eor_zero_page);
        opcodeToInstruction.put(Instructions.EOR, Instructions::eor);
        opcodeToInstruction.put(Instructions.EOR_ABSOLUTE, Instructions::eor_absolute);
        opcodeToInstruction.put(Instructions.EOR_IND_Y, Instructions::eor_ind_y);
        opcodeToInstruction.put(Instructions.EOR_ZERO_PAGE_X, Instructions::eor_zero_page_x);
        opcodeToInstruction.put(Instructions.EOR_ABSOLUTE_Y, Instructions::eor_absolute_y);
        opcodeToInstruction.put(Instructions.EOR_ABSOLUTE_X, Instructions::eor_absolute_x);
        opcodeToInstruction.put(Instructions.ADC_X_IND, Instructions::adc_x_ind);
        opcodeToInstruction.put(Instructions.ADC_ZERO_PAGE, Instructions::adc_zero_page);
        opcodeToInstruction.put(Instructions.ADC, Instructions::adc);
        opcodeToInstruction.put(Instructions.ADC_ABSOLUTE, Instructions::adc_absolute);
        opcodeToInstruction.put(Instructions.ADC_IND_Y, Instructions::adc_ind_y);
        opcodeToInstruction.put(Instructions.ADC_ZERO_PAGE_X, Instructions::adc_zero_page_x);
        opcodeToInstruction.put(Instructions.ADC_ABSOLUTE_Y, Instructions::adc_absolute_y);
        opcodeToInstruction.put(Instructions.ADC_ABSOLUTE_X, Instructions::adc_absolute_x);
        opcodeToInstruction.put(Instructions.STA_X_IND, Instructions::sta_x_ind);
        opcodeToInstruction.put(Instructions.STA_ZERO_PAGE, Instructions::sta_zero_page);
        opcodeToInstruction.put(Instructions.STA_ABSOLUTE, Instructions::sta_absolute);
        opcodeToInstruction.put(Instructions.STA_IND_Y, Instructions::sta_ind_y);
        opcodeToInstruction.put(Instructions.STA_ZERO_PAGE_X, Instructions::sta_zero_page_x);
        opcodeToInstruction.put(Instructions.STA_ABSOLUTE_Y, Instructions::sta_absolute_y);
        opcodeToInstruction.put(Instructions.STA_ABSOLUTE_X, Instructions::sta_absolute_x);
        opcodeToInstruction.put(Instructions.LDA_X_IND, Instructions::lda_x_ind);
        opcodeToInstruction.put(Instructions.LDA_ZERO_PAGE, Instructions::lda_zero_page);
        opcodeToInstruction.put(Instructions.LDA, Instructions::lda);
        opcodeToInstruction.put(Instructions.LDA_ABSOLUTE, Instructions::lda_absolute);
        opcodeToInstruction.put(Instructions.LDA_IND_Y, Instructions::lda_ind_y);
        opcodeToInstruction.put(Instructions.LDA_ZERO_PAGE_X, Instructions::lda_zero_page_x);
        opcodeToInstruction.put(Instructions.LDA_ABSOLUTE_Y, Instructions::lda_absolute_y);
        opcodeToInstruction.put(Instructions.LDA_ABSOLUTE_X, Instructions::lda_absolute_x);
        opcodeToInstruction.put(Instructions.CMP_X_IND, Instructions::cmp_x_ind);
        opcodeToInstruction.put(Instructions.CMP_ZERO_PAGE, Instructions::cmp_zero_page);
        opcodeToInstruction.put(Instructions.CMP, Instructions::cmp);
        opcodeToInstruction.put(Instructions.CMP_ABSOLUTE, Instructions::cmp_absolute);
        opcodeToInstruction.put(Instructions.CMP_IND_Y, Instructions::cmp_ind_y);
        opcodeToInstruction.put(Instructions.CMP_ZERO_PAGE_X, Instructions::cmp_zero_page_x);
        opcodeToInstruction.put(Instructions.CMP_ABSOLUTE_Y, Instructions::cmp_absolute_y);
        opcodeToInstruction.put(Instructions.CMP_ABSOLUTE_X, Instructions::cmp_absolute_x);
        opcodeToInstruction.put(Instructions.SBC_X_IND, Instructions::sbc_x_ind);
        opcodeToInstruction.put(Instructions.SBC_ZERO_PAGE, Instructions::sbc_zero_page);
        opcodeToInstruction.put(Instructions.SBC, Instructions::sbc);
        opcodeToInstruction.put(Instructions.SBC_ABSOLUTE, Instructions::sbc_absolute);
        opcodeToInstruction.put(Instructions.SBC_IND_Y, Instructions::sbc_ind_y);
        opcodeToInstruction.put(Instructions.SBC_ZERO_PAGE_X, Instructions::sbc_zero_page_x);
        opcodeToInstruction.put(Instructions.SBC_ABSOLUTE_Y, Instructions::sbc_absolute_y);
        opcodeToInstruction.put(Instructions.SBC_ABSOLUTE_X, Instructions::sbc_absolute_x);
        opcodeToInstruction.put(Instructions.JAM, Instructions::jam);
        opcodeToInstruction.put(Instructions.ASL_ZERO_PAGE, Instructions::asl_zero_page);
        opcodeToInstruction.put(Instructions.ASL, Instructions::asl);
        opcodeToInstruction.put(Instructions.ASL_ABSOLUTE, Instructions::asl_absolute);
        opcodeToInstruction.put(Instructions.ASL_ZERO_PAGE_X, Instructions::asl_zero_page_x);
        opcodeToInstruction.put(Instructions.NOP_IMPLIED, Instructions::nop);
        opcodeToInstruction.put(Instructions.ASL_ABSOLUTE_X, Instructions::asl_absolute_x);
        opcodeToInstruction.put(Instructions.ROL_ZERO_PAGE, Instructions::rol_zero_page);
        opcodeToInstruction.put(Instructions.ROL, Instructions::rol);
        opcodeToInstruction.put(Instructions.ROL_ABSOLUTE, Instructions::rol_absolute);
        opcodeToInstruction.put(Instructions.ROL_ZERO_PAGE_X, Instructions::rol_zero_page_x);
        opcodeToInstruction.put(Instructions.ROL_ABSOLUTE_X, Instructions::rol_absolute_x);
        opcodeToInstruction.put(Instructions.LSR_ZERO_PAGE, Instructions::lsr_zero_page);
        opcodeToInstruction.put(Instructions.LSR, Instructions::lsr);
        opcodeToInstruction.put(Instructions.LSR_ABSOLUTE, Instructions::lsr_absolute);
        opcodeToInstruction.put(Instructions.LSR_ZERO_PAGE_X, Instructions::lsr_zero_page_x);
        opcodeToInstruction.put(Instructions.LSR_ABSOLUTE_X, Instructions::lsr_absolute_x);
        opcodeToInstruction.put(Instructions.ROR_ZERO_PAGE, Instructions::ror_zero_page);
        opcodeToInstruction.put(Instructions.ROR, Instructions::ror);
        opcodeToInstruction.put(Instructions.ROR_ABSOLUTE, Instructions::ror_absolute);
        opcodeToInstruction.put(Instructions.ROR_ZERO_PAGE_X, Instructions::ror_zero_page_x);
        opcodeToInstruction.put(Instructions.ROR_ABSOLUTE_X, Instructions::ror_absolute_x);
        opcodeToInstruction.put(Instructions.STX_ZERO_PAGE, Instructions::stx_zero_page);
        opcodeToInstruction.put(Instructions.TXA_IMPLIED, Instructions::txa);
        opcodeToInstruction.put(Instructions.STX_ABSOLUTE, Instructions::stx_absolute);
        opcodeToInstruction.put(Instructions.STX_ZERO_PAGE_Y, Instructions::stx_zero_page_y);
        opcodeToInstruction.put(Instructions.TXS_IMPLIED, Instructions::txs);
        opcodeToInstruction.put(Instructions.SHX_ABSOLUTE_Y, Instructions::shx_absolute_y);
        opcodeToInstruction.put(Instructions.LDX, Instructions::ldx);
        opcodeToInstruction.put(Instructions.LDX_ZERO_PAGE, Instructions::ldx_zero_page);
        opcodeToInstruction.put(Instructions.TAX_IMPLIED, Instructions::tax);
        opcodeToInstruction.put(Instructions.LDX_ABSOLUTE, Instructions::ldx_absolute);
        opcodeToInstruction.put(Instructions.LDX_ZERO_PAGE_Y, Instructions::ldx_zero_page_y);
        opcodeToInstruction.put(Instructions.TSX_IMPLIED, Instructions::tsx);
        opcodeToInstruction.put(Instructions.LDX_ABSOLUTE_Y, Instructions::ldx_absolute_y);
        opcodeToInstruction.put(Instructions.DEC_ZERO_PAGE, Instructions::dec_zero_page);
        opcodeToInstruction.put(Instructions.DEX_IMPLIED, Instructions::dex);
        opcodeToInstruction.put(Instructions.DEC_ABSOLUTE, Instructions::dec_absolute);
        opcodeToInstruction.put(Instructions.DEC_ZERO_PAGE_X, Instructions::dec_zero_page_x);
        opcodeToInstruction.put(Instructions.DEC_ABSOLUTE_X, Instructions::dec_absolute_x);
        opcodeToInstruction.put(Instructions.INC_ZERO_PAGE, Instructions::inc_zero_page);
        opcodeToInstruction.put(Instructions.INC_ABSOLUTE, Instructions::inc_absolute);
        opcodeToInstruction.put(Instructions.INC_ZERO_PAGE_X, Instructions::inc_zero_page_x);
        opcodeToInstruction.put(Instructions.INC_ABSOLUTE_X, Instructions::inc_absolute_x);
        opcodeToInstruction.put(Instructions.SLO_X_IND, Instructions::slo_x_ind);
        opcodeToInstruction.put(Instructions.SLO_ZERO_PAGE, Instructions::slo_zero_page);
        opcodeToInstruction.put(Instructions.ANC, Instructions::anc);
        opcodeToInstruction.put(Instructions.SLO_ABSOLUTE, Instructions::slo_absolute);
        opcodeToInstruction.put(Instructions.SLO_IND_Y, Instructions::slo_ind_y);
        opcodeToInstruction.put(Instructions.SLO_ZERO_PAGE_X, Instructions::slo_zero_page_x);
        opcodeToInstruction.put(Instructions.SLO_ABSOLUTE_Y, Instructions::slo_absolute_y);
        opcodeToInstruction.put(Instructions.SLO_ABSOLUTE_X, Instructions::slo_absolute_x);
        opcodeToInstruction.put(Instructions.RLA_X_IND, Instructions::rla_x_ind);
        opcodeToInstruction.put(Instructions.RLA_ZERO_PAGE, Instructions::rla_zero_page);
        opcodeToInstruction.put(Instructions.RLA_ABSOLUTE, Instructions::rla_absolute);
        opcodeToInstruction.put(Instructions.RLA_IND_Y, Instructions::rla_ind_y);
        opcodeToInstruction.put(Instructions.RLA_ZERO_PAGE_X, Instructions::rla_zero_page_x);
        opcodeToInstruction.put(Instructions.RLA_ABSOLUTE_Y, Instructions::rla_absolute_y);
        opcodeToInstruction.put(Instructions.RLA_ABSOLUTE_X, Instructions::rla_absolute_x);
        opcodeToInstruction.put(Instructions.SRE_X_IND, Instructions::sre_x_ind);
        opcodeToInstruction.put(Instructions.SRE_ZERO_PAGE, Instructions::sre_zero_page);
        opcodeToInstruction.put(Instructions.ALR, Instructions::alr);
        opcodeToInstruction.put(Instructions.SRE_ABSOLUTE, Instructions::sre_absolute);
        opcodeToInstruction.put(Instructions.SRE_IND_Y, Instructions::sre_ind_y);
        opcodeToInstruction.put(Instructions.SRE_ZERO_PAGE_X, Instructions::sre_zero_page_x);
        opcodeToInstruction.put(Instructions.SRE_ABSOLUTE_Y, Instructions::sre_absolute_y);
        opcodeToInstruction.put(Instructions.SRE_ABSOLUTE_X, Instructions::sre_absolute_x);
        opcodeToInstruction.put(Instructions.RRA_X_IND, Instructions::rra_x_ind);
        opcodeToInstruction.put(Instructions.RRA_ZERO_PAGE, Instructions::rra_zero_page);
        opcodeToInstruction.put(Instructions.ARR, Instructions::arr);
        opcodeToInstruction.put(Instructions.RRA_ABSOLUTE, Instructions::rra_absolute);
        opcodeToInstruction.put(Instructions.RRA_IND_Y, Instructions::rra_ind_y);
        opcodeToInstruction.put(Instructions.RRA_ZERO_PAGE_X, Instructions::rra_zero_page_x);
        opcodeToInstruction.put(Instructions.RRA_ABSOLUTE_Y, Instructions::rra_absolute_y);
        opcodeToInstruction.put(Instructions.RRA_ABSOLUTE_X, Instructions::rra_absolute_x);
        opcodeToInstruction.put(Instructions.SAX_X_IND, Instructions::sax_x_ind);
        opcodeToInstruction.put(Instructions.SAX_ZERO_PAGE, Instructions::sax_zero_page);
        opcodeToInstruction.put(Instructions.ANE, Instructions::xaa_immediate);
        opcodeToInstruction.put(Instructions.SAX_ABSOLUTE, Instructions::sax_absolute);
        opcodeToInstruction.put(Instructions.SHA_IND_Y, Instructions::sha_ind_y);
        opcodeToInstruction.put(Instructions.SAX_ZERO_PAGE_Y, Instructions::sax_zero_page_y);
        opcodeToInstruction.put(Instructions.TAS_ABSOLUTE_Y, Instructions::tas_absolute_y);
        opcodeToInstruction.put(Instructions.SHA_ABSOLUTE_Y, Instructions::sha_absolute_y);
        opcodeToInstruction.put(Instructions.LAX_X_IND, Instructions::lax_x_ind);
        opcodeToInstruction.put(Instructions.LAX_ZERO_PAGE, Instructions::lax_zero_page);
        opcodeToInstruction.put(Instructions.LXA, Instructions::lxa);
        opcodeToInstruction.put(Instructions.LAX_ABSOLUTE, Instructions::lax_absolute);
        opcodeToInstruction.put(Instructions.LAX_IND_Y, Instructions::lax_ind_y);
        opcodeToInstruction.put(Instructions.LAX_ZERO_PAGE_Y, Instructions::lax_zero_page_y);
        opcodeToInstruction.put(Instructions.LAS_ABSOLUTE_Y, Instructions::las_absolute_y);
        opcodeToInstruction.put(Instructions.LAX_ABSOLUTE_Y, Instructions::lax_absolute_y);
        opcodeToInstruction.put(Instructions.DCP_X_IND, Instructions::dcp_x_ind);
        opcodeToInstruction.put(Instructions.DCP_ZERO_PAGE, Instructions::dcp_zero_page);
        opcodeToInstruction.put(Instructions.SBX, Instructions::sbx);
        opcodeToInstruction.put(Instructions.DCP_ABSOLUTE, Instructions::dcp_absolute);
        opcodeToInstruction.put(Instructions.DCP_IND_Y, Instructions::dcp_ind_y);
        opcodeToInstruction.put(Instructions.DCP_ZERO_PAGE_X, Instructions::dcp_zero_page_x);
        opcodeToInstruction.put(Instructions.DCP_ABSOLUTE_Y, Instructions::dcp_absolute_y);
        opcodeToInstruction.put(Instructions.DCP_ABSOLUTE_X, Instructions::dcp_absolute_x);
        opcodeToInstruction.put(Instructions.ISC_X_IND, Instructions::isc_x_ind);
        opcodeToInstruction.put(Instructions.ISC_ZERO_PAGE, Instructions::isc_zero_page);
        opcodeToInstruction.put(Instructions.USBC, Instructions::usbc);
        opcodeToInstruction.put(Instructions.ISC_ABSOLUTE, Instructions::isc_absolute);
        opcodeToInstruction.put(Instructions.ISC_IND_Y, Instructions::isc_ind_y);
        opcodeToInstruction.put(Instructions.ISC_ZERO_PAGE_X, Instructions::isc_zero_page_x);
        opcodeToInstruction.put(Instructions.ISC_ABSOLUTE_Y, Instructions::isc_absolute_y);
        opcodeToInstruction.put(Instructions.ISC_ABSOLUTE_X, Instructions::isc_absolute_x);
        opcodeToInstruction.put((byte) 0x34, Instructions::nop_zero_page_x);
        opcodeToInstruction.put((byte) 0x54, Instructions::nop_zero_page_x);
        opcodeToInstruction.put((byte) 0x74, Instructions::nop_zero_page_x);
        opcodeToInstruction.put((byte) 0xD4, Instructions::nop_zero_page_x);
        opcodeToInstruction.put((byte) 0xF4, Instructions::nop_zero_page_x);
        opcodeToInstruction.put((byte) 0x3C, Instructions::nop_absolute_x);
        opcodeToInstruction.put((byte) 0x5C, Instructions::nop_absolute_x);
        opcodeToInstruction.put((byte) 0x7C, Instructions::nop_absolute_x);
        opcodeToInstruction.put((byte) 0xDC, Instructions::nop_absolute_x);
        opcodeToInstruction.put((byte) 0xFC, Instructions::nop_absolute_x);
        opcodeToInstruction.put((byte) 0x44, Instructions::nop_zero_page);
        opcodeToInstruction.put((byte) 0x64, Instructions::nop_zero_page);
        opcodeToInstruction.put((byte) 0x89, Instructions::nop);
        opcodeToInstruction.put((byte) 0x82, Instructions::nop);
        opcodeToInstruction.put((byte) 0xC2, Instructions::nop);
        opcodeToInstruction.put((byte) 0xE2, Instructions::nop);
        opcodeToInstruction.put((byte) 0x12, Instructions::jam);
        opcodeToInstruction.put((byte) 0x22, Instructions::jam);
        opcodeToInstruction.put((byte) 0x32, Instructions::jam);
        opcodeToInstruction.put((byte) 0x42, Instructions::jam);
        opcodeToInstruction.put((byte) 0x52, Instructions::jam);
        opcodeToInstruction.put((byte) 0x62, Instructions::jam);
        opcodeToInstruction.put((byte) 0x72, Instructions::jam);
        opcodeToInstruction.put((byte) 0x92, Instructions::jam);
        opcodeToInstruction.put((byte) 0xB2, Instructions::jam);
        opcodeToInstruction.put((byte) 0xD2, Instructions::jam);
        opcodeToInstruction.put((byte) 0xF2, Instructions::jam);
        opcodeToInstruction.put((byte) 0x3A, Instructions::nop);
        opcodeToInstruction.put((byte) 0x5A, Instructions::nop);
        opcodeToInstruction.put((byte) 0x7A, Instructions::nop);
        opcodeToInstruction.put((byte) 0xDA, Instructions::nop);
        opcodeToInstruction.put((byte) 0xEA, Instructions::nop);
        opcodeToInstruction.put((byte) 0xFA, Instructions::nop);
        opcodeToInstruction.put((byte) 0x2B, Instructions::anc);
    }

    /**
     * PPU will call this upon entering V-Blank
     */
    public static void NmiInterrupt() {
        
    }

    /**
     * Read the current opcode, execute instruction.
     */
    private int executeInstruction(byte opcode) {
        int clockCycles = 0;
        try {
            Callable<Integer> instruction = opcodeToInstruction.get(opcode);
            clockCycles = instruction.call();

        } catch (Exception e) {
            Debug.printDebug("Invalid opcode (" + String.format("0x%02X", opcode & 0xFF) + ")", false);
            System.exit(0);
        }
        return clockCycles;
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


    public int executeCycle() {

        int clockCycles = executeInstruction(fetchNextValue());

        Registers.pc++;

        Instructions.resetPageCrossed();

        return clockCycles;
    }

}
