package com.theodorehai.leetcode.test.中等NC2重排链表;

/**
 * com.theodorehai.leetcode.test.中等NC2重排链表.
 *题目描述
 * 将给定的单链表L： L_0→L_1→…→L_{n-1}→L_ n
 * 重新排序为：L_0→L_n →L_1→L_{n-1}→L_2→L_{n-2}→…
 * 要求使用原地算法，不能只改变节点内部的值，需要对实际的节点进行交换。
 * 例如：
 * 对于给定的单链表{10,20,30,40}，将其重新排序为{10,40,20,30}.
 * @author chengxiaohai.
 * @date 2021/5/7.
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
    public void reorderList2(ListNode head){
        if(head == null || head.next == null) return;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next!= null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow;
        slow = slow.next;
        temp.next = null;

        ListNode pre = null;
        while (slow != null){
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        merge2(head,pre);
    }

    private void merge2(ListNode head, ListNode slow) {
        ListNode p = head,q = slow;
        while (p!= null && q!= null){
            ListNode temp = p.next;
            p.next = q;
            p = temp;
            temp = q.next;
            q.next = p;
            q = temp;
        }
    }

    /**
     * 通过快慢指针找到中间节点，拆分链表为两部分，将后半部分链表翻转，然后合并两部分
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        //快慢指针找到中间节点
        ListNode slow = head, fast = head, temp = null;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //拆分链表为两部分
        temp = slow.next;
        slow.next = null;
        slow = temp;
        //后半边进行头插法，翻转链表
        ListNode node = slow.next;
        slow.next = null;
        while (node != null) {
            temp = node.next;
            node.next = slow;
            slow = node;
            node = temp;
        }
        //合并链表
        merge(head, slow);
    }
    public void merge(ListNode head1, ListNode head2) {
        ListNode p = head1, q = head2, temp;
        while (p != null && q != null) {
            temp = p.next;
            p.next = q;
            p = temp;
            temp = q.next;
            q.next = p;
            q = temp;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Solution solution = new Solution();
        solution.reorderList2(node1);
        while (node1 != null){
            System.out.print(node1.val+" -> ");
            node1 = node1.next;
        }
    }
}
