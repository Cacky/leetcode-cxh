package com.theodorehai.leetcode.test.中等NC24删除有序链表中重复出现的元素;

/**
 * com.theodorehai.leetcode.test.中等NC24删除有序链表中重复出现的元素.
 *题目描述
 * 给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。
 * 例如：
 * 给出的链表为1→2→3→3→4→4→5, 返回1→2→5.
 * 给出的链表为1→1→1→2→3, 返回2→3.
 *
 *
 *
 * 示例1
 * 输入
 * 复制
 * {1,2,2}
 * 返回值
 * 复制
 * {1}
 * @author chengxiaohai.
 * @date 2021/4/30.
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
    public ListNode deleteDuplicates2 (ListNode head) {
        if(head == null){
            return null;
        }
        ListNode p = head;
        while (p!= null){
            while (p.next != null && p.val == p.next.val){
                p.next = p.next.next;
            }
            p = p.next;
        }
        return head;

    }
    /**
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        ListNode p =head;
        while(p != null && p.next != null){
            if(p.val == p.next.val){
                p.next = p.next.next;
            }else {
                p = p.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        ListNode res = solution.deleteDuplicates2(node1);
        while(res != null){
            System.out.print(res.val+" ");
            res = res.next;
        }
    }
}
