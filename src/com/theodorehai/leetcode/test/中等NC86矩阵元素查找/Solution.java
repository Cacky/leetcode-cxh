package com.theodorehai.leetcode.test.中等NC86矩阵元素查找;

/**
 * com.theodorehai.leetcode.test.中等NC86矩阵元素查找.
 *题目描述
 * 已知int一个有序矩阵mat，同时给定矩阵的大小n和m以及需要查找的元素x，
 * 且矩阵的行和列都是从小到大有序的。设计查找算法返回所查找元素的二元数组，
 * 代表该元素的行号和列号(均从零开始)。保证元素互异。
 *
 * 示例1
 * 输入 [[1,2,3],[4,5,6]],2,3,6
 * 返回值 [1,2]
 * @author chengxiaohai.
 * @date 2021/5/9.
 */
import java.util.*;

public class Solution {
    public int[] findElement2(int[][] mat, int n, int m, int x) {
        int row = 0;
        int col = m -1;
        int[] res = new int[2];
        while (row < n && col >=0){
            if(mat[row][col] == x){
                res[0] = row;
                res[1] = col;
                break;
            }else if(mat[row][col] <x){
                row ++;
            }else{
                col --;
            }
        }
        return res;
    }

    //由于给定的二维数组具备每行从左到右递增以及每列从上到下递增的特点，当访问到一个元素时，
    // 可以排除数组中的部分元素。我们可以从矩阵的右上角元素开始进行查询，
    // 如果其等于目标元素则直接返回结果；如果其大于目标元素，则只能往列坐标减少的方向去寻找，
    // 其他位置的元素都是大于当前访问的元素的，自然也就大于目标元素；如果当前访问的元素小于目标元素值，
    // 那么就往行坐标变大的方向去寻找，因为除了已经在先前访问时被排除的部分元素之外，
    // 在和当前元素的同一行中，位于当前访问元素前面的元素，也一定小于目标元素，所以可以直接排除。
    public int[] findElement(int[][] mat, int n, int m, int x) {
        // write code here
        int row = 0;
        int col = m - 1;
        int[] res = new int[2];
        while (row < n && col >= 0){
            if (mat[row][col] == x){
                res[0] = row;
                res[1] = col;
                break;
            }else if (mat[row][col] > x){
                col--;
            }else {
                row ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] data = new int[2][3];
        data[0] = new int[]{1,2,3};
        data[1] = new int[]{4,5,7};
        int[] res = solution.findElement2(data, 2, 3, 7);
        for (int re : res) {
            System.out.print(re+" ");
        }
        System.out.println();
    }
}
