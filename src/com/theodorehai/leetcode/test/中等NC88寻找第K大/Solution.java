package com.theodorehai.leetcode.test.中等NC88寻找第K大;

/**
 * com.theodorehai.leetcode.test.中等NC88寻找第K大. 题目描述 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 * <p>
 * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
 * <p>
 * 示例1 输入 复制 [1,3,5,2,2],5,3 返回值 复制 2
 *
 * @author chengxiaohai.
 * @date 2021/4/19.
 */

public class Solution {

    public int findKthValue(int[] a, int k) {
        return quikSort(a, 0, a.length-1, k);
    }

    public int quikSort(int[] a, int low, int hight, int k) {
        if(a == null || low > hight) return -1;
        int i = low,j = hight,temp = a[low];
        while (i<j){
            while (i<j && a[j] < temp) j--;
            if(i<j) a[i++]=a[j];
            while (i<j && a[i] >= temp) i++;
            if(i<j) a[j--] =a[i];
        }
        a[i] = temp;
        if(i == k-1){
            return a[i];
        }else if( i < k-1){
            return quikSort(a,i+1,hight,k);
        }else{
            return quikSort(a,low,i-1,k);
        }
    }

    public int findKth(int[] a, int n, int K) {
        // write code here
        int l = 0;
        int r = n - 1;
        return quik(a, l, r, K);

    }

    private int quik(int[] a, int l, int r, int k) {
        int position = find(a, l, r);
        if (position == k - 1) {
            return a[position];
        } else if (position > k - 1) {
            return quik(a, l, position - 1, k);
        } else {
            return quik(a, position + 1, r, k);
        }
    }

    private int find(int[] a, int l, int r) {
        int i = l;
        int j = r;
        int key = a[i];
        while (i < j) {
            while (i < j && a[j] < key) {
                j--;
            }
            if (i < j) {
                a[i++] = a[j];
            }
            while (i < j && a[i] > key) {
                i++;
            }
            if (i < j) {
                a[j--] = a[i];
            }

        }
        a[j] = key;
        return j;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] testData = {1, 3, 5, 2, 2,4};
        // System.out.println(solution.findKth(testData, 5, 3));
        System.out.println(solution.findKthValue(testData,7));
    }
}
