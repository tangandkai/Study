package com.tang.study.likou.simple;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 示例 1:
 * 输入: 121
 * 输出: true
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class Palindrome {

    public static void main(String[] args) {
        System.out.println(new Palindrome().isPalindrome(121));
        StringBuilder builder = new StringBuilder("123456789");
        System.out.println(builder.reverse().toString());
        System.out.println(builder.capacity());

        String x = "hello";
        String y = x;
        System.out.println(x);
        System.out.println(y);
        x = x+"x word";
        System.out.println(x);
        y = y + "y word";
        System.out.println(y);
    }

    public boolean isPalindrome(int x){
        StringBuilder builder = new StringBuilder(String.valueOf(x));
        String primary = builder.toString();
        String reverse = builder.reverse().toString();
        if (primary.equals(reverse))
            return true;
        return false;
    }
}
