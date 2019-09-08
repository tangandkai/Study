package com.tang.study.niukwwang.officer.tree;

/**
 * 判定给定的数组是否是平衡二叉树后序遍历的结果
 */
public class VerifySquenceOfBST {

    public boolean VerifyBST(int [] sequence) {
        if(sequence.length == 0) return false;
        return IsTreeBST(sequence, 0, sequence.length-1);
    }
    public boolean IsTreeBST(int [] sequence,int start,int end ){
        if(end <= start) return true;
        int i = start;
        for (; i < end; i++) {
            if(sequence[i] > sequence[end]) break;
        }
        for (int j = i; j < end; j++) {
            if(sequence[j] < sequence[end]) return false;
        }
        return IsTreeBST(sequence, start, i-1) && IsTreeBST(sequence, i, end-1);
    }

    public void test(){
        short p = 1;
//        p = p+1;
        p+=1;
    }
}
