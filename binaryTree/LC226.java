package binaryTree;

public class LC226 {
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

    public void invert(TreeNode node) {
        if (node == null)
            return;

        invert(node.left);
        invert(node.right);

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    public TreeNode invertTree(TreeNode root) {
        invert(root);

        return root;
    }
}
