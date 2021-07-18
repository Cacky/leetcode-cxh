package com.theodorehai.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * com.theodorehai.test.
 *
 * @author chengxiaohai.
 * @date 2021/6/25.
 */
public class Tree2 {

    public static void preOrder(TreeNode root,List<Integer> res){
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                res.add(root.val);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
    }

    public static void inOrder(TreeNode root,List<Integer> res){
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
    }

    public static void postOrder(TreeNode root,LinkedList<Integer> res){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            res.addFirst(temp.val);
            if(temp.left != null){
                stack.push(temp.left);
            }
            if(temp.right != null){
                stack.push(temp.right);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root){
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


    //判断是否是完全二叉树(层次遍历)
    // 非二叉树情况
    //1. 如果左子树为空，右子树不为空
    //2. 如果当前节点没有右子树，但后续节点有左子树或者又字数
    public static Boolean isAllTree(TreeNode root){
        if(root == null) return true;
        Boolean leaf = false;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.pop();
                if(leaf && (temp.left != null || temp.right != null)){
                    return false;
                }
                if(temp.left == null &&temp.right != null){
                    return false;
                }
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }else {
                    leaf = true;
                }
            }
        }
        return true;
    }


    //判断是否是二叉搜索树（中序遍历）
    public static Boolean isSearchTree(TreeNode root){
        Integer pre = Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre > root.val){
                return false;
            }
            pre = root.val;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        LinkedList<Integer> preRes = new LinkedList<>();
        LinkedList<Integer> inRes = new LinkedList<>();
        LinkedList<Integer> postRes = new LinkedList<>();
        preOrder(node1, preRes);
        inOrder(node1, inRes);
        postOrder(node1, postRes);
        ArrayList<ArrayList<Integer>> arrayLists = levelOrder(node1);
        System.out.println(arrayLists);
        System.out.println(preRes);
        System.out.println(inRes);
        System.out.println(postRes);
        System.out.println(isAllTree(node1));
        System.out.println(isSearchTree(node1));
    }

}
