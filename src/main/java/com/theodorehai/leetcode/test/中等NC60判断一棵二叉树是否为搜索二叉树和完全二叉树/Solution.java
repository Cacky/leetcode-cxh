package com.theodorehai.leetcode.test.中等NC60判断一棵二叉树是否为搜索二叉树和完全二叉树;

/**
 * com.theodorehai.leetcode.test.中等NC60判断一棵二叉树是否为搜索二叉树和完全二叉树.
 *题目描述
 * 给定一棵二叉树，已经其中没有重复值的节点，请判断该二叉树是否为搜索二叉树和完全二叉树。
 * 示例1
 * 输入 {2,1,3}
 * 返回值 [true,true]
 * 备注: n≤500000
 * @author chengxiaohai.
 * @date 2021/4/27.
 */
import com.sun.scenario.effect.Brightpass;
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
    /**
     * 1. 利用深度优先搜索+中序遍历判断是不是BST。
     * 2. 利用层序遍历（队列实现）判断是否为完全二叉树。
     * 判断一棵二叉树是否为完全二叉树，依据以下标准会使判断过程变得简单且易实现。
     * @param root TreeNode类 the root
     * @return bool布尔型一维数组
     */
    public boolean[] judgeIt (TreeNode root) {
        // write code here
        return new boolean[]{isSBT(root),isCBT2(root)};
    }

    /**
     * 判断一棵二叉树是否为搜索二叉树，
     * 只要改写一个二叉树中序遍历，在遍历的过程中看节点值是否都是递增的即可。
     * @param root
     * @return
     */
    long pre = Long.MIN_VALUE;
    public boolean isSBT(TreeNode root) {
        if(root == null){
            return true;
        }
        boolean left = isSBT(root.left);
        if(left && root.val <=pre){
            return false;
        }
        pre = root.val;
        boolean right = isSBT(root.right);
        return right;
    }

    public boolean isSBT2(TreeNode root) {
        if (root == null) {
            return  true;
        }
        if(!isSBT(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isSBT(root.right);
    }

    /**
     *
     * 判断一棵二叉树是否为完全二叉树，依据以下标准会使判断过程变得简单且易实现。
     * 1．按层遍历二叉树，从每层的左边向右边依次遍历所有的节点。
     * 2．如果当前节点有右孩子节点，但没有左孩子节点，则直接返回 false。
     * 3．如果当前节点并不是左右孩子节点全有，那么之后的节点必须都为叶节点，否则返回false。
     * 4．遍历过程中如果不返回 false，则遍历结束后返回 true。
     * @param root
     * @return
     */
    public boolean isCBT(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leaf = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //如果当前节点并不是左右孩子节点全有，那么之后的节点必须都为叶节点
                if (leaf && (node.left != null || node.right != null)) {
                    return false;
                }
                //如果当前节点有右孩子节点，但没有左孩子节点，则直接返回 false
                if (node.left == null && node.right != null) {
                    return false;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                } else {
                    leaf = true;
                }
            }
        }
        return true;

    }

    public boolean isCBT2(TreeNode root) {
        if(root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leaf = false;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if(leaf && (temp.left != null || temp.right != null)){
                    return false;
                }
                if(temp.left == null && temp.right != null){
                    return false;
                }
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }else{
                    leaf = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        TreeNode node7=new TreeNode(7);
        node4.left=node2;
        node4.right=node6;
        node2.left=node1;
        node2.right=node3;
        node6.left=node5;
        node6.right=node7;
        boolean[] res = new Solution().judgeIt(node4);
        for (boolean re : res) {
            System.out.println(re);
        }
    }
}
