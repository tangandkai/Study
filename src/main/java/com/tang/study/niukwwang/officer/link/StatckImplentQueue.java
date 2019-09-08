package com.tang.study.niukwwang.officer.link;

import org.junit.Test;

import java.util.Stack;

/**
 * 使用栈实现队列
 */
public class StatckImplentQueue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node){
        stack1.push(node);
    }

    public int pop(){
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    @Test
    public void test(){
        push(3);
        push(4);
        push(5);
        System.out.println(pop());
        int[] array = new int[10];
        int position = array.length-2>0?2:0;
    }
}
