package com.tang.study.niukwwang.r360;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import java.util.*;

public class first {

    public static void main(String[] args) {

        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        String c = ""+x;

        System.out.println(x==y);
        System.out.println(x==Integer.valueOf(c));
        System.out.println(x%5);

        new first().cal();
    }

    public void cal(){
        Scanner scan = new Scanner(System.in);
        String N_M = scan.nextLine();
        String[] N_MS = N_M.split(" ");
        int N = Integer.valueOf(N_MS[0]);
        int M = Integer.valueOf(N_MS[1]);
        String[] firstS = scan.nextLine().split(" ");
        String[] secondS = scan.nextLine().split(" ");
        solution(N,M,firstS,secondS);
    }

    public void solution(int N,int M,String[] firstS,String[] secondS){
        int[] arr = new int[N];
        StringBuilder builder = new StringBuilder(N);
        for (int i=0;i<N;i++){
            int result;
            int index=0;
            int max = Integer.MIN_VALUE;
            int f = Integer.valueOf(firstS[i]);
            for (int j=0;j<N;j++){
                int s = Integer.valueOf(secondS[j]);
                if (s==Integer.MAX_VALUE)
                    continue;
                result = (s+f)%M;
                if (result>max){
                    max = result;
                    index = j;
                }
                if (result==M-1)
                    break;
            }
            secondS[index]=Integer.MAX_VALUE+"";
//            builder.append(max);
//            list.add(max);
            arr[i] = max;
        }
        Arrays.sort(arr);
        for (int i=arr.length-1;i>=0;i--){
            builder.append(arr[i]).append(" ");
//            System.out.println(arr[i]);
        }
        System.out.println(builder.toString());
    }
}
