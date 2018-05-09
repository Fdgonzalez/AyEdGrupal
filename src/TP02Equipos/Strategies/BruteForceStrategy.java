package TP02Equipos.Strategies;

import TP02Equipos.Exceptions.InvalidResultException;
import TP02Equipos.Exceptions.NoMatchesException;
import TP02Equipos.Match;
import TP02Equipos.Team;

import java.util.List;

public class BruteForceStrategy implements SolvingStrategy {
    private int currentMatch;
    private List<Match> matches;
    private List<Team> teams;

    /**
     * Contructor, receives a list of matches and teams
     */
    public BruteForceStrategy(List<Match> matches, List<Team> teams){
        this.matches = matches;
        this.teams = teams;
        currentMatch = 0;
    }

    /**
     * Solves problem with given matches and teams
     * @throws NoMatchesException there are no matches entered
     * @throws InvalidResultException not victory, defeat or tie.
     */
    public void solve() throws NoMatchesException, InvalidResultException {
        if(matches.get(currentMatch) == null)
            throw new NoMatchesException();

    }
}
