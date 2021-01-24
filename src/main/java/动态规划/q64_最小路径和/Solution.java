package 动态规划.q64_最小路径和;

/**
 * 动态规划 dp(j)=grid(i,j)+min(dp(j),dp(j+1)) o(m*n)
 * <p>
 * https://blog.csdn.net/a1033025319/article/details/106303396
 */
public class Solution {

    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j != grid[0].length - 1) {
                    dp[j] = grid[i][j] + dp[j + 1];
                } else if (j == grid[0].length - 1 && i != grid.length - 1) {
                    dp[j] = grid[i][j] + dp[j];
                } else if (j != grid[0].length - 1 && i != grid.length - 1) {
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);

                } else {
                    dp[j] = grid[i][j];
                }
            }
        }
        return dp[0];
    }

    public int dp(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        // 最后一个位置
        dp[grid.length - 1][grid[0].length - 1] = grid[grid.length - 1][grid[0].length - 1];
        // 最后一行
        for (int i = grid[0].length - 2; i >= 0; i--) {
            dp[grid.length - 1][i] = dp[grid.length - 1][i + 1] + grid[grid.length - 1][i];
        }
        // 最后一列
        for (int i = grid.length - 2; i >= 0; i--) {
            dp[i][grid[0].length - 1] = dp[i + 1][grid[0].length - 1] + grid[i][grid[0].length - 1];
        }
        for (int i = grid.length - 2; i >= 0; i--) {
            for (int j = grid[0].length - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) + grid[i][j];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] ints = new int[2][2];

    }

}
