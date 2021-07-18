package com.theodorehai.test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * com.theodorehai.interview02.
 *
 * @author chengxiaohai.
 * @date 2021/6/23.
 */
public class LevelOrderTree {

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root){
        if(root == null){
            return null;
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                arrayList.add(temp.val);
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
            res.add(arrayList);
        }
        return res;
    }


    public static void main(String[] args) {
        //{1,2,3,4,#,#,5}
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;

        ArrayList<ArrayList<Integer>> level = levelOrder(node1);
        System.out.println(level);
    }
}


