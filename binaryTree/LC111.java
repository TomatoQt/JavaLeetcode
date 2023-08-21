package binaryTree;

public class LC111 {
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
    }

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int minLeftDepth = minDepth(root.left);
        int minRightDepth = minDepth(root.right);

        // 只需要处理其中一个子树缺失的情况就可以了
        // 缺失就返回另一颗子树的深度
        if (minLeftDepth == 0 && minRightDepth !=0)
            return 1 + minRightDepth;
        if (minRightDepth == 0 && minLeftDepth != 0)
            return 1 + minLeftDepth;

        // 能兼容：1. 左右子树深度都不为0的情况 2. 左右子树深度都为0的情况
        return 1 + Math.min(minLeftDepth, minRightDepth);
    }
}
