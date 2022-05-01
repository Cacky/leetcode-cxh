package com.theodorehai.leetcode.test.入门NC107寻找峰值;

/**
 * com.theodorehai.leetcode.test.入门NC107寻找峰值.
 *题目描述
 * 山峰元素是指其值大于或等于左右相邻值的元素。给定一个输入数组nums，
 * 任意两个相邻元素值不相等，数组可能包含多个山峰。
 * 找到索引最大的那个山峰元素并返回其索引。
 *
 * 假设 nums[-1] = nums[n] = -∞。
 *
 * 示例1
 * 输入 [2,4,1,2,7,8,4]
 * 返回值 5
 * @author chengxiaohai.
 * @date 2021/5/6.
 */
import java.util.*;


public class Solution {
    /**
     * 寻找最后的山峰
     * @param a int整型一维数组
     * @return int整型
     */
    public int solve (int[] a) {
        // write code here
        if (a == null || a.length == 0) return -1;
        if (a[a.length - 1] >= a[a.length - 2]){
            return a.length - 1;
        }
        int max = -1;
        for (int i = 0; i < a.length - 1; i ++){
            if (a[i] >= a[i + 1]){
                max = Math.max(max, i);
            }
        }

        return max;
    }

    public int solve2 (int[] a) {
        // write code here
        if (a == null || a.length == 0) return -1;
        for (int i = a.length - 1; i >= 1; i--) {
            if (a[i] > a[i - 1]) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = {2,4,1,10,7,8,9};
        System.out.println(solution.solve(data));
        System.out.println(solution.solve2(data));
    }
}
