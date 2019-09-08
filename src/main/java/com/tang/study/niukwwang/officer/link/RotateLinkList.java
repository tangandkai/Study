package com.tang.study.niukwwang.officer.link;

/**
 *给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 */
public class RotateLinkList {

    public ListNode solution(ListNode head,int k){
        if (head==null){return null;}
        ListNode curNode = head;
        ListNode result = head;
        int N = 1;
        while (curNode.next!=null){
            N++;
            curNode = curNode.next;
        }
        //将链表变成循环链表
        curNode.next = head;
        k = k%N;
        while ((N-k)>0){
            k++;
            result = result.next;
        }
        curNode = result;
        while (curNode.next!=result){
            curNode = curNode.next;
        }
        //将循环链表断开
        curNode.next = null;
        return result;
    }

}
