package com.theodorehai.leetcode.test.中等NC18顺时针旋转矩阵;

/**
 * com.theodorehai.leetcode.test.中等NC18顺时针旋转矩阵.
 *
 * @author chengxiaohai.
 * @date 2021/6/28.
 */
public class Rotation {

    public static int[][] change2(int[][] matrix){
        int[][] temp = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp[j][matrix.length-1-i] = matrix[i][j];
            }
        }
        return temp;
    }












    public static int[][] change(int [][]matrix){
        int [][]temp=new int[matrix[0].length][matrix.length];
        int dst=matrix.length-1;
        for(int i=0;i<matrix.length;i++,dst--){
            for(int j=0;j<matrix[0].length;j++){
                temp[j][dst]=matrix[i][j];
            }
        }
        return temp;
    }

    public static void main(String[]args){
        int [][]matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int [][]temp=change2(matrix);
        for(int i=0;i<temp.length;i++){
            for(int j=0;j<temp[0].length;j++){
                System.out.print(temp[i][j]+"\t");
            }
            System.out.println();
        }
    }

}
