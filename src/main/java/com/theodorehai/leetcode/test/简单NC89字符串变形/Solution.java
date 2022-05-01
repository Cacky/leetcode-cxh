package com.theodorehai.leetcode.test.简单NC89字符串变形;

/**
 * com.theodorehai.leetcode.test.简单NC89字符串变形.
 *题目描述
 * 对于一个给定的字符串，我们需要在线性(也就是O(n))的时间里对它做一些变形。
 * 首先这个字符串中包含着一些空格，就像"Hello World"一样，
 * 然后我们要做的是把着个字符串中由空格隔开的单词反序，同时反转每个字符的大小写。
 * 比如"Hello World"变形后就变成了"wORLD hELLO"。
 *
 * 输入描述:
 * 给定一个字符串s以及它的长度n(1≤n≤500)
 * 返回值描述:
 * 请返回变形后的字符串。题目保证给定的字符串均由大小写字母和空格构成。
 * 示例1
 * 输入 "This is a sample",16
 * 返回值 "SAMPLE A IS tHIS"
 * @author chengxiaohai.
 * @date 2021/4/30.
 */
import java.util.*;

public class Solution {
    public String trans(String s, int n) {
        // write code here
        if(s == null){
            return s;
        }
        int start = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = n-1; i >=0 ; i--) {
            char c = s.charAt(i);
            if(c == ' '){
                sb.append(' ');
                start = n - i;
            }else{
                char ss = (char) (c >= 97? c-32:c+32);
                sb.insert(start, ss);
            }
        }
        return String.valueOf(sb);
    }

    public static String trans2(String str){
        if(str == null || str.length() ==0) return str;
        int start =0;
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() -1; i >=0 ; i--) {
            char c = str.charAt(i);
            if(c ==' '){
                sb.append(c);
                start = str.length() -i;
            }else{
                char ss = (char)(c >=97?c-32:c+32);
                sb.insert(start,ss);
            }
        }
        return String.valueOf(sb);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str ="This is a sample";
        System.out.println(solution.trans(str, 16));
        System.out.println(trans2(str));
    }
}
