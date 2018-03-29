package TP02Equipos;

public class Match {
    private Team local;
    private Team visitor;
    private char result; // X, 1 or 2

    public Match(Team local, Team visitor) {
        this.local = local;
        this.visitor = visitor; }
    public void setResult(char result){
        this.result = result;
        switch (result){
            case 'X': local.assign(1); visitor.assign(1);break;
            case '1': local.assign(3);break;
            case '2': visitor.assign(3);break;
        }
    }
    @Override
    public String toString(){
        return result + "";
    }
    public boolean isPossible(char result) throws InvalidResultException {
        switch (result){
            case 'X': return local.isPossible(1) && visitor.isPossible(1);
            case '1': return local.isPossible(3);
            case '2': return visitor.isPossible(3);
            default: throw new InvalidResultException();
        }
    }

    public void undoResult() {
        switch (this.result){
            case 'X': local.undo(1); visitor.undo(1);break;
            case '1': local.undo(3);break;
            case '2': visitor.undo(3);break;
        }
        this.result = 0;
    }
}
