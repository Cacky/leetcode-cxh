package com.theodorehai.leetcode.test.中等NC20数字字符串转化成IP地址;

/**
 * com.theodorehai.leetcode.test.中等NC20数字字符串转化成IP地址.
 * 题目描述
 * 现在有一个只包含数字的字符串，将该字符串转化成IP地址的形式，返回所有可能的情况。
 * 例如：
 * 给出的字符串为"25525522135",
 * 返回["255.255.22.135", "255.255.221.35"]. (顺序没有关系)
 * 示例1
 * 输入 25525522135"
 * 返回值  ["255.255.22.135","255.255.221.35"]
 * @author chengxiaohai.
 * @date 2021/5/9.
 */
import java.util.*;


public class Solution {

    ArrayList<String> res = new ArrayList<>();
    ArrayList<String> ip = new ArrayList<>();  //存放中间结果

    /**
     *
     * @param s string字符串
     * @return string字符串ArrayList
     */
    public ArrayList<String> restoreIpAddresses (String s) {
        // write code here
        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int start){
        if(ip.size() == 4 && start == s.length()){  //找到一个合法解
            res.add(ip.get(0) + '.' + ip.get(1) + '.' + ip.get(2) + '.' + ip.get(3));
            return;
        }
        if(s.length() - start > 3 * (4 - ip.size()))  //剪枝（分配3位都多余）
            return;
        if(s.length() - start < (4 - ip.size()))  //剪枝（分配一位都不够）
            return;
        //从第一位开始
        int num = 0;
        for(int i = start; i < start + 3 && i < s.length(); i++){
            num = num * 10 + (s.charAt(i) - '0');
            if(num < 0 || num > 255)  //剪枝
                continue;
            ip.add(s.substring(start, i + 1));
            dfs(s, i + 1);
            ip.remove(ip.size() - 1);

            if(num == 0)  //不允许前缀0
                break;
        }
    }

    public static ArrayList<String> restoreIpAddresses2(String s){
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> ip = new ArrayList<>();
        ipDfs(s,0,res,ip);
        return res;
    }

    private static void ipDfs(String s, int start, ArrayList<String> res, ArrayList<String> ip) {
        if(ip.size() == 4 && start == s.length()){
            res.add(String.format("%s.%s.%s.%s",ip.get(0),ip.get(1),ip.get(2),ip.get(3)));
            return;
        }
        if(s.length() - start > 3 * (4 - ip.size()) || s.length() - start < 4-ip.size()) return;
        int num = 0;
        for (int i = start; i < start+3 && i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) - '0');
            if(num < 0 || num > 255) continue;
            ip.add(s.substring(start,i+1));
            ipDfs(s,i+1,res,ip);
            ip.remove(ip.size() - 1);
            if(num == 0) break;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "25522135";
        System.out.println(solution.restoreIpAddresses(s));
        System.out.println(restoreIpAddresses2(s));
    }
}
