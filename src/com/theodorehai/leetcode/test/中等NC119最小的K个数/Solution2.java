package com.theodorehai.leetcode.test.中等NC119最小的K个数;

/**
 * com.theodorehai.leetcode.test.最小的K个数.
 *
 * @author chengxiaohai.
 * @date 2021/4/13.
 */
import java.util.ArrayList;
public class Solution2 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        if(input == null || input.length == 0 || input.length < k) return list;
        quickSort(input, 0, input.length -1);

        for(int i = 0; i < k; i ++) {
            list.add(input[i]);
        }
        return list;
    }


    private void quickSort(int[] data, int l, int r) {
        if(l <= r) {
            int position = findPosition(data, l, r);
            quickSort(data, l, position -1);
            quickSort(data, position + 1, r);
        }
    }

    private int findPosition(int[] data, int l, int r) {


        int value = data[l];
        while(l < r) {
            while(l<r && data[r] >= value) {
                r--;
            }
            data[l] = data[r];
            while(l<r && data[l] <= value){
                l++;
            }
            data[r] = data[l];
        }
        data[l] = value;

        return r;
    }
}
