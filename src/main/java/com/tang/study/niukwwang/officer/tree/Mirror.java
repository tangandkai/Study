package com.tang.study.niukwwang.officer.tree;

/**
 * 二叉树左右孩子互换
 */
public class Mirror {

    public void solution(TreeNode root){
        TreeNode temp;
        if(root!=null)
        {
            temp=root.left;
            root.left=root.right;
            root.right=temp;
            if(root.left!=null)
                solution(root.left);
            if(root.right!=null)
                solution(root.right);
        }
    }
}
