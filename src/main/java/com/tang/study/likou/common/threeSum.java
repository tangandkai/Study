package com.tang.study.likou.common;

import java.util.*;

public class threeSum {
    public static void main(String[] args) {

        List<List<Integer>> value = new threeSum().threeSum(new int[]{-4,-1,-1,0,1,1,2});
        System.out.println(value);
        List<List<Integer>> list = new threeSum().fourSum(new int[]{-4, -1, -1, 0, 1, 1, 2}, -1);
        System.out.println(list);

    }

    public void twoSu(){}
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Map<String,Integer> hash = new HashMap<>();
        if(nums.length<3){return list;}
        Arrays.sort(nums);
        // for(int i=0;i<nums.length-2;i++){
        //     for(int j=i+1;j<nums.length-1;j++){
        //         for(int k=j+1;k<nums.length;k++){
        //             if(nums[i]+nums[j]+nums[k]==0){
        //                 String value = nums[i]+""+nums[j]+""+nums[k];
        //                 if(hash.containsKey(value)){continue;}
        //                 else{
        //                     List<Integer> inner_list = new ArrayList<>();
        //                     hash.put(value,1);
        //                     inner_list.add(nums[i]);
        //                     inner_list.add(nums[j]);
        //                     inner_list.add(nums[k]);
        //                     list.add(inner_list);
        //                 }
        //             }
        //         }
        //     }
        // }

        for(int i=0;i<nums.length-2;i++){
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
                int left = i+1;
                int right = nums.length-1;
                int sum = 0-nums[i];
                while(left<right){
                    if(nums[left]+nums[right]==sum){
                        list.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        while(left<right && nums[left]==nums[left+1]){left++;}
                        while(left<right && nums[right]==nums[right-1]){right--;}
                        left++;
                        right--;
                    }
                    else if(nums[left]+nums[right]>sum){
                        while(left<right && nums[right]==nums[right-1]){
                            right--;
                        }
                        right--;
                    }
                    else{
                        while(left<right && nums[left]==nums[left+1]){
                            left++;
                        }
                        left++;
                    }
                }
            }
        }
        return list;
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        if(len<4)return list;
        for(int i=0;i<len-3;i++){
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
                for(int j=i+1;j<len-2;j++){
                    if(j==1 || (j>1 && nums[j]!=nums[j-1])){
                        int left = j+1;
                        int right = len-1;
                        while(left<right){
                            if(nums[i]+nums[j]+nums[left]+nums[right]==target){
                                list.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                                while(left<right && nums[left]==nums[left+1])left++;
                                while(left<right && nums[right]==nums[right-1])right--;
                                left++;
                                right--;
                            }
                            else if(nums[i]+nums[j]+nums[left]+nums[right]>target){
                                while(left<right && nums[right]==nums[right-1]){
                                    right--;
                                }
                                right--;
                            }
                            else{
                                while(left<right && nums[left]==nums[left+1]){
                                    left++;
                                }
                                left++;
                            }
                        }
                    }
                }
            }
        }
        return list;
    }
}
