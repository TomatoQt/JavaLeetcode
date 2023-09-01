package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC40 {
    private List<Integer> path;
    private List<List<Integer>> result;

    public void combineHelper(int[] candidates, int target, int startIndex) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        } else if (target < 0) {
            return;
        }

        if (target > 0 && startIndex >= candidates.length)
            return;

        for (int i = startIndex; i < candidates.length; i++) {
            int num = candidates[i];
            // 在这里去除重复结果
            if (i > startIndex && num == candidates[i - 1])
                continue;
            path.add(num);
            target -= num;
            combineHelper(candidates, target, i + 1); // 和不限制元素使用次数情况不同
            target += num;
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        path = new ArrayList<>();
        result = new ArrayList<>();
        if (candidates.length == 0)
            return result;

        // 先对candidates排序
        Arrays.sort(candidates);

        combineHelper(candidates, target, 0);
        return result;
    }
}
