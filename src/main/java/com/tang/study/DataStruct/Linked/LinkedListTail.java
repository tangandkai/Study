package com.tang.study.DataStruct.Linked;

public class LinkedListTail<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e,null);
        }

        public Node() {
            this(null,null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", next=" + next +
                    '}';
        }
    }
    private Node head,tail;
    private int size;

    public LinkedListTail() {
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void add(E e){
        if (tail==null){
            tail = new Node(e);
            head = tail;
        }
        else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    public E remove(){
        if (isEmpty()){
            throw new IllegalArgumentException("linklist is empty...");
        }
        Node renode = head;
        head = head.next;
        renode.next = null;
        if (head==null)
            tail=null;
        size--;
        return renode.e;
    }

    public E getFirst(){
        if (isEmpty()){
            throw new IllegalArgumentException("linklist is empty...");
        }
        return head.e;
    }


}
