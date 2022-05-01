package com.theodorehai.leetcode.test.中等NC5二叉树根节点到叶子节点的所有路径和;

/**
 * com.theodorehai.leetcode.test.中等NC5二叉树根节点到叶子节点的所有路径和.
 *题目描述
 * 给定一个仅包含数字 0−9 的二叉树，每一条从根节点到叶子节点的路径都可以用一个数字表示。
 * 例如根节点到叶子节点的一条路径是1→2→3,那么这条路径就用123 来代替。
 * 找出根节点到叶子节点的所有路径表示的数字之和
 * 例如：
 *
 * 这颗二叉树一共有两条路径，
 * 根节点到叶子节点的路径 1→2 用数字 12 代替
 * 根节点到叶子节点的路径 1→3 用数字 13 代替
 * 所以答案为 12+13=25
 * 示例1
 * 输入{1,0}
 * 返回值 10
 * 示例2
 * 输入{1,#,9}
 * 返回值 19
 * @author chengxiaohai.
 * @date 2021/5/7.
 */
import java.util.*;


class TreeNode {
   int val = 0;
   TreeNode left = null;
   TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode() {
    }
}


public class Solution {
    /**
     * 解题思路：从根结点开始，当每访问到一个结点，我们把该结点添加到路径上，并"累加"
     * 该结点的值，这里"累加"的含义指的是按照题目的要求组成相应的数字即"左移"后相加。
     * 如果该结点为叶结点，那么一条路径搜索完成，将当前所得结果累加。如果当前不是叶子
     * 结点，则继续访问它 的子结点。当前结点访问结束后，递归函数将自动回到它的父结点。
     * 因此我们在函数退出之前要在路径上"删除"当前结点，做法就是将当前路径值/10，以确
     * 保返回父结点时路径刚好是从根结点到父结点的路径。我们不难看出保存路径的数据结构
     * 实际上是一个栈，因为路径要与递归调用状态一致，而递归调用的本质就是一个压栈和出
     * 栈的过程。
     * @param root TreeNode类
     * @return int整型
     */
    public int sumNumbers (TreeNode root) {
        // write code here
        if(root == null){
            return 0;
        }
        int sum = 0;
        return sumNumberAll(root,0);

    }

    public int sumNumberAll(TreeNode root, int sum) {
        if(root==null){
            return 0;
        }
        sum=sum*10+root.val;
        if(root.left==null&&root.right==null){
            return sum;
        }
        return sumNumberAll(root.left,sum)+sumNumberAll(root.right,sum);
    }

    public static int allPathSum(TreeNode root,int sum){
        if(root == null) return 0;
        sum = sum *10 + root.val;
        if(root.left ==null && root.right == null){
            return sum;
        }
        int leftSum = allPathSum(root.left,sum);
        int rightSum = allPathSum(root.right, sum);
        return leftSum + rightSum;
    }

    public static int sumNumber(TreeNode root){
        if(root == null) return 0;
        return allPathSum(root,0);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        System.out.println(sumNumber(node1));
    }
}
