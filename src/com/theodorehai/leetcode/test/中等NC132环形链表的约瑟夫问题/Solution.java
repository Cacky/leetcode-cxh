package com.theodorehai.leetcode.test.中等NC132环形链表的约瑟夫问题;

import java.util.LinkedList;

/**
 * com.theodorehai.leetcode.test.中等NC132环形链表的约瑟夫问题. https://zhuanlan.zhihu.com/p/74436158 题目描述 编号为
 * 1到n的n个人围成一圈。从编号为1的人开始报数，报到m的人离开。 下一个人继续从1开始报数。 n−1轮结束以后，只剩下一个人，问最后留下的这个人编号是多少？ 示例1 输入5,2 返回值3 说明 开始5个人 1，2，3，4，5 ，
 * 从1开始报数，1->1，2->2编号为2的人离开1，3，4，5， 从3开始报数，3->1，4->2编号为4的人离开 1，3，5， 从5开始报数，5->1，1->2编号为1的人离开 3，5，
 * 从3开始报数，3->1，5->2编号为5的人离开 最后留下人的编号是3 备注: 1≤n,m≤10000
 *
 * @author chengxiaohai.
 * @date 2021/4/30.
 */

public class Solution {

    /**
     * @param n int整型
     * @param m int整型
     * @return int整型
     */
    //运行超时
    public int ysf(int n, int m) {
        // write code here
        //1.先将1->n放入队列
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        //开始报数
        int curr = 0;
        while (!queue.isEmpty() && queue.size() != 1) {
            int size = queue.size();
            int pos = (curr + m - 1) % size;
            queue.remove(pos);
            curr = pos % (size - 1);
        }

        return queue.pop();
    }

    //参考牛客官网

    /**
     * 利用递归公式 f(n,m)=(f(n-1,m)+m)%n f(n,m)指n个人，报第m个编号出列最终编号
     */
    public int ysf2(int n, int m) {
        // write code here
        int king = 0;
        for (int i = 2; i <= n; i++) {
            king = (king + m) % i;
        }
        return king + 1;
    }

    public int ysf3(int n, int m) {
        return n == 1 ? n : (ysf3(n - 1, m) + m - 1) % n + 1;
    }

   public static int ysf4(int n,int m){
        int res = 0;
       for (int i = 2; i <=n ; i++) {
           res = (res + m)%i;
       }
        return res +1;
   }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.ysf(5, 2));
        System.out.println(solution.ysf2(5, 2));
        System.out.println(solution.ysf3(5, 2));
        System.out.println(ysf4(5, 2));
    }
}
