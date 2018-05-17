package tp04simulaciondecolas;


import tp04simulaciondecolas.exceptions.InvalidDataInFile;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * fileIn template
 * <p>
 * NUMBER_OF_CASHIERS
 * SIMULATION_TIME
 * CHANCE_OF_CLIENT_TO_ARRIVE
 * MIN_TIME_TO_ATTEND_CLIENT MAX_TIME_TO_ATTEND_CLIENT
 * <p>
 * <p>
 * Cantidad de usuarios que arribaron: NUMBER_OF_TOTAL_CLIENTS_ARRIVED
 * Cantidad de usuarios atendidos: NUMBER_OF_TOTAL_ATTENDED_CLIENTS
 * AVERAGE_WAIT_TIME
 * AVERAGE_WAIT_QUEUE_LENGTH
 * MAX_QUEUE_LENGTH
 * CASHIER_TOTAL_LEISURE_TIME
 */
public class IO {

    private BufferedReader bufferedReader;
    private FileWriter fileWriter;
    private int simulationTime;

    /**
     * Constructor
     *
     * @param input  file
     * @param output file
     *               fileOut template
     */
    IO(String input, String output) {
        try {
            // file reader
            Path path = Paths.get(input);
            System.out.println("complete path of fileIn: " + path.toAbsolutePath());
            this.bufferedReader = Files.newBufferedReader(path.toAbsolutePath());
            // file writer
            this.fileWriter = new FileWriter(output);
            System.out.println("complete path of fileOut: " + Paths.get(output).toAbsolutePath());
        } catch (IOException e) {
            System.out.println("wrong input/output file");
            System.exit(-1);
        }

    }

    /**
     * @return
     * @throws IOException
     */
    Supermarket read() throws IOException, InvalidDataInFile {

        // NUMBER_OF_CASHIERS
        int numberOfCashiers = Integer.parseInt(bufferedReader.readLine());
        if (numberOfCashiers < 0) throw new InvalidDataInFile("Number of cashiers cant be negative!");
        else if (numberOfCashiers == 0) throw new InvalidDataInFile("Number of cashiers is 0!");

        // SIMULATION_TIME
        simulationTime = Integer.parseInt(bufferedReader.readLine());
        if (simulationTime < 0) throw new InvalidDataInFile("Simulation time cant be negative!");
        else if (simulationTime == 0) throw new InvalidDataInFile("Simulation time is 0!");

        // CHANCE_OF_CLIENT_TO_ARRIVE
        double chanceToArrive = Double.parseDouble(bufferedReader.readLine());
        if (chanceToArrive < 0) throw new InvalidDataInFile("Chance to arrive cant be negative!");
        else if (chanceToArrive == 0 || chanceToArrive > 1)
            throw new InvalidDataInFile("Must be more than 0 and less than 1");

        // MIN_TIME_TO_ATTEND_CLIENT
        String[] minMax = bufferedReader.readLine().split(" ");
        int minTimeToAttend = Integer.parseInt(minMax[0]);
        if (minTimeToAttend < 0) throw new InvalidDataInFile("Minimum time to attend cant be negative!");

        // MAX_TIME_TO_ATTEND_CLIENT
        int maxTimeToAttend = Integer.parseInt(minMax[1]);
        if (maxTimeToAttend < 0) throw new InvalidDataInFile("Maximum time to attend cant be negative!");
        if (maxTimeToAttend < minTimeToAttend) {
            throw new InvalidDataInFile("Minimum cashier time is greater than the max");
        }
        bufferedReader.close();

        return new Supermarket(numberOfCashiers, chanceToArrive, minTimeToAttend, maxTimeToAttend);
    }

    public void write(String s) throws IOException {
        fileWriter.write(s);
        fileWriter.close();
    }

    int getSimulationLength() {
        return simulationTime;
    }
}
