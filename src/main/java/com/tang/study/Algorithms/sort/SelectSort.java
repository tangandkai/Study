package com.tang.study.Algorithms.sort;

public class SelectSort{

    public int[] sort(int[] a){
        int temp = -1;
        for (int i=0;i<a.length;i++){
            for (int j=i+1;j<a.length;j++){
                if (a[i]<a[j]){
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }

    public int[] solution(int[] a){
        for (int i=0;i<a.length;i++){
            int max = a[i];
            int index = i;
            for (int j=i+1;j<a.length;j++){
                if (max<a[j]){
                    index = j;
                    max = a[j];
                }
            }
            int tmp = a[i];
            a[i] = max;
            a[index] = tmp;
        }
        return a;
    }
    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        int[] arr = new int[]{5,3,9,0,1,2,4,8,6,7,1,3,6};
        int[] a = selectSort.solution(arr);
        for (int x:a){
            System.out.println(x);
        }
//        for (int x:arr){
//            System.out.println(x);
//        }
        System.out.println(a==arr);
    }
}
