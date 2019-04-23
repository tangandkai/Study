package com.tang.study.Algorithms.sort;

public class InsertSort {

    public void sort(int[] a){

        if(a.length<=1){
            return;
        }
        int current = -1;
        for (int i=1;i<a.length;i++){
            current = a[i];
            int curIndex = i;
            while (curIndex>=1 && a[curIndex-1]>current){
                a[curIndex] = a[curIndex-1];
                curIndex--;
            }
            a[curIndex] = current;
        }
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] arr = new int[]{5,3,9,0,1,2,4,8,6,7};
        insertSort.sort(arr);
        for (int a:arr){
            System.out.println(a);
        }
    }
}
