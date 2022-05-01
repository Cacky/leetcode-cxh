package com.theodorehai.leetcode.test.中等NC50链表中的节点每k个一组翻转;

import java.util.List;

/**
 * com.theodorehai.leetcode.test.NC50链表中的节点每k个一组翻转.
 * 题目描述 将给出的链表中的节点每 k 个一组翻转，返回翻转后的链表 如果链表中的节点数不是k 的倍数，将最后剩下的节点保持原样
 * 你不能更改节点中的值，只能更改节点本身。
 * 要求空间复杂度  O(1)
 * 例如： 给定的链表是1→2→3→4→5 对于 k = 2 ,
 * 你应该返回 2→1→4→3→5 对于 k = 3, 你应该返回 3→2→1→4→5
 * <p>
 * 示例1 输入 {1,2,3,4,5},2 返回值 {2,1,4,3,5}
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

    public ListNode() {
    }
}


public class Solution {

    public static ListNode reverseKGroup3(ListNode head, int k) {
        if(head == null || k<=1){
            return head;
        }
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode startHead = preHead;
        while (true){
            ListNode temp = startHead;
            for (int i = 0; i < k && temp != null; i++) {
                temp = temp.next;
            }
            if(temp != null){
                ListNode originalHead = startHead.next;
                ListNode nextHead = temp.next;
                temp.next =null;
                ListNode listNode = reverseKlistNode(originalHead);
                startHead.next = listNode;
                originalHead.next = nextHead;
                startHead = originalHead;
            }else{
                break;
            }
        }
        // if(head == null || k<=1){
        //     return head;
        // }
        // ListNode preHead = new ListNode();
        // preHead.next = head;
        // ListNode startHead = preHead;
        // while (true){
        //     ListNode temp = startHead;
        //     for (int i = 0; i < k && temp != null; i++) {
        //         temp = temp.next;
        //     }
        //     if(temp != null){
        //         ListNode originalHead = startHead.next;
        //         ListNode nextHead = temp.next;
        //         temp.next = null;
        //         ListNode listNode = reverseKlistNode(originalHead);
        //         startHead.next = listNode;
        //         originalHead.next = nextHead;
        //         startHead = originalHead;
        //     }else{
        //         break;
        //     }
        // }
        return preHead.next;
    }

    private static ListNode reverseKlistNode(ListNode originalHead) {
        ListNode pre = null;
        while (originalHead != null){
            ListNode next = originalHead.next;
            originalHead.next = pre;
            pre = originalHead;
            originalHead = next;
        }
        return pre;
    }

    /**
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // write code here
        if (head == null || head.next == null || k < 2) {
            return head;
        }

        ListNode hh = new ListNode();
        hh.next = head; //头节点的前一个结点
        int len = 0;

        //计算链表的长度
        while (head != null) {
            len++;
            head = head.next;
        }

        //将链表进行翻转
        //pre:当前组头节点的前一个结点；first当前组翻转前的头节点；
        ListNode pre = hh, first = hh.next, temp;
        for (int i = 0; i < len / k; i++) {//对每一组进行翻转
            for (int j = 1; j < k; j++) {//对当前组进行翻转（不考虑翻转前的头节点）
                //例：对于 4567 1234 8546 k=4
                //1)交换第二组 1234 -> 2 134 -> 32 14 -> 432 1;
                //其中pre = 7 即当前组的前一个结点；first = 1
                //第二组交换介绍后，此时所有元素序列为：4567 4321 8546
                //2)那么交换第三组时，pre = first = 1;  first = pre.next = 1.next=8
                temp = first.next;//获取翻转节点；
                first.next = temp.next;//修改翻转节点的前一个结点的指针,指向翻转节点的下一个节点
                temp.next = pre.next;//将翻转结点插入到第一个节点位置
                pre.next = temp;
            }
            pre = first;//修改下一组的pre节点
            first = pre.next;//修改下一组翻转前的第一个节点
        }
        return hh.next;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }
        ListNode result = new ListNode();
        result.next = head;
        ListNode startNode = result;
        while (true) {
            ListNode tmp = startNode;
            // 跳过k个节点，并断链，截取长度为K的子链表
            for (int i = 0; i < k && null != tmp; ++i) {
                tmp = tmp.next;
            }

            if (null != tmp) {
                ListNode originalHead = startNode.next;
                ListNode nextNode = tmp.next;
                //断链
                tmp.next = null;
                ListNode reverseNode = reverseList(originalHead);
                startNode.next = reverseNode;
                originalHead.next = nextNode;
                startNode = originalHead;
            } else {
                // ListNode originalHead = startNode.next;
                // ListNode reverseNode = reverseList(originalHead);
                // startNode.next = reverseNode;
                break;
            }
        }
        return result.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode tmp = null;
        while (null != head) {
            tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
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
        Solution solution = new Solution();
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
        System.out.println("原始：");
        solution.outputLinkedList(node1);
        // ListNode listNode1 = solution.reverseKGroup(node1, 3);
        // ListNode listNode2 = solution.reverseKGroup2(node1, 4);
        ListNode listNode2 = reverseKGroup3(node1,4);
        // System.out.println("reverseKGroup反转后：");
        // solution.outputLinkedList(listNode1);
        System.out.println("reverseKGroup2反转后：");
        solution.outputLinkedList(listNode2);

    }
}
