package binaryTree;

public class LC235 {
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;

        if (root.val > p.val && root.val > q.val) {
            TreeNode leftTree = lowestCommonAncestor(root.left, p, q);
            // 有结果直接返回，即这条边遍历结束，无需继续搜索
            if (leftTree != null)
                return leftTree; // return 终止当前递归函数
        }

        if (root.val < p.val && root.val < q.val) {
            TreeNode rightTree = lowestCommonAncestor(root.right, p, q);
            if (rightTree != null)
                return rightTree;
        }

        // 为什么排除上门2种情况后的root一定是最近公共祖先？很重要
        // 只剩下root val在p和q之间的情况
        return root;
    }
}
