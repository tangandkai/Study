package com.tang.study.likou.common;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 */
public class ToRoman {

    public static void main(String[] args) {
        System.out.println(new ToRoman().intToRoman(3999));
    }

    public String intToRoman(int num){
        Map<Integer,String> Link = new LinkedHashMap<>();
        Link.put(1000,"M");Link.put(900,"CM");
        Link.put(500,"D");Link.put(400,"CD");
        Link.put(100,"C");Link.put(90,"XC");
        Link.put(50,"L");Link.put(40,"XL");
        Link.put(10,"X");Link.put(9,"IX");
        Link.put(5,"V");Link.put(4,"IV");
        Link.put(1,"I");
        for (Map.Entry entry:Link.entrySet()){
            System.out.println(entry.getKey()+"\t"+entry.getValue());
        }
        StringBuilder builder = new StringBuilder();
        for (int key:Link.keySet()){
            while (num>=key){
                num-=key;
                builder.append(Link.get(key));
            }
        }

        return builder.toString();
    }
}
