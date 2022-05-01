package com.theodorehai.leetcode.test.中等NC119最小的K个数;

/**
 * com.theodorehai.leetcode.test.最小的K个数.
 *
 * @author chengxiaohai.
 * @date 2021/4/13.
 */
import java.util.ArrayList;

public class Solution1 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(k>input.length)
            return list;
        for(int n = 0;n < k;n++){//冒泡排序，只找到k个小的就行。
            for(int i = 0;i < input.length-n-1;i++){
                if(input[i] < input[i+1]){//把最小的先找到，即把小的放在后面。
                    int temp = input[i];
                    input[i] = input[i+1];
                    input[i+1] = temp;
                }
            }
            list.add(input[input.length-n-1]);//把后面的即小的放在数组里。
        }
        return list;
    }
}
