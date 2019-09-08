package com.tang.study.niukwwang.meituan;

import java.util.Scanner;

public class metriax {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for(int i =0;i<n;i++){
            height[i] = sc.nextInt();
        }

        int maxArea = -1;
        for(int i = 0;i<n;i++){
            int left=i;
            int right=i;

            //计算以当前值为最小高度的矩形面积
            while(left > 0 && height[left-1] >= height[i])  left--;//寻找左边界
            while(right < n-1 && height[right+1] >= height[i])  right++;//寻找右边界
            int tempArea = (right-left+1) * height[i];

            if(maxArea<tempArea) maxArea=tempArea;
        }

        System.out.println(maxArea);
    }
}
