package com.theodorehai.leetcode.test.较难NC44通配符匹配;

/**
 * com.theodorehai.leetcode.test.较难NC44通配符匹配.
 *题目描述
 * 请实现支持'?'and'*'.的通配符模式匹配
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任何字符序列（包括空序列）。
 * 返回两个字符串是否匹配
 * 函数声明为：
 * bool isMatch(const char *s, const char *p)
 * 下面给出一些样例：
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "d*a*b") → false
 * 示例1
 * 输入
 * 复制
 * "ab","?*"
 * 返回值
 * 复制
 * true
 * @author chengxiaohai.
 * @date 2021/5/6.
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0, iStar = -1, jStar = -1, m = s.length(), n = p.length();
        while (i < m) {
            if (j < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                ++i; ++j;
            } else if (j < n && p.charAt(j) == '*') {
                iStar = i;
                jStar = j++;
            } else if (iStar >= 0) {
                i = ++iStar;
                j = jStar + 1;
            } else return false;
        }
        while (j < n && p.charAt(j) == '*') ++j;
        return j == n;
    }

    public boolean isMatch2(String s, String p) {
        int row = s.length();
        int col = p.length();
        boolean[][] dp = new boolean[row + 1][col + 1];
        dp[0][0] = true;
        for (int j = 1; j < col + 1; j++) {
            if (dp[0][j - 1]) {
                if (p.charAt(j - 1) == '*')
                    dp[0][j] = true;
                else
                    break;
            }
        }
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) {
                if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')
                    dp[i + 1][j + 1] = dp[i][j];
                else if (p.charAt(j) == '*') {
                    dp[i + 1][j + 1] = dp[i][j] || dp[i + 1][j] || dp[i][j + 1];
                }
            }

        return dp[row][col];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str1 = "ab";
        String str2 = "?*";
        System.out.println(solution.isMatch2(str1, str2));
    }




}