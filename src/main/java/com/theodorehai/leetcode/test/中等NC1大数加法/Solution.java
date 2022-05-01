package com.theodorehai.leetcode.test.中等NC1大数加法;

import java.math.BigInteger;

/**
 * com.theodorehai.leetcode.test.中等NC1大数加法.
 * 题目描述
 * 以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
 * （字符串长度不大于100000，保证字符串仅由'0'~'9'这10种字符组成） 示例1 输入 "1","99" 返回值 "100" 说明 1+99=100
 *
 * @author chengxiaohai.
 * @date 2021/4/21.
 */

public class Solution {

    public String solve3(String s, String t) {
       int carray = 0;
       char[] array1 = s.toCharArray();
       char[] array2 = t.toCharArray();
       char[] res = new char[Math.max(array1.length,array2.length)+1];
       int index1 = array1.length -1;
       int index2 = array2.length -1;
       int index = res.length -1;
       while (index1 >=0 || index2>=0 || carray != 0){
           int num1 = index1>=0?array1[index1--]-'0':0;
           int num2 = index2>=0?array2[index2--]-'0':0;
           int sum = num1 + num2 + carray;
           carray = sum / 10;
           res[index--] = (char)(sum%10+'0');
       }
       return index == 0 ? String.valueOf(res).substring(1):String.valueOf(res);
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可 计算两个数之和
     *
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    //@Deprecated 实现有问题
    public String solve(String s, String t) {
        // write code here
        if (s == null || t == null) {
            return null;
        }
        BigInteger value1 = BigInteger.valueOf(Long.valueOf(s));
        BigInteger value2 = BigInteger.valueOf(Long.valueOf(t));
        return String.valueOf(value1.add(value2));
    }

    public String solve2(String s, String t) {
        // write code here
        int carry = 0;
        char[] res = new char[Math.max(s.length(), t.length()) + 1];
        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();
        int idx = res.length - 1;
        int idx1 = array1.length - 1;
        int idx2 = array2.length - 1;
        while (idx1 >= 0 || idx2 >= 0 || carry != 0) {
            int num1 = idx1 >= 0 ? array1[idx1--] - '0' : 0;
            int num2 = idx2 >= 0 ? array2[idx2--] - '0' : 0;
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            res[idx--] = (char) (sum % 10 + '0');
        }

        return idx == 0 ? String.valueOf(res).substring(1) : String.valueOf(res);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solve3("999", "999"));
    }
}
