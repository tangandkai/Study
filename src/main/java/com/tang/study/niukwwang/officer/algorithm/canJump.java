package com.tang.study.niukwwang.officer.algorithm;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 */
public class canJump {

    public static void main(String[] args) {

        int[] nums = {2,3,1,1,4};
        System.out.println(new canJump().jump(nums));
    }

    /**
     * 每次都要记录当前所能跳的最大距离，这个很好理解，假如当前位置能跳10步，
     * 下一位置只能跳2步，
     * 我肯定记录的是能跳10步的那个位置，因为10步的我可以跳到1到10的任何位置，
     * 明显包含了跳2步的
     * @param nums
     * @return
     */
    public boolean jump(int[] nums){

        int size = nums.length;
        int step = nums[0];
        for (int i=0;i<size;i++){
            step--;
            if (step<0){
                return false;
            }
            if (nums[i]>step){
                step = nums[i];
            }
        }
        return true;
    }

    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * [2,3,1,1,4]输出: 2解释: 跳到最后一个位置的最小跳跃数是 2。
     * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     * @param nums
     * @return
     */
    public int jump_1(int[] nums){
        if (nums.length<2){
            return 0;
        }
        int jumps = 0;
        int curEnd = 0;
        int curFarthest = 0;
        for (int i=0;i<nums.length-1;i++){
            curFarthest = Math.max(curFarthest,nums[i]+i);
            if (i==curEnd){
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}
