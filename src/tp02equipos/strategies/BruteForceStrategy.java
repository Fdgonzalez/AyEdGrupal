package tp02equipos.strategies;

import tp02equipos.Match;
import tp02equipos.Team;

import java.util.List;

public class BruteForceStrategy implements SolvingStrategy{
    private List<Match> matches;
    private List<Team> teams;
    private final char[] outcomes = {'X','1','2'};
    private int solutionsGenerated;
    private int comparisons;

    public BruteForceStrategy(List<Match> matches, List<Team> teams) {
        this.matches = matches;
        this.teams = teams;
        solutionsGenerated = 0;
        comparisons = 0;
    }
    public void solve(){
        generateAllPosible();
    }

    @Override
    public int getComparisons() {
        return comparisons;
    }

    @Override
    public long getMatchResultsGenerated() {
        //las soluciones generadas siempre tienen la misma cantidad de partidos (todos)
        return solutionsGenerated * matches.size();
    }

    @Override
    public int getSolutionsGenerated() {
        return solutionsGenerated;
    }

    private void generateAllPosible() {
        try {
            generateAllPosibleRecursive("",matches.size());
        } catch (SolvedException ignored) {
        }
    }
    private void generateAllPosibleRecursive(String current,int length) throws SolvedException {
        if(length == 0){
            solutionsGenerated++;
            if(isValid(current)){
                throw new SolvedException(); // para salir de la recursion
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
            comparisons++;
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
