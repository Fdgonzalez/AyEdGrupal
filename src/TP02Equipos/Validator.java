package TP02Equipos;


import TP02Equipos.Exceptions.InvalidResultException;
import TP02Equipos.Exceptions.NoMatchesException;
import TP02Equipos.Exceptions.InvalidStrategy;
import TP02Equipos.Strategies.BackTrackingStrategy;
import TP02Equipos.Strategies.BruteForceStrategy;
import TP02Equipos.Strategies.SolvingStrategyName;

import java.util.List;

/**
 * TP02 Soccertable por Facundo Gonzalez y Juan Gabriel Ricci
 *
 * Clase validador de mi problema
 */
public class Validator{
    private List<Match> matches;
    private List<Team> teams;

    /**
     * Contructor for validating soccer table problem.
     */
    public Validator(List<Match> matches, List<Team> teams){
        this.matches = matches;
        this.teams = teams;
    }

    /**
     * Solve method, it depends on the given strategy.
     * @param strategyName desidered strategy to be used.
     * @throws NoMatchesException nothing to solve.
     * @throws InvalidResultException is not victory, defeat or tie.
     * @throws InvalidStrategy strategy name does not exists.
     */
    public void solve(SolvingStrategyName strategyName) throws NoMatchesException, InvalidResultException, InvalidStrategy {
        switch (strategyName) {
            case BACKTRACKING:
                BackTrackingStrategy backTrackingStrategy = new BackTrackingStrategy(matches, teams);
                break;
            case BRUTEFORCE:
                BruteForceStrategy bruteForceStrategy = new BruteForceStrategy(matches, teams);
                break;
            default: throw new InvalidStrategy();
        }
    }


    public void print(){
        System.out.println(toString());
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Match m:matches){
            sb.append(m.toString());
            sb.append(' ');
        }
        sb.deleteCharAt(sb.lastIndexOf(" "));
        return sb.toString();
    }
}