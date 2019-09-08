package com.tang.study.niukwwang.officer.algorithm;

import java.util.HashMap;

/**
 * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，
 * 其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 *
 * 找到所有回旋镖的数量。你可以假设 n 最大为 500，
 * 所有点的坐标在闭区间 [-10000, 10000] 中。
 *
 * 示例:
 *
 * 输入:[[0,0],[1,0],[2,0]]
 * 输出:2
 * 解释:两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 */
public class numberOfBoomerangs {

    public static void main(String[] args) {


    }

    public int solution(int[][] matrix){
        int res = 0;
        HashMap<Integer,Integer> hash = new HashMap<>();
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix.length;j++){
                if (i==j){
                    continue;
                }
                int d = getDistance(matrix[i],matrix[j]);
                hash.put(d,hash.getOrDefault(d,0)+1);
            }
            for (int val:hash.values()){
                res += val*(val-1);
            }
            hash.clear();
        }
        return res;
    }

    public int getDistance(int[] x1,int[] x2){

        int dx = x1[0] - x2[0];
        int dy = x1[1] - x2[1];
        return dx*dx + dy*dy;
    }
}
