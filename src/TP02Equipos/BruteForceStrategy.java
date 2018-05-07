package TP02Equipos;

import java.util.List;

public class BruteForceStrategy implements SolvingStrategy {
    private int currentMatch;
    private List<Match> matches;
    private List<Team> teams;
    public BruteForceStrategy(List<Match> matches, List<Team> teams){
        this.matches = matches;
        this.teams = teams;
        currentMatch = 0;
    }
    @Override
    public void solve() throws NoMatchesException, InvalidResultException {

    }
}
