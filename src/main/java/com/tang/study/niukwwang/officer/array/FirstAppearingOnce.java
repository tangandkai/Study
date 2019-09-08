package com.tang.study.niukwwang.officer.array;

import java.util.HashMap;
import java.util.Map;

public class FirstAppearingOnce {

    static Map<Character,Integer> hash = new HashMap<>();
    static StringBuilder builder = new StringBuilder();
    public static void main(String[] args) {
        char[] chars = new char[]{'h','e','l','l','o','w','d'};
    }

    public static void insert(char ch){
        builder.append(ch);
        if (hash.containsKey(ch)){
            hash.put(ch,hash.get(ch)+1);
        }
        else
            hash.put(ch,1);
    }

    public static char solution()
    {
        char[] chars = builder.toString().toCharArray();
        for (char c:chars){
            if (hash.get(c)==1)
                return c;
        }
        return '#';
    }
}
