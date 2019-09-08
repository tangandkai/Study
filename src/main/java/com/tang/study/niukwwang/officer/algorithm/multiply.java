package com.tang.study.niukwwang.officer.algorithm;

public class multiply {

    public static void main(String[] args) {

    }

    public static int[] solution(int[] A){
        int[] B = new int[A.length];
        for (int i=0;i<A.length;i++) {
            B[i] = cal(i,A);
        }
        return B;
    }

    public static int cal(int index,int[] A) {
        int mul = 1;
        for (int i=0;i<index;i++){
            mul = mul*A[i];
        }
        for (int i=index+1;i<A.length;i++){
            mul = mul*A[i];
        }
        return mul;
    }
}
