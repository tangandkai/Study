package com.tang.study.niukwwang.zijie;

import java.util.Scanner;

public class maxLenStr {

    public static void main(String[] args) {

        System.out.println('a'-32);
    }

    public int cal(){
        Scanner scan = new Scanner(System.in);
        String line1 = scan.nextLine();
        String[] nums = line1.split(" ");
        int n = Integer.valueOf(nums[0]);
        int m = Integer.valueOf(nums[1]);
        String[] strs = scan.nextLine().trim().split(" ");
        int res = 0;
        int numA = 0;
        int numB = 0;
        int left = 0;
        for (int i=0;i<strs.length;i++){
            if (strs[i].equals("a")){
                numA++;
            }
            else
                numB++;
            while (numA>m && numB>m){
                if (strs[left].equals("a")){
                    numA--;
                }
                else
                    numB--;
                left++;
            }
            res = Math.max(res,i-left+1);
        }
        return res;
    }
}
