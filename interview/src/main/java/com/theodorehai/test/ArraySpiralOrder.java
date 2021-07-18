package com.theodorehai.test;

import java.util.ArrayList;

/**
 * com.theodorehai.test.
 *
 * @author chengxiaohai.
 * @date 2021/6/29.
 */
public class ArraySpiralOrder {
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if(matrix == null) return res;
        int top = 0,buttom = matrix.length-1;
        int left = 0,right = matrix[0].length-1;
        while (top < (matrix.length+1)/2 && left < (matrix[0].length +1)/2){
            for (int i = left; i <=right; i++) {
                res.add(matrix[buttom][i]);
            }
            for (int i = buttom -1; i >= top ; i--) {
                res.add(matrix[i][right]);
            }
            for (int i = right-1; i >=left && top != buttom ; i--) {
                res.add(matrix[top][i]);
            }
            for (int i = top+1; i <=buttom-1 && left != right ; i++) {
                res.add(matrix[i][left]);
            }
            buttom--;
            right--;
            top++;
            left++;

        }

        return res;
    }


    public static void main(String[] args) {
        int[][] data = new int[3][4];
        data[0] =new int[]{1,2,3,4};
        data[1] =new int[]{5,6,7,8};
        data[2] =new int[]{9,10,11,12};
        System.out.println(spiralOrder(data));
    }

}
