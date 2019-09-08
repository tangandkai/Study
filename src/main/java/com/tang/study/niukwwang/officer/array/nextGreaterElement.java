package com.tang.study.niukwwang.officer.array;

import scala.actors.threadpool.Arrays;

import java.util.List;
import java.util.Scanner;

/**
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 * 找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2
 * 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1
 */
public class nextGreaterElement {

    public static void main(String[] args) {

        List<Integer> list = new nextGreaterElement().solution();
        System.out.println(list);
    }

    public List<Integer> solution(){
        Scanner scan = new Scanner(System.in);
        String line1 = scan.nextLine();
        String line2 = scan.nextLine();

        String[] nums1 = line1.replaceAll("\\[","").
                replaceAll("\\]","").split(",");

        String[] nums2 = line2.replaceAll("\\[","").
                replaceAll("\\]","").split(",");

        int length1 = nums1.length;
        int length2 = nums2.length;
        Integer[] res = new Integer[length1];
        for (int i=0;i<length1;i++){
            res[i] = -1;
            for (int j=i;j<length2;j++){
                if (Integer.valueOf(nums1[i])<Integer.valueOf(nums2[j])){
                    res[i] = Integer.valueOf(nums2[j]);
                    nums2[j] = Integer.MIN_VALUE +"";
                    break;
                }
            }
        }
        return Arrays.asList(res);
    }

}
