package com.tang.study.niukwwang.officer.link;

import java.util.*;

public class TwoLinkListMerge {

    private ListNode_2 head;
    public void add(int e){
        ListNode_2 node = new ListNode_2(e);
        if (head==null){
            head = node;
        }
        else {
            node.next = head;
            head = node;
        }
    }

    public ListNode_2 solution(ListNode_2 list1,ListNode_2 list2){
        if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }
        ListNode_2 pMergeHead;
        if(list1.val<list2.val){
            pMergeHead = list1;
            pMergeHead.next = solution(list1.next,list2);
        }else{
            pMergeHead = list2;
            pMergeHead.next = solution(list1,list2.next);
        }
        return pMergeHead;

    }

    public ListNode_2 solution_1(ListNode_2 list1,ListNode_2 list2){
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode_2 mergeHead = null;
        ListNode_2 current = null;
        while(list1!=null && list2!=null){
            if(list1.val <= list2.val){
                if(mergeHead == null){
                    mergeHead = current = list1;
                }else{
                    current.next = list1;
                    current = current.next;
                }
                list1 = list1.next;
            }else{
                if(mergeHead == null){
                    mergeHead = current = list2;
                }else{
                    current.next = list2;
                    current = current.next;
                }
                list2 = list2.next;
            }
        }
        if(list1 == null){
            current.next = list2;
        }else{
            current.next = list1;
        }
        return mergeHead;
    }

    public ListNode_2 solution_2(ListNode_2 list1,ListNode_2 list2){
        if (list1==null){return list2;}
        if (list2==null){return list1;}
        ListNode_2 head1 = list1;
        ListNode_2 head2 = list2;
        ListNode_2 mergeHead = null;
        System.out.println(head1);
        System.out.println(head2);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        while (head1!=null && head2!=null){
            if (head1.val<head2.val){
                ListNode_2 tmpNode = new ListNode_2(head1.val);
                tmpNode.next = mergeHead;
                mergeHead = tmpNode;
                head1 = head1.next;
            }
            else {
                ListNode_2 tmpNode = new ListNode_2(head2.val);
                tmpNode.next = mergeHead;
                mergeHead = tmpNode;
                head2 = head2.next;
            }
        }
        return mergeHead;
    }

    public ListNode_2 solution_3(ListNode_2 list1,ListNode_2 list2){
        if (list1==null){return list2;}
        if (list2==null){return list1;}
        ListNode_2 head1 = list1;
        ListNode_2 head2 = list2;
        List<Integer> arrayList1 = new ArrayList<>();
        while (head1!=null){
            arrayList1.add(head1.val);
            head1 = head1.next;
        }
        while (head2!=null){
            arrayList1.add(head2.val);
            head2 = head2.next;
        }
        System.out.println(arrayList1);
        ListNode_2 mergeHead = null;
        Integer[] array = new Integer[arrayList1.size()];
        arrayList1.toArray(array);
        Arrays.sort(array, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                int value1 = (int)o1;
                int value2 = (int)o2;
                if (value2>value1){
                    return 0;
                }
                return -1;
            }
        });
        for (int arr:array){
            ListNode_2 tmpNode = new ListNode_2(arr);
            tmpNode.next = mergeHead;
            mergeHead = tmpNode;
        }
//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");


        return mergeHead;
    }

    public static void main(String[] args) {
        TwoLinkListMerge linkListMerge1 = new TwoLinkListMerge();
        TwoLinkListMerge linkListMerge2 = new TwoLinkListMerge();
        linkListMerge1.add(9);
        linkListMerge1.add(7);
        linkListMerge1.add(5);
        linkListMerge1.add(3);
        linkListMerge1.add(1);
        linkListMerge2.add(10);
        linkListMerge2.add(9);
        linkListMerge2.add(8);
        linkListMerge2.add(6);
        linkListMerge2.add(5);
        linkListMerge2.add(4);
        linkListMerge2.add(0);
        linkListMerge2.add(3);
//        System.out.println(linkListMerge1.head);
//        System.out.println(linkListMerge2.head);
//        ListNode_2 result = new TwoLinkListMerge().solution(linkListMerge1.head,linkListMerge2.head);
//        System.out.println(result);
//        ListNode_2 result1 = new TwoLinkListMerge().solution_1(linkListMerge1.head,linkListMerge2.head);
//        System.out.println(result1);
        System.out.println(new TwoLinkListMerge().solution_1(linkListMerge1.head,linkListMerge2.head));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        int[]aa = new int[4];
        aa[0]=2;aa[1]=3;aa[2]=4;aa[3]=6;
        for (int a:aa){
            System.out.println(a);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        int[]bb = aa;
        bb[0]=99;
        for (int a:aa){
            System.out.println(a);
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for (int b:bb){
            System.out.println(b);
        }
        aaa(aa);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for (int b:bb){
            System.out.println(b);
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for (int a:aa){
            System.out.println(a);
        }
    }

    public static void aaa(int[]aa){
        int[] bb = aa;
        bb[1] = 100;
    }
}

class ListNode_2 {
    int val;
    ListNode_2 next = null;

    ListNode_2(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode_2{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}