package com.tang.study.niukwwang.officer.link;

import org.junit.Test;

import java.util.Stack;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {
    private ListNode_1 head_1;
    public void add(int index,int e){

        ListNode_1 node = new ListNode_1(e);
        if (head_1==null){
            head_1 = node;
        }
        else {
            node.next = head_1;
            head_1 = node;
        }
//        System.out.println(head_1.toString());
    }

    public ListNode_1 solution_1(ListNode_1 head){
        ListNode_1 node = head;
        ListNode_1 resultNode = null;
        while (node!=null){
            ListNode_1 value = new ListNode_1(node.val);
            value.next = resultNode;
            resultNode = value;
            node = node.next;
        }
        return resultNode;
    }

    public ListNode_1 solution_2(ListNode_1 head){

        if(head==null)
            return null;
        ListNode_1 node = head;
        ListNode_1 resultNode = null;
        ListNode_1 pre = null;
        while(node!=null){
            ListNode_1 next = node.next;
//            if(next==null){
//                resultNode = node;
//            }
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }



    public static void main(String[] args) {
        ReverseList list = new ReverseList();
        list.add(0,1);
        list.add(0,2);
        list.add(0,3);
        list.add(0,4);
        System.out.println(list.solution_2(list.head_1));
//        System.out.println(list.head_1);
//        System.out.println(list.solution_1(list.head_1));
    }
    @Override
    public String toString() {
        return "ReverseList{" +
                "head_1=" + head_1 +
                '}';
    }
}

class ListNode_1 {
    int val;
    ListNode_1 next = null;

    ListNode_1(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode_1{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
