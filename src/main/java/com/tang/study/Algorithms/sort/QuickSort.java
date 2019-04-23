package com.tang.study.Algorithms.sort;

public class QuickSort {

    public int sort(int[] a,int low,int high){
        int pivotValue = a[low];
        if (a.length<=1){
            return -1;
        }
        while (low<high){
            while (low<high && a[high]>=pivotValue)
                high--;
            a[low] = a[high];
            while (low<high && a[low]<=pivotValue)
                low++;
            a[high] = a[low];
        }
        a[low] = pivotValue;
        return low;
    }

    public void quickSort(int[] a,int low,int high){
        int pivotloc;
        if (low<high){
            pivotloc = sort(a,low,high);
            quickSort(a,low,pivotloc-1);
            quickSort(a,pivotloc+1,high);
        }

    }
    public static void main(String[] args) {

        QuickSort quickSort = new QuickSort();
        int[] arr = new int[]{5,3,9,0,1,2,4,8,6,7};
        quickSort.quickSort(arr,0,arr.length-1);
        for (int a: arr)
            System.out.println(a);
    }
}
