package tp04simulaciondecolas;


import tp04simulaciondecolas.GUI.GUI;
import tp04simulaciondecolas.exceptions.InvalidDataInFile;

import java.io.IOException;


/**
 * TP04 Simulacion de Colas.
 * Por Facundo Gonzalez, Juan Manuel Lopez Gabeiras y Juan Gabriel Ricci
 *
 * Clase main
 */
public class Main {

    /**
     * Display command line usage help
     */
    private static void usage() {
        System.out.println("Usage: java -jar filename.jar fileIn fileOut [-n ms]");
        System.exit(0);
    }

    public static void main(String[] args) {
        if (args.length < 2 || args.length > 4) usage();
        String fileIn = args[0];
        String fileOut = args[1];
        IO io = new IO(fileIn, fileOut);
        Supermarket supermarket = null;
        try {
            supermarket = io.read();
        } catch (IOException | InvalidDataInFile e) {
            System.out.println("Invalid input file");
            System.exit(1);
        }
        int simulationLength = io.getSimulationLength();
        if (args.length > 2) {
            int iterationsPerCycle = 0;
            int ms = 0;
            try {
                iterationsPerCycle = Integer.parseInt(args[2].substring(1)); // cut the - from the argument
                ms = Integer.parseInt(args[3]);
            } catch (NumberFormatException e) {
                System.out.println("-n or ms argument not an integer number");
                System.exit( 0);
            }
            if (args[2].charAt(0) != '-')
                usage();

            GUI.showSimulation(supermarket,simulationLength,iterationsPerCycle,ms,io);
            System.exit(0);
        }

        int currentTime = 0; // current time unit
        while (currentTime < simulationLength) {
            supermarket.update(currentTime++);
        }
        supermarket.finish();
        try {
            io.write(supermarket.toString());
        } catch (IOException e) {
            System.out.println("error writing output file");
        }
    }
}

