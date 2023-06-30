package hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 双指针
public class LC18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 剪枝：一次循环最小的数大于target，就没有必要继续循环
            if (nums[i] > 0 && nums[i] > target) return res;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 注意：j从i+1开始，去重时j-1不能越界（即保证j>i+1）
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) right--;
                    else if (sum < target) left++;
                    else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        right--;
                        left++;
                    }
                }
            }
        }
        return res;
    }
}
