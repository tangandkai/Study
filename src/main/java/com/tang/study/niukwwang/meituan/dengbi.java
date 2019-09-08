package com.tang.study.niukwwang.meituan;

import java.util.Scanner;

public class dengbi {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()) {
            String value = scan.nextLine();
            System.out.println(new dengbi().cal(Integer.parseInt(value)));
        }
    }

    public int cal(int num){
        int sum=0;
        if (num==1)
            sum = 1;
        else if (num==2)
            sum = 2;
        else {
            for (int i=1;i<num;i++){
                sum+=cal(num-i);
            }
            sum+=1;
        }

        return sum;
    }
}
