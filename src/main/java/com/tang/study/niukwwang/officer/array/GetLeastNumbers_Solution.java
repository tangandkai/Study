package com.tang.study.niukwwang.officer.array;

import java.util.ArrayList;

/**
 * 获取数组中最小的k个数
 */
public class GetLeastNumbers_Solution {

    public static void main(String[] args) {
        int[] input = new int[]{4,5,1,6,2,7,3,8};
        ArrayList<Integer> result = solution(input, 4);
        System.out.println(result);
    }

    public static ArrayList<Integer> solution(int[]input,int k){
        ArrayList<Integer> array = new ArrayList<>();
        if(input.length<k ||k==0|| input.length==0){return array;}
        int index = -1;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<k;i++){
            for(int j=0;j<input.length;j++){
                if(input[j]<min){
                    min = input[j];
                    index = j;
                }
            }
            input[index] = Integer.MAX_VALUE;
            array.add(min);
            min = Integer.MAX_VALUE;
        }
        return array;
    }
}
