package TP03ArbolesColasYPilas;

import java.util.NoSuchElementException;

public class Queue<T> {
    private Node tail;
    public Queue(){
        tail = null;
    }
    public void enqueue(T elem){
        Node temp = new Node(elem);
        if(tail == null) {
            tail = temp;
            return;
        }
        temp.prev = tail;
        tail.next = temp;
        tail = temp;
    }
    public T dequeue(){
        if(isEmpty())
            throw new NoSuchElementException();
       T temp = tail.elem;
       tail = tail.prev;//hace null a tail cuando es el ultimo elemento
       if(tail != null)
        tail.next = null;
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
