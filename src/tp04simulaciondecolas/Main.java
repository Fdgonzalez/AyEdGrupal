package tp04simulaciondecolas;


import tp04simulaciondecolas.GUI.Controller;
import tp04simulaciondecolas.exceptions.InvalidDataInFile;

import java.io.IOException;

/**
 * TP04 Simulacion de Colas.
 * Por Facundo Gonzalez, Juan Manuel Lopez Gabeiras y Juan Gabriel Ricci
 * <p>
 * Clase main
 */
public class Main {

    /**
     * Display command line usage help
     */
    public static void usage() {
        System.out.println("Usage: java -jar filename.jar fileIn fileOut [-n ms]");
        System.exit(0);
    }

    public static void main(String[] args) {
        // argument validator
        if (args.length < 2 || args.length > 4)
            usage();
        String fileIn = args[0];
        String fileOut = args[1];

        // reads file and saves to my Supermarket
        IO io = new IO(fileIn, fileOut);
        Supermarket supermarket = null;
        try {
            supermarket = io.read();
        } catch (IOException | InvalidDataInFile e) {
            System.out.println("Invalid input file");
            System.exit(1);
        }
        int simulationLength = io.getSimulationLength();

        // -n and ms argument given, so execute JavaFX
        if (args.length > 2) {
            // getting ints from arguments
            if (args[2].charAt(0) != '-')
                usage();
            int ms = 0;
            int iterations = 0;
            try {
                iterations = Integer.parseInt(args[2].substring(1)); // cut the - from the argument
                ms = Integer.parseInt(args[3]);
            } catch (NumberFormatException e) {
                System.out.println("-n or ms argument not an integer number");
                usage();
            }

            // GUI execution
            Controller controller = new Controller();
            controller.load(supermarket, simulationLength, iterations, ms);
            controller.start();
        }

        // no -n and ms argument given, so calculate everything "instantly"
        if (args.length == 2) {
            int currentTime = 0; // current time unit
            while (currentTime < simulationLength) {
                supermarket.update(currentTime++);
            }
        }
        supermarket.finish();
        try {
            io.write(supermarket.toString());
        } catch (IOException e) {
            System.out.println("error writing output file");
        }
    }
}

