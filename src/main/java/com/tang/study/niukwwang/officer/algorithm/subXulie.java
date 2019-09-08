package com.tang.study.niukwwang.officer.algorithm;

import java.util.Scanner;

/**
 * 给出一个正整数序列S，其中有N个数，定义其中一个非空连续子序列T中所有数的和为T的序列和，
 * 对于S的所有非空连续子序列T，求最大的序列和
 * 5
 * 1 5 -3 2 4
 *
 * 6
 * 1 -2 3 4 -10 6
 *
 * 4
 * -3 -1 -2 -5
 */
public class subXulie {
    public static void main(String[] args) {
        new subXulie().solution();
    }

    public void solution(){
        Scanner scan = new Scanner(System.in);
        int n = Integer.valueOf(scan.nextLine()); //序列个数
        String[] nums = scan.nextLine().split(" ");
        int[] dp = new int[n];
        int result = 0;
        result = dp[0] = Integer.valueOf(nums[0]);
        for (int i=1;i<nums.length;i++){
            dp[i] =  Math.max(dp[i - 1] + Integer.valueOf(nums[i]), Integer.valueOf(nums[i]));
        }
        for (int i=1;i<nums.length;i++){
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}
