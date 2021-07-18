package com.theodorehai.leetcode.test.中等NC140排序;

/**
 * com.theodorehai.leetcode.test.中等NC140排序.
 *
 * @author chengxiaohai.
 * @date 2021/4/29.
 */

public class Solution {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可 将给定数组排序
     * <p>
     * 题目描述 给定一个数组，请你编写一个函数，返回该数组排序后的形式。 示例1 输入 [5,2,3,1,4] 返回值 [1,2,3,4,5] 示例2 输入 [5,1,6,2,5] 返回值  [1,2,5,5,6] 备注:
     * 数组的长度不大于100000，数组中每个数的绝对值不超过10^910 9
     *
     * @param arr int整型一维数组 待排序的数组
     * @return int整型一维数组
     */
    public int[] MySort(int[] arr) {
        // write code here
        quickSort(arr, 0, arr.length-1);
        return arr;
    }


    private void quickSort(int a[], int low, int hight) {
        if (low > hight) {
            return;
        }
        int i = low, j = hight, temp = a[low];
        while (i < j) {
            while (i < j && a[j] >= temp) {
                j--;
            }
            if (i < j) {
                a[i++] = a[j];
            }
            while (i < j && a[i] < temp) {
                i++;
            }
            if (i < j) {
                a[j--] = a[i];
            }
        }
        a[i] = temp;
        quickSort(a, low, i - 1);
        quickSort(a, i + 1, hight);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = {5, 2, 3, 1, 4};
        int[] res = solution.MySort(data);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
