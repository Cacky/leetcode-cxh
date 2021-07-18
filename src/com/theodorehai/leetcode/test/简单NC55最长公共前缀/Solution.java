package com.theodorehai.leetcode.test.简单NC55最长公共前缀;

/**
 * com.theodorehai.leetcode.test.简单NC55最长公共前缀.
 *题目描述
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 示例1
 * 输入 ["abca","abc","abca","abc","abcc"]
 * 返回值  "abc"
 * @author chengxiaohai.
 * @date 2021/4/29.
 */
import java.util.*;


public class Solution {
    public String longestCommonPrefix2 (String[] strs) {
        if(strs == null || strs.length ==0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(strs[j].length() <=i || strs[j].charAt(i) != ch){
                    return sb.length() ==0?"":sb.toString();
                }
            }
            sb.append(ch);
        }
        return String.valueOf(sb);
    }
    /**
     * @param strs string字符串一维数组
     * @return string字符串
     */
    /**
     *
     * @param strs string字符串一维数组
     * @return string字符串
     */
    public String longestCommonPrefix (String[] strs) {
        if (strs.length == 0 || strs == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ;i <strs[0].length();i++){
            char ch = strs[0].charAt(i);
            for (int j =1; j<strs.length;j++){
                if(strs[j].length()<=i || ch != strs[j].charAt(i)){
                    return sb.length() == 0 ? "" : sb.toString();
                }
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] data = {"abca","abc","abca","abc","abcc"};
        System.out.println(solution.longestCommonPrefix(data));
        System.out.println(solution.longestCommonPrefix2(data));
    }
}
