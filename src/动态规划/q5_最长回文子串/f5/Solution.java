package 动态规划.q5_最长回文子串.f5;

/**
 * 动态规划.q5_最长回文子串.f5. 给定一个链表，请判断该链表是否为回文结构。 输入： [1,2,2,1] 输出： true
 *
 * @author chengxiaohai.
 * @date 2021/3/26.
 */


class ListNode {

    int val;
    ListNode next = null;
}


public class Solution {

    /**
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public boolean isPail(ListNode head) {
        // write code here
        if(head == null || head.next == null){
            return true;
        }
        boolean result = true;
        while (head.next != null) {

        }
        return result;
    }
}
