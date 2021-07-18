package com.theodorehai.leetcode.test.中等NC127最长公共子串;

/**
 * com.theodorehai.leetcode.test.中等NC127最长公共子串. 题目描述 给定两个字符串str1和str2， 输出两个字符串的最长公共子序列。 如果最长公共子序列为空，则输出-1。
 * <p>
 * 示例1 输入 "1A2C3D4B56","B1D23CA45B6A" 返回值 "123456" 说明 "123456"和“12C4B6”都是最长公共子序列，任意输出一个。 备注: 1≤∣str1∣,∣str2∣≤5000
 *
 * @author chengxiaohai.
 * @date 2021/4/21.
 */

public class Solution {

    public String LCS2(String s1, String s2) {
        if (s1.equals(s2)) {
            return s1;
        }
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int maxLength = 0;
        int lastIndex = 0;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = 0;
                }
                if (maxLength < dp[i + 1][j + 1]) {
                    maxLength = dp[i + 1][j + 1];
                    lastIndex = i + 1;
                }
            }
        }
        return s1.substring(lastIndex - maxLength, lastIndex);
    }

    /**
     * longest common subsequence
     *
     * @param s1 string字符串 the string
     * @param s2 string字符串 the string
     * @return string字符串
     */
    public String LCS(String s1, String s2) {
        // write code here
        if (s1.equals(s2)) {
            return s1;
        }
        int maxLength = 0;
        int lastIndex = 0;
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = 0;
                }
                if (maxLength < dp[i + 1][j + 1]) {
                    maxLength = dp[i + 1][j + 1];
                    lastIndex = i + 1;
                }
            }
        }
        return s1.substring(lastIndex - maxLength, lastIndex);
    }

    public static void main(String[] args) {
        String text1 = "2ABCDT2234563";
        String text2 = "1ABCDQ2234563";
        Solution solution = new Solution();
        System.out.println(solution.LCS(text1, text2));
        System.out.println(solution.LCS2(text1, text2));
    }
}
