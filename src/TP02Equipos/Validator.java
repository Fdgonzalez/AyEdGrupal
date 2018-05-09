package TP02Equipos;


import TP02Equipos.Exceptions.InvalidResultException;
import TP02Equipos.Exceptions.InvalidStrategy;
import TP02Equipos.Exceptions.NoMatchesException;
import TP02Equipos.Strategies.BackTrackingStrategy;
import TP02Equipos.Strategies.BruteForceStrategy;
import TP02Equipos.Strategies.SolvingStrategy;
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
}