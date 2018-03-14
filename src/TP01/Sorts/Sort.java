package TP01.Sorts;

public abstract class Sort {
    public abstract void sort(int[] a);
    protected void swap(int[] a, int x, int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
