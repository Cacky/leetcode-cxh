package com.theodorehai.leetcode.test.中等NC105二分查找;

/**
 * com.theodorehai.leetcode.test.中等NC105二分查找.
 * 题目描述 请实现有重复数字的升序数组的二分查找
 * 给定一个 元素有序的（升序）整型数组 nums 和一个目标值 target
 * 写一个函数搜索nums 中的 target，
 * 如果目标值存在返回下标，否则返回 -1
 * 输入： [1,2,4,4,5],4 返回值： 2
 * 说明 从左到右，查找到第1个为4的，下标为2，返回2
 * 示例2 输入：[1,2,4,4,5],3 返回值：-1
 * 示例3 输入：[1,1,1,1,1],1 返回值 0
 *
 * @author chengxiaohai.
 * @date 2021/4/14.
 */
public class Solution {

    public int search2(int[] nums, int target) {
        int low = 0,high = nums.length-1;
        if(nums == null || target <nums[low] || target>nums[high]){
            return -1;
        }

        while (low<=high){
            int middle = (low + high)/2;
            if(nums[middle] < target){
                low = middle+1;
            }else if(nums[middle] >target){
                high = middle-1;
            }else{
                return middle;
            }
        }
        return -1;
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 如果目标值存在返回下标，否则返回 -1
     *
     * @param nums int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search(int[] nums, int target) {
        // write code here
        int low = 0;
        int high = nums.length - 1;
        // int middle = 0;            //定义middle

        if (target < nums[low] || target > nums[high] || low > high) {
            return -1;
        }

        while (low <= high) {
            int middle = (low + high) / 2;
            if (nums[middle] < target) {
                //比关键字小则关键字在右区域
                low = middle + 1;
            }else if (nums[middle] > target) {
                //比关键字大则关键字在左区域
                high = middle - 1;
            } else {
                return middle;
            }
        }
        //最后仍然没有找到，则返回-1
        return -1;
    }

    public static void main(String[] args) {
        // int[] arr = {1, 3, 5, 7, 9, 11};
        int[] arr = {1, 1, 1, 1, 1};
        int key = 1;
        int position = new Solution().search2(arr, key);
        if (position == -1) {
            System.out.println("查找的是" + key + ",序列中没有该数！");
        } else {
            System.out.println("查找的是" + key + ",找到位置为：" + position);
        }
    }
}
