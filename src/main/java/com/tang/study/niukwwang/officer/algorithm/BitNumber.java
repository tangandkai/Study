package com.tang.study.niukwwang.officer.algorithm;

import org.junit.Test;

public class BitNumber {

    public int solution(int n){
        int num = 0;
        if (n==0){return 0;}
        while (n!=0){
            if ((n&1)==1){num++;}
            n>>>=1;
        }
        return num;
    }

    public int solution_1(int n){
        int num = 0;
        char[] values = Integer.toBinaryString(n).toCharArray();
        for (int i=0;i<values.length;i++){
            if (values[i]=='1'){num++;}
        }
        return num;
    }


    @Test
    public void test(){
        System.out.println(solution(-2147483648));
    }
}
