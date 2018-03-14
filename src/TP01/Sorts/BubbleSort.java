package TP01.Sorts;


public class BubbleSort extends Sort{
    public void sort(Comparable[] a){
        boolean flag = true;
        while(flag){
            flag = false;
            for(int i=0;i<a.length-1;i++){
                if(a[i+1].compareTo(a[i]) < 0) {
                    swap(a, i, i + 1);
                    flag = true;
                }
            }
        }
    }

}
