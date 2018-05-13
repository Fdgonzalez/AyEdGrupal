package tp02equipos;

/**
 * TP02 Soccertable por Facundo Gonzalez y Juan Gabriel Ricci
 *
 * Clase Equipo, tiene los puntos originales y los que estoy
 * calculando actualmente
 */
public class Team {
    private int points;
    private int actual;
    private String name;

    /**
     * Constructor
     */
    public Team(int points, String name) {
        this.points = points;
        this.name = name;
        actual = 0;
    }

    public boolean isPossible() {
        return points == actual;
    }

    /**
     * verifies if the value given does not surpass
     * my goal value.
     */
    public boolean isPossible(int value){
        return points >= actual + value;
    }

    public void assign(int points){
        actual += points;
    }

    public void undo(int points){
        actual -= points;
    }

    public String getName() {
        return name;
    }

    public boolean isMax() {
        return actual == points;
    }
}
