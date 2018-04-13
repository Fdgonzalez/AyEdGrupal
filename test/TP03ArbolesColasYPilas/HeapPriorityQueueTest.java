package TP03ArbolesColasYPilas;

import org.junit.Test;

public class HeapPriorityQueueTest {
    @Test
    public void minHeapTest() throws HeapFullException {
        HeapPriorityQueue<Character> hippie = new HeapPriorityQueue<Character>(100);

        hippie.enQueue('c',1);
        hippie.enQueue('a',0);
        hippie.enQueue('e',4);
        hippie.enQueue('d',2);
        hippie.enQueue('b',0.1);

        for(int i=0;i<5;i++){
            System.out.println(hippie.dequeue());
        }
    }

}