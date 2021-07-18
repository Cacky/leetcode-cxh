package com.theodorehai.leetcode.test.中等NC119最小的K个数;

/**
 * com.theodorehai.leetcode.test.最小的K个数.
 *
 * @author chengxiaohai.
 * @date 2021/4/13.
 */
import java.util.ArrayList;

public class Solution3 {
    //构建堆
    void bulid_heap(int tree[],int n){
        int last_node=n-1;
        int parent=(last_node-1)/2;
        for(int i=parent;i>=0;i--)
            heapify(tree,n,i);
    }
    //heapify
    void heapify(int tree[],int n,int i){
        if(i>=n)return;
        int max=i;
        int left_node=i*2+1;
        int right_node=i*2+2;
        if(left_node<n&&tree[max]<tree[left_node]){
            max=left_node;
        }
        if(right_node<n&&tree[max]<tree[right_node]){
            max=right_node;
        }
        if(max!=i){
            swap(tree,i,max);
            heapify(tree,n,max);
        }
    }
    //堆排序
    void heap_sort(int tree[]){
        bulid_heap(tree,tree.length);
        for(int i=tree.length-1;i>=0;i--){
            swap(tree,0,i);
            heapify(tree,i,0);
        }
    }
    void swap(int tree[],int i,int j){
        int t=tree[i];
        tree[i]=tree[j];
        tree[j]=t;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(k>input.length||k==0)return list;
        heap_sort(input);
        for(int i=0;i<k;i++)
            list.add(input[i]);

        return list;
    }
}
