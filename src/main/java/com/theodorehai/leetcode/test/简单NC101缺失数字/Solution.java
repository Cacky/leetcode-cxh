package com.theodorehai.leetcode.test.简单NC101缺失数字;

/**
 * com.theodorehai.leetcode.test.简单NC101缺失数字.
 *题目描述
 * 从0,1,2,...,n这n+1个数中选择n个数，找出这n个数中缺失的那个数，要求O(n)尽可能小。
 * 示例1
 * 输入 [0,1,2,3,4,5,7]
 * 返回值  6
 * 示例2
 * 输入  [0,2,3]
 * 返回值  1
 * @author chengxiaohai.
 * @date 2021/4/27.
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 找缺失数字
     * @param a int整型一维数组 给定的数字串
     * @return int整型
     */
    public int solve (int[] a) {
        // write code here
        int last =a[0];
        if(a[0] !=0){
            return 0;
        }
        for (int i = 1; i < a.length; i++) {
            if(a[i] != last+1){
                return last+1;
            }
            last = a[i];
        }
        return last+1;
    }

    public int solve2 (int[] a) {
        // write code here
        for(int i = 0; i < a.length; i++){
            if(a[i] != i){
                return i;
            }
        }
        return a.length;
    }

    public static int solve3(int[] a){
        for (int i = 0; i < a.length; i++) {
            if(i != a[i]) return i;
        }
        return a.length;
    }

    public static void main(String[] args) {
        int[] data = new int[]{0,1,2,3,4,5,7};
        Solution solution = new Solution();
        System.out.println(solution.solve2(data));
        System.out.println(solve3(data));
    }
}
