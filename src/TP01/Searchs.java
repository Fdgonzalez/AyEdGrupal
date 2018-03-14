package TP01;

import java.util.Random;

public class Searchs {
    /*Ejercicio 1
    Modificar los algoritmos de búsqueda secuencial y búsqueda binaria de manera que devuelva
    la posición en donde se encuentra el valor a buscar. Tener en cuenta que el elemento a buscar
    puede no pertenecer al conjunto.
    */
    public static int binSearch(int[] a, int first, int last, int k){
        int mid = (first + last) /2;
        if(k == a[mid])
            return mid;
        if(last == first)
            return -1;
        if(k < a[mid])
            return binSearch(a,first,mid-1,k);
        return binSearch(a,mid+1,last ,k);
    }
    public static int seqSearch(int[] a,int k) {
        for (int i = 0; i < a.length; i++)
            if (a[i] == k)
                return k;
        return -1;
    }
}
