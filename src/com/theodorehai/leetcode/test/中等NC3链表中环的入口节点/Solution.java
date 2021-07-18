package com.theodorehai.leetcode.test.中等NC3链表中环的入口节点;

/**
 * com.theodorehai.leetcode.test.中等NC3链表中环的入口节点.
 *
 * 题目描述 对于一个给定的链表，返回环的入口节点，如果没有环，返回null
 *
 * 拓展： 你能给出不利用额外空间的解法么？
 * <p>
 * 说明：本题目包含复杂数据结构ListNode，点此查看相关信息
 *
 * @author chengxiaohai.
 * @date 2021/4/15.
 */

import java.util.List;

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

/**
 * slow： 走过 x 个节点
 * fast：走过2x 个节点
 * 第一次相遇时，2x-x = b+c；    (1)
 * slow走过的距离为 x = a + b + n*(b + c);   (2)
 * 由(1)(2)可得 b+c = n*(b+c) + a + b；
 * n>0时，a+b = (1-n)*(b+c) <= 0,不成立。故n = 0,得出：a = c。
 */
public class Solution {

    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode meet = null;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                meet = fast;
                break;
            }
        }
        if(meet == null) return null;
        slow = head;
        while (slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode detectCycle2(ListNode root){
        if(root == null) return root;
        ListNode slow = root;
        ListNode fast = root;
        ListNode meet = null;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                meet = slow;
                break;
            }
        }
        if(meet == null){
            return null;
        }
        slow = root;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);
        root.next.next.next.next.next.next = new ListNode(7);
        root.next.next.next.next.next.next.next = root.next.next;
        System.out.println(new Solution().detectCycle(root).val);
        System.out.println(new Solution().detectCycle2(root).val);
    }
}
