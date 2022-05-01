package com.theodorehai.leetcode.test.中等NC46加起来和为目标值的组合;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.InternetHeaders;
import java.util.ArrayList;
import java.util.Arrays;
import netscape.security.UserTarget;
import org.omg.IOP.TAG_RMI_CUSTOM_MAX_STREAM_FORMAT;

/**
 * com.theodorehai.leetcode.test.中等NC46加起来和为目标值的组合.
 *题目描述
 * 给出一组候选数C 和一个目标数 T，找出候选数中起来和等于 T 的所有组合。
 *  C 中的每个数字在一个组合中只能使用一次。
 * 注意：
 * 1. 题目中所有的数字（包括目标数T ）都是正整数
 * 2. 组合中的数字 (a_1, a_2, … , a_k) 要按非递增排序 (1≤a2≤…≤ak).
 * 3. 结果中不能包含重复的组合
 * 4. 组合之间的排序按照索引从小到大依次比较，小的排在前面，
 * 如果索引相同的情况下数值相同，则比较下一个索引。
 * 示例1
 * 输入 [100,10,20,70,60,10,50],80
 * 返回值 [[10,10,60],[10,20,50],[10,70],[20,60]]
 * 说明
 * 给定的候选数集是[100,10,20,70,60,10,50]，目标数是80
 * @author chengxiaohai.
 * @date 2021/5/9.
 */
public class Solution {

    public static ArrayList<Integer> combinationSum(int[] num, int target) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        Arrays.sort(num);
        dfsCombination(num,target,res,temp,0);
        return res;
    }

    private static void dfsCombination(int[] num, int target, ArrayList<Integer> res, ArrayList<Integer> temp,
        int start) {
        if(target ==0){
            res.addAll(temp);
            return;
        }
        if(start >= num.length || target <0) return;
        for (int i = start ; i <num.length; i++) {
            if(i > start && num[i] == num[i-1]) return;
            if(target >= num[i]){
                temp.add(num[i]);
                dfsCombination(num,target-num[i],res,temp,i+1);
                if(res.size() >0) return;
                temp.remove(temp.size() -1);
            }

        }
    }
    //     ArrayList<Integer> res = new ArrayList<>();
    //     ArrayList<Integer> temp = new ArrayList<>();
    //     Arrays.sort(num);
    //     dfsCombinate(num,target,res,temp, 0);
    //     return res;
    //
    // }
    //
    // private static void dfsCombinate(int[] num, int target, ArrayList<Integer> res, ArrayList<Integer> temp,
    //     int start) {
    //     if(target == 0){
    //         res.addAll(new ArrayList<>(temp));
    //         return;
    //     }
    //     if(start >=num.length || target <0) return;
    //     for (int i = start; i < num.length ; i++) {
    //         if(i > start && num[i] == num[i-1])  continue;
    //         if(target >= num[i]){
    //             temp.add(num[i]);
    //             dfsCombinate(num,target-num[i],res,temp,i+1);
    //             if(res.size()>0) return;
    //             temp.remove(temp.size()-1);
    //         }
    //     }
    // }


    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if(num == null || num.length==0 || target<0) return res;
        Arrays.sort(num);
        dfs(num,target,res,arr,0);
        return res;
    }
    void dfs(int[] num,int target,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> arr,int start){
        if(target==0){
            res.add(arr);
            return;
        }
        if(start >= num.length)return;
        for(int i=start;i<num.length;i++){
            if(i > start && num[i] == num[i-1])continue;
            if(num[i] <= target){
                arr.add(num[i]);
                dfs(num,target-num[i],res,arr,i+1);
                arr.remove(arr.size()-1);
            }
        }
        return;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = {100,10,20,70,60,10,50};
        System.out.println(solution.combinationSum2(data, 80));
        System.out.println(combinationSum(data, 80));
    }
}
