package binaryTree;

public class LC108 {
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

    public TreeNode helper(int[] nums, int left, int right) {
        if (left >= right)
            return null;

        int midIndex = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[midIndex]);
        node.left = helper(nums, left, midIndex);
        node.right = helper(nums, midIndex + 1, right);

        return node;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length);
    }
}
