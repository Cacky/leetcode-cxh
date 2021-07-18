package 分治法.q23_合并K个排序链表;

/**
 * 做k-1次mergeTwoLists  o(N*k) 可用分治法优化至o(N*log(k))) N为所有list的总节点数
 */
class Solution {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //0. 申请指针头节点head
        ListNode head = new ListNode(Integer.MIN_VALUE);
        // 首先指定l1
        head.next = l1;
        ListNode pre = head;
        while (l2 != null) {
            ListNode t1 = pre.next;  // 移动指针
            ListNode t2 = l2.next;   // l2的下一个节点
            while (l2.val > t1.val) {
                if (t1.next == null) {
                    t1.next = l2;
                    return head.next;
                } else {
                    pre = pre.next;
                    t1 = t1.next;
                }
            }
            pre.next = l2;
            l2.next = t1;
            l2 = t2;
        }
        return head.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = mergeTwoLists(result, lists[i]);
        }
        return result;
    }

    /**
     * 打印链表
     */
    public static void printList(ListNode head) {
        if (null == head) {
            return;
        }
        while (head.next != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println(head.val);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(12);
        l1.next.next = new ListNode(13);
        l1.next.next.next = new ListNode(14);
        l1.next.next.next.next = new ListNode(15);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);
        l2.next.next.next = new ListNode(4);
        l2.next.next.next.next = new ListNode(5);
        ListNode result = mergeTwoLists(l2, l1);
        printList(result);
    }
}
