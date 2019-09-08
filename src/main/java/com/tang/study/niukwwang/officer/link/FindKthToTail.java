package com.tang.study.niukwwang.officer.link;

public class FindKthToTail {

    public MyListNode solution_1(MyListNode head,int k){
        if (k<=0)return null;
        MyListNode node1 = head;
        MyListNode node2 = head;
        int length=0;
        while (node1!=null){
            length++;   //计算链表的长度
            node1 = node1.next;
        }
        if (length<k)return null;
        for (int i=1;i<length-k;i++){
            node2 = node2.next;
        }
        return node2.next;
    }

    public MyListNode solution_2(MyListNode head,int k){

        return null;
    }
}


class MyListNode {
    int val;
    MyListNode next = null;

    MyListNode(int val) {
        this.val = val;
    }
}