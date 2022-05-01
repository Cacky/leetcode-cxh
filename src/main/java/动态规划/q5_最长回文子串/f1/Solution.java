package 动态规划.q5_最长回文子串.f1;

/**
 * o(n^2) 以每个字符为中心计算回文长度
 */
class Solution {

    public String getPalindrome(String s, int index) {
        String rs = "";
        int sLen = s.length();
        int i = index;
        int j = index;
        while (j < sLen) {
            if (s.charAt(j) == s.charAt(index)) {
                rs = rs + s.charAt(j);
                j++;
            } else {
                break;
            }
        }
        i--;
        while (i >= 0 && j < sLen) {
            if (s.charAt(i) == s.charAt(j)) {
                rs = s.charAt(i) + rs;
                rs = rs + s.charAt(i);
                i--;
                j++;
            } else {
                break;
            }
        }
        return rs;
    }

    public String longestPalindrome(String s) {
        int maxLen = -1;
        String rs = "";
        for (int i = 0; i < s.length(); i++) {
            String t = getPalindrome(s, i);
            if (t.length() > maxLen) {
                maxLen = t.length();
                rs = t;
            }
        }
        return rs;
    }


    public String lps(String str) {
        String resutlStr = null;
        if (str == null || str.length() == 1) {
            return str;
        }
        int left = 0;
        int right = 0;
        boolean dp[][] = new boolean[str.length()][str.length()];
        for (int i = str.length() - 2; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < str.length(); j++) {
                dp[i][j] = str.charAt(i) == str.charAt(j) && (j - i < 3 || dp[i + 1][j - 1] == true);
                if (dp[i][j]) {
                    left = i;
                    right = j + 1;
                }
            }
        }
        return str.substring(left, right);
    }

}
