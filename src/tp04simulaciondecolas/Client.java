package tp04simulaciondecolas;

/**
 * TP04 Simulacion de Colas.
 * Por Facundo Gonzalez, Juan Manuel Lopez Gabeiras y Juan Gabriel Ricci
 * <p>
 * Clase cliente
 * todo javadoc de esto
 */
public class Client {
    private int timeSpentInQueue;//the time the client reached the cashier at
    private int timeCreated;// the time the client entered a cashier queue
    private boolean reachedCashier;
    private boolean finished;

    /**
     * @param timeCreated
     */
    public Client(int timeCreated) {
        this.timeCreated = timeCreated;
        reachedCashier = false;
        finished = false;
    }

    /**
     * time is the time unit in which the client reached the cashier
     */
    public void reachedCashierAt(int time) {
        reachedCashier = true;
        timeSpentInQueue = time - timeCreated;
    }

    /**
     *
     */
    public void finishedBuying() {
        finished = true;
    }

    /**
     * @return
     */
    public boolean hasLeftStore() {
        return finished;
    }

    /**
     * @return
     */
    public boolean hasReachedCashier() {
        return reachedCashier;
    }

    /**
     * @return
     */
    public int getTimeSpentInQueue() {
        return timeSpentInQueue;
    }
}
