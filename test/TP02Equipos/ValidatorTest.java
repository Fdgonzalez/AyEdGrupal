package TP02Equipos;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class ValidatorTest {

    @Test
    public void solve() throws InvalidResultException, NoMatchesException {
        Team barcelona = new Team(4, "barcelona");
        Team madrid = new Team(4, "madrid");
        Team sevilla = new Team(2, "Sevila");
        Team getafe = new Team(0, "Getafe");
        List<Match> matches = new LinkedList<>();
        List<Team> teams = new LinkedList<>();
        teams.add(barcelona);
        teams.add(madrid);
        teams.add(sevilla);
        teams.add(getafe);
        matches.add(new Match(barcelona,getafe));
        matches.add(new Match(madrid,sevilla));
        matches.add(new Match(sevilla,barcelona));
        matches.add(new Match(getafe,madrid));
        Validator v = new Validator(matches,teams);
        v.solve();
        v.print();
    }
}