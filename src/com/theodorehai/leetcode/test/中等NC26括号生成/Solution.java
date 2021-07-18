package com.theodorehai.leetcode.test.中等NC26括号生成;

/**
 * com.theodorehai.leetcode.test.中等NC26括号生成.
 *题目描述
 * 给出n对括号，请编写一个函数来生成所有的由n对括号组成的合法组合。
 * 例如，给出n=3，解集为：
 * "((()))", "(()())", "(())()", "()()()", "()(())",
 * 示例1
 * 输入 1
 * 返回值 ["()"]
 * 示例2
 * 输入 2
 * 返回值 ["(())","()()"]
 * @author chengxiaohai.
 * @date 2021/5/8.
 */
import java.util.*;
import sun.plugin.liveconnect.OriginNotAllowedException;


public class Solution {

    public ArrayList<String> generateParenthesis3 (int n) {
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        dfsGenrate(res,n,0,0,temp);
        return res;
    }

    private void dfsGenrate(ArrayList<String> res, int n, int left, int right, ArrayList<String> temp) {
        if(right == n){
            res.add(String.join("",temp));
            return;
        }
        if(left < n){
            temp.add("(");
            dfsGenrate(res,n,left+1,right,temp);
            temp.remove(temp.size()-1);
        }
        if(left > right){
            temp.add(")");
            dfsGenrate(res,n,left,right+1,temp);
            temp.remove(temp.size()-1);
        }
    }

    public ArrayList<String> generateParenthesis2 (int n) {
        ArrayList<String> res = new ArrayList<>();
        dfs(n,0,0,res,"");
        return res;
    }

    public void dfs(int n,int left,int right,ArrayList<String> res,String s){
        if(right == n){
            res.add(s);
            return;
        }
        if(left <n ){
            dfs(n,left+1,right,res,s+"(");
        }
        if(left >right){
            dfs(n,left,right+1,res,s+")");
        }
    }
    /**
     * 1.回溯法：回溯的过程是函数的进入与退出
     * 2.记录左括号和右括号的数量：
     * 当左括号数量小于n时继续添加左括号
     * 当右括号数量小于左括号时继续添加右括号
     * @param n int整型
     * @return string字符串ArrayList
     */
    public ArrayList<String> generateParenthesis (int n) {
        ArrayList<String> res = new ArrayList<>();
        generateCycle(n,0,0,"",res);
        return res;
    }

    private void generateCycle(int n, int left, int right, String s, ArrayList<String> res) {
        if (right == n){
            res.add(s);
            return;
        }

        if (left < n){
            generateCycle(n,left + 1,right,s+"(",res);
        }

        if (left > right){
            generateCycle(n,left,right+1,s+")",res);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(5));
        System.out.println(solution.generateParenthesis2(5));
        System.out.println(solution.generateParenthesis3(5));
    }
}
