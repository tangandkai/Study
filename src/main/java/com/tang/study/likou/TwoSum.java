package com.tang.study.likou;

public class TwoSum {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 7, 11, 15};
        int target = 17;
        int[] indexs = cal(nums, target);
        System.out.println("index[0]="+indexs[0]+"\n"+"index[1]="+indexs[1]);
    }

    public static int[] cal(int[] nums, int target){

        int[] indexs = new int[2];

        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if (nums[i]+nums[j]==target){
                    indexs[0] = i;
                    indexs[1] = j;
                    return indexs;
                }
            }
        }
        return indexs;
    }

    public void twoSum(int[] nums,int targer){}
}
