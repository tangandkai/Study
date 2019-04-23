package com.tang.study.huawei;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 *
 * 1、 记录最多8条错误记录，循环记录，对相同的错误记录（净文件名称和行号完全匹配）
 * 只记录一条，错误计数增加；
 * 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
 *
 * 3、 输入的文件可能带路径，记录文件名称不能带路径。
 * 输入描述:
 * 一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
 *
 * 输出描述:
 * 将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开，如：
 *
 * 示例1
 * 输入
 * E:\V1R2\product\fpgadrive.c   1325
 * 输出
 * fpgadrive.c 1325 1
 */
public class ErrorRecord {

    private static Integer ERRORNUM = 1;
    private static Integer COUNT = 0;
    private static Map<String,Integer> linkHashMap = new LinkedHashMap<>();
    public static void main(String[] args) throws IOException {
        cal();
    }

    /**
     * E:\sql\zepellin.txt
     * @throws IOException
     */
    public static void cal() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = br.readLine())!= null){
            String[] params = line.split(" ");
            String[] file = params[0].split("\\\\");
            String name = file[file.length-1];
            if (name.length()>=16){
                name = name.substring(name.length()-16);
            }
            String key = name+" " + params[1];
            if (linkHashMap.containsKey(key)){
                linkHashMap.put(key, linkHashMap.get(key)+1);
            }
            else {
                linkHashMap.put(key,ERRORNUM);
            }
        }
        for (String key:linkHashMap.keySet()){
            COUNT++;
            if (COUNT>linkHashMap.keySet().size()-8){
                System.out.println(key+" "+linkHashMap.get(key));
            }
        }
    }

}
