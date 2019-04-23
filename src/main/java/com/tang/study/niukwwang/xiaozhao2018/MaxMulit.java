package com.tang.study.niukwwang.xiaozhao2018;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，
 * 使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)
 * 输入描述:
 * 无序整数数组A[n]
 * 输出描述:
 * 满足条件的最大乘积
 * 示例1
 * 输入
 * 3 4 1 2
 * 输出
 * 24
 */
public class MaxMulit {

    public static void main(String[] args) {
        ArrayList<Integer> arraylist = getArrayList();
        calMaxMulit(arraylist);
    }

    /**
     * 获取输入的数据，存放到ArrayList
     * @return
     */
    private static ArrayList<Integer> getArrayList(){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        String[] lists = scanner.nextLine().split(" ");
        for(String list:lists){
            arrayList.add(Integer.parseInt(list));
        }
        return arrayList;
    }

    /**
     * 计算满足要求的最大乘积
     */
    private static Integer calMaxMulit(ArrayList<Integer> arrayList){

        int max = 0;
        ArrayList<Integer> result = new ArrayList<>();
        Integer[] array = new Integer[arrayList.size()];
        array = arrayList.toArray(array);
        //从数组中任意选取三个，不重复，计算乘积
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                for (int k = j+1; k < array.length; k++) {
                    result.add(array[i]*array[j]*array[k]);
                }
            }
        }
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i)>max){
                max = result.get(i);
            }
        }
        System.out.println(result.toString());
        System.out.println("最大值为："+max);
        return max;
    }
}
