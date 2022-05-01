package com.theodorehai.leetcode.test.中等NC59矩阵的最小路径和;

/**
 * com.theodorehai.leetcode.test.中等NC59矩阵的最小路径和.
 * 题目描述 给定一个 n * m 的矩阵 a，从左上角开始每次只能向右或者向下走，
 * 最后到达右下角的位置，路径上所有的数字累加起来就是路径和，
 * 输出所有的路径中最小的路径和。
 * 示例1 输入[[1,3,5,9],[8,1,3,4],[5,0,6,1],[8,8,4,0]] 返回值 12
 * 备注: 1≤n,m≤2000 1≤arri,j≤100
 *
 * @author chengxiaohai.
 * @date 2021/4/15.
 */
public class Solution {

    /**
     * @param matrix int整型二维数组 the matrix
     * @return int整型
     */
    public int minPathSum(int[][] matrix) {
        // write code here
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(i == 0 && j ==0){
                    dp[i][j] = matrix[i][j];
                }else if(i == 0 && j != 0){
                    dp[i][j] = dp[i][j-1] + matrix[i][j];
                }else if(i != 0 && j ==0){
                    dp[i][j] = dp[i-1][j] + matrix[i][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + matrix[i][j];
                }
            }
        }
        return dp[matrix.length-1][matrix[0].length-1];
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        System.out.println(new Solution().minPathSum(test));
    }
}
