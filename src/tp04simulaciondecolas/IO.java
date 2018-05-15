package tp04simulaciondecolas;


import tp04simulaciondecolas.Utils.List;
import tp04simulaciondecolas.exceptions.InvalidFileInData;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * TP04 Simulacion de Colas.
 * Por Facundo Gonzalez, Juan Manuel Lopez Gabeiras y Juan Gabriel Ricci
 * <p>
 * -------------------------------------------------------------------
 * fileIn template
 * NUMBER_OF_CASHIERS
 * SIMULATION_TIME
 * CHANCE_OF_CLIENT_TO_ARRIVE
 * MIN_TIME_TO_ATTEND_CLIENT MAX_TIME_TO_ATTEND_CLIENT
 * <p>
 * fileOut template
 * Cantidad de usuarios que arribaron: NUMBER_OF_TOTAL_CLIENTS_ARRIVED
 * Cantidad de usuarios atendidos: NUMBER_OF_TOTAL_ATTENDED_CLIENTS
 * AVERAGE_WAIT_TIME
 * AVERAGE_WAIT_QUEUE_LENGTH
 * MAX_QUEUE_LENGTH
 * CASHIER_TOTAL_LEISURE_TIME
 * -------------------------------------------------------------------
 * <p>
 * Clase IO, interpreta archivo de entrada y escribe en archivo de salida.
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
    public IO(String input, String output) {
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
    private char[] nextData() throws IOException {
        char[] input = {};
        int current;
        while ((current = bufferedReader.read()) != -1) {
            if (current == '\n') break;
            input = Arrays.copyOf(input, input.length + 1);
            input[input.length - 1] = (char) current;
        }
        return input;
    }

    /**
     * @return
     * @throws IOException
     */
    public Supermarket read() throws IOException, InvalidFileInData {

        // NUMBER_OF_CASHIERS
        int numberOfCashiers = Integer.parseInt(new String(nextData()));
        if (numberOfCashiers < 0) throw new InvalidFileInData("Number of cashiers cant be negative!");
        else if (numberOfCashiers == 0) throw new InvalidFileInData("Number of cashiers is 0!");

        // SIMULATION_TIME
        int simulationTime = Integer.parseInt(new String(nextData()));
        if (simulationTime < 0) throw new InvalidFileInData("Simulation time cant be negative!");
        else if (simulationTime == 0) throw new InvalidFileInData("Simulation time is 0!");

        // CHANCE_OF_CLIENT_TO_ARRIVE
        double chanceToArrive = Double.parseDouble(new String(nextData()));
        if (chanceToArrive < 0) throw new InvalidFileInData("Chance to arrive cant be negative!");
        else if (chanceToArrive == 0 || chanceToArrive > 1)
            throw new InvalidFileInData("Must be more than 0 and less than 1");

        // MIN_TIME_TO_ATTEND_CLIENT
        String[] minMax = new String(nextData()).split(" ");
        int minTimeToAttend = Integer.parseInt(minMax[0]);
        if (minTimeToAttend < 0) throw new InvalidFileInData("Minimum time to attend cant be negative!");
        else if (minTimeToAttend == 0) System.out.println("Thats so fast I cant even see it!");

        // MAX_TIME_TO_ATTEND_CLIENT
        int maxTimeToAttend = Integer.parseInt(minMax[1]);
        if (maxTimeToAttend < 0) throw new InvalidFileInData("Maximum time to attend cant be negative!");
        else if (maxTimeToAttend == 0) System.out.println("Cashiers truly are god!");

        return new Supermarket(numberOfCashiers, chanceToArrive, minTimeToAttend, maxTimeToAttend);
    }

    /**
     * @param outputData
     * @throws IOException
     */
    public void write(List<String> outputData) throws IOException {
        if (outputData.size() != 6) return;
        this.fileWriter.write("Cantidad de usuarios que arribaron: ");
        this.fileWriter.write(outputData.get(0) + "\n");  // NUMBER_OF_TOTAL_CLIENTS_ARRIVED
        this.fileWriter.write("Cantidad de usuarios atendidos: ");
        this.fileWriter.write(outputData.get(1) + "\n");  // NUMBER_OF_TOTAL_ATTENDED_CLIENTS
        this.fileWriter.write(outputData.get(2) + "\n");  // AVERAGE_WAIT_TIME
        this.fileWriter.write(outputData.get(3) + "\n");  // AVERAGE_WAIT_QUEUE_LENGTH
        this.fileWriter.write(outputData.get(4) + "\n");  // MAX_QUEUE_LENGTH
        this.fileWriter.write(outputData.get(5) + "\n");  // CASHIER_TOTAL_LEISURE_TIME
    }

    /**
     * @param s
     * @throws IOException
     */
    public void write(String s) throws IOException {
        this.fileWriter.write(s);
    }

    public String toString() {
        try {
            return read().toString();
        } catch (IOException | InvalidFileInData e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * @return
     */
    public int getSimulationLength() {
        return simulationTime;
    }
}
