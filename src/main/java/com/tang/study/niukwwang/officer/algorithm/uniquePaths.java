package com.tang.study.niukwwang.officer.algorithm;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角,有多少种方法
 */
public class uniquePaths {

    public static void main(String[] args) {

        long time = System.currentTimeMillis();
        int res1 = new uniquePaths().solution_1(3, 9);
        System.out.println(res1);
        System.out.println(System.currentTimeMillis()-time);

        int[][] paths = {{0,0,0},{0,1,0},{0,0,0}};
        int res2 = new uniquePaths().solution_2(paths);
        System.out.println(res2);

        time = System.currentTimeMillis();
        new uniquePaths().cal(3,9);
        System.out.println(System.currentTimeMillis()-time);
    }

    /**
     * 中间无障碍
     * @param m
     * @param n
     * @return
     */
    public int solution_1(int m,int n){

        return solution_1(1,1,m,n);
    }

    public int solution_1(int i,int j,int m,int n){
        if(i>m || j>n){return 0;}
        if (i==m && j==n){return 1;}
        int right = solution_1(i,j+1,m,n);
        int down  = solution_1(i+1,j,m,n);
        return right+down;
    }

    public void cal(int m,int n){
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i=0;i<m;i++){
            for (int j=1;j<n;j++){
                dp[j] += dp[j-1];
            }
        }
        System.out.println(dp[n-1]);
    }

    /**
     * 中间有障碍
     * @param obstacleGrid
     * @return
     */
    public int solution_2(int[][] obstacleGrid){

        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row:obstacleGrid){
            for (int i=0;i<width;i++){
                if (row[i]==1)
                    dp[i] = 0;
                else if (i>0)
                    dp[i] += dp[i-1];
            }
        }
        return dp[width-1];
    }
}
