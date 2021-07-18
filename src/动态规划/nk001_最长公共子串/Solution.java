package 动态规划.nk001_最长公共子串;

/**
 * 动态规划.nk1_最长公共子串.
 *
 * @author chengxiaohai.
 * @date 2020/11/10.
 */

public class Solution {

    public String LCS(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        int start = 0, end = 1;
        while (end < str1.length() + 1) {
            if (str2.contains(str1.substring(start, end))) {
                if (sb.length() < end - start) {
                    sb.delete(0, sb.length());
                    sb.append(str1, start, end);
                }
                end++;
            } else {
                start++;
            }
        }
        if (sb.length() == 0) {
            return "-1";
        }
        return sb.toString();
    }

    public String lcs(String str1, String str2) {
        int lastIndex = 0;
        int maxLength = 0;
        if (str1.equals(str2)) {
            return str1;
        }
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < str1.length(); i++) {
            char char1 = str1.charAt(i);
            for (int j = 0; j < str2.length(); j++) {
                char char2 = str2.charAt(j);
                if (char1 == char2) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    if (maxLength < dp[i][j]) {
                        maxLength = dp[i][j];
                        lastIndex = i;
                    }
                    dp[i + 1][j + 1] = 0;
                }
            }
        }
        return str1.substring(lastIndex - maxLength, lastIndex);
    }

    public static void main(String[] args) {
        String text1 = "2ABCDT223";
        String text2 = "2ABCDQ223";
        Solution solution = new Solution();
        System.out.println(solution.LCS(text1, text2));
        System.out.println(solution.lcs(text1, text2));
    }
}