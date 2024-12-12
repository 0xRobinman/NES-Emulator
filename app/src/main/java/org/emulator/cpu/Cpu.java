package org.emulator.cpu;

import org.emulator.memory.Ram;

/**
 * CPU is based on 6502 CPU.
 */
public class Cpu {

    public Cpu() {

    }

    /**
     * PPU will call this upon entering V-Blank
     */
    public static void NmiInterrupt() {
        Instructions.nmi_interrupt();
    }

    /**
     * Read the current opcode, execute instruction.
     */
    private int executeInstruction(byte opcode) {
        switch (opcode) {
            case Instructions.BRK_IMPLIED -> {
                return Instructions.brk();
            }
            case Instructions.NOP_ZERO_PAGE -> {
                return Instructions.nop_zero_page();
            }
            case Instructions.PHP_IMPLIED -> {
                return Instructions.php();
            }
            case Instructions.NOP_ABSOLUTE -> {
                return Instructions.nop_absolute();
            }
            case Instructions.BPL_RELATIVE -> {
                return Instructions.bpl();
            }
            case Instructions.NOP_ZERO_PAGE_X -> {
                return Instructions.nop_zero_page_x();
            }
            case Instructions.CLC_IMPLIED -> {
                return Instructions.clc();
            }
            case Instructions.NOP_ABSOLUTE_X -> {
                return Instructions.nop_absolute_x();
            }
            case Instructions.JSR_ABSOLUTE -> {
                return Instructions.jsr();
            }
            case Instructions.BIT_ZERO_PAGE -> {
                return Instructions.bit();
            }
            case Instructions.PLP_IMPLIED -> {
                return Instructions.plp();
            }
            case Instructions.BIT_ABSOLUTE -> {
                return Instructions.bit_absolute();
            }
            case Instructions.BMI_RELATIVE -> {
                return Instructions.bmi();
            }
            case Instructions.SEC_IMPLIED -> {
                return Instructions.sec();
            }
            case Instructions.RTI_IMPLIED -> {
                return Instructions.rti();
            }
            case Instructions.PHA_IMPLIED -> {
                return Instructions.pha();
            }
            case Instructions.JMP_ABSOLUTE -> {
                return Instructions.jmp();
            }
            case Instructions.BVC_RELATIVE -> {
                return Instructions.bvc();
            }
            case Instructions.CLI_IMPLIED -> {
                return Instructions.cli();
            }
            case Instructions.RTS_IMPLIED -> {
                return Instructions.rts();
            }
            case Instructions.PLA_IMPLIED -> {
                return Instructions.pla();
            }
            case Instructions.JMP_IND -> {
                return Instructions.jmp_indirect();
            }
            case Instructions.BVS_RELATIVE -> {
                return Instructions.bvs();
            }
            case Instructions.SEI_IMPLIED -> {
                return Instructions.sei();
            }
            case Instructions.NOP -> {
                return Instructions.nop();
            }
            case Instructions.STY_ZERO_PAGE -> {
                return Instructions.sty_zero_page();
            }
            case Instructions.DEY_IMPLIED -> {
                return Instructions.dey();
            }
            case Instructions.STY_ABSOLUTE -> {
                return Instructions.sty_absolute();
            }
            case Instructions.BCC_RELATIVE -> {
                return Instructions.bcc();
            }
            case Instructions.STY_ZERO_PAGE_X -> {
                return Instructions.sty_zero_page_x();
            }
            case Instructions.TYA_IMPLIED -> {
                return Instructions.tya();
            }
            case Instructions.SHY_ABSOLUTE_X -> {
                return Instructions.shy_absolute_x();
            }
            case Instructions.LDY -> {
                return Instructions.ldy();
            }
            case Instructions.LDY_ZERO_PAGE -> {
                return Instructions.ldy_zero_page();
            }
            case Instructions.TAY_IMPLIED -> {
                return Instructions.tay();
            }
            case Instructions.LDY_ABSOLUTE -> {
                return Instructions.ldy_absolute();
            }
            case Instructions.BCS_RELATIVE -> {
                return Instructions.bcs();
            }
            case Instructions.LDY_ZERO_PAGE_X -> {
                return Instructions.ldy_zero_page_x();
            }
            case Instructions.CLV_IMPLIED -> {
                return Instructions.clv();
            }
            case Instructions.LDY_ABSOLUTE_X -> {
                return Instructions.ldy_absolute_x();
            }
            case Instructions.CPY -> {
                return Instructions.cpy();
            }
            case Instructions.CPY_ZERO_PAGE -> {
                return Instructions.cpy_zero_page();
            }
            case Instructions.INY_IMPLIED -> {
                return Instructions.iny();
            }
            case Instructions.CPY_ABSOLUTE -> {
                return Instructions.cpy_absolute();
            }
            case Instructions.BNE_RELATIVE -> {
                return Instructions.bne();
            }
            case Instructions.CLD_IMPLIED -> {
                return Instructions.cld();
            }
            case Instructions.CPX -> {
                return Instructions.cpx();
            }
            case Instructions.CPX_ZERO_PAGE -> {
                return Instructions.cpx_zero_page();
            }
            case Instructions.INX_IMPLIED -> {
                return Instructions.inx();
            }
            case Instructions.CPX_ABSOLUTE -> {
                return Instructions.cpx_absolute();
            }
            case Instructions.BEQ_RELATIVE -> {
                return Instructions.beq();
            }
            case Instructions.SED_IMPLIED -> {
                return Instructions.sed();
            }
            case Instructions.ORA_X_IND -> {
                return Instructions.ora_x_ind();
            }
            case Instructions.ORA_ZERO_PAGE -> {
                return Instructions.ora_zero_page();
            }
            case Instructions.ORA -> {
                return Instructions.ora();
            }
            case Instructions.ORA_ABSOLUTE -> {
                return Instructions.ora_absolute();
            }
            case Instructions.ORA_IND_Y -> {
                return Instructions.ora_ind_y();
            }
            case Instructions.ORA_ZERO_PAGE_X -> {
                return Instructions.ora_zero_page_x();
            }
            case Instructions.ORA_ABSOLUTE_Y -> {
                return Instructions.ora_absolute_y();
            }
            case Instructions.ORA_ABSOLUTE_X -> {
                return Instructions.ora_absolute_x();
            }
            case Instructions.AND_X_IND -> {
                return Instructions.and_x_ind();
            }
            case Instructions.AND_ZERO_PAGE -> {
                return Instructions.and_zero_page();
            }
            case Instructions.AND -> {
                return Instructions.and();
            }
            case Instructions.AND_ABSOLUTE -> {
                return Instructions.and_absolute();
            }
            case Instructions.AND_IND_Y -> {
                return Instructions.and_ind_y();
            }
            case Instructions.AND_ZERO_PAGE_X -> {
                return Instructions.and_zero_page_x();
            }
            case Instructions.AND_ABSOLUTE_Y -> {
                return Instructions.and_absolute_y();
            }
            case Instructions.AND_ABSOLUTE_X -> {
                return Instructions.and_absolute_x();
            }
            case Instructions.EOR_X_IND -> {
                return Instructions.eor_x_ind();
            }
            case Instructions.EOR_ZERO_PAGE -> {
                return Instructions.eor_zero_page();
            }
            case Instructions.EOR -> {
                return Instructions.eor();
            }
            case Instructions.EOR_ABSOLUTE -> {
                return Instructions.eor_absolute();
            }
            case Instructions.EOR_IND_Y -> {
                return Instructions.eor_ind_y();
            }
            case Instructions.EOR_ZERO_PAGE_X -> {
                return Instructions.eor_zero_page_x();
            }
            case Instructions.EOR_ABSOLUTE_Y -> {
                return Instructions.eor_absolute_y();
            }
            case Instructions.EOR_ABSOLUTE_X -> {
                return Instructions.eor_absolute_x();
            }
            case Instructions.ADC_X_IND -> {
                return Instructions.adc_x_ind();
            }
            case Instructions.ADC_ZERO_PAGE -> {
                return Instructions.adc_zero_page();
            }
            case Instructions.ADC -> {
                return Instructions.adc();
            }
            case Instructions.ADC_ABSOLUTE -> {
                return Instructions.adc_absolute();
            }
            case Instructions.ADC_IND_Y -> {
                return Instructions.adc_ind_y();
            }
            case Instructions.ADC_ZERO_PAGE_X -> {
                return Instructions.adc_zero_page_x();
            }
            case Instructions.ADC_ABSOLUTE_Y -> {
                return Instructions.adc_absolute_y();
            }
            case Instructions.ADC_ABSOLUTE_X -> {
                return Instructions.adc_absolute_x();
            }
            case Instructions.STA_X_IND -> {
                return Instructions.sta_x_ind();
            }
            case Instructions.STA_ZERO_PAGE -> {
                return Instructions.sta_zero_page();
            }
            case Instructions.STA_ABSOLUTE -> {
                return Instructions.sta_absolute();
            }
            case Instructions.STA_IND_Y -> {
                return Instructions.sta_ind_y();
            }
            case Instructions.STA_ZERO_PAGE_X -> {
                return Instructions.sta_zero_page_x();
            }
            case Instructions.STA_ABSOLUTE_Y -> {
                return Instructions.sta_absolute_y();
            }
            case Instructions.STA_ABSOLUTE_X -> {
                return Instructions.sta_absolute_x();
            }
            case Instructions.LDA_X_IND -> {
                return Instructions.lda_x_ind();
            }
            case Instructions.LDA_ZERO_PAGE -> {
                return Instructions.lda_zero_page();
            }
            case Instructions.LDA -> {
                return Instructions.lda();
            }
            case Instructions.LDA_ABSOLUTE -> {
                return Instructions.lda_absolute();
            }
            case Instructions.LDA_IND_Y -> {
                return Instructions.lda_ind_y();
            }
            case Instructions.LDA_ZERO_PAGE_X -> {
                return Instructions.lda_zero_page_x();
            }
            case Instructions.LDA_ABSOLUTE_Y -> {
                return Instructions.lda_absolute_y();
            }
            case Instructions.LDA_ABSOLUTE_X -> {
                return Instructions.lda_absolute_x();
            }
            case Instructions.CMP_X_IND -> {
                return Instructions.cmp_x_ind();
            }
            case Instructions.CMP_ZERO_PAGE -> {
                return Instructions.cmp_zero_page();
            }
            case Instructions.CMP -> {
                return Instructions.cmp();
            }
            case Instructions.CMP_ABSOLUTE -> {
                return Instructions.cmp_absolute();
            }
            case Instructions.CMP_IND_Y -> {
                return Instructions.cmp_ind_y();
            }
            case Instructions.CMP_ZERO_PAGE_X -> {
                return Instructions.cmp_zero_page_x();
            }
            case Instructions.CMP_ABSOLUTE_Y -> {
                return Instructions.cmp_absolute_y();
            }
            case Instructions.CMP_ABSOLUTE_X -> {
                return Instructions.cmp_absolute_x();
            }
            case Instructions.SBC_X_IND -> {
                return Instructions.sbc_x_ind();
            }
            case Instructions.SBC_ZERO_PAGE -> {
                return Instructions.sbc_zero_page();
            }
            case Instructions.SBC -> {
                return Instructions.sbc();
            }
            case Instructions.SBC_ABSOLUTE -> {
                return Instructions.sbc_absolute();
            }
            case Instructions.SBC_IND_Y -> {
                return Instructions.sbc_ind_y();
            }
            case Instructions.SBC_ZERO_PAGE_X -> {
                return Instructions.sbc_zero_page_x();
            }
            case Instructions.SBC_ABSOLUTE_Y -> {
                return Instructions.sbc_absolute_y();
            }
            case Instructions.SBC_ABSOLUTE_X -> {
                return Instructions.sbc_absolute_x();
            }
            case Instructions.JAM -> {
                return Instructions.jam();
            }
            case Instructions.ASL_ZERO_PAGE -> {
                return Instructions.asl_zero_page();
            }
            case Instructions.ASL -> {
                return Instructions.asl();
            }
            case Instructions.ASL_ABSOLUTE -> {
                return Instructions.asl_absolute();
            }
            case Instructions.ASL_ZERO_PAGE_X -> {
                return Instructions.asl_zero_page_x();
            }
            case Instructions.NOP_IMPLIED -> {
                return Instructions.nop();
            }
            case Instructions.ASL_ABSOLUTE_X -> {
                return Instructions.asl_absolute_x();
            }
            case Instructions.ROL_ZERO_PAGE -> {
                return Instructions.rol_zero_page();
            }
            case Instructions.ROL -> {
                return Instructions.rol();
            }
            case Instructions.ROL_ABSOLUTE -> {
                return Instructions.rol_absolute();
            }
            case Instructions.ROL_ZERO_PAGE_X -> {
                return Instructions.rol_zero_page_x();
            }
            case Instructions.ROL_ABSOLUTE_X -> {
                return Instructions.rol_absolute_x();
            }
            case Instructions.LSR_ZERO_PAGE -> {
                return Instructions.lsr_zero_page();
            }
            case Instructions.LSR -> {
                return Instructions.lsr();
            }
            case Instructions.LSR_ABSOLUTE -> {
                return Instructions.lsr_absolute();
            }
            case Instructions.LSR_ZERO_PAGE_X -> {
                return Instructions.lsr_zero_page_x();
            }
            case Instructions.LSR_ABSOLUTE_X -> {
                return Instructions.lsr_absolute_x();
            }
            case Instructions.ROR_ZERO_PAGE -> {
                return Instructions.ror_zero_page();
            }
            case Instructions.ROR -> {
                return Instructions.ror();
            }
            case Instructions.ROR_ABSOLUTE -> {
                return Instructions.ror_absolute();
            }
            case Instructions.ROR_ZERO_PAGE_X -> {
                return Instructions.ror_zero_page_x();
            }
            case Instructions.ROR_ABSOLUTE_X -> {
                return Instructions.ror_absolute_x();
            }
            case Instructions.STX_ZERO_PAGE -> {
                return Instructions.stx_zero_page();
            }
            case Instructions.TXA_IMPLIED -> {
                return Instructions.txa();
            }
            case Instructions.STX_ABSOLUTE -> {
                return Instructions.stx_absolute();
            }
            case Instructions.STX_ZERO_PAGE_Y -> {
                return Instructions.stx_zero_page_y();
            }
            case Instructions.TXS_IMPLIED -> {
                return Instructions.txs();
            }
            case Instructions.SHX_ABSOLUTE_Y -> {
                return Instructions.shx_absolute_y();
            }
            case Instructions.LDX -> {
                return Instructions.ldx();
            }
            case Instructions.LDX_ZERO_PAGE -> {
                return Instructions.ldx_zero_page();
            }
            case Instructions.TAX_IMPLIED -> {
                return Instructions.tax();
            }
            case Instructions.LDX_ABSOLUTE -> {
                return Instructions.ldx_absolute();
            }
            case Instructions.LDX_ZERO_PAGE_Y -> {
                return Instructions.ldx_zero_page_y();
            }
            case Instructions.TSX_IMPLIED -> {
                return Instructions.tsx();
            }
            case Instructions.LDX_ABSOLUTE_Y -> {
                return Instructions.ldx_absolute_y();
            }
            case Instructions.DEC_ZERO_PAGE -> {
                return Instructions.dec_zero_page();
            }
            case Instructions.DEX_IMPLIED -> {
                return Instructions.dex();
            }
            case Instructions.DEC_ABSOLUTE -> {
                return Instructions.dec_absolute();
            }
            case Instructions.DEC_ZERO_PAGE_X -> {
                return Instructions.dec_zero_page_x();
            }
            case Instructions.DEC_ABSOLUTE_X -> {
                return Instructions.dec_absolute_x();
            }
            case Instructions.INC_ZERO_PAGE -> {
                return Instructions.inc_zero_page();
            }
            case Instructions.INC_ABSOLUTE -> {
                return Instructions.inc_absolute();
            }
            case Instructions.INC_ZERO_PAGE_X -> {
                return Instructions.inc_zero_page_x();
            }
            case Instructions.INC_ABSOLUTE_X -> {
                return Instructions.inc_absolute_x();
            }
            case Instructions.SLO_X_IND -> {
                return Instructions.slo_x_ind();
            }
            case Instructions.SLO_ZERO_PAGE -> {
                return Instructions.slo_zero_page();
            }
            case Instructions.ANC -> {
                return Instructions.anc();
            }
            case Instructions.SLO_ABSOLUTE -> {
                return Instructions.slo_absolute();
            }
            case Instructions.SLO_IND_Y -> {
                return Instructions.slo_ind_y();
            }
            case Instructions.SLO_ZERO_PAGE_X -> {
                return Instructions.slo_zero_page_x();
            }
            case Instructions.SLO_ABSOLUTE_Y -> {
                return Instructions.slo_absolute_y();
            }
            case Instructions.SLO_ABSOLUTE_X -> {
                return Instructions.slo_absolute_x();
            }
            case Instructions.RLA_X_IND -> {
                return Instructions.rla_x_ind();
            }
            case Instructions.RLA_ZERO_PAGE -> {
                return Instructions.rla_zero_page();
            }
            case Instructions.RLA_ABSOLUTE -> {
                return Instructions.rla_absolute();
            }
            case Instructions.RLA_IND_Y -> {
                return Instructions.rla_ind_y();
            }
            case Instructions.RLA_ZERO_PAGE_X -> {
                return Instructions.rla_zero_page_x();
            }
            case Instructions.RLA_ABSOLUTE_Y -> {
                return Instructions.rla_absolute_y();
            }
            case Instructions.RLA_ABSOLUTE_X -> {
                return Instructions.rla_absolute_x();
            }
            case Instructions.SRE_X_IND -> {
                return Instructions.sre_x_ind();
            }
            case Instructions.SRE_ZERO_PAGE -> {
                return Instructions.sre_zero_page();
            }
            case Instructions.ALR -> {
                return Instructions.alr();
            }
            case Instructions.SRE_ABSOLUTE -> {
                return Instructions.sre_absolute();
            }
            case Instructions.SRE_IND_Y -> {
                return Instructions.sre_ind_y();
            }
            case Instructions.SRE_ZERO_PAGE_X -> {
                return Instructions.sre_zero_page_x();
            }
            case Instructions.SRE_ABSOLUTE_Y -> {
                return Instructions.sre_absolute_y();
            }
            case Instructions.SRE_ABSOLUTE_X -> {
                return Instructions.sre_absolute_x();
            }
            case Instructions.RRA_X_IND -> {
                return Instructions.rra_x_ind();
            }
            case Instructions.RRA_ZERO_PAGE -> {
                return Instructions.rra_zero_page();
            }
            case Instructions.ARR -> {
                return Instructions.arr();
            }
            case Instructions.RRA_ABSOLUTE -> {
                return Instructions.rra_absolute();
            }
            case Instructions.RRA_IND_Y -> {
                return Instructions.rra_ind_y();
            }
            case Instructions.RRA_ZERO_PAGE_X -> {
                return Instructions.rra_zero_page_x();
            }
            case Instructions.RRA_ABSOLUTE_Y -> {
                return Instructions.rra_absolute_y();
            }
            case Instructions.RRA_ABSOLUTE_X -> {
                return Instructions.rra_absolute_x();
            }
            case Instructions.SAX_X_IND -> {
                return Instructions.sax_x_ind();
            }
            case Instructions.SAX_ZERO_PAGE -> {
                return Instructions.sax_zero_page();
            }
            case Instructions.ANE -> {
                return Instructions.xaa_immediate();
            }
            case Instructions.SAX_ABSOLUTE -> {
                return Instructions.sax_absolute();
            }
            case Instructions.SHA_IND_Y -> {
                return Instructions.sha_ind_y();
            }
            case Instructions.SAX_ZERO_PAGE_Y -> {
                return Instructions.sax_zero_page_y();
            }
            case Instructions.TAS_ABSOLUTE_Y -> {
                return Instructions.tas_absolute_y();
            }
            case Instructions.SHA_ABSOLUTE_Y -> {
                return Instructions.sha_absolute_y();
            }
            case Instructions.LAX_X_IND -> {
                return Instructions.lax_x_ind();
            }
            case Instructions.LAX_ZERO_PAGE -> {
                return Instructions.lax_zero_page();
            }
            case Instructions.LXA -> {
                return Instructions.lxa();
            }
            case Instructions.LAX_ABSOLUTE -> {
                return Instructions.lax_absolute();
            }
            case Instructions.LAX_IND_Y -> {
                return Instructions.lax_ind_y();
            }
            case Instructions.LAX_ZERO_PAGE_Y -> {
                return Instructions.lax_zero_page_y();
            }
            case Instructions.LAS_ABSOLUTE_Y -> {
                return Instructions.las_absolute_y();
            }
            case Instructions.LAX_ABSOLUTE_Y -> {
                return Instructions.lax_absolute_y();
            }
            case Instructions.DCP_X_IND -> {
                return Instructions.dcp_x_ind();
            }
            case Instructions.DCP_ZERO_PAGE -> {
                return Instructions.dcp_zero_page();
            }
            case Instructions.SBX -> {
                return Instructions.sbx();
            }
            case Instructions.DCP_ABSOLUTE -> {
                return Instructions.dcp_absolute();
            }
            case Instructions.DCP_IND_Y -> {
                return Instructions.dcp_ind_y();
            }
            case Instructions.DCP_ZERO_PAGE_X -> {
                return Instructions.dcp_zero_page_x();
            }
            case Instructions.DCP_ABSOLUTE_Y -> {
                return Instructions.dcp_absolute_y();
            }
            case Instructions.DCP_ABSOLUTE_X -> {
                return Instructions.dcp_absolute_x();
            }
            case Instructions.ISC_X_IND -> {
                return Instructions.isc_x_ind();
            }
            case Instructions.ISC_ZERO_PAGE -> {
                return Instructions.isc_zero_page();
            }
            case Instructions.USBC -> {
                return Instructions.usbc();
            }
            case Instructions.ISC_ABSOLUTE -> {
                return Instructions.isc_absolute();
            }
            case Instructions.ISC_IND_Y -> {
                return Instructions.isc_ind_y();
            }
            case Instructions.ISC_ZERO_PAGE_X -> {
                return Instructions.isc_zero_page_x();
            }
            case Instructions.ISC_ABSOLUTE_Y -> {
                return Instructions.isc_absolute_y();
            }
            case Instructions.ISC_ABSOLUTE_X -> {
                return Instructions.isc_absolute_x();
            }
            case (byte) 0x34 -> {
                return Instructions.nop_zero_page_x();
            }
            case (byte) 0x54 -> {
                return Instructions.nop_zero_page_x();
            }
            case (byte) 0x74 -> {
                return Instructions.nop_zero_page_x();
            }
            case (byte) 0xD4 -> {
                return Instructions.nop_zero_page_x();
            }
            case (byte) 0xF4 -> {
                return Instructions.nop_zero_page_x();
            }
            case (byte) 0x3C -> {
                return Instructions.nop_absolute_x();
            }
            case (byte) 0x5C -> {
                return Instructions.nop_absolute_x();
            }
            case (byte) 0x7C -> {
                return Instructions.nop_absolute_x();
            }
            case (byte) 0xDC -> {
                return Instructions.nop_absolute_x();
            }
            case (byte) 0xFC -> {
                return Instructions.nop_absolute_x();
            }
            case (byte) 0x44 -> {
                return Instructions.nop_zero_page();
            }
            case (byte) 0x64 -> {
                return Instructions.nop_zero_page();
            }
            case (byte) 0x89 -> {
                return Instructions.nop();
            }
            case (byte) 0x82 -> {
                return Instructions.nop();
            }
            case (byte) 0xC2 -> {
                return Instructions.nop();
            }
            case (byte) 0xE2 -> {
                return Instructions.nop();
            }
            case (byte) 0x12 -> {
                return Instructions.jam();
            }
            case (byte) 0x22 -> {
                return Instructions.jam();
            }
            case (byte) 0x32 -> {
                return Instructions.jam();
            }
            case (byte) 0x42 -> {
                return Instructions.jam();
            }
            case (byte) 0x52 -> {
                return Instructions.jam();
            }
            case (byte) 0x62 -> {
                return Instructions.jam();
            }
            case (byte) 0x72 -> {
                return Instructions.jam();
            }
            case (byte) 0x92 -> {
                return Instructions.jam();
            }
            case (byte) 0xB2 -> {
                return Instructions.jam();
            }
            case (byte) 0xD2 -> {
                return Instructions.jam();
            }
            case (byte) 0xF2 -> {
                return Instructions.jam();
            }
            case (byte) 0x3A -> {
                return Instructions.nop();
            }
            case (byte) 0x5A -> {
                return Instructions.nop();
            }
            case (byte) 0x7A -> {
                return Instructions.nop();
            }
            case (byte) 0xDA -> {
                return Instructions.nop();
            }
            case (byte) 0xEA -> {
                return Instructions.nop();
            }
            case (byte) 0xFA -> {
                return Instructions.nop();
            }
            case (byte) 0x2B -> {
                return Instructions.anc();
            }

            default -> // Handle unknown opcode
                throw new IllegalArgumentException("Unknown opcode: " + opcode);
        }

    }

    public static byte fetchNextValue() {
        return Ram.read(Registers.pc);
    }

    public void readResetVector() {
        byte[] resetVector = {
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
