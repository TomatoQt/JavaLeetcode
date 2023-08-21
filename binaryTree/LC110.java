package binaryTree;

public class LC110 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public int getHeight(TreeNode node) {
            if (node == null)
                return 0;

            // 左树高度
            int leftTreeHeight = getHeight(node.left);
            // 右树高度
            int rightTreeHeight = getHeight(node.right);

            // 假如发现子树已经不平衡，没有意义再继续比较
            // 直接返回-1，迅速通过所有的递归过程
            // 之后所有的递归调用结果都是-1
            if (leftTreeHeight == -1 || rightTreeHeight == -1)
                return -1;

            int diffHeight = Math.abs(leftTreeHeight - rightTreeHeight);
            if (diffHeight <= 1)
                return 1 + Math.max(leftTreeHeight, rightTreeHeight);
            else
                return -1;
        }

        public boolean isBalanced(TreeNode root) {
            if (root == null)
                return true;

            return getHeight(root) != -1;
        }
    }
}
