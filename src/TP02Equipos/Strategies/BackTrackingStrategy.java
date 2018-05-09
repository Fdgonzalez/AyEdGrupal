package TP02Equipos.Strategies;


import TP02Equipos.Exceptions.InvalidResultException;
import TP02Equipos.Exceptions.NoMatchesException;
import TP02Equipos.Match;
import TP02Equipos.Team;
import java.util.LinkedList;
import java.util.List;

/**
 * TP02 Soccertable por Facundo Gonzalez y Juan Gabriel Ricci
 *
 * Clase solucion estilo Backtracking
 */
public class BackTrackingStrategy implements SolvingStrategy {
    private int currentMatch;
    private List<Match> matches;
    private List<Team> teams;

    /**
     * Constructor, receives a list of matches and a list of teams
     */
    public BackTrackingStrategy(List<Match> matches, List<Team> teams) {
        this.matches = matches;
        this.teams = teams;
        currentMatch = 0;
    }

    /**
     * Solves problem with matches and teams entered.
     * @throws NoMatchesException there are no matches entered
     * @throws InvalidResultException not victory, defeat or tie.
     */
    public void solve() throws NoMatchesException, InvalidResultException {
        if(matches.get(currentMatch) == null) throw new NoMatchesException();
        Node root = new Node(matches.get(currentMatch++),'0');
        solve(root);
    }

    /**
     * Solve helper recursive method.
     * @param current node to solve.
     * @throws InvalidResultException not victory, defeat or tie.
     */
    public void solve(Node current) throws InvalidResultException {
        current.match.undoResult(); // resets the result previously set (that turned out to be wrong)

        List<Character> possibles = new LinkedList<>();
        if(current.match.isPossible('X')) possibles.add('X');
        if(current.match.isPossible('1')) possibles.add('1');
        if(current.match.isPossible('2')) possibles.add('2');
        if(possibles.isEmpty()) return; // discard path
        if(currentMatch == matches.size()) {
            current.match.setOutcome(possibles.get(0));
            return;
        }
        for(Character c: possibles) add(current, matches.get(currentMatch), c);

        for(Node next:current.possibles) {
            current.match.setOutcome(next.result);
            currentMatch++;
            solve(next);
            if(currentMatch == matches.size()) {
                //validate that the final scores were reached
                boolean isCorrect = true;
                for(Team team:teams){
                    if(!team.isMax()) {
                        isCorrect = false;
                        break;
                    }
                }
                if(isCorrect) return;
            }
            current.match.undoResult();
            currentMatch--;
        }
    }

    private void add(Node node, Match match, char result) {
        node.possibles.add(new Node(match,result));
    }

    /**
     * Node nested class
     */
    private static class Node {
        Match match;
        List<Node> possibles;
        char result;

        Node(Match match, char result) {
            possibles = new LinkedList<>();
            this.match = match;
            this.result = result;
        }
    }
}
