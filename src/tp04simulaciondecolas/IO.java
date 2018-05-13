package tp04simulaciondecolas;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IO {
    private Scanner scIn;
    private FileWriter fileWriter;

    /**
     * @param input file
     * @param output file
     *
     * fileIn template
     *
     * NUMBER_OF_CASHIERS
     * SIMULATION_TIME
     * CHANCE_OF_CLIENT_TO_ARRIVE
     * MIN_TIME_TO_ATTEND_CLIENT MAX_TIME_TO_ATTEND_CLIENT
     *
     * fileOut template
     *
     * Cantidad de usuarios que arribaron: NUMBER_OF_TOTAL_CLIENTS_ARRIVED
     * Cantidad de usuarios atendidos: NUMBER_OF_TOTAL_ATTENDED_CLIENTS
     * AVERAGE_WAIT_TIME
     * AVERAGE_WAIT_QUEUE_LENGTH
     * MAX_QUEUE_LENGTH
     * CASHIER_TOTAL_LEISURE_TIME
     */
    public IO(String input, String output){
        try {
            // file reader
            Path path = Paths.get(input);
            System.out.println(path.toAbsolutePath());
            BufferedReader bw = Files.newBufferedReader(path.toAbsolutePath());
            this.scIn = new Scanner(bw);  // Scanner class for nextInt() usage
            // file writer
            this.fileWriter = new FileWriter(output);
        } catch (IOException e) {
            System.out.println("wrong input/output file");
            System.exit(-1);
        }

    }

    public List<String> read() throws IOException {
        List<String> inputData = new ArrayList<>();
        inputData.add(this.scIn.nextInt() + "");  // NUMBER_OF_CASHIERS
        inputData.add(this.scIn.nextInt() + "");  // SIMULATION_TIME
        inputData.add(this.scIn.nextInt() + "");  // CHANCE_OF_CLIENT_TO_ARRIVE
        inputData.add(this.scIn.nextInt() + "");  // MIN_TIME_TO_ATTEND_CLIENT
        inputData.add(this.scIn.nextInt() + "");  // MAX_TIME_TO_ATTEND_CLIENT
        return inputData;
    }

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
}
