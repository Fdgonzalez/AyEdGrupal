package TP02Equipos;

import java.util.LinkedList;
import java.util.List;

public class Validator{
    private List<Match> matches;
    private int currentMatch;
    private List<Team> teams;
    public Validator(List<Match> matches,List<Team> teams) {
        this.matches = matches;
        currentMatch = 0;
        this.teams = teams;
    }
    public void solve() throws NoMatchesException, InvalidResultException {
        if(matches.get(currentMatch) == null)
            throw new NoMatchesException();
        Node root = new Node(matches.get(currentMatch++),'0');
        solve(root);
    }
    public void solve(Node current) throws InvalidResultException {
        List<Character> possibles = new LinkedList<>();
        if(current.match.isPossible('X'))
            possibles.add('X');
        if(current.match.isPossible('1'))
            possibles.add('1');
        if(current.match.isPossible('2'))
            possibles.add('2');
        if(possibles.isEmpty())
            return; // discard path
        if(currentMatch == matches.size()){
            current.match.setResult(possibles.get(0));
            return;
        }

        for(Character c: possibles){
            current.add(matches.get(currentMatch),c);
        }
        for(Node next:current.possibles){
            current.match.setResult(next.result);
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
                if(isCorrect)
                    return;
            }
            current.match.undoResult();//Bug: can't undo last match
            currentMatch--;
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

    private static class Node{
        Match match;
        List<Node> possibles;
        char result;
        Node(Match match, char result){
            possibles = new LinkedList<>();
            this.match = match;
            this.result = result;
        }
        void add(Match match,char result){
            possibles.add(new Node(match,result));
        }
    }
}