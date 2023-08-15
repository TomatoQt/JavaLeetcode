package hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 双指针
public class LC15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); // 存结果
        Arrays.sort(nums); // 先排序

        // 升序数组，最小元素大于0或者最大元素小于0，都没有必要再找了
        if (nums[0] > 0 || nums[nums.length - 1] < 0)
            return result;

        for (int i = 0; i < nums.length - 2; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    // 去重
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    // 找到答案，双指针同时变化
                    left++;
                    right--;
                }
            }
        }

        return result;
    }
}
