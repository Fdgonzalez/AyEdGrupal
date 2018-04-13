package TP03ArbolesColasYPilas;

import java.util.NoSuchElementException;

public class Queue<T> {
    private Node head;
    private Node tail;
    public Queue(){
        head = tail = null;
    }
    public void enqueue(T elem){
        Node temp = new Node(elem);
        if(head == null) {
            head = tail = temp;
            return;
        }
        temp.prev = tail;
        tail.next = temp;
        tail = temp;
    }
    public T dequeue(){
        if(isEmpty())
            throw new NoSuchElementException();
        T temp = head.elem;
        if(head != tail)
            head = head.next;
        else
            head = tail = null;
        return temp;
    }
    public boolean isEmpty(){
        return tail == null;
    }
    private class Node {
        private T elem;
        private Node next;
        private Node prev;
        public Node(T elem){
            this.elem = elem;
            prev = null;
            next = null;
        }
    }
}
