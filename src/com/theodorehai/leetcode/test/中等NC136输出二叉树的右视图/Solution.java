package com.theodorehai.leetcode.test.中等NC136输出二叉树的右视图;

/**
 * com.theodorehai.leetcode.test.中等NC136输出二叉树的右视图.
 *
 *题目描述
 * 请根据二叉树的前序遍历，中序遍历恢复二叉树，并打印出二叉树的右视图
 *
 * 示例1
 * 输入 [1,2,4,5,3],[4,2,5,1,3]
 * 返回值 [1,3,5]
 * 备注:
 * 二叉树每个节点的值在区间[1,10000]内，且保证每个节点的值互不相同。
 * @author chengxiaohai.
 * @date 2021/4/28.
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
    /**
     * 本题总体可拆分为两部分：
     * ① 根据先序、中序遍历重构二叉树
     * ② 层序遍历二叉树输出每层最右侧元素
     *
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 求二叉树的右视图
     * @param xianxu int整型一维数组 先序遍历
     * @param zhongxu int整型一维数组 中序遍历
     * @return int整型一维数组
     */
    public int[] solve (int[] xianxu, int[] zhongxu) {
        // write code here
        // TreeNode root = reconstructTree(xianxu, zhongxu, 0, 0, xianxu.length - 1);
        TreeNode root = reBuild(xianxu, zhongxu);
        return  levelTraverse(root);
        // List<Integer> res = new ArrayList<>();
        // Queue<TreeNode> queue = new LinkedList<>();
        // queue.add(root);
        // TreeNode last = root;
        // TreeNode curLast = root;
        // while (!queue.isEmpty()) {
        //     TreeNode node = queue.poll();
        //     if (node.left != null) {
        //         curLast = node.left;
        //         queue.offer(node.left);
        //     }
        //     if (node.right != null) {
        //         curLast = node.right;
        //         queue.offer(node.right);
        //     }
        //     if (last == node) {
        //         res.add(node.val);
        //         last = curLast;
        //     }
        // }
        // int[] list = new int[res.size()];
        // for (int i = 0; i < res.size(); i++) {
        //     list[i] = res.get(i);
        // }
        // return list;
    }

    /**
     * 逐个分析下。
     * 一、重构
     * 先序确定根节点，中序确定左右子树；
     * 左右子树又可以继续拆分，继续确定子树的根节点及左右子；
     * @param pre
     * @param mid
     * @param rootIdx
     * @param lIdx
     * @param rIdx
     * @return
     */
    private TreeNode reconstructTree(int[] pre, int[] mid, int rootIdx, int lIdx, int rIdx) {
        if (lIdx > rIdx) {
            return null;
        }
        TreeNode newHead = new TreeNode(pre[rootIdx]);
        int i = lIdx;
        for (; i <= rIdx; i++) {
            if (mid[i] == pre[rootIdx]) {
                break;
            }
        }
        newHead.left = reconstructTree(pre, mid, rootIdx + 1, lIdx, i - 1);
        newHead.right = reconstructTree(pre, mid, rootIdx + i - lIdx + 1, i + 1, rIdx);
        return newHead;
    }

    /**
     * 逐个分析下。
     * 一、重构
     * 先序确定根节点，中序确定左右子树；
     * 左右子树又可以继续拆分，继续确定子树的根节点及左右子；
     * */
    private TreeNode reBuild (int[] preOrder, int[] inOrder) {

        if (preOrder == null || preOrder.length == 0) return null;

        int val = preOrder[0], pos = 0, len = preOrder.length;
        TreeNode root = new TreeNode(val);

        // 找到中序数组中根节点位置
        for(; pos < len; pos++){
            if (inOrder[pos] == val) break;
        }
        // 左右子树继续拆分，递归重构
        // 此处 Arrays.copyOfRange 方法起点为 len 不抛异常，返回[]，对应递归结束条件。
        root.left = reBuild(Arrays.copyOfRange(preOrder, 1, pos + 1),
            Arrays.copyOfRange(inOrder, 0, pos));
        root.right = reBuild(Arrays.copyOfRange(preOrder, pos + 1, len),
            Arrays.copyOfRange(inOrder, pos + 1, len));

        return root;
    }

    private int[] levelTraverse(TreeNode root){
        if(root == null){
            return new int[]{0};
        }
        List<Integer> resList = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        resList.add(root.val);
        while(!queue.isEmpty()){
            int size = queue.size();
            Integer rightVal = null;
            for (int i = 0; i < size; i++) {
                TreeNode rmNode = queue.poll();
                if(rmNode.left !=null){
                    rightVal = rmNode.left.val;
                    queue.add(rmNode.left);
                }
                if(rmNode.right !=null){
                    rightVal = rmNode.right.val;
                    queue.add(rmNode.right);
                }
            }
            if(null != rightVal){
                resList.add(rightVal);
            }
        }
        int[] res = new int[resList.size()];
        if(!resList.isEmpty()){
            res = resList.stream().mapToInt(Integer::intValue).toArray();

        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //[1,2,4,5,3],[4,2,5,1,3]
        int[] data1 = {1, 2, 4, 5, 3};
        int[] data2 = {4,2,5,1,3};
        int[] solve = solution.solve(data1, data2);
        for (int i = 0; i < solve.length; i++) {
            System.out.println(solve[i]);
        }
    }

}
