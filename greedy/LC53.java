package greedy;

public class LC53 {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int subSum = 0;
        for (int i = 0; i < nums.length; i++) {
            subSum += nums[i];
            if (subSum < 0) {
                max = Math.max(subSum, max);
                subSum = 0;
                continue;
            }
            max = Math.max(subSum, max);
        }

        return max;
    }
}
