package com.theodorehai.leetcode.test.简单NC52括号序列;

import java.util.HashMap;
import java.util.Stack;

/**
 * com.theodorehai.leetcode.test.简单NC52括号序列. 题目描述 给出一个仅包含字符'(',')','{','}','['和']',的字符串，
 * 判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列， 但"(]"和"([)]"不合法。
 * 示例1 输入"[" 返回值false 示例2 输入 "[]" 返回值 true
 *
 * @author chengxiaohai.
 * @date 2021/4/14.
 */
public class Solution {

    public boolean isValid2(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
                continue;
            }
            if(stack.isEmpty()){
                return false;
            }
            if(map.containsValue(s.charAt(i))){
                if(s.charAt(i) != map.get(stack.pop())){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    /**
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid(String s) {
        // write code here
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (map.containsValue(s.charAt(i))) {
                if (!map.get(stack.pop()).equals(s.charAt(i))) {
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
        // HashMap<Character, Character> map = new HashMap<>();
        // map.put('(', ')');
        // map.put('{', '}');
        // map.put('[', ']');
        // Stack<Character> stack = new Stack<>();
        // for (int i = 0; i < s.length(); i++) {
        //     if (map.containsKey(s.charAt(i))) {
        //         stack.push(s.charAt(i));
        //         continue;
        //     }
        //     if (stack.isEmpty()) {
        //         return false;
        //     }
        //     if (map.containsValue(s.charAt(i))) {
        //         if (!map.get(stack.pop()).equals(s.charAt(i))) {
        //             return false;
        //         }
        //     }
        // }
        // if (stack.isEmpty()) {
        //     return true;
        // }
        // return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("}{(}{){)}[]}][[[{()]}(()[({({[}{[))(([])[)([])["));
        System.out.println(new Solution().isValid("(([]))([])"));
        System.out.println(new Solution().isValid2("(([]))([])"));
    }
}
