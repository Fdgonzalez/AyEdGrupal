package tp04simulaciondecolas.Utils;


import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * TP04 Simulacion de Colas.
 * Por Facundo Gonzalez, Juan Manuel Lopez Gabeiras y Juan Gabriel Ricci
 * <p>
 * Clase Stack de enteros usando arrays generico
 */
public class ArrayStack<T> {
    private T[] elements;
    private int current;
    //private final int defaultSize = 10;

    /**
     * Constructor
     *
     * @param maxSize number of arrays limit
     */
    @SuppressWarnings("unchecked")
    public ArrayStack(int maxSize) {
        elements = (T[]) new Object[maxSize];
        current = 0;
    }

    public boolean isEmpty() {
        return current == 0;
    }

    /**
     * returns current element and deletes it from my stack
     */
    public T pop() {
        if (isEmpty())
            throw new NoSuchElementException();
        T temp = elements[--current];
        elements[current] = null;
        return temp;
    }

    public boolean isFull() {
        return current == elements.length;
    }

    /**
     * inserts an element to my stack
     *
     * @param elem generic
     */
    public void push(T elem) {
        if (isFull()) {
            expand();
        }
        elements[current++] = elem;
    }

    /**
     * duplicates the size of my stack
     */
    private void expand() {
        elements = Arrays.copyOf(elements, elements.length * 2);
    }

    public int length() {
        return current;
    }
}
