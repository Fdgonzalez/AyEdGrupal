
package TP03ArbolesColasYPilas;

import java.util.Iterator;
import java.util.Queue;

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
        this.root.value = value;
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

    /**
     * @return gives the left child of this tree
     */
    public BinaryTree leftChild() {
        BinaryTree temp = new BinaryTree();
        temp.root = this.root.left;
        return temp;
    }

    /**
     * @return gives the right child of this tree
     */
    public BinaryTree rightChild() {
        BinaryTree temp = new BinaryTree();
        temp.root = this.root.right;
        return temp;
    }

    /**
     * @param level
     */
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

    /**
     * @return
     */
    public int height(){
        if(isEmpty())
            return 0;
        int left = leftChild().height();
        int right = rightChild().height();

        return 1 + Math.max(left,right);
    }

    /**
     *
     */
    public void printByLevel(){
        for(int i = 1; i <= height();i++){
            printLevel(i);
        }
        System.out.println();
    }

    /**
     * pre order: <root><left><right>
     * @return pre order iterator
     */
    @SuppressWarnings("unchecked")
    public Iterator<T> preOrder() {
        return new Iterator<T>() {
            private BinaryTree<T> tree= new BinaryTree<T>(root.value, root.left, root.right);
            private Queue<T> queue;

            void generateQueue(BinaryTree<T> current){
                if (tree.isEmpty()) return;
                queue.add(current.root.value);
                generateQueue(current.leftChild());
                generateQueue(current.rightChild());
            }

            @Override
            public boolean hasNext() {
                if (queue.isEmpty()) generateQueue(tree);
                return !queue.isEmpty();
            }

            @Override
            public T next() {
                if (queue.isEmpty()) generateQueue(tree);
                return queue.poll();
            }
        };
    }

    /**
     * pre order: <left><right><root>
     * @return pre order iterator
     */
    @SuppressWarnings("unchecked")
    public Iterator<T> postOrder() {
        return new Iterator<T>() {
            private BinaryTree<T> tree= new BinaryTree<T>(root.value, root.left, root.right);
            private Queue<T> queue;

            void generateQueue(BinaryTree<T> current){
                if (tree.isEmpty()) return;
                generateQueue(current.leftChild());
                generateQueue(current.rightChild());
                queue.add(current.root.value);
            }

            @Override
            public boolean hasNext() {
                if (queue.isEmpty()) generateQueue(tree);
                return !queue.isEmpty();
            }

            @Override
            public T next() {
                if (queue.isEmpty()) generateQueue(tree);
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
