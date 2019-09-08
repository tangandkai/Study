package com.tang.study.likou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 编写一个程序，找出第 n 个丑数。
 *
 * 丑数就是只包含质因数 2, 3, 5 的正整数
 */
public class coushu_2 {

    public static void main(String[] args) throws IOException {
        cal();
    }

    public static int cal() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line = ""
            int n = 10;
//            int num = n+1;
            int value = 1;
            int index = 0;
            while (true){
                if (f(value)){
                    index++;
                    if (index==n){
                        System.out.println("前"+n+"个丑数是: "+value);
                        return value;
                    }
                }
                value++;
            }
//        return -1;
    }

    public static boolean f(Integer num){
        if (num<1){
            return false;
        }
        else if (num%2==0){
            num = num/2;
        }
        else if (num%3==0){
            num = num/3;
        }
        else if (num%5==0){
            num = num/5;
        }
        else if (num==1){
            return true;
        }
        else
            return false;
        return f(num);
    }
}
