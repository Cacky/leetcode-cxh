package com.theodorehai.leetcode.test.中等NC18顺时针旋转矩阵;

/**
 * com.theodorehai.leetcode.test.中等NC18顺时针旋转矩阵. 题目描述
 * <p>
 * 有一个NxN整数矩阵，请编写一个算法，将矩阵顺时针旋转90度。
 * <p>
 * 给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于300。 示例1
 * <p>
 * 输入 [[1,2,3],[4,5,6],[7,8,9]],3
 * <p>
 * 返回值 [[7,4,1],[8,5,2],[9,6,3]]
 *
 * @author chengxiaohai.
 * @date 2021/5/9.
 */
public class Solution {

    public int[][] rotateMatrix1(int[][] mat, int n) {
        // write code here
        int tR=0;
        int tC=0;
        int dR=mat.length-1;
        int dC=mat[0].length-1;
        while(tR<dR){
            for(int i=0;i<dC-tC;i++){
                int tmp=mat[tR][tC+i];
                mat[tR][tC+i]=mat[dR-i][tC];
                mat[dR-i][tC]=mat[dR][dC-i];
                mat[dR][dC-i]=mat[tR+i][dC];
                mat[tR+i][dC]=tmp;
            }
            tR++;
            tC++;
            dR--;
            dC--;
        }
        return mat;
    }

    //：做两次翻转，先沿右上-左下的对角线翻转，再沿水平中线上下翻转
    // 即：对于函数中的一个点，先以y=x为轴作对称，然后以x轴作对称，
    // 则相当于该点顺时针旋转90°。所以对于图像来说每个点顺时针旋转了，则图也旋转了。所以可以将图以对角线作对称，然后以中间的横线作对称。
    public int[][] rotateMatrix2(int[][] mat, int n) {
        // write code here

        // 对角线
        for(int i=0; i<n;i++) {
            for(int j=i+1; j< n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // 以竖轴翻转
        for(int i=0;i<n;i++) {
            for(int j=0; j< n/2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][n-1-j];
                mat[i][n-1-j] = temp;
            }
        }
        return mat;
    }

    public int[][] rotateMatrix(int[][] mat, int n) {
        // write code here
        int[][]  res = new int[mat[0].length][mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                res[j][mat.length-1-i] = mat[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] data = new int[3][];
        data[0] =new int[]{1,2,3};
        data[1] =new int[]{4,5,6};
        data[2] =new int[]{7,8,9};
        int[][] res = solution.rotateMatrix(data, 3);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }

    }
}
