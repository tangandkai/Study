package com.tang.study.likou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class flower {

    public static void main(String[] args) throws IOException {

        int[] array = new int[]{1,0,0,0,1};
        boolean result = new flower().canPlaceFlowers(array, 1);
        System.out.println(result);
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int num = 0;
        for(int i=0;i<flowerbed.length;i++){
            if (flowerbed[i]==0){
                num++;
            }
            else
                num--;
        }

        return func(num)>=n;
    }
    public int func(int n){
        if (n<1){return 0;}
        else if (n<=2){return 1;}
        else return func(n-2)+1;
    }
}
