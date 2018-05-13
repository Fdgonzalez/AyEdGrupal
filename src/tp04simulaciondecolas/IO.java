package tp04simulaciondecolas;


import tp04simulaciondecolas.exceptions.InvalidFileInData;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * fileIn template
 *
 * NUMBER_OF_CASHIERS
 * SIMULATION_TIME
 * CHANCE_OF_CLIENT_TO_ARRIVE
 * MIN_TIME_TO_ATTEND_CLIENT MAX_TIME_TO_ATTEND_CLIENT
 *
 *
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
    private List<Object> inputData;

    /**
     * Constructor
     * @param input file
     * @param output file
     * fileOut template
     */
    public IO(String input, String output){
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

    private char[] nextData() throws IOException {
        char[] input = {};
        while (true) {
            Character current = (char) bufferedReader.read();
            if (current.equals('\n')) break;
            char[] temp = new char[input.length + 1];
            temp[temp.length - 1] = current;
            input = temp;
        }
        return input;
    }

    /**
     * @return
     * @throws IOException
     */
    public void read() throws IOException, InvalidFileInData {
        inputData = new List<>();

        // NUMBER_OF_CASHIERS
        int numberOfCashiers = Integer.parseInt(Arrays.toString(nextData()));
        if (numberOfCashiers < 0) throw new InvalidFileInData("Number of cashiers cant be negative!");
        else if (numberOfCashiers == 0) throw new InvalidFileInData("Number of cashiers is 0!");
        else inputData.add(numberOfCashiers);

        // SIMULATION_TIME
        int simulationTime = Integer.parseInt(Arrays.toString(nextData()));
        if (simulationTime < 0) throw new InvalidFileInData("Simulation time cant be negative!");
        else if (simulationTime == 0) throw new InvalidFileInData("Simulation time is 0!");
        else inputData.add(simulationTime);

        // CHANCE_OF_CLIENT_TO_ARRIVE
        double chanceToArrive = Double.parseDouble(Arrays.toString(nextData()));
        if (chanceToArrive < 0) throw new InvalidFileInData("Chance to arrive cant be negative!");
        else if (chanceToArrive == 0 || chanceToArrive > 1)
            throw new InvalidFileInData("Must be more than 0 and less than 1");
        else inputData.add(chanceToArrive);

        // MIN_TIME_TO_ATTEND_CLIENT
        int minTimeToAttend = Integer.parseInt(Arrays.toString(nextData()));
        if (minTimeToAttend < 0) throw new InvalidFileInData("Minimum time to attend cant be negative!");
        else if (minTimeToAttend == 0) System.out.println("Thats so fast I cant even see it!");
        else inputData.add(minTimeToAttend);

        // MAX_TIME_TO_ATTEND_CLIENT
        int maxTimeToAttend = Integer.parseInt(Arrays.toString(nextData()));
        if (maxTimeToAttend < 0) throw new InvalidFileInData("Maximum time to attend cant be negative!");
        else if (maxTimeToAttend == 0) System.out.println("Cashiers truly are god!");
        else inputData.add(maxTimeToAttend);
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

    public String toString() {
        return inputData.toString();
    }
}
