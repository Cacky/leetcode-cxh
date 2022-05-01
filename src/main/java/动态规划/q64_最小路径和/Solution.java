package 动态规划.q64_最小路径和;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 动态规划 dp(j)=grid(i,j)+min(dp(j),dp(j+1)) o(m*n)
 * <p>
 * https://blog.csdn.net/a1033025319/article/details/106303396 https://blog.csdn.net/qq_44900959/article/details/107561557
 */
public class Solution {

    public static int minPathSum(int[][] grid) {
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

    public static int minSum(int[][] grid) {
        int n = grid.length; //行
        int m = grid[0].length; //列
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i]; //第一行的只能向右去累加
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0]; //第一列的只能向下去累加
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]; //上方和左方的寻找最小值累加
            }
        }
        return dp[n - 1][m - 1];

    }

    public static int minPathSum2(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;  //起点左上角就继续
                } else if (i == 0 && j != 0) {
                    grid[i][j] += grid[i][j - 1];//只能向右累加
                } else if (i != 0 && j == 0) {
                    grid[i][j] += grid[i - 1][j];//向下累加
                } else {
                    grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);//左方和右方，寻找最小值累加
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];//最后结果右下角

    }


    public static int dp(int[][] grid) {
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

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rowAndColumn = br.readLine().split(" ");
        int row = Integer.parseInt(rowAndColumn[0]);
        int column = Integer.parseInt(rowAndColumn[1]);
        int[][] vis = new int[row][column];
        for (int i = 0; i < row; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < column; j++) {
                vis[i][j] = Integer.parseInt(str[j]);
            }
        }
        System.out.println(minPathSum2(vis));

    }


}
