package com.theodorehai.leetcode.test.中等NC83子数组最大乘积;

/**
 * com.theodorehai.leetcode.test.中等NC83子数组最大乘积.
 *题目描述
 * 给定一个double类型的数组arr，其中的元素可正可负可0，返回子数组累乘的最大乘积。
 * 示例1
 * 输入 [-2.5,4,0,3,0.5,8,-1]
 * 返回值 12.00000
 * @author chengxiaohai.
 * @date 2021/5/8.
 */
public class Solution {

    public double maxProduct2(double[] arr){
        if(arr ==null || arr.length ==0) return 0;
        double min = arr[0];
        double max = min;
        double res = max;
        for(int i = 1; i < arr.length; i++) {
            double temp_max = max;
            max = Math.max(arr[i],Math.max(arr[i]*max,arr[i]*min));
            min = Math.min(arr[i],Math.min(arr[i]*temp_max,arr[i]*min));
            res = Math.max(res,max);
        }
        return res;
    }
    /**
     * 又是一个求连续区间数组的问题，典型的动态规划问题。
     * 和求最大区间和不同的是，如果我们依然尝试用dp[i]表示以a[i]结尾的子区间的最大成绩。
     * 会发现由于负数的存在，会导致乘法结果反转。dp[i-1]a[i]反倒变成了最小值，无法得到状态转移方程。
     * 沿着乘法的特性看，如果a[i]为负数，那么dpa[i]时，dp越大结果越小。
     * dp越小结果越大。所以，我们只需要同时保存最大值和最小值，就可以写出状态转移方程了。
     * a[i] > 0时：
     * maxv[i] = max(a[i], a[i]*maxv[i-1])
     * minv[i] = min(a[i], a[i]*minv[i-1])
     * a[i] < 0时：
     * maxv[i] = max(a[i], a[i]*minv[i-1])
     * minv[i] = min(a[i], a[i]*maxv[i-1])
     * a[i]=0时，max和min肯定是0。
     */
    public double maxProduct(double[] arr) {
        /**
         动态规划
         类似最大子序和
         不过需要考虑负数的问题：因为一个负数乘以一个负数可能会变为最大
         */
        double min = arr[0];
        double max  = min;
        //注意：max记录的不是最终的最大值，而是途中每一个选择的最大值，
        // 于是需要重新用一个值保存全局最大值。
        double res=min;
        for(int i =1;i<arr.length;i++){
            double t_max = max;
            //最大值可以从哪些地方产生：
            // 1. arr[i]  2. min*arr[i] 3.max*arr[i]
            max = Math.max (Math.max(arr[i],arr[i]*max), min*arr[i]);
            //最小值可以从哪些地方产生：
            // 1. arr[i]  2.max*arr[i] 3.min*arr[i]
            min = Math.min( Math.min(arr[i],arr[i]*min),t_max * arr[i]);
            res = Math.max(res,max); //更新全局最大值
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        double[] data = {-2.5, 4, 0, 3, 0.5, 8, -1};
        System.out.println(solution.maxProduct(data));
        System.out.println(solution.maxProduct2(data));
    }
}