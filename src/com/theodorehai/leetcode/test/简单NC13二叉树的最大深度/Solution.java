package com.theodorehai.leetcode.test.简单NC13二叉树的最大深度;

/**
 * com.theodorehai.leetcode.test.简单NC13二叉树的最大深度. 题目描述 求给定二叉树的最大深度， 最大深度是指树的根结点到最远叶子结点的最长路径上结点的数量。
 * <p>
 * 示例1 输入 {1,2} 返回值 2 示例2 输入 {1,2,3,4,#,#,5} 返回值 3
 *
 * @author chengxiaohai.
 * @date 2021/4/28.
 */

import java.util.LinkedList;
import java.util.Queue;


class TreeNode {

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}


public class Solution {

    /**
     *
     * @param root TreeNode类
     * @return int整型
     */
    public int maxDepth(TreeNode root) {
        // write code here
        if (root == null) {
            return 0;
        }
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode rmNode = queue.poll();
                if(rmNode.left != null){
                    queue.add(rmNode.left);
                }
                if(rmNode.right !=null){
                    queue.add(rmNode.right);
                }
            }
            level++;
        }
        return level;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth2(root.left), maxDepth2(root.right));

    }

    public static void main(String[] args) {
        //1,2,3,4,#,#,5
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;
        Solution solution = new Solution();
        int depth = solution.maxDepth(node1);
        int depth2 = solution.maxDepth2(node1);
        System.out.println(depth);
        System.out.println(depth2);
    }
}
