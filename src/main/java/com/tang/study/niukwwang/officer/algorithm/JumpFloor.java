package com.tang.study.niukwwang.officer.algorithm;

import org.junit.Test;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class JumpFloor {

    public int solution_1(int target){
        if (target==1){return 1;}
        if (target==2){return 2;}
        return solution_1(target-1)+solution_1(target-2);
    }

    public int solution_2(int target){
        return 0;
    }

    public int solution_3(int target){
        if (target == 1){return 1;}
        if (target == 2){return 2;}
        if (target == 3){return 4;}

        return 2*solution_3(target-1);
    }
    @Test
    public void test(){

        long time = System.currentTimeMillis();
        System.out.println(solution_3(4));
        System.out.println(System.currentTimeMillis()-time);
    }
}
