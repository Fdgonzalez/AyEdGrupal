package TP03ArbolesColasYPilas;


import java.util.Iterator;


/**
 * TP 03: Integracion de Arboles, Pilas y Colas.
 * Por Facundo Gonzalez, Juan Manuel Lopez Gabeiras y Juan Gabriel Ricci
 *
 * Clase Arbol Binario con Nodos Dobles.
 * TODO: queue.
 * TODO: binary tree test!!
 * TODO: separate ex1 and ex2 ?
 *
 * @param <T> generic
 */
public class BinaryTree<T> {
    private DoubleNode root;
    private int size;

    /**
     * Constructor vacio
     */
    public BinaryTree() {
        this.root = null;
        this.size = 0;
    }

    /**
     * Creates a tree with value but no child
     * @param value of root
     */
    public BinaryTree(T value) {
        root = new DoubleNode();
        this.root.value = value;
        this.size = 1;
    }

    /**
     * constructor with root
     * @param root double node
     */
    private BinaryTree(DoubleNode root, int size){
        this.root = root;
        this.size = size;
    }

    /**
     * Creates a complete tree specified
     * @param value of root
     * @param left child
     * @param right child
     */
    public BinaryTree(T value, DoubleNode left, DoubleNode right, int size) {
        this.root.value = value;
        this.root.left = left;
        this.root.right = right;
        this.size = size;
    }

    /**
     * @return whether the tree is empty
     */
    public boolean isEmpty() {
        return this.root == null;
    }

    /**
     * @param elem generic
     */
    public void insertRight(T elem){
        root.right = new DoubleNode();
        root.right.value = elem;
    }

    /**
     * @param elem generic
     */
    public void insertLeft(T elem){
        root.left = new DoubleNode();
        root.left.value = elem;
    }

    /**
     * @return gives the left child of this tree
     */
    public BinaryTree<T> leftChild() {
        BinaryTree<T> temp = new BinaryTree<>();
        temp.root = this.root.left;
        return temp;
    }

    /**
     * @return gives the right child of this tree
     */
    public BinaryTree<T> rightChild() {
        BinaryTree<T> temp = new BinaryTree<>();
        temp.root = this.root.right;
        return temp;
    }

    /**
     * @param level int
     */
    public void printLevel(int level){
        if(isEmpty()) return;
        if(level == 1) System.out.print(root.value.toString());
        else {
            leftChild().printLevel(level - 1);
            rightChild().printLevel(level - 1);
        }
    }

    /**
     * @return int
     */
    public int height(){
        if(isEmpty()) return 0;
        int left = leftChild().height();
        int right = rightChild().height();
        return 1 + Math.max(left,right);
    }

    /**
     * prints
     */
    public void printByLevel(){
        for(int i = 1; i <= height();i++){
            printLevel(i);
        }
        System.out.println();
    }

    /**
     * @return
     */
    public Iterator<T> inOrder(){
        return new Iterator<T>() {
            private Queue<T> queue = null;
            private BinaryTree<T> tree = new BinaryTree<>(root);

            private void generateQueue(BinaryTree<T> tree){
                if(tree.isEmpty()) return;
                generateQueue(tree.leftChild());
                if(queue == null) queue = new Queue<T>();
                queue.enqueue(tree.root.value);
                generateQueue(tree.rightChild());
            }

            @Override
            public boolean hasNext() {
                if(queue == null) {
                   generateQueue(tree);
                }
                return !queue.isEmpty();
            }

            @Override
            public T next() {
                if(queue == null) {
                    generateQueue(tree);
                }
                return queue.dequeue();
            }
        };
    }

    /**
     * pre order: <root><left><right>
     * @return pre order iterator
     */
    public Iterator<T> preOrder() {
        return new Iterator<T>() {
            private BinaryTree<T> tree= new BinaryTree<T>(root.value, root.left, root.right);
            private Queue<T> queue;

            void generateQueue(BinaryTree<T> current){
                if (tree.isEmpty()) return;
                if(queue == null)
                    queue = new Queue<T>();
                queue.enqueue(current.root.value);
                generateQueue(current.leftChild());
                generateQueue(current.rightChild());
            }

            @Override
            public boolean hasNext() {
                if (queue.isEmpty()) {
                 generateQueue(tree);
                }
                return !queue.isEmpty();
            }

            @Override
            public T next() {
                if (queue.isEmpty()) {
                    generateQueue(tree);
                }
                return queue.dequeue();
            }
        };
    }

    /**
     * pre order: <left><right><root>
     * @return pre order iterator
     */
    public Iterator<T> postOrder() {
        return new Iterator<T>() {
            private BinaryTree<T> tree= new BinaryTree<T>(root.value, root.left, root.right);
            private Queue<T> queue;

            void generateQueue(BinaryTree<T> current){
                if (tree.isEmpty()) return;
                generateQueue(current.leftChild());
                generateQueue(current.rightChild());
                //if(queue == null)
               //     queue = new Queue();
             //   queue.enqueue(current.root.value);
            }

            @Override
            public boolean hasNext() {
                if (queue.isEmpty()) {
                 generateQueue(tree);
                }
                return !queue.isEmpty();
            }

            @Override
            public T next() {
                if (queue.isEmpty()) {
                    generateQueue(tree);
                }
                return queue.dequeue();
            }
        };
    }

    /**
     * Double Node nested class
     */
    private class DoubleNode {
        T value;
        DoubleNode left, right;
    }
}
