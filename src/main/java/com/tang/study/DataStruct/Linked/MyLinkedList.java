package com.tang.study.DataStruct.Linked;

public class MyLinkedList<E> {

    private class Node{
        public E data;
        public Node next;

        public Node(E data) {
            this.data = data;
            next = null;
        }
    }

    private int size;
    private Node head;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * 在链表的最后插入
     * @param data
     */
    public void addLast(E data){
        Node node = new Node(data);
        if (head==null){
            head = node;
            size++;
            return;
        }
        Node curNode = head;
        while (curNode.next!=null){
            curNode = curNode.next;
        }
        curNode.next = node;
        size++;
    }

    public void addFirst(E data){
        Node node = new Node(data);
        if (head==null){
            head = node;
            size++;
            return;
        }
        node.next = head;
//        head = node;
        size++;
    }



    public int getSize(){
        return size;
    }
}
