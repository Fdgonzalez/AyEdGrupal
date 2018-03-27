package TP02Equipos;


import java.util.ArrayList;
import java.util.Arrays;

public class AyyLmao {
//    private FileReader file;
//    {
//        try {
//            file = new FileReader("dummy.txt");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//    private BufferedReader bufferedReader = new BufferedReader(file);

    /*
     * Ejemplos para usar:
     * (A)  |(B)  |(C)  |(D)  |(E)
     * 4 4  |4 2  |1 0  |2 6  |3 3
     *  B 4 | A 3 | A 0 | A 5 | A 4
     *  M 4 | B 1 |     | B 11| B 3
     *  S 2 | C 1 |     |  A B| C 1
     *  G 0 | D 0 |     |  A B|  A B
     *   B G|  A D|     |  A B|  B C
     *   M S|  B C|     |  A B|  C A
     *   S B|     |     |  A B|
     *   G M|     |     |  A B|
     */

    public String solve(Team[] teams, int[] points, Match[] matches) {
        String[] outcomes = new String[matches.length];

        return Arrays.toString(outcomes);
    }

    public boolean solveHelper(int matchesIndex, int result, Team[] teams, int[] points, Match[] matches) {
        boolean isSafe = true;
        for (int i = 0; i < teams.length; i++) {
            if (teams[i].equals(matches[matchesIndex].teamA)) {
                switch (result) {
                    case 0:
                        points[i] += 1;
                        break;
                    case 1:
                        points[i] += 3;
                        break;
                }
            } else if (teams[i].equals(matches[matchesIndex].teamB)) {
                switch (result) {
                    case 0:
                        points[i] += 1;
                        break;
                    case 2:
                        points[i] += 3;
                        break;
                }
            }
            if (points[i] > teams[i].points) isSafe = false;
        }
        
    }
}
