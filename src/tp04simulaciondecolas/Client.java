package tp04simulaciondecolas;

public class Client {
    private int timeSpentInQueue;//the time the client reached the cashier at
    private int timeCreated;// the time the client entered a cashier queue
    private boolean reachedCashier;
    private boolean finished;
    public Client(int timeCreated){
        this.timeCreated = timeCreated;
        reachedCashier = false;
        finished = false;
    }
    //time is the time unit in which the client reached the cashier
    public void reachedCashier(int time) {
        reachedCashier = true;
        timeSpentInQueue = timeCreated - time;
    }
    public void finished(){
        finished = true;
    }
    public boolean leftCashier(){
        return finished;
    }

    public boolean reachedCashier() {
        return reachedCashier;
    }

    public int getTimeSpentInQueue() {
        return timeSpentInQueue;
    }
}
