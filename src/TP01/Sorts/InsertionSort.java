package TP01.Sorts;


/**
 * Dado una coleccion de informacion comparable desordenada, el metodo insertion sort
 */
public class InsertionSort extends Sort{
    public void sort(Comparable[] a){
        int count = 1;
        while(count < a.length){
            int i = count++;
            while(i > 0 && a[i-1].compareTo( a[i] ) > 0) {
                swap(a, i, i - 1);
                i--;
            }
        }
    }
}
