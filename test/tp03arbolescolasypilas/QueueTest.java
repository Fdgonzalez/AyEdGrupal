package tp03arbolescolasypilas;


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

        assertEquals(1,(int) a.dequeue());
        assertEquals(2,(int) a.dequeue());
        assertEquals(3,(int) a.dequeue());

        assertTrue(a.isEmpty());
    }
}