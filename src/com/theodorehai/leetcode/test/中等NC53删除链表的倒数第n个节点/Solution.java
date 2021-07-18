package com.theodorehai.leetcode.test.中等NC53删除链表的倒数第n个节点;

import java.util.List;

/**
 * com.theodorehai.leetcode.test.中等NC53删除链表的倒数第n个节点.
 * 题目描述 给定一个链表，删除链表的倒数第 n 个节点并返回链表的头指针 例如， 给出的链表为: 1→2→3→4→5, n= 2n=2.
 * 删除了链表的倒数第 n 个节点之后,链表变为1→2→3→5.
 * <p>
 * 备注： 题目保证 n 一定是有效的 请给出请给出时间复杂度为O(n) 的算法 示例1 输入 复制 {1,2},2 返回值 复制 {2}
 *
 * @author chengxiaohai.
 * @date 2021/4/20.
 */

class ListNode {

    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode() {
    }
}


public class Solution {

    /**
     * @param head ListNode类
     * @param n int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write code here
        if(head == null || n <=0 ){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        int i = 0;
        for (; i < n &&fast.next != null ; i++) {
            fast = fast.next;
        }
        if(i != n){
            return head;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    /**
     * @param head ListNode类
     * @param n int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head.next == null && n == 1) {
            return null;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode right = newHead;
        ListNode left = newHead;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }
        if (left.next != null) {
            left.next = left.next.next;
        }
        return newHead.next;

    }

    private void outputLinkedList(ListNode head) {
        ListNode tmp = head;
        while (null != tmp) {
            System.out.print(tmp.val);
            if (null != tmp.next) {
                System.out.print(" -> ");
            }
            tmp = tmp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        Solution solution = new Solution();
        solution.outputLinkedList(node1);
        ListNode listNode = solution.removeNthFromEnd(node1, 2);
        solution.outputLinkedList(listNode);
    }
}
