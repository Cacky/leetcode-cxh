package com.theodorehai.leetcode.test.中等NC137表达式求值;

/**
 * com.theodorehai.leetcode.test.中等NC137表达式求值.
 *题目描述
 * 请写一个整数计算器，支持加减乘三种运算和括号。
 * 示例1
 * 输入  "1+2"
 * 返回值 3
 * 示例2
 * 输入  "(2*(3-4))*5"
 * 返回值 -10
 * 示例3
 * 输入 "3+2*3*4-1"
 * 返回值  26
 * @author chengxiaohai.
 * @date 2021/5/9.
 */
import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回表达式的值
     * @param s string字符串 待计算的表达式
     * @return int整型
     * 算法：栈
     * 1.用栈保存各部分计算的和
     * 2.遍历表达式，使用 sign 变量记录运算符，初始化是 '+'；使用 number 变量记录字符串中的数字部分的数字值是多少
     * 2.0 遇到空格时跳过
     * 2.1 遇到数字时继续遍历求这个完整的数字的值，保存到 number 中
     * 2.2 遇到左括号时递归求这个括号里面的表达式的值
     * 先遍历找到对应的右括号，因为可能里面还嵌有多对括号，使用一个变量 counterPartition 统计括号对数直到变量为 0
     * 2.3 遇到运算符时或者到表达式末尾时，就去计算上一个运算符并把计算结果 push 进栈，然后保存新的运算符到 sign
     * 如果是 + ，不要计算，push 进去
     * 如果是 - ，push 进去负的当前数
     * 如果是 ×、÷ ，pop 出一个运算数和当前数作计算
     * 3.最后把栈中的结果求和即可
     */
    private HashMap<Character,Integer> pri = new HashMap<>();
    public int solve (String s) {
        // write code here
        if (s == null){
            return 0;
        }
        pri.put('+',0);
        pri.put('-',0);
        pri.put('*',1);

        List<String> suffixs = getSuffix(s);
        System.out.println(suffixs);
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (String suffix : suffixs) {

            if (suffix.equals("+") || suffix.equals("-") || suffix.equals("*")){

                Integer num1 = stack.pop();
                Integer num2 = stack.pop();

                switch (suffix){
                    case "+":stack.push(num2 + num1);
                        break;
                    case "-":stack.push(num2 - num1);
                        break;
                    case "*":stack.push(num2 * num1);
                        break;
                }
            }else {
                stack.push(Integer.valueOf(suffix));
            }
        }
        return stack.pop();
    }

    private List<String> getSuffix(String s) {

        Stack<Character> stack = new Stack<>();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); ) {
            int old_i = i;
            char curChar = s.charAt(i);
            // 1、分隔符
            if (curChar == '(') {
                stack.push(curChar);
            } else if (curChar == ')') {
                while (!stack.isEmpty()) {
                    Character ch = stack.pop();
                    if (ch == '(') {
                        break;
                    }
                    list.add(ch.toString());
                }
                // 2、运算符
            } else if (curChar == '+' || curChar == '-' || curChar == '*') {
                if (stack.isEmpty()) {
                    stack.push(curChar);
                } else {
                    while (!stack.isEmpty() && (stack.peek() == '+' || stack.peek() == '-' || stack.peek() == '*')
                        && pri.get(curChar) <= pri.get(stack.peek())) {
                        Character pop = stack.pop();
                        list.add(pop.toString());
                    }
                    stack.push(curChar);
                }
                // 3、操作数
            } else {
                StringBuilder cur = new StringBuilder();
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    cur.append(s.charAt(i));
                    i++;
                }
                list.add(cur.toString());
            }
            if (old_i == i) {
                i++;
            }
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop().toString());
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve("(2*(3-4))*5"));
    }
}