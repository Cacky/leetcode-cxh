package com.theodorehai.leetcode.test.简单NC22合并两个有序的数组;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * com.theodorehai.leetcode.test.简单NC22合并两个有序的数组. 题目描述 给出两个有序的整数数组A和B， 请将数组B合并到数组A中，变成一个有序的数组 注意：
 * 可以假设A数组有足够的空间存放B数组的元素，A和B中初始的元素数目分别为m和n
 *
 * @author chengxiaohai.
 * @date 2021/4/16.
 */
public class Solution {

    public void merge(int A[], int m, int B[], int n) {
        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1;
        while (i >= 0 && j >= 0) {
            A[index--] = A[i] >= B[j] ? A[i--] : B[j--];
        }
        while (j >= 0) {
            A[index--] = B[j--];
        }

        // int indexA = m - 1;
        // int indexB = n - 1;
        // int index = m + n - 1;
        // while (indexA >= 0 && indexB >= 0) {
        //     A[index--] = A[indexA] >= B[indexB] ? A[indexA--] : B[indexB--];
        // }
        // while (indexB >= 0) {
        //     A[index--] = B[indexB--];
        // }
    }

    public static int[] mergeAndSortTwoArray(int[] a, int[] b) {
        LinkedList<Integer> res = new LinkedList<>();
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] > b[j]) {
                if(res.size()>0 && res.getLast() == b[j]){
                    j++;
                    continue;
                }
                res.add(b[j++]);
            } else if (a[i] == b[j]) {
                if(res.size()>0 && res.getLast() == a[i]){
                    i++;
                    j++;
                    continue;
                }
                res.add(a[i++]);
            } else {
                if(res.size()>0 && res.getLast() == a[i]){
                    i++;
                    continue;
                }
                res.add(a[i++]);
            }
        }
        while (i<a.length){
            if(res.size()>0 && res.getLast() == a[i]){
                i++;
                continue;
            }
            res.add(a[i++]);
        }
        while (j<a.length){
            if(res.size()>0 && res.getLast() == b[j]){
                j++;
                continue;
            }
            res.add(a[j++]);
        }

        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public void merge2(int A[], int m, int B[], int n) {
        for (int i = 0; i < n; i++) {
            A[m + i] = B[i];
        }
        Arrays.sort(A);
    }

    /*
     * 最优解：从后往前处理,不需要开辟额外空间
     * Runtime: 0 ms.Your runtime beats 45.38 % of java submissions.
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, index = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[index--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (j >= 0) {
            nums1[index--] = nums2[j--];
        }
    }


    public static void main(String[] args) {
        int[] A = new int[4];
        for (int i = 0; i < 4; i++) {
            A[i] = i + 1;
        }
        int[] B = new int[]{1, 3, 3, 4, 6};
        // new Solution().merge(A, 4, B, 5);
        System.out.println(Arrays.toString(A));
        int[] res = mergeAndSortTwoArray(A, B);
        System.out.println(Arrays.toString(res));

    }
}
