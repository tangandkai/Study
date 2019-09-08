package com.tang.study.niukwwang.officer.link;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 给定入栈的数组，判断出栈结果是否正确
 */
public class IsPopOrder {

    public static void main(String[] args) {

    }

    public static boolean solution(int[]pushA,int [] popA){
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            while (!stack.isEmpty()&&stack.peek()==popA[index]){
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

    public static boolean solution_1(int[]pushA,int [] popA){

        ArrayList<Integer> arrayList = new ArrayList<>();
        int index = 0;
        for (int i=0;i<pushA.length;i++){
            arrayList.add(pushA[i]);
            while (!arrayList.isEmpty()&&arrayList.get(arrayList.size()-1)==popA[index]){
                arrayList.remove(arrayList.size()-1);
                index++;
            }

        }
        return arrayList.isEmpty();
    }
}
