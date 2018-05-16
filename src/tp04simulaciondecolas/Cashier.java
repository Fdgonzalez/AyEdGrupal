package tp04simulaciondecolas;


import tp04simulaciondecolas.Utils.Queue;

import java.util.NoSuchElementException;

/**
 * TP04 Simulacion de Colas.
 * Por Facundo Gonzalez, Juan Manuel Lopez Gabeiras y Juan Gabriel Ricci
 *
 * TODO javadoc de esto
 * Cajero
 *
 */
public class Cashier {
    private Queue<Client> clientQueue;
    private Client currentClient;
    private int minTime;
    private int maxTime;
    private int currentClientTime;//time it will take to serve this client
    private int currentClientActualTime;//time the client has been a the cashier so far
    private int idleTime;
    private int queueMaxLength;

    /**
     * @param cashierMinTime
     * @param cashierMaxTime
     */
    public Cashier(int cashierMinTime, int cashierMaxTime) {
        currentClient = null;
        clientQueue = new Queue<>();
        minTime = cashierMinTime;
        maxTime = cashierMaxTime;
        currentClientTime = 0;
        idleTime = 0;
    }

    /**
     * @param client
     */
    public void addClient(Client client) {
        if (currentClient == null && clientQueue.isEmpty()) {
            currentClient = client;
            currentClientTime = (int) (Math.random() * (maxTime - minTime + 1)) + minTime;
            currentClientActualTime = 0;
        } else {
            clientQueue.enqueue(client);
            if (clientQueue.length() > queueMaxLength)
                queueMaxLength = clientQueue.length();
        }
    }

    /**
     * @param currentTime
     */
    public void update(int currentTime) {
        if (currentClient == null) {
            try {
                currentClient = clientQueue.dequeue();
                currentClientTime = (int) (Math.random() * (maxTime - minTime + 1)) + minTime;
                currentClientActualTime = 0;
            } catch (NoSuchElementException e) {
                idleTime++;
                return;
            }
        }
        if (currentClientActualTime == 0)
            currentClient.reachedCashierAt(currentTime); // only update this the first time
        currentClientActualTime++;
        if (currentClientActualTime >= currentClientTime) {
            currentClient.finishedBuying();
            currentClient = null;
        }

    }

    public int getQueueLength() {
        return clientQueue.length();
    }

    public int getIdleTime() {
        return idleTime;
    }

    public int getQueueMaxLength() {
        return queueMaxLength;
    }

    public boolean isIdle() {
        return currentClient == null;
    }
}
