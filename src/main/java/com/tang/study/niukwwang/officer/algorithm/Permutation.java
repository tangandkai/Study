package com.tang.study.niukwwang.officer.algorithm;

import java.util.ArrayList;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Permutation {

    public ArrayList<String> solution(String str){
        ArrayList<String> list = new ArrayList<>();
        char[] array = str.toCharArray();
        int length = array.length;
        return list;
    }

    public static void main(String[] args) {
        String params = "abc";
        new Permutation().solution(params);
    }
}
