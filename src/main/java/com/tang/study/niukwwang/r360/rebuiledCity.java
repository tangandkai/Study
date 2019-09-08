package com.tang.study.niukwwang.r360;

import java.util.*;

public class rebuiledCity {

    public static void main(String[] args) {
        new rebuiledCity().tt();
    }

    public void cal(){

        Map<Long,Long> hash = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        int N = Integer.valueOf(scan.nextLine());
        String[] x_y;
        long max;
        long zero_x_max = Long.MIN_VALUE;
        long zero_x_min = Long.MAX_VALUE;
        long zero_y_max = Long.MIN_VALUE;
        long zero_y_min = Long.MAX_VALUE;
        for (int i=0;i<N;i++){
            x_y = scan.nextLine().trim().split(" ");
            if (Long.valueOf(x_y[0])==0){
                if (Long.valueOf(x_y[1])>zero_x_max){
                    zero_x_max = Long.valueOf(x_y[1]);
                }
                if (Long.valueOf(x_y[1])<zero_x_min){
                    zero_x_min = Long.valueOf(x_y[1]);
                }
            }
            if (Long.valueOf(x_y[1])==0){
                if (Long.valueOf(x_y[0])>zero_y_max){
                    zero_y_max = Long.valueOf(x_y[0]);
                }
                if (Long.valueOf(x_y[0])<zero_y_min){
                    zero_y_min = Long.valueOf(x_y[0]);
                }
            }
            //&& Long.valueOf(x_y[0])>0
            //hash.get(Long.valueOf(x_y[0])<Long.valueOf(x_y[0])

            hash.put(Long.valueOf(x_y[0]),Long.valueOf(x_y[1]));
        }
        Set<Long> keys = hash.keySet();
        Collection<Long> values = hash.values();
        long maxValue = Collections.max(values);
        long minValue = Collections.min(values);
        long maxKey = Collections.max(keys);
        long minKey = Collections.min(keys);
        Math.max(zero_x_max-zero_x_min,zero_y_max-zero_y_min);
        max = Math.max(Math.max(zero_x_max-zero_x_min,zero_y_max-zero_y_min),Math.max(maxKey-minKey,maxValue-minValue));
//        max = Math.max(maxKey-minKey,maxValue-minValue);
        System.out.println(max*max);
    }

    public void solution(){
        Scanner scan = new Scanner(System.in);
        int N = Integer.valueOf(scan.nextLine());
        String[] line;
        long max_x = Long.MIN_VALUE;
        long min_x = Long.MAX_VALUE;
        long max_y = Long.MIN_VALUE;
        long min_y = Long.MAX_VALUE;
        for (int i=0;i<N;i++){
            line = scan.nextLine().trim().split(" ");
            if (Long.valueOf(line[0])>max_x){
                max_x = Long.valueOf(line[0]);
            }
            if (Long.valueOf(line[0])<min_x){
                min_x = Long.valueOf(line[0]);
            }
            if (Long.valueOf(line[1])>max_y){
                max_y = Long.valueOf(line[1]);
            }
            if (Long.valueOf(line[0])<min_y){
                min_y = Long.valueOf(line[1]);
            }
        }
        long max;
        max = Math.max(max_x-min_x,max_y-min_y);
        System.out.println(max*max);
    }

    public void tt(){
        Map<Long,Long> hash = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        int N = Integer.valueOf(scan.nextLine());
        String[] x_y;
        long max;
        for (int i=0;i<N;i++){
            x_y = scan.nextLine().trim().split(" ");
            long x = Long.valueOf(x_y[0]);
            long y = Long.valueOf(x_y[1]);
            if (hash.containsKey(x)){
                if (hash.get(x)>y){
                    if (y>0){
                        continue;
                    }
                    if (y<=0 && hash.get(x)>0){
                        hash.put(x,hash.get(x)-y);
                    }
                    if (y<=0 && hash.get(x)<=0){
                        hash.put(x,y);
                    }
                }
                else {
                    if (y<=0){
                        continue;
                    }
                    if (y>0 && hash.get(x)<=0){
                        hash.put(x,y-hash.get(x));
                    }
                    if (y>0 && hash.get(x)>=0){
                        hash.put(x,y);
                    }
                }
            }
            else
                hash.put(Long.valueOf(x_y[0]),Long.valueOf(x_y[1]));
        }
        Set<Long> keys = hash.keySet();
        Collection<Long> values = hash.values();
        long maxValue = Collections.max(values);
        long minValue = Collections.min(values);
        long maxKey = Collections.max(keys);
        long minKey = Collections.min(keys);
        if (maxValue==minValue){minValue=-minValue;}
        if (maxKey==minKey){minKey=-minKey;}

        max = Math.max(maxKey-minKey,maxValue-minValue);
        System.out.println(max*max);
    }
    static class X_Y{
        public int X;
        public int Y;

        public X_Y(int x, int y) {
            X = x;
            Y = y;
        }
    }
}
