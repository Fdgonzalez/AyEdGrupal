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
    public void reachedCashierAt(int time) {
        reachedCashier = true;
        timeSpentInQueue = time - timeCreated;
    }
    public void finishedBuying(){
        finished = true;
    }
    public boolean hasLeftStore(){
        return finished;
    }

    public boolean hasReachedCashier() {
        return reachedCashier;
    }

    public int getTimeSpentInQueue() {
        return timeSpentInQueue;
    }
}
