package com.tang.study.test;

import java.io.*;
import java.util.*;

public class fileStream {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Map<String,Integer> hash = new HashMap<>();
        if(nums.length<3){return list;}
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        String value = nums[i]+""+nums[j]+""+nums[k];
                        if(hash.containsKey(value)){continue;}
                        else{
                            List<Integer> inner_list = new ArrayList<>();
                            hash.put(value,1);
                            inner_list.add(nums[i]);
                            inner_list.add(nums[j]);
                            inner_list.add(nums[k]);
                            list.add(inner_list);
                        }
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6});
        StringBuilder str = new StringBuilder("abc");
        System.out.println(str.toString());
        System.out.println(str.reverse().toString());
        System.out.println(str.reverse().reverse().toString());

        int totals = 0;
        for (int i = 0, j = 5; totals < 10 || j > 3; ++i, --j) {
            totals += (i + j);
        }
        System.out.println(totals);
        int c = totals==4?3:0;
    }
}
