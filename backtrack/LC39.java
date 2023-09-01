package backtrack;

import java.util.ArrayList;
import java.util.List;

public class LC39 {
    private List<Integer> path;
    private List<List<Integer>> result;

    public void combineHelper(int[] candidates, int target, int startIndex) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        } else if (target < 0) { // 已经超过了target，没有必要继续搜索这一分支
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            target -= candidates[i];
            combineHelper(candidates, target, i); // 不限制单个数字的使用次数，就体现在这里
            target += candidates[i];
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        path = new ArrayList<>();
        result = new ArrayList<>();
        if (candidates.length == 0)
            return result;
        combineHelper(candidates, target, 0);

        return result;
    }
}
