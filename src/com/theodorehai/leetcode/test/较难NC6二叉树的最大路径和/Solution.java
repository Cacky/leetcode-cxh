package com.theodorehai.leetcode.test.较难NC6二叉树的最大路径和;

/**
 * com.theodorehai.leetcode.test.较难NC6二叉树的最大路径和.
 *题目描述
 * 给定一个二叉树，请计算节点值之和最大的路径的节点值之和是多少。
 * 这个路径的开始节点和结束节点可以是二叉树中的任意节点
 * 例如：
 * 给出以下的二叉树，
 *   1
 * 2   3
 * 返回的结果为6
 * 示例1
 * 输入 {-2,1}
 * 返回值  1
 * 示例2
 * 输入 {-2,#,-3}
 * 返回值  -2
 * @author chengxiaohai.
 * @date 2021/5/8.
 */
import java.util.*;


class TreeNode {
   int val = 0;
   TreeNode left = null;
   TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}


public class Solution {
    public int res = Integer.MIN_VALUE;
    /**
     *想法的基础就是dfs，深度遍历，根据题意我们要想清楚两件事情
     * 1.节点可能是非负的，因此开始dfs的节点不一定是根节点，结束的节点也不一定是叶子结点
     * 2.题目没有说一定要按照自顶向下的顺序遍历，
     * 也就是说还有一种情况是这样 root.left->root->root.right。
     * 这就需要我们找到左子树最大值，右子树最大值加上根。这样一个值。
     * 最后就是比较这两种情况哪个更大，也就是代码中标记的1这一行。
     * *2这一行如果大家没有深入理解的话可能也会有一些疑惑，
     * 为什么返回的是Math.max(leftMax,rightMax) + root.val，
     * 而不是root.val+leftMax+rightMax。
     * 这个其实也需要大家好好的思考一下，我们这个函数getMax()的作用，
     * 只是找到root节点下的最大节点和！这点一定要搞清楚。
     * 不要被这一行代码1迷惑住，这只是我们更新res的代码。
     * 2是dfs找最大值的方式，1适用于这道题。
     * 如果大家还有疑惑，可以尝试自底向上的想法递推一下。应该问题就会想的更明白了。
     * @param root TreeNode类
     * @return int整型
     */
    public int maxPathSum (TreeNode root) {
        // write code here
        getMax(root);
        return res;
    }
    public int getMax(TreeNode root){
        if(root == null) return 0;
        int leftMax = Math.max(0,getMax(root.left));
        int rightMax = Math.max(0,getMax(root.right));
        //*1.--下面一行划重点--//
        // res = Math.max(res,Math.max(root.val+Math.max(leftMax,rightMax),root.val+leftMax+rightMax));
        //*2--这一行也很重要--//
        return Math.max(leftMax,rightMax) + root.val;
    }


    public int getMax2(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = getMax2(root.left);
        int right = getMax2(root.right);
        return Math.max(left,right)+root.val;
    }
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(10);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(20);
        TreeNode node5 = new TreeNode(30);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        int max = new Solution().getMax(node1);
        System.out.println(new Solution().getMax2(node1));
        System.out.println(max);
    }
}
