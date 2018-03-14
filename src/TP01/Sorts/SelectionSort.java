package TP01.Sorts;


public class SelectionSort extends Sort{
    public void sort(int[] a){
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
}
