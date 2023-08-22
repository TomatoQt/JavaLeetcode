package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class LC257 {
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

    public void traverse(TreeNode node, List<Integer> nodePath, List<String> result) {
        // preOrder traverse
        nodePath.add(node.val); // mid

        // node会为null吗?
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (Integer item : nodePath) {
                sb.append(item);
                sb.append("->");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            result.add(sb.toString());
            return;
        }

        // 防止空节点进入nodePath
        if (node.left != null) { // left
            traverse(node.left, nodePath, result);
            nodePath.remove(nodePath.size() - 1);
        }
        if (node.right != null) { // right
            traverse(node.right, nodePath, result);
            nodePath.remove(nodePath.size() - 1);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<Integer> nodePath = new ArrayList<>();
        List<String> result = new ArrayList<>();
        traverse(root, nodePath, result);

        return result;
    }
}
