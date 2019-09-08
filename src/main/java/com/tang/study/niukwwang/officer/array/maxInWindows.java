package com.tang.study.niukwwang.officer.array;

import java.util.ArrayList;


public class maxInWindows {

    public static void main(String[] args) {

        int[] array = new int[]{2,3,4,2,6,2,5,1};
        ArrayList<Integer> list = solution(array, 0);
        System.out.println(list);
    }

    public static ArrayList<Integer> solution(int [] num, int size){
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (size==0)
            return arrayList;
        int windowSize = num.length-size+1;
        for (int i=0;i<windowSize;i++){
            int index = i+size-1;
            int max = Integer.MIN_VALUE;
            while (index>=i){
                if (num[index]>max){
                    max = num[index];
                }
                index--;
            }
            arrayList.add(max);
        }
        return arrayList;
    }
}
