
package TP03ArbolesColasYPilas;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * TP 03: Integracion de Arboles, Pilas y Colas.
 * Por Facundo Gonzalez, Juan Manuel Lopez Gabeiras y Juan Gabriel Ricci
 * Clase Arbol Binario con Nodos Dobles.
 * @param <T> generic
 */
public class BinaryTree<T> {
    private DoubleNode<T> root;

    /**
     * Constructor vacio
     */
    public BinaryTree() {
        this.root = null;
    }

    /**
     * Creates a tree with value but no child
     * @param value of root
     */
    public BinaryTree(T value) {
        root = new DoubleNode<>();
        this.root.value = value;
    }
    private BinaryTree(DoubleNode<T> root){
        this.root = root;
    }
    /**
     * Creates a complete tree
     * @param value of root
     * @param left child
     * @param right child
     */
    public BinaryTree(T value, DoubleNode<T> left, DoubleNode<T> right) {
        this.root.value = value;
        this.root.left = left;
        this.root.right = right;
    }

    /**
     * @return whether the tree is empty
     */
    public boolean isEmpty() {
        return this.root == null;
    }
    public void insertRight(T elem){
        root.right = new DoubleNode<T>();
        root.right.value = elem;
    }
    public void insertLeft(T elem){
        root.left = new DoubleNode<T>();
        root.left.value = elem;
    }
    /**
     * @return gives the left child of this tree
     */
    public BinaryTree<T> leftChild() {
        BinaryTree<T> temp = new BinaryTree<T>();
        temp.root = this.root.left;
        return temp;
    }

    /**
     * @return gives the right child of this tree
     */
    public BinaryTree<T> rightChild() {
        BinaryTree<T> temp = new BinaryTree<T>();
        temp.root = this.root.right;
        return temp;
    }
    public void printLevel(int level){
        if(isEmpty())
            return;
        if(level == 1)
            System.out.print(root.value.toString());
        else{
            leftChild().printLevel(level - 1);
            rightChild().printLevel(level - 1);
        }
    }
    public int height(){
        if(isEmpty())
            return 0;
        int left = leftChild().height();
        int right = rightChild().height();

        return 1 + Math.max(left,right);
    }
    public void printByLevel(){
        for(int i = 1; i <= height();i++){
            printLevel(i);
        }
        System.out.println();
    }
    public Iterator<T> inOrder(){
        return new Iterator<T>() {
            private Queue<T> queue = null;
            private BinaryTree<T> tree = new BinaryTree<>(root);
            private void generateQueue(BinaryTree<T> tree){
                if(tree.isEmpty())
                    return;
                generateQueue(tree.leftChild());
                if(queue == null)//TODO: Reemplazar la cola con la nuestra
                    queue = new LinkedBlockingQueue<>();
                queue.add(tree.root.value);
                generateQueue(tree.rightChild());
            }
            @Override
            public boolean hasNext() {
                if(queue == null)
                    generateQueue(tree);
                return !queue.isEmpty();
            }

            @Override
            public T next() {
                if(queue == null)
                    generateQueue(tree);
                return queue.poll();
            }
        };
    }
    /**
     * Double Node nested class
     * @param <T> generic
     */
    private class DoubleNode<T> {
        T value;
        DoubleNode<T> left, right;
    }
}
