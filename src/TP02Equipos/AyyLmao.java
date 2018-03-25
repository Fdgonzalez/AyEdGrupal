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
     * 4 4  |3 1  |1 0  |2 6  |3 3
     *  B 4 | A 3 | A 0 | A 5 | A 4
     *  M 4 | B 0 |     | B 11| B 3
     *  S 2 | C 0 |     |  A B| C 1
     *  G 0 |  A B|     |  A B|  A B
     *   B G|     |     |  A B|  B C
     *   M S|     |     |  A B|  C A
     *   S B|     |     |  A B|
     *   G M|     |     |  A B|
     *
     */
    public static String matchesOutcome(Team[] teams, Match[] matches, int[] points) {
        int treeBranchIndex = 0;
        boolean hasSolution = matchesOutcome(0, matches, teams, points, new int[matches.length - 1]);
        ArrayList<Integer> rejectedOutcomes = new ArrayList<>();

        return "o sos un vovo o lo hiciste mal (vovo)";
    }

    private static boolean matchesOutcome(int index, String[] local, String[] visitor, String[] teams, int[] points, int[] outcomes) {
        if (index == teams.length - 1) {
            for (int i = 0; i < teams.length; i++) {
                if (points[i] != outcomes[i]) return false;
            }
        }
    }

    public static void main(String[] args) {
        Team[] teamsE = {new Team("team A"), }
        Match[] exampleE = {new Match("team A", "team B"), new Match("team B", "team C"),
                            new Match("team C", "team A")};
        int[] pointsExampleE = {4, 3, 1};
        System.out.println(matchesOutcome(teamsE, exampleE, pointsExampleE));
    }
}
