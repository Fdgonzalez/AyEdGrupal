package TP03ArbolesColasYPilas;


import java.lang.reflect.Array;


/**
 * TP 03: Integracion de Arboles, Pilas y Colas.
 * Por Facundo Gonzalez, Juan Manuel Lopez Gabeiras y Juan Gabriel Ricci
 *
 * Clase Heap Tree generico.
 *
 * @param <T> generic
 */
public class MinHeap<T> {
    private Element[] heap;
    private int current;
    private final int max;

    /**
     * constructor
     * @param max int
     */
    @SuppressWarnings("unchecked")
    public MinHeap(int max) {
        heap = (Element[]) Array.newInstance(Element.class, max);
        this.max = max;
    }

    /**
     * paradox: dequeue is for queues, this is heap, but is meant for queue
     * @return deletes and returns the first and lesser element
     */
    public T dequeue() {
        T temp = heap[0].value;
        swap(--current, 0);
        heap[current] = null;
        minHeapify(0);
        return temp;
    }

    /**
     * could be static
     * @param pos int
     * @return relative position int
     */
    private int left(int pos) {
        return 2 * pos + 1;
    }

    /**
     * could be static
     * @param pos int
     * @return relative position int
     */
    private int right(int pos) {
        return 2 * pos + 2;
    }

    /**
     * 3 variables because we want a visual and aesthetic sight
     * @param pos int
     */
    private void minHeapify(int pos) {
        double p = heap[pos].priority;
        double l = heap[left(pos)].priority;
        double r = heap[right(pos)].priority;

        if (isLeaf(pos) || pos >= current) return;
        if (heap[right(pos)] == null) {
            if (p >= l) {
                swap(left(pos), pos);
                minHeapify(left(pos));
            }
        } if (p >= r || p >= l) {
            if (l <= r) {
                swap(left(pos), pos);
                minHeapify(left(pos));
            } else {
                swap(right(pos), pos);
                minHeapify(right(pos));
            }
        }

    }

    /**
     * @param pos int
     * @return is this a leaf? does this has no child?
     */
    private boolean isLeaf(int pos) {
        return left(pos) >= current;
    }

    /**
     * @param value generic
     * @param priority priority to be attached to the generic element
     * @throws HeapFullException because we dont want to fix it
     */
    public void insert(T value, double priority) throws HeapFullException {
        if (current >= max) throw new HeapFullException();
        Element temp = new Element(value, priority);
        heap[current] = temp;
        correct(current++);
    }

    /**
     * is elem i well located
     * @param pos int
     */
    private void correct(int pos) {
        if (pos == 0 || heap[pos].priority >= heap[(pos - 1) / 2].priority)
            return;
        swap(pos, (pos - 1) / 2);
        correct((pos - 1) / 2);
    }

    /**
     * @param a int
     * @param b int
     */
    private void swap(int a, int b) {
        Element temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    /**
     * Generic element with a priotity double.
     */
    private class Element {
        T value;
        double priority;

        public Element(T value, double priority) {
            this.value = value;
            this.priority = priority;
        }
    }
}
