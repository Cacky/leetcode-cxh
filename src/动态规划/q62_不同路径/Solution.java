package 动态规划.q62_不同路径;

import java.util.Scanner;

/**
 * 动态规划 dp[i][j]是到达i, j的最多路径 dp[i][j] = dp[i-1][j] + dp[i][j-1] o(m*n)
 * <p>
 * 描述
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * https://www.cnblogs.com/fanguangdexiaoyuer/p/11856683.html
 */
public class Solution {

    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    //优化：画图后发现（动归要多画图），其实每次计算都只用了当前行和上一行。可以将二维数组变为一维数组。
    //
    // dp[m][n] = dp[m][n - 1] + dp[m - 1][n]，可以变为dp[i] = dp[i] + dp[i -  1]
    public int uniquePaths1(int m, int n) {
        if (m < 1 || n < 1) {
            return 0;
        }
        int[] dp = new int[n]; //用列初始化
        //初始化
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        // 公式：dp[i] = dp[i-1] + dp[i]
        for (int i = 1; i < m; i++) {
            dp[0] = 1; // 第 i 行第 0 列的初始值
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j - 1] + dp[j];
            }
        }
        return dp[n - 1];
    }

    // cxh 20210412
    public int uniquePaths2(int m, int n) {
        if (m < 1 || n < 1) {
            return 0;
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            dp[0] = 1;
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j - 1] + dp[j];
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println(new Solution().uniquePaths(m, n));
        System.out.println(new Solution().uniquePaths1(m, n));
        System.out.println(new Solution().uniquePaths2(m, n));
    }
}
