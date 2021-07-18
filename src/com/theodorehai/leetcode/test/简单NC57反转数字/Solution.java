package com.theodorehai.leetcode.test.简单NC57反转数字;

/**
 * com.theodorehai.leetcode.test.简单NC57反转数字. 题目描述 将给出的32位整数x翻转。 例1:x=123，返回321 例2:x=-123，返回-321
 * <p>
 * 你有注意到翻转后的整数可能溢出吗？因为给出的是32位整数， 则其数值范围为[−2^{31}, 2^{31} − 1] 翻转可能会导致溢出，如果反转后的结果会溢出就返回 0。
 * <p>
 * 示例1 输入  -123 返回值  -321
 *
 * @author chengxiaohai.
 * @date 2021/4/23.
 */

public class Solution {

    public int reverse_20210612(int x) {
        int res = 0;
        while (x != 0){
            int tail = x % 10;
            res = res * 10 + tail;
            x = x / 10;
        }
        return res;
    }


    /**
     * @param x int整型
     * @return int整型
     */
    public int reverse(int x) {
        // write code here
        long res = 0;
        while (x != 0) {
            int tail = x % 10;
            res = res * 10 + tail;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return 0;
            }
            x = x / 10;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(-123));
        System.out.println(new Solution().reverse_20210612(-123));
    }
}
