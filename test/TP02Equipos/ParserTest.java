package TP02Equipos;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ParserTest {
    @Test
    public void test1() throws InvalidResultException, NoMatchesException {
        String input = "2 1\n" +
                "Barcelona 1\n" +
                "Madrid 1\n" +
                "Barcelona Madrid\n" +
                "2 1\n" +
                "Barcelona 3\n" +
                "Madrid 0\n" +
                "Madrid Barcelona\n" +
                "2 1\n" +
                "Madrid 3\n" +
                "Barcelona 0\n" +
                "Madrid Barcelona\n" +
                "4 4\n" +
                "Barcelona 4\n" +
                "Madrid 4\n" +
                "Sevilla 2\n" +
                "Getafe 0\n" +
                "Barcelona Getafe\n" +
                "Madrid Sevilla\n" +
                "Sevilla Barcelona\n" +
                "Getafe Madrid\n" +
                "6 9\n" +
                "Barcelona 6\n" +
                "Valencia 4\n" +
                "Madrid 4\n" +
                "Deportivo 4\n" +
                "Sevilla 3\n" +
                "Betis 3\n" +
                "Barcelona Deportivo\n" +
                "Valencia Deportivo\n" +
                "Valencia Barcelona\n" +
                "Betis Sevilla\n" +
                "Madrid Deportivo\n" +
                "Sevilla Madrid\n" +
                "Betis Deportivo\n" +
                "Madrid Betis\n" +
                "Betis Valencia\n" +
                "6 10\n" +
                "Madrid 8\n" +
                "Barcelona 8\n" +
                "Valencia 4\n" +
                "Sevilla 4\n" +
                "Deportivo 2\n" +
                "Betis 0\n" +
                "Madrid Deportivo\n" +
                "Barcelona Sevilla\n" +
                "Betis Madrid\n" +
                "Betis Sevilla\n" +
                "Barcelona Deportivo\n" +
                "Betis Barcelona\n" +
                "Madrid Barcelona\n" +
                "Sevilla Deportivo\n" +
                "Deportivo Valencia\n" +
                "Madrid Valencia\n" +
                "-1";
        Parser p = new Parser(input);
        List<Validator> validators = p.ParseAll();
        for(Validator v:validators){
            v.solve();
            v.print();
        }

    }
    @Test
    public void test2() throws InvalidResultException, NoMatchesException {
        String input = "10 18\n" +
                "Deportivo 11\n" +
                "Betis 9\n" +
                "Sevilla 6\n" +
                "AtlMadrid 6\n" +
                "Barcelona 5\n" +
                "AthBilbao 4\n" +
                "Madrid 2\n" +
                "Espanyol 2\n" +
                "Valencia 1\n" +
                "RealSociedad 1\n" +
                "Deportivo RealSociedad\n" +
                "Barcelona AtlMadrid\n" +
                "AthBilbao Espanyol\n" +
                "AtlMadrid Madrid\n" +
                "Deportivo Madrid\n" +
                "Betis Deportivo\n" +
                "RealSociedad Espanyol\n" +
                "Valencia Deportivo\n" +
                "Deportivo Barcelona\n" +
                "Madrid Barcelona\n" +
                "Espanyol Sevilla\n" +
                "Sevilla AtlMadrid\n" +
                "Madrid Betis\n" +
                "Valencia AthBilbao\n" +
                "Betis AthBilbao\n" +
                "Valencia AtlMadrid\n" +
                "RealSociedad Betis\n" +
                "Barcelona Betis\n" + "\n" + "-1";
        Parser p = new Parser(input);
        Validator v = p.parseNext();
        v.solve();
        assertEquals(v.toString(),"1 1 X 1 1 X X X 1 X 2 1 X 2 1 2 2 X");
    }
    @Test
    public void test3() throws InvalidResultException, NoMatchesException {
        String input = "6 9\n" +
                "Barcelona 6\n" +
                "Valencia 4\n" +
                "Madrid 4\n" +
                "Deportivo 4\n" +
                "Sevilla 3\n" +
                "Betis 3\n" +
                "Barcelona Deportivo\n" +
                "Valencia Deportivo\n" +
                "Valencia Barcelona\n" +
                "Betis Sevilla\n" +
                "Madrid Deportivo\n" +
                "Sevilla Madrid\n" +
                "Betis Deportivo\n" +
                "Madrid Betis\n" +
                "Betis Valencia";
        Parser p = new Parser(input);
        Validator v = p.parseNext();
        v.solve();
        v.print();
    }
}