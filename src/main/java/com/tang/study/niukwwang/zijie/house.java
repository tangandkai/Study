package com.tang.study.niukwwang.zijie;

import java.util.Scanner;

/**
 * 存在n+1个房间，每个房间依次为房间1 2 3...i，每个房间都存在一个传送门，
 * i房间的传送门可以把人传送到房间pi(1<=pi<=i),
 * 现在路人甲从房间1开始出发(当前房间1即第一次访问)，每次移动他有两种移动策略：
 *     A. 如果访问过当前房间 i 偶数次，那么下一次移动到房间i+1；
 *     B. 如果访问过当前房间 i 奇数次，那么移动到房间pi；
 * 现在路人甲想知道移动到房间n+1一共需要多少次移动；
 */
public class house {

    public static void main(String[] args) {

    }

    public int cal(){
        Scanner scan = new Scanner(System.in);
        int mod = 1000000007;
        int n = scan.nextInt();
        int[] pi = new int[n+1];
        int[] dp = new int[n+1];
        for (int i=1;i<=n;i++){
            pi[i] = scan.nextInt();
        }
        if (n==1){
            return 1;
        }
        for(int j = 1; j < n+1; j++){
            dp[j] = (2 * dp[j-1]%mod - dp[pi[j]-1] + 2) % mod;
        }
        return dp[n];
    }
}
