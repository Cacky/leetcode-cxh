package com.theodorehai.test;

import java.nio.file.StandardWatchEventKinds;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * com.theodorehai.test.
 *
 * @author chengxiaohai.
 * @date 2021/6/15.
 */
public class Tree {

    //二叉树遍历(层次遍历)
    public static void levelOrderTree(TreeNode root, List<Integer> level) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        System.out.println();
    }


    //二叉树遍历(非递归先序遍历)
    public static void dlr(TreeNode root) {
        System.out.println("-----dlr------");
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null) {
            while (root != null) {
                System.out.print(root.val+",");
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        System.out.println();
    }

    //二叉树遍历(非递归中序遍历)
    public static void ldr(TreeNode root) {
        System.out.println("-----ldr------");
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.print(root.val +",");
            root = root.right;
        }
        System.out.println();
    }


    //二叉树遍历(非递归后序遍历)
    public static void lrd(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println("-----lrd------");
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        LinkedList<Integer> res = new LinkedList<>();
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            res.addFirst(temp.val);
            if(temp.left != null){
                stack.push(temp.left);
            }
            if(temp.right != null){
                stack.push(temp.right);
            }
        }
        System.out.println(res);
    }
    //二叉树遍历(递归先序遍历)
    public static void preOrderTree(TreeNode root, List<Integer> pre) {
        if (root == null) {
            return;
        }
        pre.add(root.val);
        preOrderTree(root.left, pre);
        preOrderTree(root.right, pre);
    }

    //二叉树遍历(递归中序遍历)
    public static void inOrderTree(TreeNode root, List<Integer> in) {
        if (root == null) {
            return;
        }
        inOrderTree(root.left, in);
        in.add(root.val);
        inOrderTree(root.right, in);
    }

    //二叉树遍历(递归后序遍历)
    public static void postOrderTree(TreeNode root, List<Integer> post) {
        if (root == null) {
            return;
        }
        postOrderTree(root.left, post);
        postOrderTree(root.right, post);
        post.add(root.val);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    //判断是否有路径.
    public static boolean hasPath(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && target == root.val) {
            return true;
        }
        boolean leftPath = hasPath(root.left, target - root.val);
        boolean rightPath = hasPath(root.right, target - root.val);
        return leftPath || rightPath;
    }


    public static Integer minSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        Integer leftSum = minSum(root.left);
        Integer rightSum = minSum(root.right);
        return Math.min(leftSum, rightSum) + root.val;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node4.left = node5;
        System.out.println(maxDepth(node1));
        System.out.println(minSum(node1));
        System.out.println(hasPath(node1, 4));
        ArrayList<Integer> pre = new ArrayList<Integer>();
        ArrayList<Integer> in = new ArrayList<Integer>();
        ArrayList<Integer> post = new ArrayList<Integer>();
        ArrayList<Integer> level = new ArrayList<Integer>();
        preOrderTree(node1, pre);
        inOrderTree(node1, in);
        levelOrderTree(node1, level);
        postOrderTree(node1, post);
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
        System.out.println(level);

        dlr(node1);
        ldr(node1);
        lrd(node1);


    }
}
