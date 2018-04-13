package TP03ArbolesColasYPilas;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    @Test
    public void test(){
        BinarySearchTree<Character> t = new BinarySearchTree<>(Character::compareTo);
        t.insert('a');
        t.insert('b');
        t.insert('d');
        t.insert('f');
        t.insert('c');
        t.insert('e');
        Iterator<Character> inOrder = t.inOrder();
        while(inOrder.hasNext())
            System.out.println(inOrder.next());
    }

}