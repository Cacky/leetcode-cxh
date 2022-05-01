package 动态规划.q5_最长回文子串.f4;
/**
 * 动态规划.q5_最长回文子串.f4.
 *
 * @author chengxiaohai.
 * @date 2021/3/26.
 */

/**
 * 对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。
 * <p>
 * 给定字符串A以及它的长度n，请返回最长回文子串的长度。 输入："abc1234321ab",12 输出：7
 */
public class NkSolution {

    public int getLongestPalindrome(String A, int n) {
        // write code here
        if (n <= 1) {
            return n;
        }
        int size = 0;
        boolean dp[][] = new boolean[n][n];
        for (int i = n - 2; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = A.charAt(i) == A.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && size < j - i + 1) {
                    size = j - i + 1;
                }
            }
        }
        return size;
    }

    public static void main(String[] args) {
        NkSolution nkSolution = new NkSolution();
        System.out.println(nkSolution.getLongestPalindrome("ccbcabaabba", 11));
    }
}
