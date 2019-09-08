package com.tang.study.niukwwang.officer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}

/**
 * 二叉树四种遍历方式
 */
public class PrintFromTopToBottom {

    public static void main(String[] args) {

    }

    /**
     * 层次遍历
     * @param root
     * @return
     */
    public static ArrayList<Integer> layerTranverse(TreeNode root){

        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> array = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            array.add(node.val);
            if (node.left!=null){
                queue.add(node.left);
            }
            if (node.right!=null){
                queue.add(node.right);
            }
        }
        return array;
    }

    /**
     * 前序遍历
     * @param root
     * @return
     */
    public static ArrayList<Integer> preOrder(TreeNode root){
        ArrayList<Integer> array = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node!=null || !stack.isEmpty()){
            if (node!=null){
                array.add(node.val);
                stack.push(node);
                node = node.left;
            }
            else {
                node = stack.pop();
                node = node.right;
            }
        }
        return array;
    }

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public static ArrayList<Integer> inOrder(TreeNode root){
        ArrayList<Integer> array = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node!=null || !stack.isEmpty()){
            if (node!=null){
                stack.push(node);
                node = node.left;
            }
            else {
                node = stack.pop();
                array.add(node.val);
                node = node.right;
            }
        }
        return array;
    }

    /**
     * 后序遍历
     * @param root
     * @return
     */
    public static ArrayList<Integer> postOrder(TreeNode root){
        ArrayList<Integer> array = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode node = root;
        while (node!=null || !stack2.isEmpty()){
            if (node!=null){
                stack1.push(node);
                stack2.push(node);
                node = node.left;
            }
            else {
                node = stack2.pop();
                node = node.right;
            }
        }
        while (!stack1.isEmpty()){
            node = stack1.pop();
            array.add(node.val);
        }
        return array;
    }
}
