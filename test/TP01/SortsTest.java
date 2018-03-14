package TP01;

import TP01.Sorts.BubbleSort;
import TP01.Sorts.InsertionSort;
import TP01.Sorts.SelectionSort;
import TP01.Sorts.Sort;

import java.util.Arrays;

import static TP01.Sorts.Sorts.*;
import static org.junit.Assert.*;

public class SortsTest {

    @org.junit.Test
    public void selectionSortTest() {
        int[] array = {6,8,1,4,12,10,14};
        Sort s = new SelectionSort();
        s.sort(array);
        assertEquals("[1, 4, 6, 8, 10, 12, 14]",Arrays.toString(array));
    }
    @org.junit.Test
    public void insertionSortTest(){
        int[] array = {6,8,1,4,12,10,14};
        Sort s = new InsertionSort();
        s.sort(array);
        assertEquals("[1, 4, 6, 8, 10, 12, 14]",Arrays.toString(array));
    }
    @org.junit.Test
    public void bubbleSortTest(){
        int[] array = {6,8,1,4,12,10,14};
        Sort s = new BubbleSort();
        s.sort(array);
        assertEquals("[1, 4, 6, 8, 10, 12, 14]", Arrays.toString(array));
    }
    @org.junit.Test
    public void generateRandomTest(){
        System.out.println(Arrays.toString(generateRandom(10)));
    }
}