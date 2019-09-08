package com.tang.study.niukwwang.fly;

import java.util.Scanner;

public class second {

    public static void main(String[] args) {

        new second().cal();
    }

    public void cal(){
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        line = line.replace("\\{","").replace("\\}","");

        String[] arr = line.split(",");
        int res = solution(arr,0,arr.length-1);
        System.out.println(res);
    }

    public int solution(String[] str,int low,int high){
        int mid = low + (high-low)/2;
        if (low>=high){
            return -1;
        }
        int val = Integer.parseInt(str[mid]);
        if (val==19){
            return mid+1;
        }
        if (val>19){
            high = mid-1;
        }
        if (val<19){
            low = mid+1;
        }
        return solution(str,low,high);

    }
}
