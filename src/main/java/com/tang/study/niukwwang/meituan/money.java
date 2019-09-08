package com.tang.study.niukwwang.meituan;

import java.util.Scanner;

public class money {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()) {
            String value = scan.nextLine();
            System.out.println(new money().cal(Integer.parseInt(value)));
        }
    }

    public int cal(int num){

        if(num <= 0)return 0;
        int[] coins = new int[]{1,5,10,20,50,100};
        int[] dp = new int[num+1];
        dp[0] = 1;
        for(int i = 0; i < coins.length; i++) {
            for(int j = coins[i]; j <= num; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];//类似斐波那契 后者的种类数基于前者
            }
        }
        return dp[num];
    }
}
