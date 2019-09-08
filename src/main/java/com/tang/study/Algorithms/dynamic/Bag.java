package com.tang.study.Algorithms.dynamic;

public class Bag {

    public static void main(String[] args) {
        int N = 3;
        int C = 4;
        int[]W = new int[]{1, 4, 3};
        int[]V = new int[]{1500, 3000, 2000};
        cal(N,C,W,V);
    }

    /**
     *
     * @param N 物品种类
     * @param C 背包承重
     * @param W 物品种类对应的重量，列表
     * @param V 物品种类对应的价值，列表
     */
    public static void cal(int N, int C, int[] W,int[] V){

        int[][]res = new int[N][C+1];
        for (int i=0;i<=C;i++){
            if (i<W[0])
                res[0][i] = 0;
            else
                res[0][i] = V[0];
        }

        for (int i=1;i<N;i++){
            for (int j=0;j<=C;j++){
                if (j<W[i])
                    res[i][j] = res[i-1][j];
                else
                    res[i][j] = Math.max(res[i-1][j], V[i]+res[i-1][j-W[i]]);
            }
        }
        System.out.println(res[N-1][C]);
    }
}
