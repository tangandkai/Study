package com.tang.study.likou.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum2 {

    public static void main(String[] args) {

        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> list = new combinationSum2().solution(candidates, target);
        System.out.println(list);
    }

    public List<List<Integer>> solution(int[] candidates, int target){

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        for(int i=0;i<candidates.length;++i){
            List<Integer> tmp = new ArrayList<>();
            int sum = 0;
            for(int index=i;index<candidates.length;index++){
                sum = sum + candidates[index];
                if(sum <= target){
                    tmp.add(candidates[index]);
                }
                if(sum == target){
                    list.add(tmp);
                }
                if(sum > target){
                    break;
                }
                // index++;
            }
        }
        return list;
    }

    public List<List<Integer>> solution1(int[] candidates, int target){

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);

        return list;
    }

    public void recu(int[] candidates,List<List<Integer>> list,List<Integer>ans, int pos, int target){
        if (target==0){
            list.add(ans);
            return;
        }
        for (int i=pos;i<candidates.length;i++){
            if (target - candidates[i] >= 0) {
                if (i!=pos && candidates[i]==candidates[i-1])
                    continue;
                ans.add(candidates[i]);
                recu(candidates,list,ans,pos+1,target-candidates[i]);
            }
            else
                break;
        }
    }
}
