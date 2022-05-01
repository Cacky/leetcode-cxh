package com.theodorehai.leetcode.test.简单NC62平衡二叉树;

/**
 * com.theodorehai.leetcode.test.简单NC62平衡二叉树. 题目描述 输入一棵二叉树，判断该二叉树是否是平衡二叉树。 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树 平衡二叉树（Balanced
 * Binary Tree）， 具有以下性质： 它是一棵空树或它的左右两个子树的高度差的绝对值不超过1， 并且左右两个子树都是一棵平衡二叉树。 示例1 输入 复制 {1,2,3,4,5,6,7} 返回值 复制 true
 *
 * @author chengxiaohai.
 * @date 2021/5/6.
 */
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 &&
            IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

    }

    public int maxDepth2(TreeNode root) {
        // write code here
        if (root == null) {
            return 0;
        }
        int left = maxDepth2(root.left);
        int right = maxDepth2(root.right);
        return Math.max(left, right) + 1;
    }

    public boolean IsBalanced_Solution2(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.abs(left - right) <= 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        System.out.println(solution.IsBalanced_Solution2(node1));
        System.out.println(solution.IsBalanced_Solution(node1));
    }
}
