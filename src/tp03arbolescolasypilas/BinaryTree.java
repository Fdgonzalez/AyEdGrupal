package tp03arbolescolasypilas;


import java.util.Iterator;


/**
 * TP 03: Integracion de Arboles, Pilas y Colas.
 * Por Facundo Gonzalez, Juan Manuel Lopez Gabeiras y Juan Gabriel Ricci
 *
 * Ejercicio 2.
 * Clase Arbol Binario con Nodos Dobles.
 *
 * @param <T> generic
 */
public class BinaryTree<T> {
    protected DoubleNode root;

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
        root = new DoubleNode();
        this.root.value = value;
    }

    /**
     * constructor with root
     * @param root double node
     */
    private BinaryTree(DoubleNode root){
        this.root = root;
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
    }

    /**
     * @return whether the tree is empty
     */
    public boolean isEmpty() {
        return this.root == null;
    }
    public BinaryTree<T> getTree(){
        return this;
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
     * exercise 1
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
            private BinaryTree<T> tree = getTree();

            private void generateQueue(BinaryTree<T> tree){
                if(tree.isEmpty()) return;
                generateQueue(tree.leftChild());
                if(queue == null) queue = new Queue<T>();
                queue.enqueue(tree.getRoot());
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
            private BinaryTree<T> tree= getTree();
            private Queue<T> queue;

            void generateQueue(BinaryTree<T> current){
                if (current.isEmpty()) return;
                if(queue == null)
                    queue = new Queue<T>();
                queue.enqueue(current.getRoot());
                generateQueue(current.leftChild());
                generateQueue(current.rightChild());
            }

            @Override
            public boolean hasNext() {
                if (queue == null) {
                 generateQueue(tree);
                }
                return !queue.isEmpty();
            }

            @Override
            public T next() {
                if (queue == null) {
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
            private BinaryTree<T> tree=getTree();
            private Queue<T> queue;

            void generateQueue(BinaryTree<T> current){
                if (current.isEmpty()) return;
                generateQueue(current.leftChild());
                generateQueue(current.rightChild());
                if(queue == null)
                    queue = new Queue<>();
                queue.enqueue(current.getRoot());
            }

            @Override
            public boolean hasNext() {
                if (queue == null) {
                 generateQueue(tree);
                }
                return !queue.isEmpty();
            }

            @Override
            public T next() {
                if (queue == null) {
                    generateQueue(tree);
                }
                return queue.dequeue();
            }
        };
    }

    public T getRoot(){
        return root.value;
    }

    /**
     * Double Node nested class
     */
    protected class DoubleNode {
        T value;
        DoubleNode left, right;
    }
}
