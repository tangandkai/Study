package com.tang.study.niukwwang.officer.algorithm;

/**
 * 英国的货币单位包括英镑£和便士p，在流通中的硬币一共有八种：
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p), £2 (200p)
 * 以下是组成£2的其中一种可行方式：
 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 * 不限定使用的硬币数目，组成£2有多少种不同的方式？
 */
public class coinsSum {

    public static void main(String[] args) {

        int res = new coinsSum().solution(5,0);
        System.out.println(res);
    }

    public int solution(int totalMoney,int index){
        int[] money = {1,2,5,10,20,50,100,200};
        int sum = 0;
        for (int i=index;i<money.length;i++){
            if (totalMoney - money[i] == 0){
                sum ++;
                break;
            }
            if (totalMoney - money[i] > 0){
                sum += solution(totalMoney-money[i],i);
            }
        }
        return sum;
    }
}
