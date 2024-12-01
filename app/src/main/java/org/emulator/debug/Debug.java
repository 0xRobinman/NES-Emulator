package org.emulator.debug;

import org.emulator.cpu.Registers;

public class Debug {

    private static final String ERROR = "[\u001B[31mERROR\u001B[0m]",
                                SUCCESS = "[\u001B[32mSUCCESS\u001B[0m]";
                                
    public static void printDebug(String information, boolean success) {
        String status = "\t" + ( (success) ? SUCCESS : ERROR ); 
        System.out.println(information + status);
    }

    public static void printASM(short opcode, String asmString) {

        System.out.println(String.format("0x%02X", Registers.pc) + "\t" + String.format("%02X", opcode & 0xFF) + "\t" + asmString + "\t" + asmString);

    }

    public static void printASM(short opcode, short param, String asmString, String addressingMode) {

        System.out.println(
            String.format("0x%04X  %02X %02X   %-10s %-10s",
                Registers.pc,
                opcode & 0xFF,
                param & 0xFF,
                asmString,
                asmString + " $" + String.format("%04X", param & 0xFF)
            )
        );        

    }

    public static void printASM(short opcode, short param1, short param2, String asmString) {

        System.out.println(String.format("0x%02X", Registers.pc) + "\t" + String.format("%02X %02X %02X", param2, param1, opcode & 0xFF) + "\t" + asmString);
    }


}
