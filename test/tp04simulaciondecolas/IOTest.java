package tp04simulaciondecolas;


import org.junit.Test;
import tp04simulaciondecolas.Utils.List;
import tp04simulaciondecolas.exceptions.InvalidDataInFile;

import java.io.IOException;

import static org.junit.Assert.*;


public class IOTest {
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

    @Test
    public void read() throws IOException, InvalidDataInFile {
        List<Object> result1 = new List<>();
        result1.add(3);
        result1.add(200);
        result1.add(0.5);
        result1.add(10);
        result1.add(30);
        System.out.println("result1 is: " + result1.toString());
//        List<Integer> result2 = new List<>();
//        List<Integer> result3 = new List<>();
        IO io1 = new IO("testf.txt", "test_1_out.txt");
//        IO io2 = new IO("test_2.txt", "test_2_out.txt");
//        IO io3 = new IO("test_3.txt", "test_3_out.txt");
        //io1.read();
//        io2.read();
//        io3.read();
        System.out.println("io1 is: " + io1.toString());
      //  assertEquals(result1.toString(), io1.toString());


    }

    @Test
    public void write() {

    }
}