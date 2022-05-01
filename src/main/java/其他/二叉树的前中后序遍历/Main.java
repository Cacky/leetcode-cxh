package 其他.二叉树的前中后序遍历;

import java.util.ArrayList;
import java.util.Stack;

public class Main {

    /**
     * 前序遍历 - 递归
     */
    public void dlr_dg(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        dlr_dg(root.left);
        dlr_dg(root.right);
    }

    /**
     * 前序遍历 - 非递归
     */
    public void dlr(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null) {
            while (root != null) {
                System.out.println(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
    }

    public ArrayList<Integer> dlr_20210612(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        while(stack != null || root !=null){
            while(root != null){
                res.add(root.val);
                stack.push(root.left);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }

    /**
     * 中序遍历 - 递归
     */
    public void ldr_dg(TreeNode root) {
        if (root == null) {
            return;
        }
        ldr_dg(root.left);
        System.out.println(root.val);
        ldr_dg(root.right);
    }

    public ArrayList<Integer> ldr_20210612(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
    /**
     * 中序遍历 - 非递归
     */
    public void ldr(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.println(root.val);
            root = root.right;
        }
    }

    /**
     * 后序遍历 - 递归
     */
    public void lrd_dg(TreeNode root) {
        if (root == null) {
            return;
        }
        lrd_dg(root.left);
        lrd_dg(root.right);
        System.out.println(root.val);
    }

    /**
     * 后序遍历 - 非递归
     */
    public void lrd(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> rs = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode temp = stack.pop();
            rs.push(temp.val);
            if (temp.left != null) {
                stack.push(temp.left);
            }
            if (temp.right != null) {
                stack.push(temp.right);
            }
        }

        while (!rs.empty()) {
            System.out.println(rs.pop());
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        root.left = n1;
        root.right = n2;
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(1);
        n1.right = n5;
        n2.left = n3;
        n2.right = n4;
        new Main().dlr(root);

//        Deque<Integer> deque = new LinkedList<>();
//        deque.add(1);
//        deque.add(2);
//        deque.add(3);
//        deque.pollLast();
//        System.out.println(deque);
    }
}
