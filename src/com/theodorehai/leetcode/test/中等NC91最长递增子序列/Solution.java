package com.theodorehai.leetcode.test.中等NC91最长递增子序列;

import java.util.Arrays;

/**
 * com.theodorehai.leetcode.test.中等NC91最长递增子序列.
 *题目描述
 * 给定数组arr，设长度为n，输出arr的最长递增子序列。
 * （如果有多个答案，请输出其中字典序最小的）
 * 示例1
 * 输入 [2,1,5,3,6,4,8,9,7]
 * 返回值 [1,3,4,8,9]
 * 示例2
 * 输入 [1,2,8,6,4]
 * 返回值 [1,2,4]
 * 说明
 * 其最长递增子序列有3个，
 * （1，2，8）、（1，2，6）、（1，2，4）其中第三个字典序最小，
 * 故答案为（1，2，4）
 * @author chengxiaohai.
 * @date 2021/4/23.
 */
public class Solution {

    public int[] LIS2 (int[] arr) {
        int[] dp = new int[arr.length];
        int[] subset = new int[arr.length +1];
        int len =0;
        for (int i = 0; i < arr.length; i++) {
            if(subset[len] <arr[i]){
                subset[++len] = arr[i];
                dp[i] = len;
            }else{
                int index = Arrays.binarySearch(subset,0,len,arr[i]);
                if(index <0){
                    index = -(index +1);
                }
                subset[index] = arr[i];
                dp[i] = index;
            }
        }
        int[] res = new int[len];
        for (int i = arr.length -1; i >=0 ; i--) {
            if(dp[i] == len){
                res[--len] = arr[i];
            }
        }
        return res;
    }
    /**
     * retrun the longest increasing subsequence
     * @param arr int整型一维数组 the array
     * @return int整型一维数组
     */
    public int[] LIS (int[] arr) {
        int[] dp = new int[arr.length];
        int[] subset = new int[arr.length + 1];
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            if (subset[len] < arr[i]) {
                len += 1;
                subset[len] = arr[i];
                dp[i] = len;
            } else {
                int idx = Arrays.binarySearch(subset, 0, len, arr[i]);
                if (idx < 0) {
                    idx = -(idx + 1);
                }
                subset[idx] = arr[i];
                dp[i] = idx;
            }
        }
        // System.out.println("--------dp-------");
        // for (int i = 0; i < dp.length; i++) {
        //     System.out.print(dp[i]+",");
        // }
        // System.out.println("\n"+len);
        int[] res = new int[len];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (dp[i] == len) {
                res[--len] = arr[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // int[] data = new int[]{2,1,5,3,6,4,8,9,7};
        // int[] res = new Solution().LIS(data);
        // for (int i = 0; i < res.length; i++) {
        //     System.out.print(res[i]+" ");
        // }
        // System.out.println();
        int[] data2 = new int[]{2,3,1,2,3};
        int[] res = new Solution().LIS(data2);
        int[] res2 = new Solution().LIS2(data2);
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(res2));
    }
}
