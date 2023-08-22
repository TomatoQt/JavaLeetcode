package binaryTree;

import java.util.HashMap;
import java.util.Map;

public class LC106 {
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

    public TreeNode build(int[] inorder, int in_left, int in_right, int[] postorder, int post_left, int post_right, Map<Integer, Integer> inorderMap) {
        // [left, right)
        // 没有节点了，返回空
        if (post_left == post_right)
            return null;

        // 从后序数组中取出最后一个元素，就是根
        int rootVal = postorder[post_right - 1];
        TreeNode root = new TreeNode(rootVal);

        // 叶子节点
        if (post_right - post_left == 1)
            return root;

        // 找切割点
        int cutIndex = inorderMap.get(rootVal);

        // 切割inorder，得到inorder左数组和inorder右数组
        // 利用inorder和postorder数组的大小必定相等特性，切割postorder，得到postorder左数组和postorder右数组
        root.left = build(inorder, in_left, cutIndex, postorder, post_left, post_left + (cutIndex - in_left), inorderMap);
        root.right = build(inorder, cutIndex + 1, in_right, postorder, post_left + (cutIndex - in_left), post_right - 1, inorderMap);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(inorder, 0, inorder.length, postorder, 0, postorder.length, inorderMap);
    }
}
