package TP03ArbolesColasYPilas;


import java.util.Comparator;

/**
 * TP 03: Integracion de Arboles, Pilas y Colas.
 * Por Facundo Gonzalez, Juan Manuel Lopez Gabeiras y Juan Gabriel Ricci
 *
 * Ejercicio 1.
 * Clase Binary Search Tree with double nodes.
 *
 * @param <T>
 */
public class BinarySearchTree<T> extends BinaryTree<T>{
    private Comparator<T> comparator;

    /**
     * constructor
     * @param comparator comparation condition for the generic elements
     */
    public BinarySearchTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    /**
     * @param element generic
     */
    public void insert(T element){
        root = insert(element, root);
    }

    /**
     * insert auxiliary
     * @param element generic
     * @param t current node
     * @return corrected node (this is recursive)
     */
    private DoubleNode insert(T element, DoubleNode t){
        if(t == null) {
            t = new DoubleNode();
            t.value = element;
        }
        int comparison = comparator.compare(t.value,element);
        if(comparison == 0) t.value = element;
        else if(comparison > 0) t.left = insert(element,t.left);
        else t.right = insert(element,t.right);
        return t;
    }

    /**
     * @param element generic
     * @return the element searched or null if not contained.
     */
    public T search(T element){
        return search(element, root);
    }

    /**
     * search auxiliary
     * @param element generic
     * @param t current node
     * @return recursive search starting in root
     */
    private T search(T element, DoubleNode t) {
        if(t == null) return null;
        int comparison = comparator.compare(t.value, element);
        if(comparison == 0) return t.value;
        if(comparison < 0) return search(element, t.right);
        else return search(element, t.left);
    }

    /**
     * @param element generic
     * @return boolean whether element is on my tree
     */
    public boolean contains(T element) {
        return contains(element, root);
    }

    /**
     * contains helper, is recursive
     * @param element generic
     * @param t current node to search
     * @return boolean whether element is in current node.
     */
    private boolean contains(T element,DoubleNode t){
        if(t == null) return false;
        int comparison = comparator.compare(t.value, element);
        if(comparison == 0) return true;
        else if(comparison < 0) return contains(element, t.right);
        else return contains(element, t.left);
    }

    /**
     * @return the least value on my tree
     */
    public T getMin(){
        return getMin(root);
    }

    /**
     * recursive getMin auxiliary
     * @param t generic
     * @return if left is null, parent is the least in the node
     */
    private T getMin(DoubleNode t){
        if(t == null) return null;
        if(t.left == null) return t.value;
        return getMin(t.left);
    }

    /**
     * @return the bigger value, is on the rightest child.
     */
    public T getMax(){
        return getMax(root);
    }

    /**
     * recursive getMax auxiliary
     * @param t current node to check
     * @return if child is null, the parent is the biggest value in the node.
     */
    private T getMax(DoubleNode t) {
        if(t == null)
            return null;
        if(t.right == null)
            return t.value;
        return getMax(t.right);
    }

}
