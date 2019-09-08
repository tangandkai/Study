package com.tang.study.likou.common;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class TwoListedLinkSum {

    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode node = new ListNode(0);
        ListNode l11 = l1;
        ListNode l22 = l2;
        ListNode head = node;
        int f = 0;
        while (l1!=null && l2!=null){
            head.next = new ListNode(((l1.val+l2.val)%10+f)%10);
            f = (l1.val+l2.val+f)/10>0?1:0;
            l1 = l1.next;
            l2 = l2.next;
            head = head.next;
        }
        while (l1!=null){
            head.next = new ListNode((l1.val%10+f)%10);
            f = ((l1.val+f)/10)>0?1:0;
            l1 = l1.next;
            head = head.next;
        }
        while (l2!=null){
            head.next = new ListNode((l2.val%10+f)%10);
            f = ((l2.val+f)/10)>0?1:0;
            l2 = l2.next;
            head = head.next;
        }
        if (f>0){
            head.next = new ListNode(f);
        }
        return node.next;
    }

    public static void main(String[] args) {
        TwoListedLinkSum t = new TwoListedLinkSum();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(7);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(4);

        System.out.println(l1);
        System.out.println(l2);

        ListNode res = t.addTwoNumbers(l1, l2);
        System.out.println(res);
    }

}
