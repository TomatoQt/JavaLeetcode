package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class LC98 {
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

    public void inorderTraverse(TreeNode node, List<Integer> inorderBST) {
        if (node == null)
            return;

        inorderTraverse(node.left, inorderBST);
        inorderBST.add(node.val);
        inorderTraverse(node.right, inorderBST);
    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> inorderBST = new ArrayList<>();
        inorderTraverse(root, inorderBST);

        for (int i = 1; i < inorderBST.size(); i++) {
            if (inorderBST.get(i) <= inorderBST.get(i - 1))
                return false;
        }

        return true;
    }
}
