package com.tang.study.likou.common;

import java.util.ArrayList;
import java.util.List;

public class letterCombinations {

    public static void main(String[] args) {
        List<String> list = new letterCombinations().letter("234");
        System.out.println(list);
    }

    public List<String> letter(String digits) {
        List<String> list = new ArrayList<>();
        int length = digits.length();
        if(length==0){return list;}
        String[] str = new String[length];
        for(int i=0;i<length;i++){
            switch(digits.charAt(i)){
                case '2':str[i]="abc";break;
                case '3':str[i]="def";break;
                case '4':str[i]="ghi";break;
                case '5':str[i]="jkl";break;
                case '6':str[i]="mno";break;
                case '7':str[i]="pqrs";break;
                case '8':str[i]="tuv";break;
                case '9':str[i]="wxyz";break;
            }
        }
        list = solution(str,0,list,"");
        return list;
    }

    private List<String> solution(String[]s,int i,List<String> list,String stemp){
        if(i<s.length-1){
            for(int j=0;j<s[i].length();j++){
                list = solution(s,i+1,list,stemp+s[i].charAt(j));
            }
        }
        else{
            for(int j=0;j<s[i].length();j++){
                list.add(stemp+s[i].charAt(j));
            }
        }
        return list;
    }
}
