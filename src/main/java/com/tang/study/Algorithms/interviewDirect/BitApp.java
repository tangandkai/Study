package com.tang.study.Algorithms.interviewDirect;

public class BitApp {

    public static void main(String[] args) {
        System.out.println(new BitApp().isPower(2));
        System.out.println(new BitApp().OneNum(21));
    }

    public boolean isPower(int n){
        if (n<1)
            return false;
        while (n>=1){
            if (n==1){
                return true;
            }
            n >>= 1;
        }
        return false;
    }

    public int OneNum(int n){
        int count = 0;
        while (n>0){
            if ((n&1)==1)
                count++;
            n >>= 1;
        }
        return count;
    }
}
