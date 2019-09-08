package com.tang.study.niukwwang.zijie;

import scala.Int;

import java.io.IOException;

import java.util.Scanner;

public class array {

    public static void main(String[] args) throws IOException {
        new array().solution();
    }

    public void solution() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine().trim();
        String[] splits = line.split(" ");
        int len = splits.length;
        int max = Integer.valueOf(splits[0])*Integer.valueOf(splits[0]);
        for (int i=0;i<len-1;i++){
            int sum = Integer.valueOf(splits[i]);
            int min = Integer.valueOf(splits[i]);
            for (int j=i+1;j<len-1;j++){
                if (Integer.valueOf(splits[j])==0){
                    break;
                }
                sum += Integer.valueOf(splits[j]);
                if (Integer.valueOf(splits[j])<min){
                    min = Integer.valueOf(splits[j]);
                }
                if (sum * min>max){
                    max = sum*min;
                }
            }
        }
        System.out.println(max);
    }
}
