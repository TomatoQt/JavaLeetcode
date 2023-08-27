package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class LC501 {
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

    private int maxCount = 0;
    private int count = 0;
    private List<Integer> result = new ArrayList<>();
    private TreeNode pre = null;

    public void searchBST(TreeNode cur) {
        if (cur == null)
            return;

        // left
        searchBST(cur.left);

        // middle
        if (pre == null) // pre为null，是第一次进入递归
            count = 1;
        else if (cur.val == pre.val) // 相等 频率+1
            count++;
        else // 不相等
            count = 1;
        pre = cur; // 更新pre
        if (count == maxCount)
            result.add(cur.val);

        if (count > maxCount) {
            maxCount = count;
            result.clear();
            result.add(cur.val);
        }

        // right
        searchBST(cur.right);
    }

    public int[] findMode(TreeNode root) {
        searchBST(root);
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
