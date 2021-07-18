package com.theodorehai.leetcode.test.简单NC61两数之和;

/**
 * com.theodorehai.leetcode.test.两数之和.
 *
 * @author chengxiaohai.
 * @date 2021/4/13.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[]{-1, -1};

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }

        for (int i = 0; i < numbers.length; i++) {
            int two = target - numbers[i];
            if (map.containsKey(two) && target != 2 * two) {
                res[0] = i + 1 < map.get(two) + 1 ? i + 1 : map.get(two) + 1;
                res[1] = i + 1 > map.get(two) + 1 ? i + 1 : map.get(two) + 1;
            }
        }
        return res;
    }

    public int[] twoSum2(int[] numbers, int target) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if(map.get(target - numbers[i]) != null){
                return new int[]{map.get(target-numbers[i])+1,i+1};
            }
            map.put(numbers[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{3, 2, 4};
        int[] result = new Solution2().twoSum2(numbers, 7);
        System.out.println(Arrays.toString(result));
    }
}
