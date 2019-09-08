package com.tang.study.test;

import java.util.Scanner;

public class insert {

    public static void main(String[] args) {

        new insert().solution_2();
    }

    public void solution_1(){
        Scanner scan = new Scanner(System.in);
        String line1 = scan.nextLine();
        String line2 = scan.nextLine();
        String[] nums = line1.split(" ");
        String[] words = line2.split(" ");
        StringBuilder builder = new StringBuilder(nums.length+words.length);
        int count = 0;
        int index = 0;
        for (int i=0;i<nums.length;i++){
            builder.append(nums[i]).append(" ");
            count++;
            if (count==4){
                if (index<words.length){
                    builder.append(words[index]).append(" ");
                    index++;
                }
                count=0;
            }
        }
        while (index<words.length){
            builder.append(words[index]).append(" ");
            index++;
        }
        System.out.println(builder.toString());
    }

    public void solution_2(){
        Scanner scan = new Scanner(System.in);
        int N = Integer.valueOf(scan.nextLine());
        int[] nums = new int[N];
        for (int i=0;i<N;i++){
            nums[i] = Integer.valueOf(scan.nextLine());
        }

        for (int i =0;i<nums.length;i++){
            cal(nums[i],0,0);
        }

    }

    public void cal(int num,int sum,int count){
        String tmp = num+"";
        for (int i=0;i<tmp.length();i++){
            int value = Integer.valueOf(tmp.charAt(i)+"");
            sum += Math.pow(value,2);
        }
        if (sum==1){
            System.out.println(true);
            return;
        }
        if (count>1000){
            System.out.println(false);
            return;
        }
        count++;
        cal(sum,0,count);
    }


//    public void calu(version v){
//        String older = v.first.replaceAll("\\.","");
//        String newer = v.second.replaceAll("\\.","");
//        int olderLen = older.length();
//        int newerLen = newer.length();
//        int newerValue = Integer.valueOf(newer);
//        int olderValue = Integer.valueOf(older);
//
//        while (olderLen<newerLen){
//            olderValue = olderValue*10;
//            olderLen++;
//        }
//
//        while (olderLen>newerLen){
//            newerValue = newerValue*10;
//            newerLen++;
//        }
//        if (olderLen==newerLen){
//            System.out.println(newerValue>olderValue);
//        }
//    }

}
