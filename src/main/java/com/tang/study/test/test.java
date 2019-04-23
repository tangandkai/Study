package com.tang.study.test;

import org.junit.Test;


public class test {

    int c = 1;
    public void cal(String x,String y){
        String tmp = x;
        x = y;
        y = tmp;
    }

    public void cal_1(Integer a, Integer b){
        Integer tmp = a;
        a = b;
        b = tmp;
        System.out.println("a="+a+"\t"+"b="+b);
    }

    @Test
    public void tet_1(){
        String x = new String("hello");
        String y = new String("word");
        cal(x,y);
        System.out.println("x="+x+"\t"+"y="+y);

        Integer a = new Integer(11);
        Integer b = new Integer(2);
        cal_1(a,b);
        String aa = "tang";
        String bb = "tang";
        System.out.println("a="+a+"\t"+"b="+b);
        System.out.println(c);
        aa = "kai";
        System.out.println("aa="+aa+"\t"+"bb="+bb);
        System.out.println(aa==bb);
    }
}
