package tp03arbolescolasypilas;


import org.junit.Test;

import java.util.Iterator;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

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
        BinaryTree<Character> tree = new BinaryTree<Character>('F');
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

        char[] result = new char[9];
        char[] expectedInOrder = {'A','B','C','D','E','F','G','H','I'};
        int i = 0;

        while(inOrderIt.hasNext())
            result[i++] = inOrderIt.next();
        assertArrayEquals(expectedInOrder,result);

        i=0;
        char[] expectedPreOrder = {'F','B','A','D','C','E','G','I','H'};
        while(preIt.hasNext())
            result[i++] = preIt.next();
        assertArrayEquals(expectedPreOrder,result);

        i=0;
        char[] expectedPostOrder = {'A','C','E','D','B','H','I','G','F'};
        while(postIt.hasNext())
            result[i++] = postIt.next();
        assertArrayEquals(expectedPostOrder,result);
    }
}