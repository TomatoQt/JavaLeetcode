package binaryTree;

public class LC700 {
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

    public TreeNode searchBST(TreeNode root, int val) {
        // 惰性判断
        if (root == null || root.val == val)
            return root;

        TreeNode result = null;

        if (val > root.val)
            result = searchBST(root.right, val);
        if (val < root.val)
            result = searchBST(root.left, val);

        return result;
    }
}
