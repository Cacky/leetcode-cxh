package com.theodorehai.leetcode.test.简单NC7股票一次交易;

/**
 * com.theodorehai.leetcode.test.简单.
 * 题目描述 假设你有一个数组，其中第i 个元素是股票在第i 天的价格。
 * 你有一次买入和卖出的机会。（只有买入了股票以后才能卖出）。
 * 请你设计一个算法来计算可以获得的最大收益。
 * 示例1 输入[1,4,2] 返回值 3 示例2 输入 [2,4,1] 返回值 2
 *
 * @author chengxiaohai.
 * @date 2021/4/27.
 */
public class Solution {

    /**
     * @param prices int整型一维数组
     * @return int整型
     */
    public int maxProfit(int[] prices) {
        // write code here
        int max = 0; //收益
        int min = prices[0]; //买入价格
        for (int i = 1; i < prices.length; i++) {
            //1.计算最大收益
            max = Math.max(max, prices[i] - min);
            //2.调整买入价格
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] data = {2,1, 4};
        System.out.println(new Solution().maxProfit(data));
    }
}
