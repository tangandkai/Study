package com.tang.study.niukwwang.officer.collection;

import java.util.HashMap;
import java.util.Map;

public class duplicate {

    public static void main(String[] args) {

    }

    public static boolean solution(int numbers[],int length,int [] duplication){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<length;i++){
            if (map.containsKey(numbers[i])){
                duplication[0] = numbers[i];
                return true;
            }
            else {
                map.put(numbers[i],1);
            }
        }
        return false;
    }
}
