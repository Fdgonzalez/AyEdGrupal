package TP02Equipos.Strategies;


import TP02Equipos.Exceptions.InvalidResultException;
import TP02Equipos.Exceptions.NoMatchesException;

public interface SolvingStrategy {
    void solve() throws NoMatchesException, InvalidResultException;
}
