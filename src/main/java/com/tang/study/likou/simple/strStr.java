package com.tang.study.likou.simple;

public class strStr {
    public static void main(String[] args) {
        System.out.println(new strStr().solution("mississippi","pi"));
    }

    public int solution(String haystack, String needle) {
        if(needle.equals("")){return 0;}
        if(needle.length()==haystack.length()){return needle.equals(haystack)?0:-1;}
        int index = 0;
        int len = needle.length();
        for(int i=0;i<=haystack.length()-len;i++){
            String str = haystack.substring(i,i+len>haystack.length()?haystack.length():i+len);
            if(str.equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
