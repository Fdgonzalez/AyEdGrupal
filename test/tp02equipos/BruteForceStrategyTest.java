package tp02equipos;


import tp02equipos.exceptions.InvalidResultException;
import tp02equipos.exceptions.InvalidStrategy;
import tp02equipos.exceptions.NoMatchesException;
import tp02equipos.strategies.BruteForceStrategy;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;


public class BruteForceStrategyTest {
    @Test
    public void test1() throws InvalidStrategy, InvalidResultException, NoMatchesException {
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
        List<String> expectedResults = new ArrayList<>();
        expectedResults.add("X");
        expectedResults.add("2");
        expectedResults.add("1");
        expectedResults.add("1 X X 2");
        expectedResults.add("1 1 2 2 2 2 X X X");
        expectedResults.add("1 1 2 2 X 2 X X 2 X");
        for(int i=0;i<6;i++){
            Validator current = validators.get(i);
            current.swapStrategy(new BruteForceStrategy(current.getMatches(), current.getTeams()));
            current.solve();
        }
        for(int i=0;i<6;i++){
            assertEquals(validators.get(i).toString(), expectedResults.get(i));
        }

    }
    @Test
    public void test2() throws InvalidStrategy, InvalidResultException, NoMatchesException {
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
                "Barcelona Betis\n" +
                "\n" + "-1";
        Parser p = new Parser(input);
        Validator v = p.parseNext();
        v.swapStrategy(new BruteForceStrategy(v.getMatches(), v.getTeams()));
        v.solve();
        assertEquals("1 1 X 1 1 X X X 1 X 2 1 X 2 1 2 2 X",v.toString());
        System.out.println("Comparisons: "+v.getComparisons());
        System.out.println("Match results generated: "+v.getMatchResultsGenerated());
        System.out.println("Solutions generated: "+v.getSolutionsGenerated());
    }

    @Test
    public void test3() throws InvalidStrategy, InvalidResultException, NoMatchesException {
        String input = "3 3\n" +
                "EquipoA 4\n" +
                "EquipoB 1\n" +
                "EquipoC 2\n" +
                "EquipoA EquipoB\n" +
                "EquipoB EquipoC\n" +
                "EquipoC EquipoA\n" + "\n" + "-1";
        Parser p = new Parser(input);
        Validator v = p.parseNext();
        v.swapStrategy(new BruteForceStrategy(v.getMatches(), v.getTeams()));
        v.solve();
        assertEquals("1 X X", v.toString());
    }

    @Test
    public void test4() throws InvalidStrategy, InvalidResultException, NoMatchesException {
        String input = "4 3\n" +
                "EquipoA 3\n" +
                "EquipoB 3\n" +
                "EquipoC 1\n" +
                "EquipoD 1\n" +
                "EquipoA EquipoB\n" +
                "EquipoB EquipoC\n" +
                "EquipoC EquipoD\n" +
                "\n" + "-1";
        Parser p = new Parser(input);
        Validator v = p.parseNext();
        v.swapStrategy(new BruteForceStrategy(v.getMatches(), v.getTeams()));
        v.solve();
        assertEquals("1 1 X", v.toString());
    }
}
