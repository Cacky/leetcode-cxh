package com.theodorehai.leetcode.test.简单NC4判断链表中是否有环;

/**
 * com.theodorehai.leetcode.test.中等NC4	判断链表中是否有环.
 *
 * 题目描述
 * 判断给定的链表中是否有环。如果有环则返回true，否则返回false。
 * 你能给出空间复杂度O(1)的解法么？
 *
 * @author chengxiaohai.
 * @date 2021/4/15.
 */
/**
 * Definition for singly-linked list.
 * */
class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {

    public boolean hasCycle(ListNode head) {
        /*
        链表有环思路：如果有环，设置一个快指针，设置一个慢指针，
        快指针一次走两步，慢指针一次走一步，快指针总能追上慢的
        */
        if(head == null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(5);
        root.next.next.next.next = root.next;
        System.out.println(new Solution().hasCycle(root));
    }
}
