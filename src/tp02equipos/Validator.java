package tp02equipos;


import tp02equipos.exceptions.InvalidResultException;
import tp02equipos.exceptions.InvalidStrategy;
import tp02equipos.exceptions.NoMatchesException;
import tp02equipos.strategies.BackTrackingStrategy;
import tp02equipos.strategies.SolvingStrategy;
import java.util.List;

/**
 * TP02 Soccertable por Facundo Gonzalez y Juan Gabriel Ricci
 *
 * Clase validador de mi problema
 */
public class Validator{
    private List<Match> matches;
    private List<Team> teams;
    private SolvingStrategy strategy;

    /**
     * Contructor for validating soccer table problem.
     * The default strategy is backtracking
     */
    public Validator(List<Match> matches, List<Team> teams) {
        this.matches = matches;
        this.teams = teams;
        this.strategy = new BackTrackingStrategy(matches, teams);
    }

    /**
     * Solve method, it depends on the given strategy.
     * @throws InvalidStrategy strategy name does not exists.
     */
    public void solve() throws InvalidStrategy, InvalidResultException, NoMatchesException {
        strategy.solve();
    }

    public void swapStrategy(SolvingStrategy solvingStrategy) {
        this.strategy = solvingStrategy;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void print() {
        System.out.println(toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Match m: matches){
            sb.append(m.toString());
            sb.append(' ');
        }
        sb.deleteCharAt(sb.lastIndexOf(" "));
        return sb.toString();
    }

    public int getComparisons() {
        return strategy.getComparisons();
    }

    public long getMatchResultsGenerated() {
        return strategy.getMatchResultsGenerated();
    }

    public int getSolutionsGenerated() {
        return strategy.getSolutionsGenerated();
    }
}