package com.theodorehai.leetcode.test.中等NC103反转字符串;

/**
 * com.theodorehai.leetcode.test.中等NC103反转字符串. 题目描述 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000） 示例1 输入 复制 "abcd" 返回值
 * 复制 "dcba"
 *
 * @author chengxiaohai.
 * @date 2021/4/21.
 */

public class Solution {
    public String solve3(String str) {
        char[] strArray = str.toCharArray();
        for (int i = 0,j=strArray.length-1; i < j ; i++,j--) {
            char temp = strArray[i];
            strArray[i] = strArray[j];
            strArray[j] = temp;
        }
        return String.valueOf(strArray);
    }

    /**
     * 反转字符串
     *
     * @param str string字符串
     * @return string字符串
     */
    public String solve(String str) {
        // write code here
        StringBuilder stringBuilder = new StringBuilder(str);
        return stringBuilder.reverse().toString();
    }

    /**
     * 反转字符串
     *
     * @param str string字符串
     * @return string字符串
     */
    public String solve2(String str) {
        // write code here
        if(str == null || str.length() <2){
            return str;
        }
        char[] ch = str.toCharArray();
        for (int low = 0,hight = ch.length-1; low < hight ; low++,hight--) {
            char temp = ch[low];
            ch[low] = ch[hight];
            ch[hight] = temp;
        }
        return new String(ch);

    }



    public static void main(String[] args) {
        System.out.println(new Solution().solve2("ADCVFRGD"));
        System.out.println(new Solution().solve3("ADCVFRGD"));
    }
}
