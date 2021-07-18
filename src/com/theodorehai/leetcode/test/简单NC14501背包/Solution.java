package com.theodorehai.leetcode.test.简单NC14501背包;

/**
 * com.theodorehai.leetcode.test.简单NC14501背包.
 *题目描述
 * 已知一个背包最多能容纳物体的体积为V
 * 现有n个物品第i个物品的体积为vi,第i个物品的重量为wi​
 * 求当前背包最多能装多大重量的物品
 * 示例1
 * 输入 10,2,[[1,3],[10,4]]
 * 返回值  4
 * 说明
 * 第一个物品的体积为1，重量为3，
 * 第二个物品的体积为10，重量为4。
 * 只取第二个物品可以达到最优方案，取物重量为4
 * 备注:
 * 1≤V≤200
 * 1≤n≤200
 * 1≤vi≤200
 * 1≤wi≤200
 * @author chengxiaohai.
 * @date 2021/5/6.
 */
import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算01背包问题的结果
     * @param V int整型 背包的体积
     * @param n int整型 物品的个数
     * @param vw int整型二维数组 第一维度为n,第二维度为2的二维数组,
     * vw[i][0],vw[i][1]分别描述i+1个物品的vi,wi
     * @return int整型
     */
    public int knapsack (int V, int n, int[][] vw) {
        // write code here
        int[] w=new int[V+1];
        for(int i=0;i<n;i++){
            for(int j=V;j>=vw[i][0];j--){
                w[j]=Math.max(w[j],w[j-vw[i][0]]+vw[i][1]);
            }
        }
        return w[V];
    }

   public static int knapsack3(int v,int n,int[][] vm){
       int[] w = new int[v +1];
       for (int i = 0; i < n; i++) {
           for (int j = v; j >= vm[i][0] ; j--) {
               w[j] = Math.max(w[j],w[j-vm[i][0]]+vm[i][1]);
           }
       }
       return w[v];
   }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] data = new int[2][2];
        data[0] = new int[]{4,3};
        data[1] = new int[]{6,4};
        System.out.println(solution.knapsack(10, 2, data));
        System.out.println(knapsack3(10, 2, data));
    }
}
