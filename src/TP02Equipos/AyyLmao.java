package TP02Equipos;


import java.util.ArrayList;

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
     *  Cositas ricas
     *
     *  points is the condition to whether the outcome is proved r8 or wrong; its length is the # of teams
     *
     * Ejemplos para usar:
     * (A)  |(B)  |(C)  |(D)  |(E)
     * 4 4  |4 2  |1 0  |2 6  |3 3
     *  B 4 | A 3 | A 0 | A 5 | A 4
     *  M 4 | B 1 |     | B 11| B 3
     *  S 2 | C 1 |     |  A B| C 1
     *  G 0 | D 0|     |  A B|  A B
     *   B G|  A D|     |  A B|  B C
     *   M S|  B C|     |  A B|  C A
     *   S B|     |     |  A B|
     *   G M|     |     |  A B|
     *
     */
    public static String matchesOutcome(Match[] matches, int teams) {
        // boolean hasSolution = matchesOutcome();
        Team[] teamsx = new Team[teams];
        boolean ok = matchesOutcome();
        return "";
    }

    private static boolean matchesOutcome(int index, int result, Match[] matches, Team[] teams, int[] condition) {
        boolean safe = true;
        Match actualMatch = matches[index];
        for (int i = 0; i < matches.length - 1; i++) {
            if (teams[i].equals(matches[i].teamA)) {
                switch (result) {
                    case (0): teams[i].points += 1;
                    case (1): teams[i].points += 3;
                }
                if (teams[i].points > condition[i]) safe = false;
            } else if (teams[i].equals(matches[i].teamB)) {
                switch (result) {
                    case (0): teams[i].points += 1;
                    case (2): teams[i].points += 3;
                }
                if (teams[i].points > condition[i]) safe = false;
            }
        }
        if (index == teams.length) {
            return safe;
        }
        if (result <= 2 && safe) {
            return matchesOutcome(index + 1, 0, matches, teams, condition);
        } else if (result ==1 &&)
    }

    public static void main(String[] args) {
        Team teamA = new Team(4);
        Team teamB = new Team(3);
        Team teamC = new Team(1);
        Match[] exampleE = {new Match(teamA, teamB), new Match(teamB, teamC), new Match(teamC, teamA)};
        System.out.println(matchesOutcome(exampleE, 3));
    }
}
