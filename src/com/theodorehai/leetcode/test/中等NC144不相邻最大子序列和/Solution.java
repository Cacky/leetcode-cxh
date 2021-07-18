package com.theodorehai.leetcode.test.中等NC144不相邻最大子序列和;

/**
 * com.theodorehai.leetcode.test.中等NC144不相邻最大子序列和.
 *题目描述
 * 给你一个n（1≤n≤10^5），和一个长度为n的数组，在不同时选位置相邻的两个数的基础上，
 * 求该序列的最大子序列和（挑选出的子序列可以为空）。
 * 示例1
 * 输入 3,[1,2,3]
 * 返回值  4
 * 说明
 * 有[],[1],[2],[3],[1,3] 4种选取方式其中[1,3]选取最优，答案为4
 * 示例2
 * 输入  4,[4,2,3,5]
 * 返回值 9
 * 说明
 * 其中[4,5]的选取方案是在满足不同时选取相邻位置的数的情况下是最优的答案
 * @author chengxiaohai.
 * @date 2021/5/9.
 */
import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算
     * @param n int整型 数组的长度
     * @param array int整型一维数组 长度为n的数组
     * @return long长整型
     */
    //其实就是一个打家劫舍的问题，数组中每一个元素值就是可以偷的金额，相邻的不能偷，求能够偷出的最大金额是多少。
    //
    // 设置一个状态转移数组dp，dp[i]表示数组中前i个元素所能偷的最大金额是多少
    //
    // 状态转移表达式：
    // (1)对于当前的元素arr[i],如果偷，那么dp[i] = dp[i-2] + arr[i]
    // (2)如果不偷，那么dp[i] = dp[i-1]
    // dp[i] = max(array[i]+dp[i-2],dp[i-1])
    public long subsequence (int n, int[] array) {
        // write code here
        long[] dp = new long[n + 1];
        dp[0] =0;
        dp[1] = array[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+array[i-1]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = {4, 2, 3, 5, 4};
        System.out.println(solution.subsequence(5, data));
    }
}
