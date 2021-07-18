package 链表操作.q19_删除链表的倒数第N个节点;

/**
 * 利用两个指针 o(n)
 * 为只使用一次遍历。我们可以使用两个指针而不是一个指针。
 * 第一个指针从列表的开头向前移动 n+1 步，而第二个指针将从列表的开头出发。
 * 现在，这两个指针被 n个结点分开。我们通过同时移动两个指针向前来保持这个
 * 恒定的间隔，直到第一个指针到达最后一个结点。此时第二个指针将指向从最后
 * 一个结点数起的第 n个结点。我们重新链接第二个指针所引用的结点的 next 指针
 * 指向该结点的下下个结点。
 */
public class Solution {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    /**
     * 打印链表
     */
    public static void printList(ListNode head){
        if(null == head){
            return;
        }
        while(head.next!=null) {
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.println(head.val);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = removeNthFromEnd(head, 3);
        printList(head);
    }


}
