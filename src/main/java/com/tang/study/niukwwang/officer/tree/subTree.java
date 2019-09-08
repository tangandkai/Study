package com.tang.study.niukwwang.officer.tree;

/**
 * 树的子结构
 */
public class subTree {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null || root2==null){return false;}
        boolean result = false;
        if(root1.val>root2.val){
            result = HasSubtree(root1.left,root2);
        }
        if(root1.val<root2.val){
            result = HasSubtree(root1.right,root2);
        }
        if(root1.val==root2.val){
            result = isSub(root1,root2);
        }
        return result;
    }

    public boolean isSub(TreeNode tree1,TreeNode tree2){
        if(tree2 == null){return true;}
        if(tree1 == null){return false;}
        if(tree1.val!=tree2.val){return false;}
        if(tree1.val == tree2.val){
            return isSub(tree1.left,tree2.left) && isSub(tree1.right,tree2.right);
        }
        else
            return false;
    }
}
