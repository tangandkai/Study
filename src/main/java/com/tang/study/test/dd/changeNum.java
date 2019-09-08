package com.tang.study.test.dd;

import scala.collection.immutable.List;

import java.util.ArrayList;
import java.util.Scanner;

public class changeNum {

    public static void main(String[] args) {

        System.out.println();
    }

    public void solution(){
        Scanner scan = new Scanner(System.in);
        int N = Integer.valueOf(scan.nextLine());
        String[] splits = scan.nextLine().trim().split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        String[] f = new String[N-1];
        int index = 0;
        for (int i=0;i<splits.length;i++){
            try {
                int value = Integer.valueOf(splits[i]);
                list.add(value);
            }catch (Exception e){
                f[index++] = splits[i];
            }
        }

        for (int i=0;i<f.length;i++){
            if (f[i].equals("+")){

            }
        }
    }
}
