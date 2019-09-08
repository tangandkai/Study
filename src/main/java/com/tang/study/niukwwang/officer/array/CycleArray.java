package com.tang.study.niukwwang.officer.array;

import org.junit.Test;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class CycleArray {

    public int minNumberInRotateArray(int [] array) {
        if(array.length==0)
            return 0;
        int[] tmp = new int[array.length];
        int position = array.length-2>0?2:0;
        int start = 0;
        int min = Integer.MAX_VALUE;
        for(int i=position;i<array.length;i++){
            tmp[start++] = array[i];
            if(min>array[i]){
                min = array[i];
            }
        }
        for(int i=0;i<position;i++){
            tmp[start++] = array[i];
            if(min>array[i]){
                min = array[i];
            }
        }
        return min;
    }

    @Test
    public void test(){
        int[] array = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println(minNumberInRotateArray(array));
    }

    /**
     * 数组旋转
     * @param nums
     * @param k
     */
    public void rotate(int nums[], int k) {
        int n = nums.length;
        if ((n == 0) || (k <= 0))
            return;
        int numsCopy[] = new int[n];
        for (int i = 0; i < n; i++) {
            numsCopy[i] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[(i + k) % n] = numsCopy[i];
        }
    }
}
