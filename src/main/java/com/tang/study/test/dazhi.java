package com.tang.study.test;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Scanner;

public class dazhi {

    public static void main(String[] args) {
        new dazhi().solution();

    }


    public void solution(){
        Scanner scan = new Scanner(System.in);
        int N = Integer.valueOf(scan.nextLine());
        String words = scan.nextLine();
        int index = N;
        int count = 0;
        char[] warr = words.toCharArray();

        int[] first = new int[100];
        int[] second = new int[100];
        int i = 1;
        while (N>0){
            --N;
            first[0] = 0;
            second[0] = 1;
            for (i=1;i<warr.length;i++){
                if (warr[i]>='a' && warr[i]<='z'){
                    first[i] = Math.min(first[i-1]+1,second[i-1]+2);
                    second[i] = Math.min(first[i-1]+2,second[i-1]+2);
                }
                else if (warr[i]>='A' && warr[i]<='Z'){
                    first[i] = Math.min(first[i-1]+2,second[i-1]+2);
                    second[i] = Math.min(first[i-1]+2,second[i-1]+1);
                }
            }
        }
        System.out.println(Math.min(first[i-1],second[i-1]+1));

    }

    public int solution_1(){
        Scanner scan = new Scanner(System.in);
        int N = Integer.valueOf(scan.nextLine());
        String words = scan.nextLine();
        int[][] res = new int[N+2][2];
        res[0][0] = 0;
        res[0][1] = 1;
        int index = N;
        char[] warr = words.toCharArray();
        while (index>0){
            index--;
            for (int i=1;i<warr.length;i++){
                if (warr[i]>='A' && warr[i]<='Z'){
                    res[i][0] = Math.min(res[i-1][0]+2,res[i-1][1]+2);
                    res[i][1] = Math.min(res[i-1][0]+2,res[i-1][1]+1);
                }
                else {
                    res[i][0] = Math.min(res[i-1][0]+1,res[i-1][1]+2);
                    res[i][1] = Math.min(res[i-1][0]+2,res[i-1][1]+2);
                }
            }
            res[warr.length][1]++;
        }
        System.out.println(Math.min(res[warr.length][0],res[warr.length][1]));
        return 1;
    }
}
