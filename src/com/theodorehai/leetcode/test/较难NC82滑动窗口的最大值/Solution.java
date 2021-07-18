package com.theodorehai.leetcode.test.较难NC82滑动窗口的最大值;

/**
 * com.theodorehai.leetcode.test.较难NC82滑动窗口的最大值. 题目描述 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * <p>
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * <p>
 * 那么一共存在6个滑动窗口， 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。 窗口大于数组长度的时候，返回空 示例1 输入
 * [2,3,4,2,6,2,5,1],3 返回值 [4,4,6,6,6,5]
 *
 * @author chengxiaohai.
 * @date 2021/4/29.
 */

import java.util.ArrayList;

public class Solution {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (size <= 0 || size > num.length) {
            return list;
        }
        int left = 0;
        int right = size - 1;
        while (right < num.length) {
            list.add(getMax(num, left, right));
            left++;
            right++;
        }
        return list;
    }

    public int getMax(int[] num, int left, int right) {
        if (num.length == 0 || left < 0 || right > num.length) {
            return -1;
        }
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            max = max > num[i] ? max : num[i];
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = {2, 3, 4, 2, 6, 2, 5, 1};
        ArrayList<Integer> res = solution.maxInWindows(data, 3);
        System.out.println(res);
    }
}
