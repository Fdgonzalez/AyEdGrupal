/*
  TP 03: Integracion de Arboles, Pilas y Colas.
  Por Facundo Gonzalez, Juan Manuel Lopez Gabeiras y Juan Gabriel Ricci
 */
package TP03ArbolesColasYPilas;


/**
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
     * Double Node nested class
     * @param <T> generic
     */
    private class DoubleNode<T> {
        T value;
        DoubleNode<T> left, right;
    }
}
