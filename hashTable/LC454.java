package hashTable;

import java.util.HashMap;
import java.util.Map;

public class LC454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 记录A、B中元素之和+出现次数
        Map<Integer, Integer> ABhash = new HashMap<>();
        int targetCount = 0;

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                // 取出“和”+1，统计“和”出现次数
                ABhash.put(nums1[i] + nums2[j], ABhash.getOrDefault(nums1[i] + nums2[j], 0) + 1);
            }
        }

        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                if (ABhash.containsKey(-nums3[i] - nums4[j]))
                    targetCount += ABhash.get(-nums3[i] - nums4[j]);
            }
        }

        return targetCount;
    }
}
