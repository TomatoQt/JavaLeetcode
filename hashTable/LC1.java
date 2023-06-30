package hashTable;

import java.util.HashMap;
import java.util.Map;

public class LC1 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> num2Index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tryToFind = target - nums[i];
            if (num2Index.containsKey(tryToFind)) {
                result[0] = i;
                result[1] = num2Index.get(tryToFind);
                break;
            } else { // put [K, V]=[nums[i], i]
                num2Index.put(nums[i], i);
            }
        }
        return result;
    }
}
