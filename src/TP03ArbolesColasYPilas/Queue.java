package TP03ArbolesColasYPilas;

import java.util.NoSuchElementException;

/**
 * TP 03: Integracion de Arboles, Pilas y Colas.
 * Por Facundo Gonzalez, Juan Manuel Lopez Gabeiras y Juan Gabriel Ricci
 *
 * Clase auxiliar Queue con Nodos doblemente encadenados.
 *
 * @param <T> generic
 */
public class Queue<T> {
    private Node head, tail;

    /**
     * empty queue constructor
     */
    public Queue(){
        head = tail = null;
    }


    /**
     * adds element to the queue
     * @param elem generic
     */
    public void enqueue(T elem){
        Node temp = new Node(elem);
        if(head == null) head = tail = temp;
        else {
            temp.prev = tail;
            tail.next = temp;
            tail = temp;
        }
    }

    /**
     * @return generic
     */
    public T dequeue(){
        if(isEmpty()) throw new NoSuchElementException();
        T temp = head.elem;
        if(head != tail) head = head.next;
        else head = tail = null;
        return temp;
    }

    /**
     * @return whether this queue is empty
     */
    public boolean isEmpty(){
        return tail == null;
    }

    /**
     * Node nested class. Double referenced to the next node
     * of the queue and the previous node of the queue.
     */
    private class Node {
        private T elem;
        private Node next, prev;

        public Node(T elem){
            this.elem = elem;
            prev = null;
            next = null;
        }
    }
}
