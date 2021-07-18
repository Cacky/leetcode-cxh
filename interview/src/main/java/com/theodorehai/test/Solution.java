package com.theodorehai.test;

/**
 * com.theodorehai.interview.test.test01.
 *
 * @author chengxiaohai.
 * @date 2021/6/15.
 */
public class Solution {

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if(head == null || n ==0){
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode fast = newHead;
        ListNode slow = newHead;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        if(slow.next != null){
            slow.next = slow.next.next;
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
        ListNode listNode = solution.removeNthFromEnd2(node1, 2);
        solution.outputLinkedList(listNode);
    }
}


class ListNode{
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}
