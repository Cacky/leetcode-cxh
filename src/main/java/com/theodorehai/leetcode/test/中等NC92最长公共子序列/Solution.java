package com.theodorehai.leetcode.test.中等NC92最长公共子序列;

/**
 * com.theodorehai.leetcode.test.中等NC92最长公共子序列.
 * <p>
 * 题目描述 给定两个字符串str1和str2,输出两个字符串的最长公共子串 题目保证str1和str2的最长公共子串存在且唯一。 示例1 输入 "1AB2345CD","12345EF" 返回值 "2345"
 * 备注:1≤∣str1∣,∣str2∣≤5000
 *
 * @author chengxiaohai.
 * @date 2021/4/21.
 */

public class Solution {

    public String LCS3(String str1, String str2) {
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j] +1;
                }else{
                    dp[i+1][j+1] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = str1.length()-1,j = str2.length()-1; i >=0 && j >=0 && dp[i+1][j+1] >0 ;) {
            if(str1.charAt(i) == str2.charAt(j)){
                sb.append(str1.charAt(i));
                i--;j--;
            }else if(dp[i+1][j] < dp[i][j+1]){
                i--;
            }else{
                j--;
            }
        }
        return sb.reverse().toString();
    }

    /**
     * longest common substring
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS(String str1, String str2) {
        // write code here
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = str1.length() - 1, j = str2.length() - 1; i >= 0 && j >= 0 && dp[i + 1][j + 1] > 0; ) {
            if (str1.charAt(i) == str2.charAt(j)) {
                sb.insert(0, str1.charAt(i));
                i--;
                j--;
            } else if (dp[i + 1][j] < dp[i][j + 1]) {
                i--;
            } else {
                j--;
            }
        }
        return String.valueOf(sb);

    }

    public String LCS2(String s1, String s2) {
        // write code here
        if (s1 == null || s2 == null) {
            return "-1";
        }
        int n = s1.length(), m = s2.length();
        if (n == 0 || m == 0) {
            return "-1";
        }

        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        int[][] dp = new int[n + 1][m + 1];

        // 动态规划求出s1和s2的最长公共子序列的长度
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (s1Chars[i] == s2Chars[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        // 逆推得到最长公共子序列具体的字符串信息
        int i = n - 1, j = m - 1;

        while (i >= 0 && j >= 0 && dp[i + 1][j + 1] > 0) {
            if (s1Chars[i] == s2Chars[j]) {
                sb.append(s1Chars[i]);
                i--;
                j--;
            } else if (dp[i + 1][j] >= dp[i][j + 1]) {
                j--;
            } else {
                i--;
            }
        }

        return sb.length() > 0 ? sb.reverse().toString() : "-1";
    }

    public static void main(String[] args) {
        String text1 = "2ABCDT2234";
        String text2 = "2ABCDQ223";
        Solution solution = new Solution();
        System.out.println(solution.LCS(text1, text2));
        System.out.println(solution.LCS2(text1, text2));
        System.out.println(solution.LCS3(text1, text2));
    }
}
