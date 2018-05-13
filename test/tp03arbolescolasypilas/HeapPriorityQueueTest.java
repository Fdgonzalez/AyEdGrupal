package tp03arbolescolasypilas;


import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * TP 03: Integracion de Arboles, Pilas y Colas.
 * Por Facundo Gonzalez, Juan Manuel Lopez Gabeiras y Juan Gabriel Ricci
 *
 * Ejercicio 3.
 * Clase tester del Heap Tree generico.
 */
public class HeapPriorityQueueTest {
    @Test
    public void minHeapTest() throws HeapFullException {
        HeapPriorityQueue<Character> heap = new HeapPriorityQueue<>(100);

        heap.enQueue('c', 1);
        heap.enQueue('a', 0);
        heap.enQueue('e', 4);
        heap.enQueue('d', 2);
        heap.enQueue('b', 0.1);
        assertEquals('a',(char) heap.dequeue());
        assertEquals('b',(char) heap.dequeue());
        assertEquals('c',(char) heap.dequeue());
        assertEquals('d',(char) heap.dequeue());
        assertEquals('e',(char) heap.dequeue());
    }
}