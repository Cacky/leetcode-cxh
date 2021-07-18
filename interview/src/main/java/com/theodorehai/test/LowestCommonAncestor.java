package com.theodorehai.test;

/**
 * com.theodorehai.interview02.
 *
 * @author chengxiaohai.
 * @date 2021/6/18.
 */
public class LowestCommonAncestor {

    public static TreeNode getTreeNode(TreeNode root,TreeNode t1,TreeNode t2){
        if(root == null){
            return null;
        }

        if(root.val == t1.val || root.val == t2.val){
            return root;
        }

        if(root.left == null && root.right == null){
            return null;
        }

        TreeNode leftTreeNode = getTreeNode(root.left, t1, t2);
        TreeNode rightTreeNode = getTreeNode(root.right, t1, t2);

        if(leftTreeNode == null){
            return rightTreeNode;
        }
        if(rightTreeNode == null){
            return leftTreeNode;
        }

        return root;
    }

    public static void main(String[] args) {
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
        // node2.left = node4;
        // node2.right = node5;
        // node3.left = node6;
        // node3.right = node7;
        // node5.left=node8;
        // node5.right = node9;

        TreeNode treeNode = getTreeNode(node1, node2, node3);
        System.out.println(treeNode.val);
    }

}

// class TreeNode{
//     int val;
//     TreeNode left;
//     TreeNode right;
//
//     public TreeNode(int val) {
//         this.val = val;
//     }
// }

