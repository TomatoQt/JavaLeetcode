package hashTable;

import java.util.HashMap;
import java.util.Map;

public class LC454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> sum_times = new HashMap<>(); // record nums1, nums2
        int count = 0;

        for (int item1 : nums1) {
            for (int item2 : nums2) {
                int sum_temp = item1 + item2;
                if (sum_times.containsKey(sum_temp)) {
                    int times_temp = sum_times.get(sum_temp);
                    sum_times.put(sum_temp, times_temp + 1);
                } else {
                    sum_times.put(sum_temp, 1);
                }
            }
        }

        for (int item3 : nums3) {
            for (int item4 : nums4) {
                int sum_temp = item3 + item4;
                if (sum_times.containsKey(-sum_temp)) {
                    count += sum_times.get(-sum_temp);
                }
            }
        }

        return count;
    }
}
