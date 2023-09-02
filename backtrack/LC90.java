package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC90 {
    private List<Integer> path;
    private List<List<Integer>> result;

    public void subsetHelper(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length)
            return;

        for (int i = startIndex; i < nums.length; i++) {
            // 去除重复结果
            if (i > startIndex && nums[i] == nums[i - 1])
                continue;
            path.add(nums[i]);
            subsetHelper(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        path = new ArrayList<>();
        result = new ArrayList<>();

        Arrays.sort(nums);
        subsetHelper(nums, 0);
        return result;
    }
}
