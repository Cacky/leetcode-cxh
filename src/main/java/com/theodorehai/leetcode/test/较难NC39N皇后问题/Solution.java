package com.theodorehai.leetcode.test.较难NC39N皇后问题;

/**
 * com.theodorehai.leetcode.test.较难NC39N皇后问题.
 * https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247487459&idx=1&sn=f45fc8231198edb3de2acc69e17986ea&chksm=fb419cc3cc3615d5d31d55072d5c2f58e4002aa8c1b637e889f1ef577e253943c04efc39c1b1d&token=1327182919&lang=zh_CN#rd
 *题目描述
 * N皇后问题是指在N*N的棋盘上要摆N个皇后，
 * 要求：任何两个皇后不同行，不同列也不再同一条斜线上，
 * 求给一个整数N，返回N皇后的摆法数。
 * 示例1
 * 输入1
 * 返回值1
 * 示例2
 * 输入8
 * 返回值92
 * 备注:
 * 1≤n≤14
 * @author chengxiaohai.
 * @date 2021/5/9.
 */
import java.util.*;


public class Solution {
    /**
     *
     * @param n int整型 the n
     * @return int整型
     */
    public int Nqueen (int n) {
        // write code here
        return Nqueen(n, 0, new int[n]);
    }

    public int Nqueen(int n, int row, int[] column) {
        if(n == row) {
            return 1;
        }
        int num = 0;
        for(int i = 0; i < n; i++) {
            column[row] = i;
            boolean conflict = false;
            for(int j = 0; j < row;j++) {
                if(column[j] == column[row]
                    || Math.abs(j - row) == Math.abs(column[j] - column[row])) {
                    conflict = true;
                    break;
                }
            }
            if(!conflict) {
                num += Nqueen(n, row + 1, column);
            }
        }
        return num;
    }

    public static int Nqueen2(int n,int row,int[] column){
        if(n == row) return 1;
        int num =0;
        for (int i = 0; i < n; i++) {
            column[row] = i;
            boolean conflict = false;
            for (int j = 0; j < row; j++) {
                if(column[j] == column[row]
                || Math.abs(j - row) == Math.abs(column[j] - column[row])){
                    conflict = true;
                    break;
                }
            }
            if(!conflict){
                num += Nqueen2(n,row+1,column);
            }
        }
        return num;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        System.out.println(solution.Nqueen(n));
        System.out.println(Nqueen2(n, 0, new int[n]));

    }
}
