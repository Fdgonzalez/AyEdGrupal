package TP01Listas;

import TP01Listas.Sorts.BubbleSort;
import TP01Listas.Sorts.InsertionSort;
import TP01Listas.Sorts.SelectionSort;
import TP01Listas.Sorts.Sort;

import java.util.Arrays;

import static TP01Listas.Sorts.Sorts.*;
import static org.junit.Assert.*;

public class SortsTest {
    @org.junit.Test
    public void selectionSortTest() {
        Integer[] array = {6,8,1,4,12,10,14};
        Sort s = new SelectionSort();
        s.sort(array);
        assertEquals("[1, 4, 6, 8, 10, 12, 14]", Arrays.toString(array));
    }
    @org.junit.Test
    public void recursiveSelectionSortTest() {
        Integer[] array = {6,8,1,4,12,10,14};
        SelectionSort s = new SelectionSort();
        s.sortRecursive(array);
        assertEquals("[1, 4, 6, 8, 10, 12, 14]", Arrays.toString(array));
    }
    @org.junit.Test
    public void insertionSortTest(){
        Integer[] array = {6,8,1,4,12,10,14};
        Sort s = new InsertionSort();
        s.sort(array);
        assertEquals("[1, 4, 6, 8, 10, 12, 14]", Arrays.toString(array));
    }
    @org.junit.Test
    public void bubbleSortTest(){
        Integer[] array = {6,8,1,4,12,10,14};
        Sort s = new BubbleSort();
        s.sort(array);
        assertEquals("[1, 4, 6, 8, 10, 12, 14]", Arrays.toString(array));
    }
    @org.junit.Test
    public void generateRandomTest(){
        System.out.println(Arrays.toString(generateRandom(10)));
    }
}