package com.tang.study.niukwwang.officer.algorithm;

/**
 *你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，
 * 能够偷窃到的最高金额
 */
public class robHouse {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int res = new robHouse().rob(nums);
        System.out.println(res);
    }

    public int rob(int[] nums) {
        return rob(nums, nums.length - 1);
    }

    /**
     * dp[i] = max(dp[i-2]+nums[i],dp[i-1])
     * @param nums
     * @param i
     * @return
     */
    private int rob(int[] nums, int i) {
        if (i < 0)
            return 0;
        return Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
    }

//    public
}
