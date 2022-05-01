package com.theodorehai.leetcode.test.困难NC118数组中的逆序对;

/**
 * com.theodorehai.leetcode.test.困难NC118数组中的逆序对.
 *题目描述
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 对于50%的数据,size≤10^4
 * 对于75%的数据,size≤10^5
 * 对于100%的数据,size≤2*10^5
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 * 示例1
 * 输入 [1,2,3,4,5,6,7,0]
 * 返回值 7
 * @author chengxiaohai.
 * @date 2021/5/8.
 */
public class Solution {
    int[] nums,tmp;
    public int InversePairs(int [] array) {
        //归并排序和逆序对息息相关
        this.nums = array;
        tmp = new int[nums.length];
        return mergeSort(0,nums.length-1) ;
    }

    private int  mergeSort(int l,int r){
        //终止条件
        if(l>=r) return 0;
        //递归划分
        int m=l+(r-l)/2;
        long res = mergeSort(l,m)+mergeSort(m+1,r);
        //合并阶段
        int i = l,j=m+1;
        for(int k = l;k<=r;k++){
            tmp[k] = nums[k];
        }
        for(int k =l;k<=r;k++){
            if(i ==m+1){
                nums[k] = tmp[j++];
            }else if(j==r+1||tmp[i]<=tmp[j]){
                nums[k] = tmp[i++];

            }else{
                nums[k] = tmp[j++];
                res+=m-i+1;
            }
        }
        return (int)(res%1000000007) ;

    }
}
