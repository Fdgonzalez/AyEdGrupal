package TP03ArbolesColasYPilas;


import org.junit.Test;
import java.util.Iterator;

/**
 * TP 03: Integracion de Arboles, Pilas y Colas.
 * Por Facundo Gonzalez, Juan Manuel Lopez Gabeiras y Juan Gabriel Ricci
 *
 * Ejercicio 1.
 * Clase tester del Binary Search Tree.
 */
public class BinarySearchTreeTest {
    /* Example given:
             d
            / \
           c   i
          /   / \
         b   h   j
        /   /
       a   f
          / \
         e   g       */
    @Test
    public void test(){
        BinarySearchTree<Character> t = new BinarySearchTree<>(Character::compareTo);

        t.insert('d');
        t.insert('c');
        t.insert('b');
        t.insert('a');
        t.insert('i');
        t.insert('j');
        t.insert('h');
        t.insert('f');
        t.insert('g');
        t.insert('e');

        Iterator<Character> inOrder = t.inOrder();

        while(inOrder.hasNext())
            System.out.println(inOrder.next());
    }

}