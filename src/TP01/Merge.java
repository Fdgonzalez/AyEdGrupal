package TP01;

import java.util.Arrays;

/**
 * Given 2 sorted collections, merge them and return a new sorted collection.
 * The collections must be comparable.
 *
 */
public class Merge {
    public static Comparable[] merge(Comparable[] arrayA, Comparable[] arrayB) {
        int i = 0; //arrayA iteration index
        int j = 0; //arrayB iteration index
        Comparable[] arrayC = new Comparable[arrayA.length + arrayB.length];
        int k = 0; //arrayC iteration index
        while(k <= arrayC.length - 1) {
            if(i >= arrayA.length){
                while(j < arrayB.length)
                    arrayC[k++] = arrayB[j++];
                return arrayC;
            }
            if(j >= arrayB.length)
                while(i < arrayA.length)
                    arrayC[k++] = arrayA[i++];
            if(arrayA[i].compareTo(arrayB[j]) <= 0)
                arrayC[k++] = arrayA[i++];
             else
                arrayC[k++] = arrayB[j++];
        }
        return arrayC;
    }
}
