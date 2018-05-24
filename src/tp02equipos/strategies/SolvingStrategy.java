package tp02equipos.strategies;


import tp02equipos.exceptions.InvalidResultException;
import tp02equipos.exceptions.NoMatchesException;


public interface SolvingStrategy {
    void solve() throws NoMatchesException, InvalidResultException;

    int getComparisons();

    long getMatchResultsGenerated();

    int getSolutionsGenerated();
}
