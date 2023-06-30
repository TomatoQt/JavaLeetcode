package hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 双指针
public class LC15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>(); // sorted

        // smallest > 0 || biggest < 0
        if (nums[0] > 0 || nums[nums.length - 1] < 0)
            return ans;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    right--;
                    left++;
                }
            }
        }

        return ans;
    }
}
