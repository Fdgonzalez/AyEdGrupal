package TP03ArbolesColasYPilas;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 * TP 03: Integracion de Arboles, Pilas y Colas.
 * Por Facundo Gonzalez, Juan Manuel Lopez Gabeiras y Juan Gabriel Ricci
 *
 * Ejercicio 3.
 * Clase tester auxiliar del Queue generico.
 */
public class QueueTest {
    @Test
    public void queue(){
        Queue<Integer> a = new Queue<>();

        a.enqueue(1);
        a.enqueue(2);
        a.enqueue(3);

        System.out.println(a.dequeue());
        System.out.println(a.dequeue());
        System.out.println(a.dequeue());

        assertTrue(a.isEmpty());
    }
}