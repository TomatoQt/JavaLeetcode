package backtrack;

import java.util.ArrayList;
import java.util.List;

public class LC46 {
    private List<Integer> path;
    private List<List<Integer>> result;

    public void permuteHelper(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;

            used[i] = true;
            path.add(nums[i]);
            permuteHelper(nums, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        path = new ArrayList<>();
        result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        permuteHelper(nums, used);

        return result;
    }
}
