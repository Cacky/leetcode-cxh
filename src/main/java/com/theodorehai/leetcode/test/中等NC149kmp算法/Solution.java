package com.theodorehai.leetcode.test.中等NC149kmp算法;

/**
 * com.theodorehai.leetcode.test.中等NC149kmp算法.
 * https://blog.csdn.net/dark_cy/article/details/88698736
 * https://www.zhihu.com/question/21923021
 *题目描述
 * 给你一个非空模板串S，一个文本串T，问S在T中出现了多少次
 * 示例1
 * 输入 "ababab","abababab"
 * 返回值 2
 * 示例2
 * 输入 "abab","abacabab"
 * 返回值  1
 * 备注:
 * 空间O(n)时间O(n)的算法
 * @author chengxiaohai.
 * @date 2021/5/7.
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 计算模板串S在文本串T中出现了多少次
     * @param S string字符串 模板串
     * @param T string字符串 文本串
     * @return int整型
     */
    public int kmp (String S, String T) {
        // write code here
        int[] next = getNext(S);
        char[] str = T.toCharArray();
        char[] t = S.toCharArray();
        int si = 0;
        int ti = 0;
        int res = 0;
        while(si < str.length){
            if(str[si] == t[ti]){
                si++;
                ti++;
            }else{
                ti = (next[ti] < 0)? 0 : next[ti];
            }
            if(ti == t.length-1){
                res++;
                ti = (next[ti] < 0)? 0 : next[ti];
            }
        }
        return res;
    }
    public int[] getNext(String s){
        char[] arr = s.toCharArray();
        int[] next = new int[arr.length];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while(j < arr.length-1){
            if(k == -1 || arr[j] == arr[k]){
                j++;
                k++;
                next[j] = k;
            }else{
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str1 = "ababab";
        String str2 = "abababab";
        System.out.println(solution.kmp(str1, str2));
    }
}
