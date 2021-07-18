package com.theodorehai.leetcode.test.入门NC65斐波那契数列;

/**
 * com.theodorehai.leetcode.test.
 *
 * 入门NC65斐波那契数列.
 *题目描述
 * 大家都知道斐波那契数列，
 * 现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。n≤39
 *
 * 示例1
 * 输入 4
 * 返回值 3
 * @author chengxiaohai.
 * @date 2021/4/14.
 */
public class Solution {
    public int Fibonacci2(int n) {
        int[] res = {0, 1};
        if(n < 2) {
            return res[n];
        }
        int first = 0;
        int second = 1;
        int fibn = 0;
        for(int i = 2; i <= n; i++) {
            fibn = first + second;
            first = second;
            second = fibn;
        }
        return fibn;
    }

    public int Fibonacci(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().Fibonacci(39));
        System.out.println(new Solution().Fibonacci2(39));
    }
}
