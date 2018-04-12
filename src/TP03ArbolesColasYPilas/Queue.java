package TP03ArbolesColasYPilas;

public class Queue<T> {
    private Node root;
    private final int maxSize;

    @SuppressWarnings("unchecked")
    public Queue() {
        this.maxSize = maxSize;
    }

    @SuppressWarnings("unchecked")
    public Queue(int maxSize) {
        this.maxSize = maxSize;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void enqueue(T t) {

    }

    public T dequeue() {
        return null;
    }

    private class Node {
        T value;
        Node next;

        Node() {
            this.value = null;
            this.next = null;
        }

        Node(T value) {
            this.value = value;
        }

        Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
