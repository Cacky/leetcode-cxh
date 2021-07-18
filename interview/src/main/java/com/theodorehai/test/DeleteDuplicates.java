package com.theodorehai.test;

/**
 * com.theodorehai.interview01.
 *
 * @author chengxiaohai.
 * @date 2021/6/15.
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while (p != null) {
            while (p.next != null && p.val == p.next.val) {
                p.next = p.next.next;
            }
            p = p.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        DeleteDuplicates res = new DeleteDuplicates();
        ListNode listNode = res.deleteDuplicates(node1);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

