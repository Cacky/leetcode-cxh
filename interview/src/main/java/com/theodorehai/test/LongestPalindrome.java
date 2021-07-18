package com.theodorehai.test;

/**
 * com.theodorehai.interview01.
 *
 * @author chengxiaohai.
 * @date 2021/6/15.
 */
public class LongestPalindrome {

    public int getLongestPalindrome(String A, int n) {
        boolean[][] dp = new boolean[n][n];
        int max = 0;
        for (int i = n - 2; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < n; j++) {
                if (A.charAt(i) == A.charAt(j)) {
                    if (j - i <= 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j]) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestPalindrome palindrome = new LongestPalindrome();
        String str = "abcdefdeffed";
        System.out.println(palindrome.getLongestPalindrome(str, str.length()));
    }
}
