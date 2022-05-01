package com.theodorehai.leetcode.test.简单NC48在旋转过的有序数组中寻找目标值;

import java.util.HashMap;

/**
 * com.theodorehai.leetcode.test.简单NC48在旋转过的有序数组中寻找目标值.
 * 题目描述 给定一个整数数组nums，按升序排序，数组中的元素各不相同。
 * nums数组在传递给search函数之前，
 * 会在预先未知的某个下标 t（0 <= t <= nums.length-1）上进行旋转，
 * 让数组变为[nums[t], nums[t+1], ..., nums[nums.length-1], nums[0], nums[1], ..., nums[t-1]]。
 * 比如，数组[0,2,4,6,8,10]在下标2处旋转之后变为[6,8,10,0,2,4]
 * 现在给定一个旋转后的数组nums和一个整数target，请你查找这个数组是不是存在这个target，
 * 如果存在，那么返回它的下标，如果不存在，返回-1
 * 示例1 输入 [6,8,10,0,2,4],10 返回值 2
 * 示例2 输入 [6,8,10,0,2,4],3 返回值 -1
 * 示例3 输入 [2],1 返回值  -1
 * 备注: 1 <= nums.length <= 4000
 *
 * @author chengxiaohai.
 * @date 2021/4/28.
 */
public class Solution {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * HashMap 先将数组里的数以值为关键字，下标为保存值；
     * 利用count函数，若关键字target存在，count返回1，
     * 输出哈希表中的值。若不存在 count输出0，返回-1；
     *
     * @param nums int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search(int[] nums, int target) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        if (map.get(target) != null) {
            return map.get(target);
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        // write code here
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < nums[hi] && nums[mid] < target && target <= nums[hi]) {
                lo = mid + 1;
            } else if (nums[mid] > nums[hi] && !(nums[lo] <= target && target < nums[mid])) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = {6,8,10,0,2,4};
        System.out.println(new Solution().search(data, 10));
        System.out.println(new Solution().search2(data, 10));
    }
}
