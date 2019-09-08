package com.tang.study.niukwwang.officer.algorithm;

/**
 * 旋转矩阵
 */
public class rotatePicture {

    public static void main(String[] args) {


    }

    public void solution(int[][] matrix){
        int length = matrix.length;
        for (int i = 0; i < length / 2; i++) {
            int temp[] = matrix[i];
            matrix[i] = matrix[length - i - 1];
            matrix[length - i - 1] = temp;
        }
        for (int i = 0; i < length; ++i) {
            for (int j = i + 1; j < matrix[i].length; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
