package 树的遍历;

import java.util.Stack;

/**
 * 树的遍历.
 *
 * @author chengxiaohai.
 * @date 2020/11/24.
 */
public class BinaryTree {

    private class TreeNode {

        private int key = 0;
        private String data = null;
        private TreeNode leftChild = null;
        private TreeNode rightChild = null;

        public TreeNode(int key, String data) {
            this.key = key;
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    //获取根节点
    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    //定义根节点
    private TreeNode root = null;

    public BinaryTree() {
        root = new TreeNode(1, "A");
    }

    public void createBinaryTree(TreeNode root) {
        TreeNode nodeB = new TreeNode(2, "B");
        TreeNode nodeC = new TreeNode(3, "C");
        TreeNode nodeD = new TreeNode(4, "D");
        TreeNode nodeE = new TreeNode(5, "E");
        TreeNode nodeF = new TreeNode(6, "F");
        root.leftChild = nodeB;
        root.rightChild = nodeC;
        nodeB.leftChild = nodeD;
        nodeB.rightChild = nodeE;
        nodeC.rightChild = nodeF;

    }

    private void visited(TreeNode node) {
        System.out.println(node.data + "," + node.key);
    }

    public void preOrder(TreeNode node) {
        if (node != null) {
            visited(node);
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }

    public void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.leftChild);
            visited(node);
            inOrder(node.rightChild);
        }
    }

    public void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.leftChild);
            postOrder(node.rightChild);
            visited(node);
        }
    }

    public void nonRecPreOrder(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pNode = node;
        while (pNode != null || stack.size() > 0) {
            while (pNode != null) {
                visited(pNode);
                stack.push(pNode);
                pNode = pNode.leftChild;
            }
            if (stack.size() > 0) {
                pNode = stack.pop();
                pNode = pNode.rightChild;
            }
        }
    }

    public void nonRecInOrder(TreeNode node) {
        System.out.println("nonRecInOrder" + node.data);
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pNode = node;
        while (pNode != null || stack.size() > 0) {
            while (pNode != null) {
                stack.push(pNode);
                pNode = pNode.leftChild;
            }
            if (stack.size() > 0) {
                pNode = stack.pop();
                visited(pNode);
                pNode = pNode.rightChild;
            }
        }
    }

    public void nonRecPostOrder(TreeNode pNode) {
        System.out.println("nonRecPostOrder" + pNode.data);
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = pNode;
        while (pNode != null) {
            //左子树入栈
            while (pNode.leftChild != null) {
                stack.push(pNode);
                pNode = pNode.leftChild;
            }
            //当前节点无右子树或者右子树已输出
            while (pNode != null && (pNode.rightChild == null || pNode.rightChild == node)) {
                visited(pNode);
                //记录上一个已输出的节点
                node = pNode;
                if (!stack.isEmpty()) {
                    pNode = stack.pop();
                } else {
                    return;
                }
            }
            //右子树入栈
            stack.push(pNode);
            pNode = pNode.rightChild;
        }
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int i = height(node.leftChild);
            int j = height(node.rightChild);
            return (i < j) ? j + 1 : i + 1;
        }
    }

    private int size(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int left = size(node.leftChild);
            int right = size(node.rightChild);
            return 1 + left + right;
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.root;
        binaryTree.createBinaryTree(root);
        System.out.println("-----height--------");
        // System.out.println(binaryTree.height(root));
        // System.out.println("------size-------");
        // System.out.println(binaryTree.size(root));
        // System.out.println("------preOrder-------");
        // binaryTree.preOrder(root);
        // System.out.println("-------nonRecPreOrder------");
        // binaryTree.nonRecPreOrder(root);
        System.out.println("-------nonRecInOrder------");
        binaryTree.nonRecInOrder(root);
        System.out.println("-------inOrder------");
        binaryTree.inOrder(root);
        // System.out.println("-------nonRecPostOrder------");
        // binaryTree.nonRecPostOrder(root);
        System.out.println(binaryTree.size(root));
    }
}
