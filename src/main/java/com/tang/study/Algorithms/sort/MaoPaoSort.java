package com.tang.study.Algorithms.sort;



public class MaoPaoSort {

    public int[] sort(int[] a){

        for (int i=0;i<a.length;i++){
            for (int j=0;j<a.length-1-i;j++){
                if (a[j]>a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        MaoPaoSort maoPaoSort = new MaoPaoSort();
        int[] arr = new int[]{5,3,9,0,1,2,4,8,6,7};
        maoPaoSort.sort(arr);
        for (int a:arr){
            System.out.println(a);
        }
    }
}
