package com.theodorehai.leetcode.test.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * test.com.theodorehai.leetcode.tree.
 *
 * @author chengxiaohai.
 * @date 2021/3/18.
 */
public class TreeOrder {

    public static List<List<Integer>> levelOrder(TreeNode node) {
        List<List<Integer>> levels = new ArrayList<>();
        if (node == null) {
            return levels;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        Integer level = 0;
        while (!queue.isEmpty()) {
            levels.add(new ArrayList<>());
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode temp = queue.remove();
                levels.get(level).add(temp.getVal());
                if (temp.getLeft() != null) {
                    queue.add(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    queue.add(temp.getRight());
                }
            }
            level++;
        }
        return levels;
    }


    public static List<Integer> preOrder(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.empty()) {
            while (node != null) {
                result.add(node.getVal());
                stack.push(node);
                node = node.getLeft();
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.getRight();
            }
        }
        return result;
    }

    public static List<Integer> onOrder(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                result.add(node.getVal());
                node = node.getRight();
            }
        }
        return result;
    }

    public static List<Integer> postOrder(TreeNode node) {
        LinkedList<Integer> rs = new LinkedList<>();
        if (node == null) {
            return rs;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            node = stack.pop();
            rs.addFirst(node.getVal());
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
        }
        return rs;
    }

    public static Integer treeHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        Integer leftHeight = treeHeight(node.getLeft());
        Integer rightHeight = treeHeight(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static Integer treeSize(TreeNode node) {
        if (node == null) {
            return 0;
        }
        Integer leftSize = treeSize(node.getLeft());
        Integer rightSize = treeSize(node.getRight());
        return leftSize + rightSize + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        root.setLeft(node2);
        root.setRight(node3);
        node2.setRight(node4);
        node3.setRight(node5);
        node5.setLeft(node6);

        System.out.println(levelOrder(root));
        System.out.println(preOrder(root));
        System.out.println(onOrder(root));
        System.out.println(postOrder(root));
        System.out.println(treeHeight(root));
        System.out.println(treeSize(root));
    }

}
