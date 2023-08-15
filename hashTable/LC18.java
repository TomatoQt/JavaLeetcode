package hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 双指针
public class LC18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums); // 排序
        List<List<Integer>> result = new ArrayList<>(); // 存结果

        // 最小的数字大于target，不能找到和为target的数
        if (nums[0] > target)
            return result;

        for (int i = 0; i < nums.length - 3; i++) {
            // 剪枝，访问过nums[0]之后再判重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                // 剪枝，访问过nums[i+1]之后再判重
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1, right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) right--;
                    else if (sum < target) left++;
                    else {
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));
                        // 去重
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        right--;
                        left++;
                    }
                }
            }
        }

        return result;
    }
}
