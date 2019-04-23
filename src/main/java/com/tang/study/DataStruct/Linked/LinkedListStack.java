package com.tang.study.DataStruct.Linked;

import org.junit.Test;

public class LinkedListStack<E extends Comparable<E>> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.get(0);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Stack: top ");
        builder.append(list);
        return builder.toString();
    }

    @Test
    public void test(){
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        long time = System.currentTimeMillis();
        for (int i=0;i<100000;i++){
            stack.push(i);
//            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
        System.out.println(System.currentTimeMillis()-time);
    }
}
