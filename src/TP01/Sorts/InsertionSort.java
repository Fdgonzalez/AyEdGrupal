package TP01.Sorts;

public class InsertionSort extends Sort{
    public void sort(int[] a){
        int count = 1;
        while(count < a.length){
            int i = count++;
            while(i > 0 && a[i-1] > a [i]) {
                swap(a, i, i - 1);
                i--;
            }
        }
    }
}
