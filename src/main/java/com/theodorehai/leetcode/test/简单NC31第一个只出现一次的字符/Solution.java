package com.theodorehai.leetcode.test.简单NC31第一个只出现一次的字符;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * com.theodorehai.leetcode.test.简单NC31第一个只出现一次的字符.
 *题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)
 * 中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 * 示例1
 * 输入 "google"
 * 返回值  4
 * @author chengxiaohai.
 * @date 2021/5/9.
 */
public class Solution {
    public int FirstNotRepeatingChar(String str) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
            }else{
                map.put(str.charAt(i),1);
            }
        }
        int pos = -1;
        for (int i = 0; i < str.length(); i++) {
            if(map.get(str.charAt(i))==1){
                return i;
            }
        }
        return pos;

    }
    public static int firstNotRepeatingChar(String str){
        if(str == null || str.length() ==0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
            }else{
                map.put(str.charAt(i),1);
            }
        }
        int pos = -1;
        for (int i = 0; i < str.length(); i++) {
            if(map.get(str.charAt(i)) ==1){
                return i;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "google";
        System.out.println(solution.FirstNotRepeatingChar(str));
        System.out.println(firstNotRepeatingChar(str));
    }
}
