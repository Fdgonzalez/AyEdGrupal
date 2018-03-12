package TP01;

import java.util.Arrays;

import static TP01.Ejercicios.*;
import static org.junit.Assert.*;

public class EjerciciosTest {


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

    @org.junit.Test
    public void selectionSortTest() {
        int[] array = {6,8,1,4,12,10,14};
        selectionSort(array);
        assertEquals("[1, 4, 6, 8, 10, 12, 14]",Arrays.toString(array));
    }
    @org.junit.Test
    public void insertionSortTest(){
        int[] array = {6,8,1,4,12,10,14};
        insertionSort(array);
        assertEquals("[1, 4, 6, 8, 10, 12, 14]",Arrays.toString(array));
    }
}