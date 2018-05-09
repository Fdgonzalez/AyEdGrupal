package TP02Equipos;


import TP02Equipos.Exceptions.InvalidResultException;

/**
 * TP02 Soccertable por Facundo Gonzalez y Juan Gabriel Ricci
 *
 * Clase partido, con los dos equipos y el
 * resultado (X empate, 1 victoria local y 2 victoria visitante)
 */
public class Match {
    private Team local;
    private Team visitor;
    private char outcome; // X, 1 or 2

    /**
     * Constructor without outcome
     */
    public Match(Team local, Team visitor) {
        this.local = local;
        this.visitor = visitor;
    }

    /**
     * Assigns the match outcome
     */
    public void setOutcome(char outcome){
        this.outcome = outcome;
        switch (outcome){
            case 'X':
                local.assign(1);
                visitor.assign(1);
                break;
            case '1':
                local.assign(3);
                break;
            case '2':
                visitor.assign(3);
                break;
        }
    }

    @Override
    public String toString(){
        return outcome + "";
    }

    /**
     * Checks whether the outcome entered
     * @throws InvalidResultException not victory, defeat or tie.
     */
    public boolean isPossible(char outcome) throws InvalidResultException {
        switch (outcome){
            case 'X': return local.isPossible(1) && visitor.isPossible(1);
            case '1': return local.isPossible(3);
            case '2': return visitor.isPossible(3);
            default: throw new InvalidResultException();
        }
    }

    /**
     * Reverses outcome
     */
    public void undoResult() {
        switch (this.outcome){
            case 'X': local.undo(1); visitor.undo(1);break;
            case '1': local.undo(3);break;
            case '2': visitor.undo(3);break;
        } this.outcome = 0;
    }
}
