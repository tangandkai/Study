package com.tang.study.likou;

public class distinctIndex {

    public int cal(String str){
        int [] freq = new int[26];

        for (int i=0;i<str.length();i++){
            freq[str.charAt(i)-'a']++;
        }
        for (int i=0;i<str.length();i++){
            if (freq[str.charAt(i)-'a']==1)
                return i;
        }
        return -1;
    }
}
