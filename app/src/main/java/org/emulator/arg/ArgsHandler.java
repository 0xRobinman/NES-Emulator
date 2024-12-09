package org.emulator.arg;

/**
 * 
 *
 */
public class ArgsHandler {

    private boolean verbose = false;
    
    public static boolean debug = true;

    public ArgsHandler(String [] args) {
        for (String arg : args) {
            switch (arg) {
                case "-v" -> verbose = true;
                default -> printHelp();
            }
        }
    }
    

    private void printHelp() {

        System.out.println(" | \\ | |           |  ____|               | |     | |            ");
        System.out.println(" |  \\| | ___  ___  | |__   _ __ ___  _   _| | __ _| |_ ___  _ __ ");
        System.out.println(" | . ` |/ _ \\/ __| |  __| | '_ ` _ \\| | | | |/ _` | __/ _ \\| '__|");
        System.out.println(" | |\\  |  __/\\__ \\ | |____| | | | | | |_| | | (_| | || (_) | |   ");
        System.out.println(" |_| \\_|\\___||___/ |______|_| |_| |_|\\__,_|_|\\__,_|\\__\\___/|_|   ");
        
        System.out.println("#################################################################");

        System.out.println("Usage\n\tjava Emulator <args>\n");
        System.out.println("Options\n\t-v\tVerbose");
        System.out.println("\t-h\tHelp");
        System.out.println("\t-v\tVerbose");
        System.out.println("\t-v\tVerbose");
        System.out.println("\t-v\tVerbose");

        System.exit(0);
    }

    public boolean getVerbose() {
        return verbose;
    }

}   
