package com.tang.study.niukwwang.officer.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 顺时针打印矩阵
 * 构造矩阵
 */
public class printMatrix {

    String str = "\\[";
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(matrix[2][3]);
        List<Integer> rs = solution_1(matrix);
        System.out.println(rs);
        System.out.println(Math.addExact(5,4));

        int[][] res = new printMatrix().solution_2(4);
        for (int[] r:res){
            System.out.println(r[0]+" "+r[1]+" "+r[2]+" "+r[3]);
        }
    }

    /**
     * 顺时针打印矩阵
     * @param matrix
     * @return
     */
    public static List<Integer> solution_1(int[][] matrix){
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return list;
        //矩阵行数
        int R = matrix.length;
        //矩阵列数
        int C = matrix[0].length;
        int up = 0;
        int down = R-1;
        int left = 0;
        int right = C-1;
        int total = R*C;
        while (list.size()<total){
            for (int i=left;i<=right && list.size()<total;i++){
                list.add(matrix[up][i]);
            }
            for (int i=up+1;i<=down-1 && list.size()<total;i++){
                list.add(matrix[i][right]);
            }
            for (int i=right;i>=left && list.size()<total;i--){
                list.add(matrix[down][i]);
            }
            for (int i=down-1;i>up && list.size()<total;i--){
                list.add(matrix[i][left]);
            }
            up++;
            down--;
            left++;
            right--;
        }
        return list;
    }

    /**
     * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
     * @param n
     * @return
     */
    public int[][] solution_2(int n){
        int[][] matrix = new int[n][n];
        int total = n*n;
        //矩阵的四个方向
        int up = 0;
        int down = n-1;

        int left = 0;
        int right = n-1;

        int num = 0;
        while (total>0){
            for (int i=left;i<=right;i++){
                matrix[up][i] = ++num;
                total--;
            }
            for (int i=up+1;i<=down-1;i++){
                matrix[i][right] = ++num;
                total--;
            }
            for (int i=right;i>=left;i--){
                matrix[down][i] = ++num;
                total--;
            }
            for (int i=down-1;i>up;i--){
                matrix[i][left] = ++num;
                total--;
            }
            up++;
            down--;
            left++;
            right--;
        }
        return matrix;
    }
}
