package tp04simulaciondecolas;


import tp04simulaciondecolas.Utils.ArrayStack;

/**
 * TP04 Simulacion de Colas.
 * Por Facundo Gonzalez, Juan Manuel Lopez Gabeiras y Juan Gabriel Ricci
 *
 * Clase supermercado
 * todo javadoc
 */
public class Supermarket {
    private Cashier[] cashiers;
    private double newCustomerChance;
    private int clientsServiced;
    private double timeSpentInQueueAverage;
    private int queueLengthAverageAtEnd;
    private int queueMaxLength;
    private int totalIdleTime;
    private int totalClients;
    private ArrayStack<Client> clients; // keep a reference to all clients to do the final calculations

    /**
     * @param cashierAmount
     * @param newCustomerChance
     * @param cashierMinTime
     * @param cashierMaxTime
     */
    public Supermarket(int cashierAmount, double newCustomerChance, int cashierMinTime, int cashierMaxTime) {
        cashiers = new Cashier[cashierAmount];
        clients = new ArrayStack<>(10);
        this.newCustomerChance = newCustomerChance;
        for (int i = 0; i < cashierAmount; i++) {
            cashiers[i] = new Cashier(cashierMinTime, cashierMaxTime);
        }
    }

    /**
     * @param currentTime
     */
    public void update(int currentTime) {
        if (Math.random() <= newCustomerChance) {
            Client newClient = new Client(currentTime);
            clients.push(newClient);
            int length = cashiers[0].getQueueLength();
            int shortestQueue = 0;
            for (int i = 1; i < cashiers.length; i++) {
                int currentQueueLength = cashiers[i].getQueueLength();
                if (currentQueueLength < length) {
                    length = cashiers[i].getQueueLength();
                    shortestQueue = i;
                }
            }
            cashiers[shortestQueue].addClient(newClient);
        }
        for (Cashier cashier : cashiers) {
            cashier.update(currentTime);
        }
    }

    /**
     *
     */
    public void finish() {//TODO: el promedio de colas no es al final, es sobre el total
        int clientsThatReachedACashier = 0;
        totalClients = clients.length();
        int totalSpentInQueue = 0; // sum of all times clients that reached a cashier spent in a queue
        while (!clients.isEmpty()) {
            Client c = clients.pop();
            if (c.hasLeftStore())
                clientsServiced++;
            if (c.hasReachedCashier()) {
                clientsThatReachedACashier++;
                totalSpentInQueue += c.getTimeSpentInQueue();
            }
        }
        if (clientsThatReachedACashier > 0)
            timeSpentInQueueAverage = totalSpentInQueue / clientsThatReachedACashier;
        else
            timeSpentInQueueAverage = 0;
        for (Cashier c : cashiers) {
            queueLengthAverageAtEnd += c.getQueueLength();
            totalIdleTime += c.getIdleTime();
            if (c.getQueueMaxLength() > queueMaxLength) {
                queueMaxLength = c.getQueueMaxLength();
            }
        }
        queueLengthAverageAtEnd /= cashiers.length;

    }

    /**
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cantidad de usuarios que arribaron: ");
        sb.append(totalClients);
        sb.append('\n');
        sb.append("Cantidad de usuarios atendidos: ");
        sb.append(clientsServiced);
        sb.append('\n');
        sb.append(String.format("%.1f", timeSpentInQueueAverage));//use only one decimal point
        sb.append('\n');
        sb.append(queueLengthAverageAtEnd);
        sb.append('\n');
        sb.append(queueMaxLength);
        sb.append('\n');
        sb.append(totalIdleTime);
        return sb.toString();
    }
}
