package com.theodorehai.leetcode.test.中等NC41最长无重复子串;

import java.util.LinkedList;
import jdk.nashorn.internal.runtime.JSONListAdapter;

/**
 * com.theodorehai.leetcode.test.中等NC41最长无重复子串.
 *题目描述
 * 给定一个数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
 * 子数组是连续的，比如[1,2,3,4,5]的子数组有[1,2]，[2,3,4]等等，但是[1,3,4]不是子数组
 * 示例1
 * 输入 [2,3,4,5]
 * 返回值 4
 * 说明
 * [2,3,4,5]是最长子数组
 * 示例2
 * 输入 [2,2,3,4,3]
 * 返回值  3
 * 说明
 * [2,3,4]是最长子数组
 * 示例3
 * 输入  [9]
 * 返回值  1
 * 示例4
 * 输入  [1,2,3,1,2,3,2,2]
 * 返回值 3
 * 说明
 * 最长子数组为[1,2,3]
 * @author chengxiaohai.
 * @date 2021/4/14.
 */
public class Solution1 {

    /**
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength(int[] arr) {
        // write code here
        int[] vis = new int[100005];
        int ans = 0;
        int l = 0, r = 0;
        while (r < arr.length) {
            if (vis[arr[r]] == 0) {
                vis[arr[r]] = 1;
                ans = Math.max(ans, r - l + 1);
                r++;
            } else {
                vis[arr[l]] = 0;
                l++;
            }
        }
        return ans;
    }

    public int maxLength2 (int[] arr) {
        LinkedList<Integer> list = new LinkedList<>();
        int ans=0;
        for(int i=0;i<arr.length;i++){
            if(list.contains(arr[i])){
                int j=list.indexOf(arr[i]);
                while (j-->=0){
                    list.removeFirst();
                }
            }
            list.add(arr[i]);
            ans=Math.max(ans,list.size());
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = {2,2,3,4,3};
        System.out.println(solution.maxLength(data));
        System.out.println(solution.maxLength2(data));
    }

}
