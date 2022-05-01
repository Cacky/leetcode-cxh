package com.theodorehai.leetcode.test.中等NC54数组中相加和为0的三元组;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * com.theodorehai.leetcode.test.中等NC54数组中相加和为0的三元组. 题目描述 给出一个有n个元素的数组S， S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。 注意：
 * 三元组（a、b、c）中的元素必须按非降序排列。（即a≤b≤c） 解集中不能包含重复的三元组。 例如，给定的数组 S = {-10 0 10 20 -10 -40},解集为(-10, 0, 10) (-10, -10, 20)
 * <p>
 * 示例1 输入 复制 [-2,0,1,1,2] 返回值 复制 [[-2,0,2],[-2,1,1]]
 *
 * @author chengxiaohai.
 * @date 2021/4/19.
 */
public class Solution {

    public static ArrayList<ArrayList<Integer>> threeSum2(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(num ==null) return res;
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            if(i ==0 || num[i] !=num[i-1]){
                int left = i+1;
                int right = num.length -1;
                while (left <right){
                    while (left < right && num[i] + num[left] + num[right] >0){
                        right--;
                    }
                    if(left < right && num[i] + num[left] + num[right] ==0){
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(num[i]);
                        temp.add(num[left]);
                        temp.add(num[right]);
                        res.add(temp);
                    }
                    left++;
                }
            }
        }

        return res;
    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> t;
        int len = num.length;
        for (int i = 0; i < len - 2; i++) {//len-3,len-2,len-1
            if (i == 0 || num[i] != num[i - 1]) {
                int left = i + 1;
                int right = len - 1;
                while (left < right) {
                    while (left < right && (num[i] + num[left] + num[right]) > 0) {
                        right--;
                    }
                    if (left < right && (num[i] + num[left] + num[right]) == 0) {
                        t = new ArrayList<>();
                        t.add(num[i]);
                        t.add(num[left]);
                        t.add(num[right]);
                        res.add(t);
                        while (left < right && num[left] == t.get(1)) {
                            left++;
                        }
                    } else {
                        left++;
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] temp = {-10, 0, 10, 20, -10, -40};
        System.out.println(new Solution().threeSum(temp));
        System.out.println(threeSum2(temp));
    }
}
