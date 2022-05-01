package com.theodorehai.leetcode.test.中等NC128容器盛水问题;

/**
 * com.theodorehai.leetcode.test.中等NC128容器盛水问题. 题目描述 给定一个整形数组arr，已知其中所有的值都是非负的，将这个数组看作一个容器，请返回容器能装多少水。
 * <p>
 * 示例1 输入  [3,1,2,5,2,4] 返回值 5 示例2 输入  [4,5,1,3,2] 返回值  2 备注: 1≤N≤10^6
 *
 * @author chengxiaohai.
 * @date 2021/5/6.
 */

public class Solution {

    /**
     * max water
     *
     * @param arr int整型一维数组 the array
     * @return long长整型
     */
    public long maxWater(int[] arr) {
        // write code here
       long res = 0;
       int left = 0,right = arr.length-1;
       int leftMax = 0,rightMax = 0;
       while (left < right){
           leftMax = Math.max(leftMax,arr[left]);
           rightMax = Math.max(rightMax,arr[right]);
           if(leftMax < rightMax){
               res += leftMax - arr[left++];
           }else{
               res += rightMax - arr[right--];
           }
       }
       return res;
    }

    /**
     * max water
     *
     * @param arr int整型一维数组 the array
     * @return long长整型
     */
    public long maxWater3(int[] arr) {
        // write code here
        int min = 0;
        int max = 0;
        long res = 0;
        int left = 0, right = arr.length - 1;
        while (left < right) {
            min = arr[arr[left] < arr[right] ? left++ : right--];
            max = Math.max(min, max);
            res = res + (max - min);
        }
        return res;
    }

    /**
     * 将数组中每个位置上的累加起来就是总的水量 首先求容器边界, 然后使用双指针, 分别从两边往中间扫描, 当左边的高度小于右边的高度时,左指针++, 如果此时当前位置的高度小于容器的边界高度,这个位置上方有水,进行水量累加。
     * 反之，则右指针向左扫描-1。
     */
    public long maxWater2(int[] arr) {
        int left = 0, right = arr.length - 1;
        int leftMax = 0, rightMax = 0;
        long res = 0;
        while (left <= right) {
            leftMax = Math.max(leftMax, arr[left]);
            rightMax = Math.max(rightMax, arr[right]);
            if (leftMax <= rightMax) {
                res += leftMax - arr[left];
                left++;
            } else {
                res += rightMax - arr[right];
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = {3, 1, 2, 5, 2, 4, 7};
        int[] data2 = {3, 2, 1};
        System.out.println(solution.maxWater(data));
        System.out.println(solution.maxWater2(data));
    }
}
