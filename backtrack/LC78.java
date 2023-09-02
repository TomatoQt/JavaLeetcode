package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC78 {
    private List<Integer> path;
    private List<List<Integer>> result;

    public void subsetHelper(int[] nums, int startIndex) {
        if (startIndex >= nums.length)
            return;

        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            result.add(new ArrayList<>(path));
            subsetHelper(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        path = new ArrayList<>();
        result = new ArrayList<>();
        result.add(new ArrayList<>()); // 先塞一个[]

        Arrays.sort(nums);
        subsetHelper(nums, 0);
        return result;
    }
}
