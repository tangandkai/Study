package com.tang.study.niukwwang.zijie;

import java.io.IOException;
import java.util.*;

public class x_y {

    public static void main(String[] args) throws IOException {
        new x_y().cal();
    }

    public void cal() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.valueOf(scanner.nextLine());
        Point[] points = new Point[num];
        String[] line;
        List<Point> list = new ArrayList<>();
        for (int i=0;i<num;i++){
            line = scanner.nextLine().trim().split(" ");
            points[i] = new Point(Integer.valueOf(line[0]),Integer.valueOf(line[1]));
        }
        Arrays.sort(points);
        System.out.println(points);
        list.add(points[num-1]);
        long max = points[num-1].y;
        for (int i=num-2;i>=0;i--){
            if (points[i].y>max){
                max = points[i].y;
                list.add(points[i]);
            }
        }
        Collections.reverse(list);
        for (Point point:list){
            System.out.println(point);
        }
//        System.out.println(list);
    }



    static class Point implements Comparable{
        long x;
        long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Object o) {
            return Long.compare(this.x,((Point)o).x);
        }

        @Override
        public String toString() {
            return x+" "+y;
        }
    }

}
