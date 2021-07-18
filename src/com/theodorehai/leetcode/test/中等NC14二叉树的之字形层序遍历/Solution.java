package com.theodorehai.leetcode.test.中等NC14二叉树的之字形层序遍历;

/**
 * com.theodorehai.leetcode.test.中等NC14二叉树的之字形层序遍历. 题目描述 给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替） 例如：
 * 给定的二叉树是{3,9,20,#,#,15,7},
 * <p>
 * 该二叉树之字形层序遍历的结果是 [ [3], [20,9], [15,7] ] 示例1 输入 复制 {1,#,2} 返回值 复制 [[1],[2]]
 *
 * @author chengxiaohai.
 * @date 2021/4/19.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


class TreeNode {

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder2(TreeNode root) {
        if(root == null){
            return null;
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level  = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> tempArray = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.pop();
                tempArray.add(temp.val);
                if(level %2 == 0){
                    if(temp.right != null){
                        queue.add(temp.right);
                    }
                    if(temp.left != null){
                        queue.add(temp.left);
                    }
                }else{
                    if(temp.left != null){
                        queue.add(temp.left);
                    }
                    if(temp.right != null){
                        queue.add(temp.right);
                    }
                }
            }
            res.add(tempArray);
            level++;
        }
        return res;
    }
    /**
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            levels.add(new ArrayList<>());
            int levelLength = queue.size();
            for (int i = 0; i < levelLength; i++) {
                TreeNode node = queue.remove();
                levels.get(level).add(node.val);
                if (level % 2 == 0) {
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                } else {
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }

            }
            level++;
        }
        return levels;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        root.right = t1;
        TreeNode t2 = new TreeNode(3);
        root.left = t2;
        TreeNode t3 = new TreeNode(4);
        t2.left = t3;
        ArrayList<ArrayList<Integer>> result = new Solution().zigzagLevelOrder2(root);
        System.out.println(result);
    }
}
