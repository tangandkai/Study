package com.tang.study.likou.common;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 示例 1:
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 * 示例 5:
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 */
public class Atoi {

    public static void main(String[] args) throws IOException {
        System.out.println(new Atoi().myAtoi(" 0000000000012345678"));
        System.out.println(Integer.parseInt("+0098"));
//        String x = "0123456789";
//        for (int i=0;i<x.length();i++){
//            System.out.println((int)x.charAt(i));
//        }
    }

    public int myAtoi(String str) {
        String line = str.trim();
        StringBuilder builder = new StringBuilder();
        try{
            line.charAt(0);
        }catch (Exception e){
            return 0;
        }
        if (line.charAt(0)=='-' || line.charAt(0)=='+'){
            builder.append(line.charAt(0));
            for (int i=1;i<line.length();i++){
                if ((int)line.charAt(i)>=48 && (int)line.charAt(i)<58){
                    builder.append(line.charAt(i));
                }
                else
                    break;
            }
        }
        else if ((int)line.charAt(0)>47 && (int)line.charAt(0)<58){//数字
            builder.append(line.charAt(0));
            for (int i=1;i<line.length();i++){
                if ((int)line.charAt(i)>47 && (int)line.charAt(i)<58){
                    builder.append(line.charAt(i));
                }
                else
                    break;
            }
        }
        else //不是数字
            builder.append('0');
        int max = (int) (Math.pow(2,31)-1);
        int min = (int) Math.pow(-2,31);
        String str_1 = builder.toString();
        if (str_1.charAt(0)=='-'){
            try{
                int value = Integer.parseInt(str_1);
                return value;
            }catch (NumberFormatException e){
                if (str_1.length()==1)
                    return 0;
                return min;
            }
        }
        else {
            try{
                int value = Integer.parseInt(str_1);
                return value;
            }catch (NumberFormatException e){
                if (str_1.length()==1)
                    return 0;
                return max;
            }
        }
    }
}
