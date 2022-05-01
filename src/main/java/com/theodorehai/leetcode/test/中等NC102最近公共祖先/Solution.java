package com.theodorehai.leetcode.test.中等NC102最近公共祖先;

/**
 * com.theodorehai.leetcode.test.中等NC102最近公共祖先.
 *
 * 题目描述 给定一棵二叉树以及这棵树上的两个节点 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。
 *
 * 示例1
 * 输入 [3,5,1,6,2,0,8,#,#,7,4],5,1
 * 返回值  3
 *
 *
 * @author chengxiaohai.
 * @date 2021/4/28.
 */

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
     * 关键还是找到最近公共节点的特征：
     * 1. 如果该节点不是O1也不是O2，那么O1与O2必然分别在该节点的左子树和右子树中
     * 2. 如果该节点就是O1或者O2，那么另一个节点在它的左子树或右子树中
     * 稍微可以优化的一点就是，遇到O1或者O2节点就不往下递归了，
     * 把O1或者O2节点一层层往上传。
     * @param root TreeNode类
     * @param o1 int整型
     * @param o2 int整型
     * @return int整型
     */
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        // write code here
        if (root == null) {
            return -1;
        }
        //遇到O1或者O2节点就不往下递归了，把O1或者O2节点一层层往上传
        if (o1 == root.val || o2 == root.val) {
            return root.val;
        }
        //如果该节点不是O1也不是O2，那么O1与O2必然分别在该节点的左子树和右子树中
        int left = lowestCommonAncestor(root.left, o1, o2);
        int right = lowestCommonAncestor(root.right, o1, o2);
        if (left == -1) {
            return right;
        }
        if (right == -1) {
            return left;
        }
        return root.val;
    }

    public static void main(String[] args) {
        //3,5,1,6,2,0,8,#,#,7,4
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left=node8;
        node5.right = node9;
        Solution solution = new Solution();
        System.out.println(solution.lowestCommonAncestor(node1, 7, 4));
    }
}
