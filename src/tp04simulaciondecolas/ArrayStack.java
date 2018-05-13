package tp04simulaciondecolas;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayStack<T> {
    private T[] elements;
    private int current;
    private final int defaultSize = 10;
    @SuppressWarnings("unchecked")
    public ArrayStack(int maxSize){
        elements = (T[]) new Object[maxSize];
        current = 0;
    }
    public boolean isEmpty(){
        return current == 0;
    }

    public T pop(){
        if(isEmpty())
            throw new NoSuchElementException();
        T temp = elements[--current];
        elements[current] = null;
        return temp;
    }
    public boolean isFull(){
        return current == elements.length;
    }
    public void push(T elem){
        if(isFull()){
            expand();
        }
        elements[current++] = elem;
    }
    private void expand(){
        elements = Arrays.copyOf(elements,elements.length * 2);
    }

    public int length() {
        return current;
    }
}
