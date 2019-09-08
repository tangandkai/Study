package com.tang.study.niukwwang.officer.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词
 * 输入: ["Hello", "Alaska", "Dad", "Peace"]
 * 输出: ["Alaska", "Dad"]
 */
public class findWords {

    public static void main(String[] args) {

        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        String[] res = new findWords().solution_1(words);
        for (String r:res){
            System.out.println(r);
        }
    }

    public String[] solution_1(String[] words){

        String line_1 = "qwertyuiop";
        String line_2 = "asdfghjkl";
        String line_3 = "zxcvbnm";
        List<String> list = new ArrayList<>();
        Map<Character,Integer> hash = new HashMap<>();
        for(char x : line_1.toCharArray()){
            hash.put(x,1);
        }
        for(char x : line_2.toCharArray()){
            hash.put(x,2);
        }
        for(char x : line_3.toCharArray()){
            hash.put(x,3);
        }

        for (int i=0;i<words.length;i++){
            String str = words[i].toLowerCase();
            boolean yes = true;
            int level = hash.get(str.charAt(0));
            for (int j=1;j<str.length();j++){
                int level_1 = hash.get(str.charAt(j));
                if (level != level_1){
                    yes = false;
                    break;
                }
                else {
                    continue;
                }
            }
            if (yes){
                list.add(words[i]);
            }
        }
        return list.toArray(new String[]{});
    }
}
