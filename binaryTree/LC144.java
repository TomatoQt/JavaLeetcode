package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class LC144 {
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
        list.add(node.val); // 中
        Traverse(node.left, list); // 左
        Traverse(node.right, list); // 右
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Traverse(root, result);

        return result;
    }
}
