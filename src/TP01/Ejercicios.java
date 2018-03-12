package TP01;

import java.util.Arrays;
import java.util.Random;

public class Ejercicios {
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
    public static void swap(int[] a, int x, int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
    public static void selectionSort(int[] a){
        int count = 0;
        while(count < a.length - 2){
            int min = count;
            for(int i=count;i<a.length;i++){
                if(a[i] < a[min])
                    min = i;
            }
            swap(a,count++,min);
        }
    }
    public static void insertionSort(int[] a){
        int count = 1;
        while(count < a.length){
            int i = count++;
            while(i > 0 && a[i-1] > a [i]) {
                swap(a, i, i - 1);
                i--;
            }
        }
    }
    public static int[] generateRandom(int n){
        int[] result = new int[n];
        Random random = new Random();
        for(int i=0;i<n;i++){
            result[i] = random.nextInt();
        }
        return result;
    }
    public static void main(String[] args) {
    }
}
