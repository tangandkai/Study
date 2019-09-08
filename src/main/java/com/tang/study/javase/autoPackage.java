package com.tang.study.javase;

public class autoPackage extends supe{

    @Override
    public void hh(){

    }

    public static void main(String[] args) {

        Integer x = 12;
        Integer y = 12;
        int c = 12;
        Integer z = new Integer(12);
        System.out.println(x==c);
        System.out.println(x==z);

        Integer a = Integer.valueOf(12);
        System.out.println(x==a);

        Integer b = Integer.parseInt("12");
        System.out.println(x==b);

        String xx = new String("123");
        String yy = new String("123");
        System.out.println(xx==yy);

        String s1 = xx.intern();
        String s2 = yy.intern();

        System.out.println(s1==s2);
    }
}

class supe{
    protected void hh(){
        System.out.println("hh");
    }
}