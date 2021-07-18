package com.theodorehai.leetcode.test.简单NC25删除有序链表中重复的元素;

/**
 * com.theodorehai.leetcode.test.简单NC25删除有序链表中重复的元素.
 * 题目描述
 * 删除给出链表中的重复元素（链表中元素从小到大有序），使链表中的所有元素都只出现一次
 * 例如：
 * 给出的链表为1→1→2,返回1→2.
 * 给出的链表为1→1→2→3→3,返回1→2→3.
 *
 * 示例1
 * 输入 {1,1,2}
 * 返回值 {1,2}
 * @author chengxiaohai.
 * @date 2021/5/9.
 */
import java.util.*;


class ListNode {
   int val;
   ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}


public class Solution {
    /**
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates (ListNode head) {
        // write code here

        ListNode p = head;
        if(p == null){
            return head;
        }
        ListNode temp = p.next;
        while (temp != null){
            while (temp!=null && temp.val == p.val){
                temp = temp.next;
            }
            p.next = temp;
            p=p.next;
            if(temp != null){
                temp = temp.next;
            }

        }
        return head;
    }

    public ListNode deleteDuplicates2 (ListNode head) {
        // write code here
        ListNode cur = head;
        while(cur!=null){
            while(cur.next!=null&&cur.val==cur.next.val){
                cur.next=cur.next.next;
            }
            cur=cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode listNode = solution.deleteDuplicates(node1);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
