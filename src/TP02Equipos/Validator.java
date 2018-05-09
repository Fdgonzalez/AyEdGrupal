package TP02Equipos;


import TP02Equipos.Exceptions.InvalidStrategy;
import TP02Equipos.Strategies.BackTrackingStrategy;
import TP02Equipos.Strategies.BruteForceStrategy;
import TP02Equipos.Strategies.SolvingStrategyName;
import java.util.List;
import static TP02Equipos.Strategies.SolvingStrategyName.BACKTRACKING;

/**
 * TP02 Soccertable por Facundo Gonzalez y Juan Gabriel Ricci
 *
 * Clase validador de mi problema
 */
public class Validator{
    private List<Match> matches;
    private List<Team> teams;
    private SolvingStrategyName strategy;

    /**
     * Contructor for validating soccer table problem.
     * The default strategy is backtracking
     */
    public Validator(List<Match> matches, List<Team> teams) {
        this.matches = matches;
        this.teams = teams;
        this.strategy = BACKTRACKING;
    }

    /**
     * Solve method, it depends on the given strategy.
     * @throws InvalidStrategy strategy name does not exists.
     */
    public void solve() throws InvalidStrategy {
        switch (this.strategy) {
            case BACKTRACKING:
                BackTrackingStrategy backTrackingStrategy = new BackTrackingStrategy(matches, teams);
                break;
            case BRUTEFORCE:
                BruteForceStrategy bruteForceStrategy = new BruteForceStrategy(matches, teams);
                break;
            default: throw new InvalidStrategy();
        }
    }

    public void swapStrategy(SolvingStrategyName strategyName) {
        this.strategy = strategyName;
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