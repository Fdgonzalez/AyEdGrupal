package TP03ArbolesColasYPilas;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class BinaryTreeTest {

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
        Iterator<Character> it = tree.inOrder();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}