package com.tang.study.niukwwang.officer.tree;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，
 * 这条路径上所有节点值相加等于目标和。
 */
public class hasPathSum {

    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {

    }

    public boolean solution(TreeNode root, int sum){

        if (root == null) return false;
        if (root.left == null && root.right == null && sum - root.val == 0) return true;
        return solution(root.left, sum - root.val) || solution(root.right, sum - root.val);
    }

    int count =0;
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0, 1);
        helper(root, 0, sum, preSum);
        return count;
    }

    public void helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null)
            return;
        currSum += root.val;
        if (preSum.containsKey(currSum - target)) {
            count += preSum.get(currSum - target);
        }
        if (!preSum.containsKey(currSum)) {
            preSum.put(currSum, 1);
        } else {
            preSum.put(currSum, preSum.get(currSum) + 1);
        }
        helper(root.left, currSum, target, preSum);
        helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
    }

    /**
     * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     * (注意: 在返回值的list中，数组长度大的数组靠前)
     * @param root
     * @param target
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target){
        if(root==null)return result;
        list.add(root.val);
        target-=root.val;
        if(target==0&&root.left==null&&root.right==null){
            result.add(new ArrayList<Integer>(list));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size()-1);
        return result;
    }
}
