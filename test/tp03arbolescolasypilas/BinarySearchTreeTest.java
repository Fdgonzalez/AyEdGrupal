package tp03arbolescolasypilas;


import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

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
        char[] result = new char[10];
        char[] expected = {'a','b','c','d','e','f','g','h','i','j'};
        int i =0;
        while(inOrder.hasNext())
           result[i++] = inOrder.next();
        assertArrayEquals(expected,result);
    }
}