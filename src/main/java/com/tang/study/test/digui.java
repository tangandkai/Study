package com.tang.study.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class digui {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int N = Integer.valueOf(scan.nextLine());
        String[] nums = scan.nextLine().trim().split(" ");
        System.out.println(solution(nums));
    }

    public static int solution(String[] nums){
        int f = Integer.valueOf(nums[0]);
        int index = 0;
        int[] res = new int[nums.length];
        for (int i=1;i<nums.length;i++){
            if (f>Integer.valueOf(nums[i])){
                res[index] = Integer.valueOf(nums[i]);
                f = Integer.valueOf(nums[i]);
            }
            else {
                f = Integer.valueOf(nums[i]);
                index++;
                res[index] = Integer.valueOf(nums[i]);
            }
        }
        return index+1;
    }
}
