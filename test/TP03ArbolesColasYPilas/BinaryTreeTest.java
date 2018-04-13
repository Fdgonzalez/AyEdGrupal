package TP03ArbolesColasYPilas;


import org.junit.Test;
import java.util.Iterator;

/**
 * TP 03: Integracion de Arboles, Pilas y Colas.
 * Por Facundo Gonzalez, Juan Manuel Lopez Gabeiras y Juan Gabriel Ricci
 *
 * Ejercicio 2.
 * Clase tester del Binary Tree generico construyendo un arbol manualmente.
 */
public class BinaryTreeTest {
    /* Example given:
             F
            / \--¬
           B      G
          / \      \
         A   D      I
            / \    /
           C   E  H       */
    @Test
    public void inOrder() {
        BinaryTree<Character> tree = new BinaryTree<Character>('D');
        tree.insertRight('G');
        BinaryTree<Character> right1 = tree.rightChild();
        right1.insertRight('I');
        right1.rightChild().insertLeft('H');
        tree.insertLeft('B');
        BinaryTree<Character> left1 = tree.leftChild();
        left1.insertLeft('A');
        left1.insertRight('D');
        left1.rightChild().insertRight('E');
        left1.rightChild().insertLeft('C');

        Iterator<Character> postIt = tree.postOrder();
        Iterator<Character> preIt = tree.preOrder();
        Iterator<Character> inOrderIt = tree.inOrder();

        while(inOrderIt.hasNext()) System.out.print(inOrderIt.next());  // ABCDEFGHI

        System.out.println();

        while(preIt.hasNext()) System.out.print(preIt.next()); // FBADCEGIH

        System.out.println();

        while(postIt.hasNext()) System.out.print(postIt.next());  // ACEDBHIGF
    }
}