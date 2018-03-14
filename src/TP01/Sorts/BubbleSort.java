package TP01.Sorts;


public class BubbleSort extends Sort{
    public void sort(int[] a){
        boolean flag = true;
        while(flag){
            flag = false;
            for(int i=0;i<a.length-1;i++){
                if(a[i+1] < a[i]) {
                    swap(a, i, i + 1);
                    flag = true;
                }
            }
        }
    }

}
