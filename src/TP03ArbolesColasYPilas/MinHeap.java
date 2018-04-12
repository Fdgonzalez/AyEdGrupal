package TP03ArbolesColasYPilas;

import java.lang.reflect.Array;

public class MinHeap<T>{
    private Element[] heap;
    int current,max;
    //left = 2i + 1
    // right = 2i+ 2
    //parent = (i-1)/2
    @SuppressWarnings("unchecked")
    public MinHeap(int max){
        heap = (Element[]) Array.newInstance(Element.class,max);
        this.max = max;
    }
    public T getMin(){
        T temp = heap[0].value;
        swap(--current,0);
        heap[current] = null;
        minHeapify(0);
        return temp;
    }
    private int left(int pos){
        return 2*pos + 1;
    }
    private int right(int pos){
        return 2*pos + 2;
    }
    private void minHeapify(int pos) {
        if(isLeaf(pos) || pos >= current)
            return;//TODO: ACAAAAAAA si el right es null solo chequea con el left sino EXPLOTA EXPLOTA QUE EXPLO! EXPLOTA EXPLOTA
        if(heap[pos].priority <= heap[left(pos)].priority &&
        heap[pos].priority <= heap[right(pos)].priority)
            return;
        if(heap[left(pos)].priority < heap[right(pos)].priority){
            swap(left(pos),pos);
            minHeapify(left(pos));
            return;
        }
        swap(right(pos),pos);
        minHeapify(right(pos));
    }
    private boolean isLeaf(int pos) {
        return left(pos) >= current;
    }

    public void insert(T value, double priority) throws HeapFullException {
        if(current >= max)
            throw new HeapFullException();
        Element temp = new Element(value,priority);
        heap[current] = temp;
        correct(current++);
    }

    public void correct(int pos){
        if(pos == 0 || heap[pos].priority >= heap[(pos - 1)/ 2].priority)
            return;
        swap(pos,(pos-1)/2);
        correct((pos-1)/2);
    }
    private void swap(int a, int b) {
        Element temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    private class Element{
        T value;
        double priority;
        public Element(T value, double priority){
            this.value = value;
            this.priority = priority;
        }
    }
}
