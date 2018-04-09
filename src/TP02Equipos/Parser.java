package TP02Equipos;

import java.util.*;

public class Parser {
    private String input;
    private Scanner scanner;
    public Parser(String input) {
        scanner = new Scanner(input);
        this.input = input;
    }

    public Validator parseNext(){
        int teams = scanner.nextInt();
        if(teams == -1)
            return null;
        int matches = scanner.nextInt();

        List<Match> matchList = new ArrayList<>();
        List<Team> teamList = new ArrayList<>();
        HashMap<String, Team> teamTable = new HashMap<>();
        for(int i=0;i<teams;i++){
            String name = scanner.next();
            Team temp = new Team(scanner.nextInt(),name);
            teamTable.put(name,temp);
            teamList.add(temp);
        }
        for(int i=0;i<matches;i++)
            matchList.add(new Match(teamTable.get(scanner.next()),teamTable.get(scanner.next())));
        return new Validator(matchList,teamList);
    }
    public List<Validator> ParseAll(){
        List<Validator> validators = new LinkedList<>();
        Validator v;
        while((v = parseNext()) != null) {
            validators.add(v);
        }
        return validators;
    }
}
