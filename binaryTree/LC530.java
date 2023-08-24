package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class LC530 {
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

    public void inorderTraverse(TreeNode node, List<Integer> seq) {
        if (node == null)
            return;

        inorderTraverse(node.left, seq);
        seq.add(node.val);
        inorderTraverse(node.right, seq);
    }

    public int getMinimumDifference(TreeNode root) {
        List<Integer> inorderSeq = new ArrayList<>();
        inorderTraverse(root, inorderSeq);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < inorderSeq.size(); i++) {
            if (Math.abs(inorderSeq.get(i) - inorderSeq.get(i-1)) < min)
                min = Math.abs(inorderSeq.get(i) - inorderSeq.get(i-1));
        }

        return min;
    }
}
