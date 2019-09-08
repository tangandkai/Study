package com.tang.study.niukwwang.officer.array;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ChangeArrayIndex {

    public void solution(int[] array){
        int low = 0;
        int tmp = array[low];
        int high = array.length-1;
        while (low<high){
            while (array[high]%2==0)
                high--;
            array[low] = array[high];
            while (array[low]%2!=0){
                low++;
            }
            array[high] = array[low];
        }
    }

    public void solution_1(int[] array){
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        for (int i=0;i<array.length;i++){
            if (array[i]%2!=0)
                listA.add(array[i]);
            else
                listB.add(array[i]);
        }
        listA.addAll(listB);
        System.out.println(listA);
        for (int i=0;i<listA.size();i++){
            array[i] = listA.get(i);
        }
    }

    @Test
    public void test(){
        solution_1(new int[]{1,2,3,4,5,6,7,8,9});
    }
}
