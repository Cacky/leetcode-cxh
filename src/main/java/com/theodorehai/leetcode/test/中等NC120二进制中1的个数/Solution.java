package com.theodorehai.leetcode.test.中等NC120二进制中1的个数;

/**
 * com.theodorehai.leetcode.test.中等NC120二进制中1的个数.
 *题目描述
 * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 * 示例1
 * 输入 10
 * 返回值 2
 * @author chengxiaohai.
 * @date 2021/5/9.
 */
public class Solution {

    /**
     * 在机器中，整数的存储和运算都是其补码表示的。
     *
     * 正数右移：保持为正数，相当于/2。
     *
     * 负数右移：保持为负数，移位前是负数，移位后保持是负数，因此移位后最高位设为1。如果一直右移，最终会变成-1，即(-1)>>1是-1。
     *
     * 正数左移：不保持为正数，相当于*2。（注意：1左移31时为负数最大值）
     *
     * 负数左移：不保持为负数，在左移的过程中会有正有负的情况。所以切记负数左移不会特殊处理符号位。如果一直左移，最终会变成0。
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        int num = 0, flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                num++;
            }
            flag <<= 1;
        }
        return num;
    }

    /**
     * 整数n，进行n&(n-1)运算，会把二进制表示中最右边的1变为0。
     * （让我想起来树状数组中的lowbit函数，同样很神奇的位运算）
     * @param n
     * @return
     */
    public int NumberOf2(int n) {
        int num = 0;
        while (n != 0) {
            num++;
            n &= (n - 1);
        }
        return num;
    }
}
