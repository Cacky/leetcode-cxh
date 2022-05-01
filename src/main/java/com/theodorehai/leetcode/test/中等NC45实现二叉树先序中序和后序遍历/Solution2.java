package com.theodorehai.leetcode.test.中等NC45实现二叉树先序中序和后序遍历;

import java.util.ArrayList;
import java.util.List;

/**
 * com.theodorehai.leetcode.test.中等NC45实现二叉树先序中序和后序遍历.
 *
 * @author chengxiaohai.
 * @date 2021/4/29.
 */


public class Solution2 {

    /**
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders(TreeNode root) {
        // write code here
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        preOrder_20210612(root, pre);
        inOrder_20210612(root, in);
        postOrder_20210612(root, post);
        int[][] res = new int[3][pre.size()];
        for (int j = 0; j < pre.size(); j++) {
            res[0][j] = pre.get(j);
        }
        for (int j = 0; j < in.size(); j++) {
            res[1][j] = in.get(j);
        }
        for (int j = 0; j < post.size(); j++) {
            res[2][j] = post.get(j);
        }

        return res;
    }

    // 递归前序遍历
    public void preOrder(TreeNode root, List<Integer> pre) {
        if (root == null) {
            return;
        }

        pre.add(root.val);
        preOrder(root.left, pre);
        preOrder(root.right, pre);
    }

    // 递归中序遍历
    public void inOrder(TreeNode root, List<Integer> in) {
        if (root == null) {
            return;
        }

        inOrder(root.left, in);
        in.add(root.val);
        inOrder(root.right, in);
    }

    // 递归后序遍历
    public void postOrder(TreeNode root, List<Integer> post) {
        if (root == null) {
            return;
        }

        postOrder(root.left, post);
        postOrder(root.right, post);
        post.add(root.val);
    }

    // 递归前序遍历
    public void preOrder_20210612(TreeNode root, List<Integer> pre) {
        if (root == null) {
            return;
        }
        pre.add(root.val);
        preOrder_20210612(root.left, pre);
        preOrder_20210612(root.right, pre);
    }

    // 递归中序遍历
    public void inOrder_20210612(TreeNode root, List<Integer> in) {
        if(root== null){
            return;
        }
        inOrder_20210612(root.left,in);
        in.add(root.val);
        inOrder_20210612(root.right,in);
    }

    // 递归后序遍历
    public void postOrder_20210612(TreeNode root, List<Integer> post){
        if(root == null){
             return;
        }
        postOrder_20210612(root.left,post);
        postOrder_20210612(root.right,post);
        post.add(root.val);
    }


}
