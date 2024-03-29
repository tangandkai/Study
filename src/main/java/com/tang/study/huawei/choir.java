package com.tang.study.huawei;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * 计算最少出列多少位同学，使得剩下的同学排成合唱队形
 *
 * 说明：
 *
 * N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
 * 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，
 * 则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 * 输入描述:
 * 整数N
 *
 * 输出描述:
 * 最少需要几位同学出列
 *
 * 示例1
 * 输入
 * 8
 * 186 186 150 200 160 130 197 200
 * 输出
 * 4
 */
public class choir {

    private static LinkedHashSet linkedHashSet;
    public static void main(String[] args) throws IOException {
        cal();
    }

    public static void cal() throws IOException {
        int n = 0;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line=br.readLine())!= null){
            int Num = 0;
            linkedHashSet = new LinkedHashSet();
            if (n == 0){
                Num = Integer.parseInt(line);
            }
            else {
                get(line);

            }
            n++;
        }
    }

    public static void get(String line){
        boolean flag = false;
        String[] heights = line.split(" ");
        for (String height:heights){
            linkedHashSet.add(height);
        }
        int diff = heights.length-linkedHashSet.size();
        Integer[] array = new Integer[linkedHashSet.size()];
        linkedHashSet.toArray(array);
        for (int i=0;i<array.length-1;i++){
            for (int j=i+1;j<array.length;j++){
                if (array[i]>array[j]){
                    flag = true;
                    continue;
                }
            }
        }
    }
}
