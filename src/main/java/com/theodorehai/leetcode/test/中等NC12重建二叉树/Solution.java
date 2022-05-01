package com.theodorehai.leetcode.test.中等NC12重建二叉树;

/**
 * com.theodorehai.leetcode.test.中等NC12重建二叉树. 题目描述 输入某二叉树的前序遍历和中序遍历的结果， 请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。 示例1 输入 [1,2,3,4,5,6,7],[3,2,4,1,6,5,7] 返回值
 * {1,2,5,3,4,6,7}
 *
 * @author chengxiaohai.
 * @date 2021/4/29.
 */

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import 链表操作.q2_两数相加.ListNode;

/**
 * Definition for binary tree
 **/
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    public static TreeNode reConstructBinaryTree2(int[] pre,int[] in){
        if(pre == null || pre.length ==0) return null;
        TreeNode root = new TreeNode(pre[0]);
        int i = 0;
        for (; i < in.length; i++) {
            if(pre[0] == in[i]) break;
        }
        root.left = reConstructBinaryTree2(Arrays.copyOfRange(pre,1,i+1), Arrays.copyOfRange(in,0,i));
        root.right = reConstructBinaryTree2(Arrays.copyOfRange(pre,i+1,pre.length), Arrays.copyOfRange(in,i+1,in.length));
        return root;
    }


    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        if (pre == null || pre.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        int pos = 0;
        for (; pos < pre.length; pos++) {
            if (pre[0] == in[pos]) {
                break;
            }
        }
        root.left = reConstructBinaryTree(
            Arrays.copyOfRange(pre, 1, pos + 1), Arrays.copyOfRange(in, 0, pos));
        root.right = reConstructBinaryTree(
            Arrays.copyOfRange(pre, pos + 1, pre.length), Arrays.copyOfRange(in, pos + 1, in.length)
        );
        return root;
    }

    public void levelPrint(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                System.out.print(temp.val + " ");
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        Solution solution = new Solution();
        TreeNode treeNode = solution.reConstructBinaryTree(pre, in);
        TreeNode treeNode2 = solution.reConstructBinaryTree2(pre, in);
        solution.levelPrint(treeNode);
        solution.levelPrint(treeNode2);
    }
}