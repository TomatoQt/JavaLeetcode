package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class LC94 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void Traverse(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        Traverse(node.left, list); // 左
        list.add(node.val); // 中
        Traverse(node.right, list); // 右
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Traverse(root, result);

        return result;
    }
}
