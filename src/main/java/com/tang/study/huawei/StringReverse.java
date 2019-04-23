package com.tang.study.huawei;


import java.util.Scanner;

/**
 * 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。例如：
 * 输入描述:
 * 输入N个字符
 * 输出描述:
 * 输出该字符串反转后的字符串
 * 示例1
 * 输入
 * abcd
 *
 * 输出
 * dcba
 */
public class StringReverse {

    public static void main(String[] args) {
        System.out.println(cal());
    }

    /**
     * 实现将输入的字符串反转
     * @return
     */
    public static String cal(){

        Scanner scanner = new Scanner(System.in);
        StringBuffer buffer = new StringBuffer(scanner.nextLine());
        return buffer.reverse().toString();

    }
}
