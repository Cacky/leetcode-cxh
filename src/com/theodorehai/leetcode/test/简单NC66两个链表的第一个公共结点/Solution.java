package com.theodorehai.leetcode.test.简单NC66两个链表的第一个公共结点;

/**
 * com.theodorehai.leetcode.test.简单NC66两个链表的第一个公共结点. 题目描述 输入两个链表，找出它们的第一个公共结点。 （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，
 * 保证传入数据是正确的）
 *
 * @author chengxiaohai.
 * @date 2021/4/23.
 */

class ListNode {

    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2){
            p1 = p1 == null ?pHead2:p1.next;
            p2 = p2 == null ?pHead1:p2.next;
        }
        return p1;
    }

    /*
    假定 List1长度: a+n  List2 长度:b+n, 且 a<b
    那么 p1 会先到链表尾部, 这时p2 走到 a+n位置,将p1换成List2头部
    接着p2 再走b+n-(n+a) =b-a 步到链表尾部,这时p1也走到List2的b-a位置，还差a步就到可能的第一个公共节点。
    将p2 换成 List1头部，p2走a步也到可能的第一个公共节点。如果恰好p1==p2,那么p1就是第一个公共节点。
    或者p1和p2一起走n步到达列表尾部，二者没有公共节点，退出循环。 同理a>=b.
    时间复杂度O(n+a+b)
    */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node4.next = node5;
        node5.next = node2;
        System.out.println(new Solution().FindFirstCommonNode(node1, node4).val);
        System.out.println(new Solution().FindFirstCommonNode2(node1, node4).val);
    }
}
