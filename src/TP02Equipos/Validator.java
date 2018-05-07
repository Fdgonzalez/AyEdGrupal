package TP02Equipos;

import java.util.LinkedList;
import java.util.List;

public class Validator{
    private List<Match> matches;
    private List<Team> teams;
    private SolvingStrategy strategy;
    public Validator(List<Match> matches,List<Team> teams,SolvingStrategy strategy) {
        this.matches = matches;
        this.teams = teams;
        this.strategy = strategy;
    }
    public Validator(List<Match> matches, List<Team> teams){
        this.matches = matches;
        this.teams=teams;
        this.strategy = new BackTrackingStrategy(matches,teams);
    }
    public void solve() throws InvalidResultException, NoMatchesException {
        strategy.solve();
    }
    public void swapStrategy(SolvingStrategy strategy){
        this.strategy = strategy;
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


    public List<Team> getTeams() {
        return teams;
    }
    public List<Match> getMatches(){
        return matches;
    }
}