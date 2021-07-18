package com.theodorehai.leetcode.test.中等NC15求二叉树的层序遍历;

/**
 * com.theodorehai.leetcode.test.中等NC15求二叉树的层序遍历. 题目描述 给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历） 例如：
 * 给定的二叉树是{3,9,20,#,#,15,7},
 * <p>
 * 该二叉树层序遍历的结果是 [ [3], [9,20], [15,7] ]
 * <p>
 * 示例1 输入 复制 {1,2} 返回值 复制 [[1],[2]] 示例2 输入 复制 {1,2,3,4,#,#,5} 返回值 复制 [[1],[2,3],[4,5]]
 *
 * @author chengxiaohai.
 * @date 2021/4/19.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

    public static ArrayList<ArrayList<Integer>> levelOrder3(TreeNode root){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> array = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.pop();
                array.add(temp.val);
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
            res.add(array);
        }

        return res;
    }
    /**
     *
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
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
                if (node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
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
        ArrayList<ArrayList<Integer>> result = new Solution().levelOrder3(root);
        System.out.println(result);
    }
}
