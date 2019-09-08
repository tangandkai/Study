package com.tang.study.niukwwang.officer.algorithm.dynamic;

public class Bag_1 {

    static int n;           // 描述物品个数
    static int c;           // 描述背包容量
    static int[] value;     // 描述物品价值
    static int[] weight;    // 描述物品重量

    public static void main(String[] args) {

        // 初始赋值操作
        value = new int[]{1500, 3000, 2000};
        weight = new int[]{1, 4, 3};
        c = 4;
        n = 3;

        // 构造最优解的网格:3行4列
        int[][] maxValue = new int[n][c];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < c; j++) {
                maxValue[i][j] = 0;
            }
        }

        for (int i=0;i<n;i++){
            for (int j=1;j<=c;j++){

            }
        }

    }

}
