package com.tang.study.niukwwang.officer.tree;

/**
 * 二叉树的深度
 */
public class Depth {

    public static void main(String[] args) {

    }

    /**
     * 最小深度
     * @param root
     * @return
     */
    public int solution_1(TreeNode root){

        if (root == null) return 0;
        int left = solution_1(root.left);
        int right = solution_1(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }

    /**
     * 最大深度
     */
    public int solution_2(TreeNode root){
        if (root == null) return 0;
        int left = solution_2(root.left);
        int right = solution_2(root.right);
        return Math.max(left,right)+1;
    }

    /**
     * 判断二叉树是否平衡
     * @param root
     * @return
     */
    public boolean isBanlence(TreeNode root){
        return check(root)!=-1;
    }
    private int check(TreeNode root) {
        if (root == null) return 0;
        int left = check(root.left);
        int right = check(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1)
            return -1;
        return 1 + Math.max(left, right);
    }
}
