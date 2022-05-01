package com.theodorehai.leetcode.test.中等NC41最长无重复子串;

import java.util.HashMap;

/**
 * com.theodorehai.leetcode.test.NC41最长无重复子串.
 * <p>
 * https://blog.csdn.net/varyall/article/details/80115182
 * <p>
 * 题目描述 给定一个数组arr， 返回arr的最长无的重复子串的长度(无重复指的是所有数字都不相同)。1≤n≤10^5 输入： [2,3,4,5] 返回值：4 示例 2 输入 [2,2,3,4,3] 返回值  3
 *
 * @date 2021/4/14.
 */

public class Solution {

    /**
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength(int[] arr) {
        int ans = 0;
        int[] index = new int[100000];
        for (int j = 0, i = 0; j < arr.length; j++) {
            i = Math.max(index[arr[j]], i);
            ans = Math.max(ans, j - i + 1);
            index[arr[j]] = j + 1;
        }
        return ans;
    }

    public int maxLength3(int[] arr) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                start = Math.max(start, map.get(arr[i]));
            }
            res = Math.max(res, i - start + 1);
            map.put(arr[i], i + 1);
        }
        return res;
    }


    public int maxLength2(int[] arr) {
        int res = 0;
        int start = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                start = Math.max(start, map.get(arr[i]));
            }
            res = Math.max(res, i - start + 1);
            map.put(arr[i], i + 1);
        }

        return res;
    }


    public static void main(String[] args) {
        int[] data = {2, 2, 3, 2, 4, 2, 3, 4, 5};
        System.out.println(new Solution().maxLength(data));
        System.out.println(new Solution().maxLength2(data));
        System.out.println(new Solution().maxLength3(data));
    }
}
