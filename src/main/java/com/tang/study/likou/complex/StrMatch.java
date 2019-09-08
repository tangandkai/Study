package com.tang.study.likou.complex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class StrMatch {

    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder();
        builder.append("hhhhhh");
        String res1 = builder.toString();
        builder.setLength(0);
        System.out.println("res1="+res1);
        builder.append("gggggg");
        String res2 = builder.toString();
        System.out.println("res2="+res2);
        String s = "ab";
        String p = "a*";
        Matcher m = Pattern.compile(p).matcher(s);
        System.out.println(m.find());
        System.out.println(new StrMatch().isMatch("","."));
    }

    public boolean isMatch(String s, String p) {
        if (p.length()<s.length())
            return false;
        int sLen = s.length();
        int pLen = p.length();
        for (int i=0;i<p.length();i++){
            String pStr = p.substring(i,i+sLen>pLen?pLen:i+sLen);
            int pStrLen = pStr.length();
            if (pStrLen<sLen)
                return false;
            else {
                if (pStr.equals(s)){
                    return true;
                }
                else {
                    Matcher m = Pattern.compile(pStr).matcher(s);
                    return m.find();
                }
            }
        }
        return false;
    }
}
