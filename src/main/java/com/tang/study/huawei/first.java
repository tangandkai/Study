package com.tang.study.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class first {

    public static void main(String[] args) throws IOException {

        cal();
    }

    public static void cal() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line=br.readLine())!= null){
            Integer N = Integer.parseInt(line);
            String str = br.readLine();
            func(N,str);
        }
    }

    /**
     * 2
     * 0abcdefgh1abcdefgh
     * @param num
     * @param line
     */
    public static void func(Integer num,String line){
        StringBuilder builder = new StringBuilder();
        char[] chars = line.toCharArray();
        Integer limit = num*9;

        Stack stack = new Stack();
        for (int i=0;i<num;i++){
            if (chars[i*9]=='0'){
                for (int j=(i+1)*9-1;j>i*9;j--){
                    builder.append(chars[j]);
                }
                builder.append(" ");
            }
            else if(chars[i*9]=='1'){
                for (int j=i*9+1;j<(i+1)*9;j++){
                    builder.append(chars[j]);
                }
                builder.append(" ");
            }

        }
        System.out.println(builder.toString());
    }
}
