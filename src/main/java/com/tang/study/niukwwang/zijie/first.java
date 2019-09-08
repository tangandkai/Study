package com.tang.study.niukwwang.zijie;

import java.util.Scanner;

public class first {

    static class TTime implements Comparable{
        public int H;
        public int M;

        public TTime(int h, int m) {
            H = h;
            M = m;
        }

        @Override
        public String toString() {
            return H+" "+M;
        }

        @Override
        public int compareTo(Object o) {
            return Integer.compare(this.H,((TTime)o).H);
        }
    }

    public static void main(String[] args) {

        new first().cal();
    }

    public void cal(){
        Scanner scan = new Scanner(System.in);
        int N = Integer.valueOf(scan.nextLine());
        TTime[] TT = new TTime[N+1];
        String[] line;
        for (int i=0;i<N;i++){
            line = scan.nextLine().split(" ");
            TT[i] = new TTime(Integer.valueOf(line[0]),Integer.valueOf(line[1]));
        }

        TT[N] = new TTime(0,0);
        int stayTime = Integer.valueOf(scan.nextLine());
        String startTime = scan.nextLine();
        int satrtM = Integer.valueOf(startTime.split(" ")[1]);
        int satrtH = Integer.valueOf(startTime.split(" ")[0]);
        int M = 0;
//        int sub = 0;
        if (satrtM>=stayTime)
            M = satrtM-stayTime;
        else {
            while ((M=satrtM-stayTime)<0){
                satrtM = satrtM+60;
                satrtH--;
            }
//            satrtM = satrtM+60-stayTime;
//            satrtH--;
        }
        for (int i=0;i<N;i++){
            if (TT[i].H < satrtH){
                TT[N].H = TT[i].H;
                TT[N].M = TT[i].M;
            }
            else if (TT[i].H==satrtH && TT[i].M <= M){
                TT[N].H = TT[i].H;
                TT[N].M = TT[i].M;
            }
            else
                break;
        }
        System.out.println(TT[N]);
    }
}
