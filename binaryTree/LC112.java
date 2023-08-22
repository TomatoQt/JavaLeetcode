package binaryTree;

public class LC112 {
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

    public boolean pathSum(TreeNode node, int curVal, int targetSum) {
        if (node.left == null && node.right == null) { // 子节点
            return curVal == targetSum;
        }

        boolean leftTree = false;
        boolean rightTree = false;

        if (node.left != null)
            leftTree = pathSum(node.left, curVal + node.left.val, targetSum);
        if (node.right != null)
            rightTree = pathSum(node.right, curVal + node.right.val, targetSum);

        return leftTree || rightTree;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        return pathSum(root, root.val, targetSum);
    }
}
