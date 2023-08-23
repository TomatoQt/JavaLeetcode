package binaryTree;

public class LC654 {
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

    public TreeNode constructHelper(int[] nums, int left, int right) {
        // [left, right)
        // 长度为0，返回空
        if (right - left == 0)
            return null;

        // 长度为1，不用找最大值，直接返回TreeNode
        if (right - left == 1)
            return new TreeNode(nums[left]);

        // 长度不为1，找到最大值坐标，分割数组
        int maxIndex = left;
        for (int i = left; i < right; i++)
            maxIndex = nums[i] > nums[maxIndex] ? i : maxIndex;
        TreeNode root = new TreeNode(nums[maxIndex]);

        // -------- [leftLeft, leftRight), maxIndex, [rightLeft, rightRight) ------>
        int leftLeft = left;
        int leftRight = maxIndex;
        int rightLeft = maxIndex + 1;
        int rightRight = right;

        root.left = constructHelper(nums, leftLeft, leftRight);
        root.right = constructHelper(nums, rightLeft, rightRight);

        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0)
            return null;

        return constructHelper(nums, 0, nums.length);
    }
}
