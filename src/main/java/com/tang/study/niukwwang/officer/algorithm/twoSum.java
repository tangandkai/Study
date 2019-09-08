package com.tang.study.niukwwang.officer.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class twoSum {

    public static void main(String[] args) {

        int[] nums = {2,7,11,15};
        List<List<Integer>> res = new twoSum().solution(nums, 9);
        System.out.println(res);
    }

    public List<List<Integer>> solution(int[] nums,int target){
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length-1;
        while (low<=high){
            if (nums[low]+nums[high]==target){
                List<Integer> tmp = new ArrayList<>(2);
                tmp.add(nums[low]);
                tmp.add(nums[high]);
                list.add(tmp);
            }
            if (nums[low]+nums[high]>target){
                high--;
            }

            if (nums[low]+nums[high]<target){
                low++;
            }
        }
        return list;
    }
}
