package com.theodorehai.leetcode.test.简单NC19子数组的最大累加和问题;

/**
 * com.theodorehai.leetcode.test.简单NC19子数组的最大累加和问题.
 * 题目描述 给定一个数组arr，返回子数组的最大累加和
 * 例如，arr = [1, -2, 3, 5, -2, 6,-1]，所有子数组中，
 * [3, 5, -2, 6]可以累加出最大的和12，所以返回12.
 * 题目保证没有全为负数的数据 [要求] 时间复杂度为O(n)，空间复杂度为O(1)
 * <p>
 * 示例1
 * 输入 [1, -2, 3, 5, -2, 6, -1]
 *
 * 返回值 12
 * 备注: 1≤N≤10 |arri∣≤100
 *
 * @author chengxiaohai.
 * @date 2021/4/20.
 */
public class Solution {

    /**
     * max sum of the subarray
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxsumofSubarray(int[] arr) {
        // write code here
        int maxSum = 0;
        int currentSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currentSum = currentSum + arr[i];
            if (currentSum < 0) {
                currentSum = 0;
            }
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    public int maxsumofSubarray2(int[] arr) {
        // write code here
        if (arr.length == 0 || arr == null) {
            return 0;
        }
        int sum = arr[0];
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            if (sum + arr[i] > arr[i]) {
                sum = sum + arr[i];
            } else {
                sum = arr[i];
            }
        }
        return sum;
    }
    public static int maxSumOfSubArray(int[] a){
        if(a == null || a.length ==0) return 0;
        int maxSum = 0;
        int currentSum =0;
        for (int i = 0; i < a.length; i++) {
            currentSum += a[i];
            if(currentSum < 0){
                currentSum = 0;
            }
            maxSum = Math.max(maxSum,currentSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] data = {1, -2, 3, 5, -2, 6, -1};
        System.out.println(new Solution().maxsumofSubarray(data));
        System.out.println(maxSumOfSubArray(data));
    }
}
