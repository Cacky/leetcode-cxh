package 链表操作.q206_反转链表.f2;

/**
 * 链表操作.q206_反转链表.f2.
 *
 * @author chengxiaohai.
 * @date 2020/11/9.
 */
public class TestMain {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        Solution solution = new Solution();
        ListNode result = solution.reverseList(l1);
        printList(result);
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
}
