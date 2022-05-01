package com.theodorehai.leetcode.test.中等NC45实现二叉树先序中序和后序遍历;

/**
 * com.theodorehai.leetcode.test.中等NC45实现二叉树先序中序和后序遍历. 题目描述 分别按照二叉树先序，中序和后序打印所有的节点。 示例1 输入 {1,2,3} 返回值
 * [[1,2,3],[2,1,3],[2,3,1]] 备注: n≤10^6
 *
 * @author chengxiaohai.
 * @date 2021/4/29.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


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
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders(TreeNode root) {
        // write code here
        int[][] result = new int[3][];
        result[0] = preOrder(root);
        result[1] = inOrder(root);
        result[2] = postOrder(root);
        return result;
    }

    private int[] preOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> resList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                resList.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        int[] res = resList.stream().mapToInt(Integer::valueOf).toArray();
        return res;
    }

    private int[] inOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> resList = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            resList.add(root.val);
            root = root.right;
        }
        return resList.stream().mapToInt(Integer::valueOf).toArray();
    }

    private int[] postOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> resList = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tempNode = stack.pop();
            resList.addFirst(tempNode.val);
            if (tempNode.left != null) {
                stack.push(tempNode.left);
            }
            if (tempNode.right != null) {
                stack.push(tempNode.right);
            }
        }
        return resList.stream().mapToInt(Integer::valueOf).toArray();
    }

    /**
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders2 (TreeNode root) {
        // write code here
        int[][] res = new int[3][getSize(root)];
        order(res,root);
        return res;
    }
    int i1=0;
    int i2=0;
    int i3=0;
    public void order(int[][] res,TreeNode root){
        if(root==null) return;
        res[0][i1++]=root.val;
        order(res,root.left);
        res[1][i2++]=root.val;
        order(res,root.right);
        res[2][i3++]=root.val;
    }

    public int getSize(TreeNode root){
        if(root==null) return 0;
        return 1+getSize(root.left)+getSize(root.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        root.right = t1;
        TreeNode t2 = new TreeNode(3);
        root.left = t2;
        TreeNode t3 = new TreeNode(4);
        t2.left = t3;
        int[][] res = solution.threeOrders(root);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
}
