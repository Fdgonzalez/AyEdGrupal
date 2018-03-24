package TP01Listas.Sorts;


/**
 * Dado una coleccion de informacion comparable desordenada, el metodo selection sort
 */
public class SelectionSort extends Sort {
    public void sort(Comparable[] a) {
        int count = 0;
        while (count < a.length - 2) {
            int min = count;
            for (int i = count; i < a.length; i++) {
                if (a[i].compareTo(a[min]) < 0)
                    min = i;
            }
            if(count != min)
                swap(a, count, min);
            count++;
        }
    }
    public void sortRecursive(Comparable[] a){
        sortRecursiveHelper(a,0);
    }
    public void sortRecursiveHelper(Comparable[] a,int count) {
        if(count > a.length - 2)
            return;
        int min = count;
        for (int i = count; i < a.length; i++) {
            if (a[i].compareTo(a[min]) < 0)
                min = i;
        }
        if(count != min)
            swap(a,count,min);
        count++;
        sortRecursiveHelper(a, count);
    }
}
