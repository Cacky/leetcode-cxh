package com.theodorehai.test;

/**
 * com.theodorehai.interview02.
 *
 * @author chengxiaohai.
 * @date 2021/6/28.
 */
public class ListDeleteN {

    public static ListNode deleteN(ListNode node,int n){
        if(node == null){
            return node;
        }
        ListNode fast = new ListNode(Integer.MIN_VALUE);
        ListNode pre = fast;
        fast.next = node;
        ListNode slow = fast;
        int i = 0;
        for (; i < n && fast.next != null ; i++) {
            fast = fast.next;
        }
        if(i != n){
            return node;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next =slow.next.next;
        return pre.next;
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
        ListNode res = deleteN(node1, 1);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }

    }


}

