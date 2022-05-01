package com.theodorehai.leetcode.test.sort.二叉树;

/**
 * com.theodorehai.leetcode.test.sort.
 *
 * @author chengxiaohai.
 * @date 2021/6/11.
 */
public class Solution {


    public boolean hasPath(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum == root.val) {
            return true;
        }
        boolean left = hasPath(root.left, sum - root.val);
        boolean right = hasPath(root.right, sum - root.val);
        return left || right;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left != 0 && right != 0) {
            return 1 + Math.min(left, right);
        }
        return 1 + left + right;
    }

    public Integer minSum2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Integer left = minSum2(root.left);
        Integer right = minSum2(root.right);
        return Math.min(left, right) + root.val;
    }


    public Integer minSum(TreeNode root) {
        return root == null ? 0 : Math.min(minSum(root.left), minSum(root.right)) + root.val;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        Solution solution = new Solution();
        Integer res = solution.minSum(node1);
        Integer res2 = solution.minSum2(node1);
        System.out.println(res);
        System.out.println(res2);

    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
