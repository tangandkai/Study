package com.tang.study.niukwwang.officer.algorithm;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 */
public class combinnationSum {

    public static void main(String[] args) {

    }

    /**
     * candidates 中的数字可以无限制重复被选取。
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> solution_1(int[] nums,int target){
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        getResult_1(list,new ArrayList<>(),nums,target,0);
        return list;
    }

    public void getResult_1(List<List<Integer>> list,List<Integer> tmp,int[]nums,int target,int start){
        if (target>0){
            for (int i=start;i<nums.length && target>=nums[i];i++){
                tmp.add(nums[i]);
                getResult_1(list,tmp,nums,target-nums[i],i);
                tmp.remove(tmp.size()-1);
            }
        }
        else if (target==0){
            list.add(new ArrayList<>(tmp));
        }
    }


    /**
     * candidates 中的数字每次只能选取一个。
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> solution_2(int[] nums,int target){
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        getResult_2(list,new ArrayList<>(),nums,target,0);
        return list;
    }

    public void getResult_2(List<List<Integer>> list,List<Integer> tmp,int[]nums,int target,int start){

        if (target<0)
            return;
        else if(target==0)
            list.add(new ArrayList<>(tmp));
        else {
            for (int i=start;i<nums.length;i++){
                if (i>start && nums[i]==nums[i-1])
                    continue;
                tmp.add(nums[i]);
                getResult_2(list,tmp,nums,target-nums[i],i+1);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
