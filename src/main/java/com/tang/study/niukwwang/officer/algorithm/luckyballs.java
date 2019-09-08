package com.tang.study.niukwwang.officer.algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 一个袋子里面有n个球，每个球上面都有一个号码(拥有相同号码的球是无区别的)。
 * 如果一个袋子是幸运的当且仅当所有球的号码的和大于所有球的号码的积。
 * 例如：如果袋子里面的球的号码是{1, 1, 2, 3}，这个袋子就是幸运的，
 * 因为1 + 1 + 2 + 3 > 1 * 1 * 2 * 3
 * 你可以适当从袋子里移除一些球(可以移除0个,但是别移除完)，要使移除后的袋子是幸运的。
 * 现在让你编程计算一下你可以获得的多少种不同的幸运的袋子。
 */
public class luckyballs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] balls = new int[n];
            for (int i =0;i<n;i++) {
                balls[i] = scanner.nextInt();
            }
            int luckyBall = solution(balls);
            System.out.println(luckyBall);
        }
        scanner.close();
    }

    private static int solution(int[] nums) {
        Arrays.sort(nums);
        int count = findNumber(nums,0,0,1);
        return count;
    }

    private static int findNumber(int[] nums, int index, int sum, int multi) {
        int count = 0;
        for (int i = index; i < nums.length; i++) {
            sum += nums[i];
            multi *= nums[i];
            if (sum > multi) { //当前满足要求
                count += 1 + findNumber(nums, i + 1, sum, multi);
            }else if (nums[i] == 1) {//当前数为1，后续说不定可以保证满足要求
                count += findNumber(nums, i + 1, sum, multi);
            } else break; // 当前数不满足 那么ball[i+1]
            sum -= nums[i];
            multi /= nums[i];//回溯法 遍历
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {//去掉重复的集合
                i++;
            }
        }
        return count;
    }
}
