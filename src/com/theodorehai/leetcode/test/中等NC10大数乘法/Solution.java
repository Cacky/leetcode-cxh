package com.theodorehai.leetcode.test.中等NC10大数乘法;

import java.math.BigInteger;

/**
 * com.theodorehai.leetcode.test.中等NC10大数乘法.
 *题目描述
 * 以字符串的形式读入两个数字，编写一个函数计算它们的乘积，以字符串形式返回。
 * （字符串长度不大于10000，保证字符串仅由'0'~'9'这10种字符组成）
 * 示例1
 * 输入 "11","99"
 * 返回值  "1089"
 * 说明
 * 11*99=1089
 * @author chengxiaohai.
 * @date 2021/5/9.
 */
public class Solution {

   public static String solve3(String s,String t){
      int[] num1 = new int[s.length()];
      int[] num2 = new int[t.length()];
      int[] res = new int[s.length()+t.length()-1];
       for (int i = 0; i < s.length(); i++) {
           num1[i] = s.charAt(i)-'0';
       }
       for (int i = 0; i < t.length();i++){
           num2[i] = t.charAt(i) -'0';
       }
       for (int i = 0; i < s.length(); i++) {
           for (int j = 0; j < t.length(); j++) {
               res[i+j] += num1[i] * num2[j];
           }
       }

       for (int k = res.length -1; k >0 ; k--) {
           res[k-1] += res[k] /10;
           res[k] = res[k] % 10;
       }
       StringBuilder sb = new StringBuilder();
       for (int i = 0; i < res.length; i++) {
           sb.append(res[i]);
       }
       return String.valueOf(sb);
   }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串 第一个整数
     * @param t string字符串 第二个整数
     * @return string字符串
     */
    public String solve (String s, String t) {
        // write code here
        int len1 = s.length();
        int len2 = t.length();

        int[] nums1 = new int[len1];
        int[] nums2 = new int[len2];

        for(int i = 0; i < len1; i++){
            nums1[i] = s.charAt(i) - '0';
        }
        for(int i = 0; i < len2; i++){
            nums2[i] = t.charAt(i) - '0';
        }
        int[] result = new int[len1 + len2];

        // 1. 逐位相乘
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                result[i + j] += nums1[i] * nums2[j];
            }
        }

        // 2. 从后往前进位
        for(int k = result.length - 1; k > 0; k--){
            result[k - 1] += result[k] / 10;
            result[k] = result[k] % 10;
        }
        // 输出字符串
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < result.length - 1; i++){
            stringBuilder.append(result[i]);
        }
        return stringBuilder.toString();
    }

    //使用大树相乘
    public String solve2 (String s, String t) {
        // write code here
        if ("".equals(s) || "".equals(t)) {
            return "";
        }
        BigInteger b1 = new BigInteger(s);
        BigInteger b2 = new BigInteger(t);
        BigInteger res = b1.multiply(b2);
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve("100", "1000"));
        System.out.println(solution.solve3("100", "1000"));
    }
}
