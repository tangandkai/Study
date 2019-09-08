package com.tang.study.likou.simple;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 */
public class CommonPrefix {

    public static void main(String[] args) {

        String[] str = new String[]{"hello","word"};
        System.out.println(new CommonPrefix().longestCommonPrefix(str));
    }

    public String longestCommonPrefix(String[] strs){
        int cLen = Integer.MAX_VALUE;  //列数
        for (String str:strs){
            if (cLen>str.length())
                cLen = str.length();
        }
        int rLen = strs.length;         //行数，数组元素的个数
        char[][] matrix = new char[rLen][cLen];
        for (int i=0;i<rLen;i++){
            for (int j=0;j<cLen;j++){
                matrix[i][j] = strs[i].charAt(j);
                System.out.println(matrix[i][j]);
            }
        }

        System.out.println(matrix);
        return "";
    }
}
