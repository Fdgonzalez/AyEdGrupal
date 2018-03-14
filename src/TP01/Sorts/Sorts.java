package TP01.Sorts;

import java.util.Random;

public class Sorts {

    public static Integer[] generateRandom(int n){
        Integer[] result = new Integer[n];
        Random random = new Random();
        for(int i=0;i<n;i++){
            result[i] = random.nextInt() % 100;
        }
        return result;
    }
    public static long benchmarkSort(Sort s, Integer[] a){
        long start = System.nanoTime();
        s.sort(a);
        long end = System.nanoTime();
        return (end - start ); //return value in nanoseconds
    }
    public static long sortAverageHundredRuns(Sort s, int size){
        long sum = 0;
        for(int i=0;i<100;i++){
            sum += benchmarkSort(s,generateRandom(size));
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println("Average run time for ten arrays");
        System.out.println("Selection Sort");
        System.out.println("Length 10: " + sortAverageHundredRuns(new SelectionSort(),10));
        System.out.println("Length 100: " + sortAverageHundredRuns(new SelectionSort(),100));
        System.out.println("Length 1000: " + sortAverageHundredRuns(new SelectionSort(),1000));
        System.out.println("Insertion Sort");
        System.out.println("Length 10: " + sortAverageHundredRuns(new InsertionSort(),10));
        System.out.println("Length 100: " + sortAverageHundredRuns(new InsertionSort(),100));
        System.out.println("Length 1000: " + sortAverageHundredRuns(new InsertionSort(),1000));
        System.out.println("Bubble Sort");
        System.out.println("Length 10: " + sortAverageHundredRuns(new BubbleSort(),10));
        System.out.println("Length 100: " + sortAverageHundredRuns(new BubbleSort(),100));
        System.out.println("Length 1000: " + sortAverageHundredRuns(new BubbleSort(),1000));
    }
}
