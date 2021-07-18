package com.theodorehai.leetcode.test.简单NC33合并有序链表;

/**
 * com.theodorehai.leetcode.test.简单NC33合并有序链表.
 * <p>
 * 题目描述 将两个有序的链表合并为一个新链表，
 * <p>
 * 要求新的链表是通过拼接两个链表的节点来生成的， 且合并后新链表依然有序。
 * <p>
 * 示例1 输入 复制 {1},{2} 返回值 {1,2} 示例2 输入 {2},{1} 返回值 {1,2}
 *
 * @author chengxiaohai.
 * @date 2021/4/19.
 */

class ListNode {

    int val;
    ListNode next = null;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
       ListNode pre = new ListNode(Integer.MIN_VALUE);
       ListNode p = pre;
       while (l1 != null && l2 != null){
           if(l1.val <= l2.val){
               if(p.val == l1.val){
                   l1 = l1.next;
                   continue;
               }
               p.next = l1;
               p = p.next;
               l1 = l1.next;
           }else{
               if(p.val == l2.val){
                   l2 = l2.next;
                   continue;
               }
               p.next = l2;
               p = p.next;
               l2 = l2.next;
           }
       }
       while (l1 != null){
           p.next = l1;
           while (l1.next != null && l1.val == l1.next.val){
               l1.next = l1.next.next;
           }
           l1 = l1.next;
       }

       while (l2 != null){
           p.next = l2;
           while (l2.next != null && l2.val == l2.next.val){
               l2.next = l2.next.next;
           }
           l2 = l2.next;
       }
       return pre.next;
    }
    /**
     * @param l1 ListNode类
     * @param l2 ListNode类
     * @return ListNode类
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write code here
       ListNode temp = new ListNode(Integer.MIN_VALUE);
       ListNode p = temp;
       while (l1 != null && l2 !=null){
           if(l1.val <= l2.val){
               // if(p.val ==l1.val){
               //     l1 = l1.next;
               //     continue;
               // }
               p.next = l1;
               p = p.next;
               l1 = l1.next;
           }else {
               // if(p.val ==l2.val){
               //     l2 = l2.next;
               //     continue;
               // }
               p.next = l2;
               p = p.next;
               l2 = l2.next;
           }
       }
       if(l1 != null){
           p.next = l1;
           // while(l1 != null){
           //     while(l1.next != null && l1.val == l1.next.val){
           //         l1.next = l1.next.next;
           //     }
           //     l1 = l1.next;
           // }
       }
        if(l2 != null){
           p.next = l2;
           // while(l2 != null){
           //     while(l2.next != null && l2.val == l2.next.val){
           //         l2.next = l2.next.next;
           //     }
           //     l2 = l2.next;
           // }
       }
       return temp.next;
    }

    public void printList(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);
        l1.next.next.next = new ListNode(5);
        l1.next.next.next.next = new ListNode(6);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);
        Solution solution = new Solution();
        ListNode listNode = solution.mergeTwoLists2(l1, l2);
        solution.printList(listNode);

    }
}
