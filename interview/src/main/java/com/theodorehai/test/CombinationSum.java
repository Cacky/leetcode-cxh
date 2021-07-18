package com.theodorehai.test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * com.theodorehai.interview01.
 *
 * @author chengxiaohai.
 * @date 2021/6/15.
 */
public class CombinationSum {

    public ArrayList<ArrayList<Integer>> combinationSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if (num == null || num.length == 0 || target < 0) {
            return res;
        }
        Arrays.sort(num);
        dfs(num, target, res, arr, 0);
        return res;
    }

    private void dfs(int[] num, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> arr, int start) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(arr));
            return;
        }
        if (start >= num.length) {
            return;
        }
        for (int i = start; i < num.length; i++) {
            if (i > start && num[i] == num[i - 1]) {
                continue;
            }
            if (num[i] <= target) {
                arr.add(num[i]);
                dfs(num, target - num[i], res, arr, i + 1);
                arr.remove(arr.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{100, 10, 20, 70, 60, 10, 50};
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(num, 80));
    }

}
