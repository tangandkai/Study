package com.tang.study.niukwwang.officer.algorithm;

import org.junit.Test;

public class power {

    public double solution(double base,int exponent){
        if(exponent==0){return 1;}
        double result = 1;
        if(exponent>0){
            for(int i=0;i<exponent;i++){
                result = result*base;
            }
        }
        else{
            for(int i=0;i>exponent;i--){
                result = result*base;
            }
            result = 1/result;
        }
        return result;
    }

    @Test
    public void test(){
        System.out.println(solution(-2,-2));
    }
}
