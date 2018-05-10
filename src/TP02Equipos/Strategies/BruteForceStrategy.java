package TP02Equipos.Strategies;


import TP02Equipos.Exceptions.InvalidResultException;
import TP02Equipos.Exceptions.NoMatchesException;
import TP02Equipos.Match;
import TP02Equipos.Team;

import java.util.List;


public class BruteForceStrategy implements SolvingStrategy {
    private List<Match> matches;
    private List<Team> teams;

    /**
     * Contructor, receives a list of matches and teams
     */
    public BruteForceStrategy(List<Match> matches, List<Team> teams) {
        this.matches = matches;
        this.teams = teams;
    }

    /**
     * Solves problem with given matches and teams
     *
     * @throws NoMatchesException     there are no matches entered
     * @throws InvalidResultException not victory, defeat or tie.
     */
    public void solve() throws NoMatchesException, InvalidResultException {
        if (matches.get(0) == null) throw new NoMatchesException();
        String how = "";
        List<Match> temp = this.matches;
        solveHelper(temp, how, matches.size(), 0);
        this.matches = temp;
    }

    private boolean solveHelper(List<Match> matches, String how, int size, int index) {
        System.out.println(matches.toString());
        System.out.println(how);
        if (index == size) {
            System.out.print("this is leaf!... ");
            if (matches.get(index - 1).isPossible()) {
                System.out.println("and possible!");
                return true;
            } else {
                matches = this.matches;  // meant to reset all matches outcome
                System.out.println("not possible!");
                return false;
            }
        } else if (index < size) {
            matches.get(index).setOutcome('X');
            how += " X";
            if (solveHelper(matches, how, size, index + 1)) return true;
            matches.get(index).undoResult();
            how = how.substring(0, how.length() - 2);
            matches.get(index).setOutcome('1');
            how += " 1";
            if (solveHelper(matches, how, size, index + 1)) return true;
            matches.get(index).undoResult();
            how = how.substring(0, how.length() - 2);
            matches.get(index).setOutcome('2');
            how += " 2";
            return solveHelper(matches, how, size, index + 1);
        } return false;
    }


//    private boolean solveHelper(String currentOutcome, int length, int matchIndex) throws InvalidResultException {
//        System.out.println(currentOutcome);
//        if (matchIndex == length) return true;
//        else if (matchIndex < length) {
//            if (matches.get(matchIndex).isPossible('X')) {
//                matches.get(matchIndex).setOutcome('X');
//                if (!solveHelper(currentOutcome + " X", length, matchIndex + 1)) {
//                    matches.get(matchIndex).undoResult();
//                } else return true;
//            }
//            if (matches.get(matchIndex).isPossible('1')) {
//                matches.get(matchIndex).setOutcome('1');
//                if (!solveHelper(currentOutcome + " 1", length, matchIndex + 1)) {
//                    matches.get(matchIndex).undoResult();
//                } else return true;
//            }
//            if (matches.get(matchIndex).isPossible('2')) {
//                matches.get(matchIndex).setOutcome('2');
//                if (!solveHelper(currentOutcome + " 2", length, matchIndex + 1)) {
//                    matches.get(matchIndex).undoResult();
//                } else return true;
//            }

}
