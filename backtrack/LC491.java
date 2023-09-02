package backtrack;

import java.util.*;

public class LC491 {
    private List<Integer> path;
    private List<List<Integer>> result;

    public void findHelper(int[] nums, int startIndex) {
        if (path.size() > 1)
            result.add(new ArrayList<>(path));
        if (startIndex >= nums.length)
            return;

        Set<Integer> used = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (!used.contains(nums[i]))
                used.add(nums[i]);
            else
                continue;

            if (path.size() == 0 || path.size() > 0 && nums[i] >= path.get(path.size() - 1)) {
                path.add(nums[i]);
                findHelper(nums, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        path = new ArrayList<>();
        result = new ArrayList<>();
        findHelper(nums, 0);

        return result;
    }
}
