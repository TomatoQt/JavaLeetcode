package binaryTree;

public class LC450 {
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

    public TreeNode deleteNode(TreeNode root, int key) {
        // 找遍整棵树都没找到对应的节点
        if (root == null)
            return null;

        // 找到了
        if (root.val == key) {
            if (root.left == null && root.right == null)
                return null;
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;
            if (root.left != null && root.right != null) {
                // 左子一定比右子树最左边的子还要小，这就是合适的位置
                TreeNode leftMark = root.left;
                TreeNode pre = null, cur = root.right;
                while (cur != null) {
                    pre = cur;
                    cur = cur.left;
                }
                pre.left = leftMark;
                return root.right;
            }
        }

        // 已经滤除了相等情况，开始排查找不到相等的key的情况
        if (key < root.val)
            root.left = deleteNode(root.left, key);
        else
            root.right = deleteNode(root.right, key);

        return root;
    }
}
