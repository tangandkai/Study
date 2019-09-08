package com.tang.yaxin.Str;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class singleSplit {

    public static void main(String[] args) {
        String content = "6|31|24|460015503397598|3567010845713617|15635507200|460|01|2019-05-21 15:27:48.6082310|2019-05-21 15:27:48.6449970|0|0|00000b85000001f0000000005ce3a874|10.105.8.54|36412|10.100.0.245|36412|67123388|941968|0|1|0||||160|3814722329|13655|127397900|13655|||||1|5|000719|10.100.32.233|1935999305|5||10.105.8.54|3592686192|2019-05-21 15:27:47.6124490|2|2019-05-21 15:27:48.6082310||||||||2019-05-21 15:27:48.6124790|2019-05-21 15:27:48.6449970|||||||1|9|0||";
        String pattern = "\\|";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(content);
        int count = 1;
        while (m.find()){
            count++;
        }
//        System.out.println(count);
        String[] splits = content.split("\\|");
        int index = 1;
//        System.out.println(splits.length);
//        for (String s:splits){
//            System.out.println(s+"\t"+index++);
//        }

        String line = "100009137135016Ж焦作市龙湖景苑2机房ЖЖ其他Ж本地接入Ж100009137204831Ж8ЖЖЖЖAЖJЖ1Ж10ЖЖЖ在网Ж2011-12-31 00:00:00Ж无Ж无ЖЖ自建ЖЖЖЖ自有产权ЖЖ";
        String pattern1 = "\\Ж";
        Pattern p1 = Pattern.compile(pattern1);
        Matcher m1 = p.matcher(line);
        int count1 = 1;
        while (m1.find()){
            count1++;
        }
        System.out.println(count1);
        String[] splits1 = line.split("\\Ж");
        for (String s:splits1){
            System.out.println(s+"\t"+index++);
        }
    }
}
