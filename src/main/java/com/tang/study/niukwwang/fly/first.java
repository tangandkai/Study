package com.tang.study.niukwwang.fly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class first {

    public static void main(String[] args) {
        new first().solution();
        System.out.println((int)'0');
        System.out.println((int)'9');
    }

    //48 58
    public void cal(){
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        int len = line.length();
        int N=0;
        if (len==0)
            return;
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<len;i++){
            try {
                int value = Integer.parseInt(""+line.charAt(i));
                list.add(value);
            }catch (Exception e){
                N++;
                continue;
            }
        }
        if (N==len){
            System.out.println(-1);
        }
        else {
            Collections.sort(list);
            StringBuilder builder = new StringBuilder(list.size());

            for (int v:list){
                builder.append(v);
            }
            System.out.println(builder.toString());
        }

    }

    public void solution(){
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        int len = line.length();
        int N=0;
        if (len==0)
            return;
        List<Character> list = new ArrayList<>();
        char[] arr = line.toCharArray();
        for (int i=0;i<arr.length;i++){
            if (arr[i]>=48 && arr[i]<58){
                list.add(arr[i]);
            }
            else
                N++;
        }

        if (N==len){
            System.out.println(-1);
        }
        else {
            Collections.sort(list);
            StringBuilder builder = new StringBuilder(list.size());

            for (char v:list){
                builder.append(v);
            }
            System.out.println(builder.toString());
        }
    }
}
