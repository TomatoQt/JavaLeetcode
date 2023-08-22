package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class LC404 {
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

    public void findLeftLeaves(TreeNode node, List<Integer> leftList) {
        // node不会为null
        if (node.left != null && node.left.left == null && node.left.right == null) {
            leftList.add(node.left.val);
        }

        if (node.left != null)
            findLeftLeaves(node.left, leftList);
        if (node.right != null)
            findLeftLeaves(node.right, leftList);
        // 无需处理中间节点
    }

    public int sumOfLeftLeaves(TreeNode root) {
        List<Integer> leftLeafList = new ArrayList<>();
        findLeftLeaves(root, leftLeafList);

        int result = 0;
        for (Integer integer : leftLeafList) {
            result += integer;
        }

        return result;
    }
}
