package com.theodorehai.leetcode.test.入门NC38螺旋矩阵;

import java.util.ArrayList;

/**
 * com.theodorehai.leetcode.test.入门NC38螺旋矩阵.
 * https://www.nowcoder.com/practice/7edf70f2d29c4b599693dc3aaeea1d31?tpId=188&tqId=38351&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 *题目描述
 * 给定一个m x n大小的矩阵（m行，n列），按螺旋的顺序返回矩阵中的所有元素。
 * 示例1
 * 输入 [[1,2,3],[4,5,6],[7,8,9]]
 * 返回值 [1,2,3,6,9,8,7,4,5]
 * @author chengxiaohai.
 * @date 2021/5/9.
 */
public class Solution {

    /**
     *
     * @param matrix
     * @return
     */
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if(matrix.length == 0)
            return res;
        int top = 0, bottom = matrix.length-1;
        int left = 0, right = matrix[0].length-1;

        while( top < (matrix.length+1)/2 && left < (matrix[0].length+1)/2 ){
            //上面  左到右
            for(int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            }

            //右边 上到下
            for(int i = top+1; i <= bottom; i++){
                res.add(matrix[i][right]);
            }

            //下面  右到左
            for(int i = right-1; top!=bottom && i>=left; i--){
                res.add(matrix[bottom][i]);
            }

            //左边 下到上
            for(int i = bottom-1; left!=right && i>=top+1; i--){
                res.add(matrix[i][left]);
            }
            ++top;
            --bottom;
            ++left;
            --right;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] data = new int[4][4];
        data[0] = new int[]{1,2,3,10};
        data[1] = new int[]{4,5,6,11};
        data[2] = new int[]{7,8,9,12};
        data[3] = new int[]{17,18,19,20};
        ArrayList<Integer> res = solution.spiralOrder(data);
        System.out.println(res);
    }
}
