package com.tang.study.niukwwang.officer;


import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */

class ListNode{
    protected int val;
    ListNode next = null;

    public ListNode(int val) {
         this.val = val;
      }
}
public class printArrayList {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        ArrayList<Integer> arrayList = new ArrayList();
        Stack<Integer> stack = new Stack<>();
        while(listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()){
            arrayList.add(stack.pop());
        }
        return arrayList;
    }
}
