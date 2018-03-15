package TP01;

import java.util.Arrays;

/**
 * Given 2 sorted collections, merge them and return a new sorted collection.
 * The collections must be comparable.
 *
 * Todo: falta comprobar que lista a o b ya dio todos los elementos y tirar todos los del otro a c
 */
public class Merge {
    public static Comparable[] mergeSort(Comparable[] arrayA, Comparable[] arrayB) {
        boolean flag = true;
        int i = 0; //arrayA iteration index
        int j = 0; //arrayB iteration index
        Comparable[] arrayC = new Comparable[arrayA.length + arrayB.length];
        int k = 0; //arrayC iteration index
        while(flag) {
            System.out.println("arrayA: " + Arrays.toString(arrayA) + "\n" +
                    "arrayB: " + Arrays.toString(arrayB) + "\narrayC: " + Arrays.toString(arrayC));
            int comparation = arrayA[i].compareTo(arrayB[j]);
            if(comparation <= 0) {
                arrayC[k] = arrayA[i];
                if(i < arrayA.length - 1){
                    i++;
                    k++;
                } else k++;
            } else {
                arrayC[k] = arrayB[j];
                if(j < arrayB.length - 1) {
                    j++;
                    k++;
                } else {
                    k++;
                }
            }
            if(k+1 == arrayC.length) flag = false;
        }
        return arrayC;
    }


    public static void main(String[] args) {
        Integer[] arrayA = {1, 2, 3};
        Integer[] arrayB = {2, 4};
        Integer[] resultArray = {1, 2, 2, 3, 4};
        mergeSort(arrayA, arrayB);
    }
}
