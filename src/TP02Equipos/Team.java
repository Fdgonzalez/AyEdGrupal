package TP02Equipos;

public class Team {
    private int points;
    private int actual;
    private String name;


    public Team(int points, String name) {
        this.points = points;
        this.name = name;
        actual = 0;
    }
    public boolean isPossible(int v){
        return points >= actual + v;
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
