package com.tang.study.test;

import scala.Int;

public class firrst {

    public static int flag = 0;
    public static void main(String[] args) {

        String str = "123";
        System.out.println(str.charAt(0));
        System.out.println(str.charAt(1));
//        System.out.println(str.charAt(3));
        System.out.println(17 % 10);
        System.out.println((int) (17 / 10));
        String res = new firrst().cal("99999.564", "12345.999900000000");
        if (res.endsWith("0")){}
        System.out.println(res);

        str = new firrst().caa("45353001000");
        System.out.println(str);
    }

    public String cal(String num1, String num2) {
        StringBuffer buffer = new StringBuffer();
        String[] str1 = num1.split("\\.");
        String[] str2 = num2.split("\\.");
        if (str1.length == 1 && str2.length == 1) {
            int len1 = str1[0].length();
            int len2 = str2[0].length();
            ca(len1,len2,str1[0],str2[0],buffer);
            if (flag>0){
                buffer.append("1");
            }
        }
        if (str1.length == 1 && str2.length == 2) {
            int len1 = str1[0].length();
            int len2 = str2[0].length();
            buffer.append(caa(str2[1])).reverse().append(".");
            ca(len1,len2,str1[0],str2[0],buffer);
            if (flag>0)
                buffer.append("1");
        }
        if (str1.length == 2 && str2.length == 1) {
            int len1 = str1[0].length();
            int len2 = str2[0].length();
            buffer.append(caa(str1[1])).reverse().append(".");
            ca(len1,len2,str1[0],str2[0],buffer);
            if (flag>0)
                buffer.append("1");
        }
        if (str1.length == 2 && str2.length == 2) {
            int len1 = str1[1].length();
            int len2 = str2[1].length();
            ca(len1,len2,str1[1],str2[1],buffer);
            buffer.append(".");
            int len11 = str1[0].length();
            int len22 = str2[0].length();
            ca(len11,len22,str1[0],str2[0],buffer);
            if (flag>0)
                buffer.append("1");
        }

        return buffer.reverse().toString();
    }

    public  void ca(int len1, int len2, String str1, String str2, StringBuffer buffer) {
        if (len1 < len2) {
            int index = len1;
            int i = 1;
            while (i <= len1) {
                int value = Integer.parseInt("" + str1.charAt(len1 - i)) +
                        Integer.parseInt("" + str2.charAt(len2 - i));
                int a = (value + flag) % 10;
                flag = (value + flag) / 10 > 0 ? 1 : 0;
                buffer.append("" + a);
                i++;
            }
            for (int j=len2-len1-1;j>=0;j--){
                int value = (Integer.parseInt(""+str2.charAt(j))+flag)%10;
                flag = (Integer.parseInt(""+str2.charAt(j))+flag)/10>0?1:0;
                buffer.append(""+value);
            }
        }

        else {
            int index = len2;
            int i = 1;
            while (i <= len2) {
                int value = Integer.parseInt("" + str1.charAt(len1 - i)) +
                        Integer.parseInt("" + str2.charAt(len2 - i));
                int a = (value + flag) % 10;
                flag = (value + flag) / 10 > 0 ? 1 : 0;
                buffer.append("" + a);
                i++;
            }
            for (int j=len1-len2-1;j>=0;j--){
                int value = (Integer.parseInt(""+str1.charAt(j))+flag)%10;
                flag = (Integer.parseInt(""+str1.charAt(j))+flag)/10>0?1:0;
                buffer.append(""+value);
            }
        }
    }

    public String caa(String str){
        StringBuilder builder = new StringBuilder();
        int len = str.length();
        int index = 0;
        char[] array = str.toCharArray();
        for (int i=len-1;i>=0;i--){
            if (array[i]=='0')
                index++;
            else
                break;
        }
        builder.append(str.substring(0,len-index));
        return builder.toString();
    }
}
