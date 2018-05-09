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
    public BruteForceStrategy(List<Match> matches, List<Team> teams){
        this.matches = matches;
        this.teams = teams;
    }

    /**
     * Solves problem with given matches and teams
     * @throws NoMatchesException there are no matches entered
     * @throws InvalidResultException not victory, defeat or tie.
     */
    public void solve() throws NoMatchesException, InvalidResultException {
        if (matches.get(0) == null) throw new NoMatchesException();
        solveHelper("", matches.size(), 0);

    }

    private void solveHelper(String currentOutcome, int length, int matchIndex) throws InvalidResultException {
        if (currentOutcome.length() == length) {
            return;
        } else if (currentOutcome.length() < length) {
            if (matches.get(matchIndex).isPossible('X')) {
                matches.get(matchIndex).setOutcome('X');
                solveHelper(matches.get(matchIndex) + " X", length, matchIndex + 1);
            } else if (matches.get(matchIndex).isPossible('1')) {
                matches.get(matchIndex).setOutcome('1');
                solveHelper(matches.get(matchIndex) + " 1", length, matchIndex + 1);
            } else if (matches.get(matchIndex).isPossible('2')) {
                matches.get(matchIndex).setOutcome('2');
                solveHelper(matches.get(matchIndex) + " 2", length, matchIndex + 1);
            }
        }
    }

    private class Node {
        Match match;
        Node next;

        public Node(Match match, Node next) {
            this.match = match;
            this.next = next;
        }
    }
}
