package TP03ArbolesColasYPilas;

import java.util.Comparator;

public class BinarySearchTree<T> extends BinaryTree<T>{
    private Comparator<T> comparator;
    public BinarySearchTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }
    public void insert(T element){
        root = insert(element, root);
    }
    private DoubleNode insert(T element, DoubleNode t){
        if(t == null) {
            t = new DoubleNode();
            t.value = element;
        }
        int comparison = comparator.compare(t.value,element);
        if(comparison == 0){
            t.value = element;
        }else if(comparison > 0){
            t.left = insert(element,t.left);
        }else{
            t.right = insert(element,t.right);
        }
        return t;
    }
    public boolean exists(T element){
        return exists(element, root);
    }
    public T search(T element){
        return search(element, root);
    }

    private T search(T element, DoubleNode t) {
        if(t == null)
            return null;
        int comparison = comparator.compare(t.value,element);
        if(comparison == 0)
            return t.value;
        if(comparison < 0){
            return search(element,t.right);
        }else
            return search(element,t.left);
    }

    private boolean exists(T element,DoubleNode t){
        if(t == null)
            return false;
        int comparison = comparator.compare(t.value,element);
        if(comparison == 0)
            return true;
        else if(comparison < 0)
            return exists(element,t.right);
        else
            return exists(element,t.left);
    }
    private T getMin(DoubleNode t){
        if(t == null)
            return null;
        if(t.left == null)
            return t.value;
        return getMin(t.left);
    }
    public T getMin(){
        return getMin(root);
    }
    public T getMax(){
        return getMax(root);
    }

    private T getMax(DoubleNode t) {
        if(t == null)
            return null;
        if(t.right == null)
            return t.value;
        return getMax(t.right);
    }

}
