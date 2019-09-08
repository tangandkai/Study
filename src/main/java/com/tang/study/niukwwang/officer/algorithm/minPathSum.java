package com.tang.study.niukwwang.officer.algorithm;

/**
 * 给定一个包含非负整数的 m x n 网格，
 * 请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小
 */
public class minPathSum {

    public static void main(String[] args) {

        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int res = new minPathSum().solution_1(grid);
        System.out.println(res);

        int[][] grid1 = {{1,3,1},{1,5,1},{4,2,1}};
        res = new minPathSum().solution_2(grid1);
        System.out.println(res);
    }

    /**
     * 使用循环
     * @param grid
     * @return
     */
    public int solution_1(int[][] grid){

        //矩阵的行数
        int m = grid.length;
        //矩阵的列数
        int n = grid[0].length;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (i==0 && j!=0){
                    grid[i][j] += grid[i][j-1];
                }
                if (i!=0 && j==0){
                    grid[i][j] += grid[i-1][j];
                }
                if (i!=0 && j!=0){
                    grid[i][j] += Math.min(grid[i][j-1],grid[i-1][j]);
                }
            }
        }
        return grid[m-1][n-1];
    }

    /**
     * 使用递归解决
     * @param grid
     * @return
     */
    public int solution_2(int[][] grid){

        return cal(grid,0,0);
    }

    public int cal(int[][] grid,int i,int j){
        if (i==grid.length-1 && j!=grid[0].length-1){
            return grid[i][j] + cal(grid,i,j+1);
        }
        if (i!=grid.length-1 && j==grid[0].length-1){
            return grid[i][j] + cal(grid,i+1,j);
        }
        if (i==grid.length-1 && j==grid[0].length-1){
            return grid[i][j];
        }
        return grid[i][j] + Math.min(cal(grid,i+1,j),cal(grid,i,j+1));
    }
}
