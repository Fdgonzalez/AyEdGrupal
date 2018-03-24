package TP02Equipos;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class AyyLmao {
    private FileReader file;
    {
        try {
            file = new FileReader("dummy.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private BufferedReader bufferedReader = new BufferedReader(file);

    public void method(int n, int m, Match[] matches, )
}
