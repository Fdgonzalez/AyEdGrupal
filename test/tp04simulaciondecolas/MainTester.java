package tp04simulaciondecolas;


import org.junit.Test;
import tp04simulaciondecolas.Utils.List;
import tp04simulaciondecolas.exceptions.InvalidDataInFile;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * TP04 Simulacion de colas por Facundo Gonzalez, Juan Manuel Lopez Gabeiras y Juan Gabriel Ricci
 *
 * Clase Tester,
 */
public class MainTester {
    private final int filesToTest = 5;

    public static void main(String[] args) throws IOException, InvalidDataInFile {
        System.out.println("Program Tester. insert -n and ms for\nall 5 test.");
        Scanner sc = new Scanner(System.in);
        String n;
        String ms;

        // scan -n and ms
        while (true) {
            System.out.print("Insert -n: ");
            n = sc.next();
            System.out.print("Insert ms: ");
            ms = sc.next();
            sc.nextLine();

            if (Integer.parseInt(n) > 0 && Integer.parseInt(ms) > 0) break;
            System.out.println("Invalid -n or ms, try again");
        }

        /**
         * NUMBER_OF_CASHIERS
         * SIMULATION_TIME
         * CHANCE_OF_CLIENT_TO_ARRIVE
         * MIN_TIME_TO_ATTEND_CLIENT   MAX_TIME_TO_ATTEND_CLIENT
         */
        // test 1, normal input
        //3
        //200
        //0.5
        //10 30
        Main.main(new String[]{"testfilein1", "testfileout1", n, ms});
        // test 2, all 0, should throw InvalidDataFile
        //0
        //0
        //0
        //0 0
//        Main.main(new String[]{"testfilein2", "testfileout2", n, ms});
        // test 3, normal input
        //
//        Main.main(new String[]{"testfilein3", "testfileout3", n, ms});
        // test 4, normal input
        //
//        Main.main(new String[]{"testfilein4", "testfileout4", n, ms});
        // test 5, normal input
        //
//        Main.main(new String[]{"testfilein5", "testfileout5", n, ms});
    }
}