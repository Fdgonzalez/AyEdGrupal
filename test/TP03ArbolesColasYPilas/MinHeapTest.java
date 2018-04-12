package TP03ArbolesColasYPilas;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinHeapTest {
    @Test
    public void minHeapTest() throws HeapFullException {
        MinHeap<Character> hippie = new MinHeap<Character>(100);
        hippie.insert('c',1);
        hippie.insert('a',0);
        hippie.insert('e',4);
        hippie.insert('d',2);
        hippie.insert('b',0.1);
        for(int i=0;i<5;i++){
            System.out.println(hippie.getMin());
        }
    }

}