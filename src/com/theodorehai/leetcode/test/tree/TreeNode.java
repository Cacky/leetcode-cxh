package com.theodorehai.leetcode.test.tree;

/**
 * test.com.theodorehai.leetcode.tree.
 *
 * @author chengxiaohai.
 * @date 2021/3/18.
 */
public class TreeNode {

    private Integer val;

    private TreeNode left;

    private TreeNode right;

    public TreeNode(Integer val) {
        this.val = val;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
