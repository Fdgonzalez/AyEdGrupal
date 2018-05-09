package TP02Equipos;

import java.util.*;

public class Parser {
    private String input;
    private Scanner scanner;

    /**
     * Constructor
     * @param input to be parsed
     */
    public Parser(String input) {
        scanner = new Scanner(input);
        this.input = input;
    }

    /**
     * Parses current string
     * @return a array with [0] matches and [1] teams
     */
    public Validator parseNext() {
        int teams = scanner.nextInt();
        if(teams == -1) return null;
        int matches = scanner.nextInt();
        // initialize collections
        List<Match> matchList = new ArrayList<>();
        List<Team> teamList = new ArrayList<>();
        HashMap<String, Team> teamTable = new HashMap<>();
        // parse teams
        for(int i = 0; i < teams; i++) {
            String name = scanner.next();
            Team temp = new Team(scanner.nextInt(), name);
            teamTable.put(name,temp);
            teamList.add(temp);
        }
        // parse matches
        for(int i = 0; i < matches; i++)
            matchList.add(new Match(teamTable.get(scanner.next()),
                                    teamTable.get(scanner.next())));

        return new Validator(matchList, teamList);
    }

    /**
     *
     * @return
     */
    public List<Validator> ParseAll(){
        List<Validator> validators = new LinkedList<>();
        Validator validator;
        while((validator = parseNext()) != null) {
            validators.add(validator);
        }
        return validators;
    }
}
