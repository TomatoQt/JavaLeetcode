package binaryTree;

public class LC538 {
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

    private int preVal = 0;
    public void convertHelper(TreeNode node) {
        if (node == null)
            return;

        convertHelper(node.right);
        node.val += preVal;
        preVal = node.val;
        convertHelper(node.left);
    }

    public TreeNode convertBST(TreeNode root) {
        convertHelper(root);
        return root;
    }
}
