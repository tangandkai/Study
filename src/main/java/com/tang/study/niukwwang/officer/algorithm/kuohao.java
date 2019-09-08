package com.tang.study.niukwwang.officer.algorithm;

import java.util.Scanner;

/**
 * 例如"", "()", "()()()", "(()())", "(((())))"都是合法的。
 * 东东现在有一个合法的括号序列s,一次移除操作分为两步:
 * 1. 移除序列s中第一个左括号
 * 2. 移除序列s中任意一个右括号.保证操作之后s还是一个合法的括号序列
 * 东东现在想知道使用上述的移除操作有多少种方案可以把序列s变为空
 * 如果两个方案中有一次移除操作移除的是不同的右括号就认为是不同的方案。
 * 例如: s = "()()()()()",输出1, 因为每次都只能选择被移除的左括号所相邻的右括号.
 * s = "(((())))",输出24, 第一次有4种情况, 第二次有3种情况, ... ,
 * 依次类推, 4 * 3 * 2 * 1 = 24
 */
public class kuohao {

    public static void main(String[] args) {

        new kuohao().solution();
    }

    public int solution(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int res = 1;
        int tmp = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='(')
                tmp++;
            else{
                res*=tmp;
                tmp--;
            }
        }
        System.out.println(res);
        return 1;
    }
}
