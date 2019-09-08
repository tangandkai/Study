package com.tang.study.niukwwang.zijie;

import java.util.*;

public class three {

    public static void main(String[] args) {
        new three().tt();
    }

    public void cal(){
        Scanner scan = new Scanner(System.in);
        int N = Integer.valueOf(scan.nextLine());
        String line = scan.nextLine();
        int[] sal = new int[N];
        List<Integer> list = new ArrayList<>(N);
        String[] ages = line.split(" ");

        int sum = 0;
        for (int i=0;i<ages.length;i++){
            int tmp = Integer.valueOf("");
            if (i==0){
                sal[0] = 100;
                list.add(sal[0]);
            }
            else {
                if (Integer.valueOf(ages[i])>Integer.valueOf(ages[i-1])){
                    sal[i] = sal[i-1]+100;
                    list.add(sal[i]);
                }
                else if (Integer.valueOf(ages[i])==Integer.valueOf(ages[i-1])){
                    sal[i] = sal[i-1];
                    list.add(sal[i]);
                }
                else {
                    sal[i] = sal[i-1]-100;
                    if (sal[i]<=100){
                        sal[i] = 100;
                    }
                    list.add(sal[i]);
                }
            }
            sum += sal[i];
        }

        System.out.println(list);
//        int sum = 0;
//        for (int i=0;i<sal.length;i++){
//            sum += sal[i];
//        }
        System.out.println(sum);
    }

    public void su(){
        Scanner scan = new Scanner(System.in);
        int N = Integer.valueOf(scan.nextLine());
        String line = scan.nextLine();
        int[] sal = new int[N];
        List<Integer> list = new ArrayList<>(N);
        String[] ages = line.split(" ");

        int[] res = new int[N];
        for (int i=0;i<ages.length;i++){
            res[i] = Integer.valueOf(ages[i]);
        }
        Arrays.sort(res);
        int sum = 0;
        for (int i=0;i<res.length;i++){
            int tmp = res[i];
            if (i==0){
                res[0] = 100;
                list.add(res[0]);
            }
            else {
                if (res[i]>tmp){
                    res[i] = res[i-1]+100;
                    list.add(res[i]);
                }
                else if (res[i]==tmp){
                    res[i] = res[i-1];
                    list.add(res[i]);
                }
                else {
                    res[i] = res[i-1]-100;
                    if (res[i]<=100){
                        res[i] = 100;
                    }
                    list.add(res[i]);
                }
            }
            sum += res[i];
        }

        System.out.println(list);
//        int sum = 0;
//        for (int i=0;i<sal.length;i++){
//            sum += sal[i];
//        }
        System.out.println(sum);
    }

    public void tt(){

        Scanner scan = new Scanner(System.in);
        int N = Integer.valueOf(scan.nextLine());
        String line = scan.nextLine();
        int[] sal = new int[N];
        List<Integer> list = new ArrayList<>(N);
        String[] ages = line.split(" ");

        int sum = 0;
        for (int i=0;i<ages.length;i++){
            int tmp = Integer.valueOf(ages[i]);
            if (i==0){
                ages[0] = ""+100;
                list.add(sal[0]);
            }
            else {
                if (Integer.valueOf(ages[i])>tmp){
                    sal[i] = sal[i-1]+100;
                    list.add(sal[i]);
                }
                else if (Integer.valueOf(ages[i])==tmp){
                    sal[i] = sal[i-1];
                    list.add(sal[i]);
                }
                else {
                    sal[i] = sal[i-1]-100;
                    if (sal[i]<=100){
                        sal[i] = 100;
                    }
                    list.add(sal[i]);
                }
            }
            sum += Integer.valueOf(ages[i]);
        }

        System.out.println(list);
//        int sum = 0;
//        for (int i=0;i<sal.length;i++){
//            sum += sal[i];
//        }
        System.out.println(sum);
    }
}
