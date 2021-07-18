package com.theodorehai.leetcode.test.简单NC76用两个栈实现队列;

/**
 * com.theodorehai.leetcode.test.简单NC76用两个栈实现队列.
 * 题目描述
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @author chengxiaohai.
 * @date 2021/4/16.
 */
import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        //1.先将栈stack1中的数据放入stack2
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        //2.放入当前数据
        stack1.push(node);
        //3. 将栈stack2中的数据放入stack1
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        return stack1.pop();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(1);
        solution.push(2);
        solution.push(3);
        System.out.println(solution.pop());
        System.out.println(solution.pop());
        System.out.println(solution.pop());
    }
}
