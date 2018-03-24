package TP01Listas;

import static TP01Listas.Searchs.binSearch;
import static org.junit.Assert.*;

public class SearchsTest {
    @org.junit.Test
    public void binSearchTest() {
        int[] array = {1,4,6,8,10,12,14};
        assertEquals(4,binSearch(array,0,array.length,10));
    }

    @org.junit.Test
    public void seqSearch() {
        int[] array = {1,4,6,8,10,12,14};
        assertEquals(4,binSearch(array,0,array.length,10));
    }

}