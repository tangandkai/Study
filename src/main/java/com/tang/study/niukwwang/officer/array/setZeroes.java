package com.tang.study.niukwwang.officer.array;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0
 */
public class setZeroes {

    public static void main(String[] args) {

        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        new setZeroes().solution(matrix);
        System.out.println(matrix);
    }

    public void solution(int[][] matrix){

        int m = matrix.length;
        int n = matrix[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (matrix[i][j] == 0){
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (rows[i]==1 || cols[j]==1)
                    matrix[i][j] = 0;
            }
        }
    }
}
