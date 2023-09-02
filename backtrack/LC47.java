package backtrack;

import java.util.*;

public class LC47 {
    private List<Integer> path;
    private List<List<Integer>> result;

    public void permuteHelper(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        Set<Integer> accessed = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || accessed.contains(nums[i]))
                continue;

            used[i] = true;
            accessed.add(nums[i]);
            path.add(nums[i]);
            permuteHelper(nums, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        path = new ArrayList<>();
        result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        permuteHelper(nums, used);

        return result;
    }
}
