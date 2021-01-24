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

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.LCS("1AB2345CD", "12345EF"));
    }
}