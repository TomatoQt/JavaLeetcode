package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LC101 {
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

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // 遍历层
        while (queue.size() > 0) {
            int nodeNum = queue.size();

            if (queue.peek() != root && queue.size() % 2 != 0)
                return false;

            // 存储这一层的节点
            int[] level = new int[nodeNum];
            // 遍历每一层的节点
            for (int i = 0; i < nodeNum; i++) {
                TreeNode cur = queue.poll();
                if (cur != null) {
                    level[i] = cur.val;
                    queue.add(cur.left);
                    queue.add(cur.right);
                } else
                    level[i] = 101; // 用越界数据表示异常，-100 <= Node.val <= 100
            }

            int left = 0, right = nodeNum - 1;
            while (left < right) {
                if (level[left] != level[right])
                    return false;
                left++;
                right--;
            }
        }

        return true;
    }
}
