package com.theodorehai.test;

import java.util.Stack;

/**
 * com.theodorehai.interview02.
 *
 * @author chengxiaohai.
 * @date 2021/6/24.
 */
public class Stack2Queue {


    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public void push(int a){
        if(stack1.isEmpty()){
            stack1.push(a);
            return;
        }
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(a);
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public int pop(){
        return stack1.pop();
    }

    public static void main(String[] args) {
        Stack2Queue stack2Queue = new Stack2Queue();
        stack2Queue.push(1);
        stack2Queue.push(2);
        System.out.println(stack2Queue.pop());
        stack2Queue.push(3);
        System.out.println(stack2Queue.pop());
        System.out.println(stack2Queue.pop());
    }


}
