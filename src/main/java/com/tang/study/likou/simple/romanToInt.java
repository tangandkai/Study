package com.tang.study.likou.simple;

import java.util.HashMap;
import java.util.Map;

/**
 *I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
public class romanToInt {
    public static void main(String[] args) {

        //"MDCXCV"  1695
        //MCMXCIV
        System.out.println(new romanToInt().romanToInt("MDCXCV"));
    }

    /**
     * 输入: "III"    输出: 3
     * 输入: "IV"     输出: 4
     * @param s
     * @return
     */
    public int romanToInt(String s){
        Map<Character,Integer> hash = new HashMap<>();
        hash.put('I',1);hash.put('V',5);
        hash.put('X',10);hash.put('L',50);
        hash.put('C',100);hash.put('D',500);
        hash.put('M',1000);
        Integer resultValue = 0;
        Integer currentValue = 0;
        Integer nextValue = 0;
        char keyCurrent;
        char keyNext;
        for (int i=0;i<s.length();i++){
            try{
                keyCurrent = s.charAt(i);
                currentValue = hash.get(keyCurrent);
                keyNext = s.charAt(i+1);
                nextValue = hash.get(keyNext);
                if (currentValue>=nextValue){
                    resultValue+=currentValue;
                }
                else {
                    resultValue+=nextValue-currentValue;
                    i++;
                }
            }catch (IndexOutOfBoundsException e){
                resultValue+=currentValue;
                System.out.println("out index");
            }
        }
        return resultValue;
    }
}
