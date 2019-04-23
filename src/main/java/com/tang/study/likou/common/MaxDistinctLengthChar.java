package com.tang.study.likou.common;

import java.util.Hashtable;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class MaxDistinctLengthChar {

    public int lengthOfLongestSubstring(String str){
        int max = 0;
        Hashtable<Character, Integer> table = new Hashtable<>();
        for (int i=0;i<str.length();i++){
            if (table.containsKey(str.charAt(i))){
//                if (max<table.size()){
//                    max = table.size();
//                }
                table.clear();
            }
            if(!table.containsKey(str.charAt(i))){
                table.put(str.charAt(i),1);
                if (max<table.size()){
                    max = table.size();
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {

        MaxDistinctLengthChar T = new MaxDistinctLengthChar();
        System.out.println(T.lengthOfLongestSubstring("uuuuuuu"));
    }
}
