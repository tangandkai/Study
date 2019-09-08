package com.tang.study.niukwwang.officer.algorithm;

import org.junit.Test;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class matrixRectCover {

    public int solution(int n){
        if (n == 1){return 1;}
        if (n == 2){return 2;}
        int first = 1;
        int second = 2;
        int total = 0;
        for(int i=2;i<n;i++){
            total = first + second;
            first = second;
            second = total;
        }
        return total;
    }

    public int solution_1(int n){
        if (n==1)return 1;
        if (n==2)return 2;
        return solution_1(n-1)+solution_1(n-2);
    }

    @Test
    public void test(){
        System.out.println(solution_1(4));
    }
}
