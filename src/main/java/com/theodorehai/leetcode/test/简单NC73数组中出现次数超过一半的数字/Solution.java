package com.theodorehai.leetcode.test.简单NC73数组中出现次数超过一半的数字;

import java.util.HashMap;

/**
 * com.theodorehai.leetcode.test.简单NC73数组中出现次数超过一半的数字.
 * 题目描述 数组中有一个数字出现的次数超过数组长度的一半， 请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 示例1 输入 [1,2,3,2,2,2,5,4,2] 返回值 2
 *
 * @author chengxiaohai.
 * @date 2021/4/15.
 */
public class Solution {

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 1) {
            return array[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                if (map.get(array[i]) >= array.length / 2) {
                    return array[i];
                } else {
                    map.put(array[i], map.get(array[i]) + 1);
                }
            } else {
                map.put(array[i], 1);
            }
        }
        return 0;
    }

    public int MoreThanHalfNum_Solution2(int [] array) {
        int vote = 0;
        int x = 0;
        for (int num : array) {
            if (vote == 0) {
                x = num;
                vote = 1;
            } else {
                vote += x == num ? 1 : -1;
            }
        }
        int y = 0;
        for (int num : array) {
            if (num == x) {
                y++;
            }
        }
        return y > array.length / 2 ? x : 0;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1};
        // int[] test = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(new Solution().MoreThanHalfNum_Solution(test));
    }
}
