package com.tang.study.test.dd;

import java.util.Scanner;

public class maxValue {

    public static void main(String[] args) {

        new maxValue().solution();
    }

    public void solution(){
        Scanner scan = new Scanner(System.in);
        String[] line1 = scan.nextLine().split(" ");
        int N = Integer.valueOf(line1[0]);
        int M = Integer.valueOf(line1[1]);
        int[][] nums = new int[N][M];
        for (int i=0;i<N;i++){
            String[] splits = scan.nextLine().trim().split(" ");
            for (int j=0;j<M;j++){
                nums[i][j] = Integer.valueOf(splits[j]);
            }
        }
        int[] res = new int[M];
        int max = Integer.MIN_VALUE;
        for (int i=0;i<M;i++){
            for (int j=0;j<N;j++){
                if (nums[j][i]>max){
                    max = nums[j][i];
                }
            }
            res[i] = max;
            max = Integer.MIN_VALUE;
        }
        int sum = 0;
        for (int i=0;i<M;i++){
            sum+=res[i];
        }
        System.out.println(sum);
    }
}
