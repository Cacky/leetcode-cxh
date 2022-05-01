package com.theodorehai.leetcode.test.简单NC68跳台阶;

/**
 * com.theodorehai.leetcode.test.简单NC68跳台阶.
 *
 * 题目描述
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 *
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * @author chengxiaohai.
 * @date 2021/4/20.
 */
public class Solution {

    public int jumpFloor(int target) {
        if (target <= 2) {
            return target;
        }
        int first = 1, second = 2;
        for (int i = 3; i <= target; i++) {
            int tmp = second;
            second = first + second;
            first = tmp;
        }
        return second;
    }

    public int jumpFloor2(int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }

    public int jumpFloor3(int target) {
        int[] dp = new int[target +1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <=target ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().jumpFloor(1));
        System.out.println(new Solution().jumpFloor(2));
        System.out.println(new Solution().jumpFloor(3));
        System.out.println(new Solution().jumpFloor(4));
        System.out.println(new Solution().jumpFloor(5));
        System.out.println(new Solution().jumpFloor3(5));
    }
}
