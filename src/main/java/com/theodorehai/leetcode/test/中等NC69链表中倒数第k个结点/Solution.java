package com.theodorehai.leetcode.test.中等NC69链表中倒数第k个结点;

import java.util.List;

/**
 * com.theodorehai.leetcode.test.NC69链表中倒数第k个结点. 题目描述 输入一个链表，输出该链表中倒数第k个结点。 如果该链表长度小于k，请返回空。 示例1 输入 {1,2,3,4,5},1 返回值
 * {5}
 *
 * @author chengxiaohai.
 * @date 2021/4/16.
 */


class ListNode {

    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}


public class Solution {

    public ListNode FindKthToTail3(ListNode pHead, int k) {
        if(pHead == null || k <=0){
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;
        int i = 0;
        for (; i < k && fast != null; i++) {
            fast= fast.next;
        }
        if(i != k){
            return null;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pHead ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail(ListNode pHead, int k) {
        // write code here 双指正
        if(pHead == null){
            return null;
        }
        ListNode first = pHead;
        ListNode last = pHead;
        int i = 0;
        for (; i < k && first != null ; i++) {
            first = first.next;
        }
        if(i < k){
            return null;
        }
        while (first != null){
            first = first.next;
            last = last.next;
        }
        return last;
    }

    public ListNode FindKthToTail2(ListNode pHead, int k) {
        int currentIndex = 0;
        ListNode first = pHead;
        ListNode second = pHead;

        if (pHead == null) {
            return null;
        }
        while (currentIndex < k && first != null) {
            first = first.next;
            currentIndex++;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        if (currentIndex < k) {
            return null;
        }
        return second;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        System.out.println(new Solution().FindKthToTail(node, 1).val);
        System.out.println(new Solution().FindKthToTail3(node, 1).val);
    }
}
