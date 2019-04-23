package com.tang.study.huawei;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。
 * 输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 * 输入描述:
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 *
 * 输出描述:
 * 删除字符串中出现次数最少的字符后的字符串。
 *
 * 示例1
 * 输入
 * abcdd
 * 输出
 * dd
 */
public class DropString {

    //用于存放输入的字符串
    private static Map<Character,Integer> hashMap;
    public static void main(String[] args) throws IOException {

        cal();
    }

    public static void cal() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line=br.readLine())!= null){
            char[] chars = line.toCharArray();
            init(chars);
            drop(chars);
        }
    }

    /**
     * 初始化hashMap
     * @param chars
     */
    public static void init(char[] chars){
        hashMap = new HashMap<>();
        for (int i=0;i<chars.length;i++){
            if (hashMap.containsKey(chars[i])){
                hashMap.put(chars[i], hashMap.get(chars[i])+1);
            }
            else
                hashMap.put(chars[i],1);
        }
    }

    /**
     * 删除
     */
    public static void drop(char[] chars){
        StringBuilder builder = new StringBuilder();
        Collection<Integer> values = hashMap.values();
        int min = Collections.min(values);
        System.out.println("min="+min);
        for (char key:chars){
            if(hashMap.get(key)!=min){
                builder.append(key);
            }
        }
        System.out.println(builder.toString());
    }
}
