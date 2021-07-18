package com.theodorehai.leetcode.test.中等NC17最长回文子串;

/**
 * com.theodorehai.leetcode.test.中等NC17最长回文子串.
 * 题目描述
 * 对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。 给定字符串A以及它的长度n，请返回最长回文子串的长度。
 * <p>
 * 示例1 输入  "abc1234321ab",12 返回值  7
 *
 * @author chengxiaohai.
 * @date 2021/4/15.
 */
public class Solution {

    public static int getLongestPalindrome3(String A,int n){
        boolean[][] dp = new boolean[n][n];
        int maxLength = 0;
        for (int i = n-2; i >=0 ; i--) {
            dp[i][i] = true;
            for (int j = i+1; j < n; j++) {
                if(A.charAt(i) == A.charAt(j)){
                    if(j-i<3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j]){
                    maxLength = Math.max(maxLength,j-i+1);
                }
            }

        }

        return maxLength;
    }










    // public int getLongestPalindrome3(String A, int n) {
    //     boolean[][] dp = new boolean[n][n];
    //     int maxLength =0;
    //     for (int i = n-2; i >=0 ; i--) {
    //         dp[i][i] = true;
    //         for (int j = i+1; j < n ; j++) {
    //             if(A.charAt(i) == A.charAt(j)){
    //                 if(j -i <3){
    //                     dp[i][j] = true;
    //                 }else{
    //                     dp[i][j] = dp[i+1][j-1];
    //                 }
    //             }
    //             if(dp[i][j]){
    //                 maxLength = Math.max(maxLength,j-i+1);
    //             }
    //         }
    //     }
    //     return maxLength;
    // }


    public int getLongestPalindrome(String A, int n) {
        // write code here
        //boolean dp[i][j] 代表i->j之间是否是回文
        boolean[][] dp= new boolean[n][n];
        int maxLength = 0;
        for (int i = n-2; i >=0 ; i--) {
            dp[i][i] = true;
            for (int j = i+1; j < n ; j++) {
                if(A.charAt(i) == A.charAt(j)){
                    if(j-i<3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j]){
                    maxLength = Math.max(maxLength,j-i+1);
                }
            }

        }
        return maxLength;

    }

    public int getLongestPalindrome2(String A, int n) {
        // write code here
        if (n <= 1) {
            return n;
        }
        int size = 0;
        boolean dp[][] = new boolean[n][n];
        for (int i = n - 2; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = A.charAt(i) == A.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && size < j - i + 1) {
                    size = j - i + 1;
                }
            }
        }
        return size;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getLongestPalindrome("abcdefdeffed", 12));
        System.out.println(new Solution().getLongestPalindrome2("abcdefdeffed", 12));
        System.out.println(new Solution().getLongestPalindrome3("abcdefdeffed", 12));
    }
}
