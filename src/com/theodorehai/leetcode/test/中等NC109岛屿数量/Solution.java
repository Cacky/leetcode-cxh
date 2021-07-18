package com.theodorehai.leetcode.test.中等NC109岛屿数量;

/**
 * com.theodorehai.leetcode.test.中等NC109岛屿数量.
 * 题目描述 给一个01矩阵，1代表是陆地，0代表海洋， 如果两个1相邻，那么这两个1属于同一个岛。
 * 我们只考虑上下左右为相邻。
 * 岛屿:
 * 相邻陆地可以组成一个岛屿（相邻:上下左右） 判断岛屿个数。
 * 示例1
 * 输入 [[1,1,0,0,0],[0,1,0,1,1],[0,0,0,1,1],[0,0,0,0,0],[0,0,1,1,1]]
 * 返回值 3
 * 备注:
 * 01矩阵范围<=200*200
 *
 * @author chengxiaohai.
 * @date 2021/4/23.
 */

public class Solution {

    public int solve2(char[][] grid) {
        int count =0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] =='1'){
                    dfsGrid(grid,i,j);
                    count++;
                }

            }

        }
        return count;
    }

    private void dfsGrid(char[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j >=grid[0].length || grid[i][j] =='0'){
            return;
        }
        grid[i][j] ='0';
        dfsGrid(grid,i+1,j);
        dfsGrid(grid,i-1,j);
        dfsGrid(grid,i,j+1);
        dfsGrid(grid,i,j-1);
    }

    /**
     * 判断岛屿数量
     * bfs
     * 1.队列保存矩阵中1的坐标，通过bfs搜索附近四周同属一个岛屿的所有坐标，
     * 并置为0防止后续搜索重复计算
     * 2.搜索一次发现一座岛屿计数加一
     * 3.返回结果
     * @param grid char字符型二维数组
     * @return int整型
     */
    public int solve(char[][] grid) {
        // write code here
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    //把相连为'1'的全部置为'0'
    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] data = new char[5][];
        data[0] =new char[]{'1','1','0','0','0'};
        data[1] =new char[]{'0','1','0','1','1'};
        data[2] =new char[]{'0','0','0','1','1'};
        data[3] =new char[]{'0','0','0','0','0'};
        data[4] =new char[]{'0','0','0','1','1'};
        // System.out.println(solution.solve(data));
        System.out.println(solution.solve2(data));
    }
}
