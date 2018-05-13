package TP02Equipos.Strategies;

import TP02Equipos.Match;
import TP02Equipos.Team;

import java.util.List;

public class BruteForceStrategy implements SolvingStrategy{
    private List<Match> matches;
    private List<Team> teams;
    private final char[] outcomes = {'X','1','2'};

    public BruteForceStrategy(List<Match> matches, List<Team> teams) {
        this.matches = matches;
        this.teams = teams;
    }
    public void solve(){
        generateAllPosible();
    }

    private void generateAllPosible() {
        try {
            generateAllPosibleRecursive("",matches.size());
        } catch (SolvedException ignored) {
        }
    }
    private void generateAllPosibleRecursive(String current,int length) throws SolvedException {
        if(length == 0){
            if(isValid(current)){
                throw new SolvedException();
            }
            return;
        }
        for(int i = 0; i<outcomes.length;i++){
            String next = current + outcomes[i];
            generateAllPosibleRecursive(next,length-1);
        }
    }
    private boolean isValid(String outcome){
        int index = 0;
        for (Match m : matches) {
            m.setOutcome(outcome.charAt(index++));
        }
        boolean valid = valid();
        if(!valid) {
            for (Match m : matches) {
                m.undoResult();
            }
        }
        return valid;
    }
    private boolean valid(){
        boolean isCorrect = true;
        for(Team team:teams){
            if(!team.isMax()) {
                isCorrect = false;
                break;
            }
        }
        return isCorrect;
    }

    private class SolvedException extends Throwable {
    }
}
