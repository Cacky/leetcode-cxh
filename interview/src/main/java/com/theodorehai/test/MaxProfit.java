package com.theodorehai.test;

/**
 * com.theodorehai.interview01.
 *
 * @author chengxiaohai.
 * @date 2021/6/15.
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}
