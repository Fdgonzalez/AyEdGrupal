package TP01Listas.Sorts;

public abstract class Sort {
    public abstract void sort(Comparable[] a);
    protected void swap(Comparable[] a, int x, int y){
        Comparable temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
