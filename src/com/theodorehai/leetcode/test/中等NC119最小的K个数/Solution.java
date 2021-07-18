package com.theodorehai.leetcode.test.中等NC119最小的K个数;

import java.util.ArrayList;

/**
 * com.theodorehai.leetcode.test.最小的K个数.
 * 题目描述
 *  给定一个数组，找出其中最小的K个数。
 *  例如数组元素是4,5,1,6,2,7,3,8这8个数字，
 *  则最小的4个数字是1,2,3,4。
 *  如果K>数组的长度，那么返回一个空的数组
 *  输入： [4,5,1,6,2,7,3,8],4
 *  输出： [1,2,3,4]
 */
public class Solution {
    //1.采用冒泡排序
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> result = new ArrayList<>();
        if(k>input.length) return result;
        for (int i = 0; i < input.length-1 && result.size()<k; i++) {
            for (int j = 0; j < input.length-1-i; j++) {
                if(input[j]<input[j+1]){
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
            result.add(input[input.length-1-i]);
        }

        return result;
    }

    //2. 采用堆排序
    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {

        ArrayList<Integer> result = new ArrayList<>();
        if(k>input.length) return result;
        buildHeap(input,k,result);
        return result;
    }

    // 建堆
    private void buildHeap(int[] input,int k,ArrayList<Integer> result){
        for (int i = (input.length-1)/2; i >=0 ; i--) {
            adjustHeap(input,i,input.length);
        }
        for (int i = input.length-1; i >input.length-1-k ; i--) {
            swap(input, 0, i);
            result.add(input[i]);
            adjustHeap(input, 0, i);
        }
    }
    // 调整
    private void adjustHeap(int[] a,int s,int e){
        for (int i = s; i < e;) {
            int max = i;
            if(i*2+1<e && a[i*2+1]<a[max]){
                max = i*2+1;
            }
            if(i*2+2<e && a[i*2+2]<a[max]){
                max = i*2+2;
            }
            if(max != i){
                swap(a,i,max);
                i = max;
            } else {
                break;
            }
        }
    }

    private void swap(int[] input,int s,int e){
        int temp = input[s];
        input[s] = input[e];
        input[e] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = new int[]{4,5,1,6,2,7,3,8};
        System.out.println(solution.GetLeastNumbers_Solution(data, 4));
        System.out.println(solution.GetLeastNumbers_Solution2(data, 4));
    }
}
