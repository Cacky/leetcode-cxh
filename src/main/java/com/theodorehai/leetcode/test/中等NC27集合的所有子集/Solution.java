package com.theodorehai.leetcode.test.中等NC27集合的所有子集;

/**
 * com.theodorehai.leetcode.test.中等NC27集合的所有子集.
 *题目描述
 * 现在有一个没有重复元素的整数集合S，求S的所有子集
 * 注意：
 * 你给出的子集中的元素必须按升序排列
 * 给出的解集中不能出现重复的元素
 * 示例1
 * 输入 [1,2,3]
 * 返回值 [[],[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]]
 * @author chengxiaohai.
 * @date 2021/5/9.
 */
import java.util.*;

public class Solution {

    public ArrayList<ArrayList<Integer>> subsets2(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> array = new ArrayList<>();
        dfsArray(res,array,S,0);
        return res;
    }

    private void dfsArray(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> array, int[] s, int start) {
        res.add(new ArrayList<>(array));
        for (int i = start; i < s.length; i++) {
            array.add(s[i]);
            dfsArray(res,array,s,i+1);
            array.remove(array.size() -1);
        }
    }


    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        LinkedList<Integer> track = new LinkedList<>();
        back(S, 0, track);
        return res;
    }
    public void back(int[] S, int start, LinkedList<Integer> track){
        res.add(new ArrayList<>(track));
        for(int i = start; i < S.length; i++){
            track.add(S[i]);
            back(S, i+1, track);
            //撤销 回溯
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = {1,2,3,4};
        System.out.println(solution.subsets(data));
        System.out.println(solution.subsets2(data));
    }
}
