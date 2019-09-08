package com.tang.study.niukwwang.officer.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现序列的全排
 */
public class quanpai {
    public static void main(String[] args) {

        int[] nums = {2,3,4,1};
        List<List<Integer>> res = new quanpai().solution_1(nums);

        StringBuilder builder = new StringBuilder("ggg");
        builder.length();
        System.out.println(builder.indexOf("r"));

        System.out.println(res);
    }

    /**
     * 给定一个不含重复数字的序列，返回所有不重复的全排列。
     * @param nums
     * @return
     */
    public List<List<Integer>> solution_1(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        backtrack_1(list,new ArrayList<>(),nums);
        return list;
    }

    private void backtrack_1(List<List<Integer>> list,
                             List<Integer> tempList, int[] nums){

        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i]))
                    continue;
                tempList.add(nums[i]);
                backtrack_1(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    /**
     *给定一个可包含重复数字的序列，返回所有不重复的全排列。
     * @param nums
     * @return
     */
    public List<List<Integer>> solution_2(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        backtrack_2(list,new ArrayList<>(),nums);
        return list;
    }

    private void backtrack_2(List<List<Integer>> list,
                             List<Integer> tempList, int[] nums){


    }
}
