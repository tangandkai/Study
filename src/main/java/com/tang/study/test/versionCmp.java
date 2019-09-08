package com.tang.study.test;

import java.util.Scanner;

public class versionCmp {

    public static void main(String[] args) {

        new versionCmp().solution();
    }

    public void solution(){
        Scanner scan = new Scanner(System.in);
        int N = Integer.valueOf(scan.nextLine());
        version[] nums = new version[N];
        for (int i=0;i<N;i++){
            String[] splits = scan.nextLine().split(" ");
            nums[i] = new version(splits[0],splits[1]);
        }
        for (int i=0;i<nums.length;i++){
            cal(nums[i]);
        }
    }

    public void cal(version v){
        String[] olders = v.first.split("\\.");
        String[] newers = v.second.split("\\.");
        int olderLen = olders.length;
        int newerLen = newers.length;
        int min = Math.min(olderLen,newerLen);
        for (int i=0;i<min;i++){
            int olderValue = Integer.valueOf(olders[i]);
            int newerValue = Integer.valueOf(newers[i]);
            if (newerValue>olderValue){
                System.out.println(true);
                return;
            }
            else if(newerValue<olderValue){
                System.out.println(false);
                return;
            }
            else
                continue;
        }
        int sum = 0;
        if (newerLen>olderLen){
            for (int i=olderLen;i<newerLen;i++){
                int newerValue = Integer.valueOf(newers[i]);
                sum += newerValue;
            }
        }
        System.out.println(sum>0);
    }


    static class version{
        public String first;
        public String second;

        public version(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }
}
