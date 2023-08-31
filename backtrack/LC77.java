package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC77 {
    List<List<Integer>> result;
    LinkedList<Integer> path;
    public void combineHelper(int n, int k, int start) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 横向遍历
        for (int i = start; i <= n; i++) {
            // 处理当前节点
            path.add(i);
            // 递归
            combineHelper(n, k, i + 1);
            path.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        path = new LinkedList<>();
        combineHelper(n, k, 1);
        return result;
    }
}
