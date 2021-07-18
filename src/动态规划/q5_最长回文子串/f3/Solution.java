package 动态规划.q5_最长回文子串.f3;

/**
 * o(n^2) 以每个字符为中心计算回文长度 https://www.jianshu.com/p/a7741619dd58
 */
class Solution {

    public String longestPalindromeSubstring(String s) {
        if (s.isEmpty()) {
            return s;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int left = 0;
        int right = 0;
        for (int i = n - 2; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);//小于3是因为aba一定是回文
                if (dp[i][j] && right - left < j - i) {
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }

    String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return "";
        }
        int len = s.length();
        if (len == 1) {
            return s;
        }
        int longest = 1;
        int start = 0;

        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
            if (i < len - 1) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][i + 1] = 1;
                    start = i;
                    longest = 2;
                }
            }
        }
        for (int l = 3; l <= len; l++)//子串长度
        {
            for (int i = 0; i + l - 1 < len; i++)//枚举子串的起始点
            {
                int j = l + i - 1;//终点
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                    start = i;
                    longest = l;
                }
            }
        }
        return s.substring(start, longest);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindromeSubstring("abacdffdced"));
    }
}
