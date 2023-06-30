package list;

public class LC209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int sum = 0, min = Integer.MAX_VALUE;
        int left = 0, right = 0;

        for (; right < len; right++) {
            sum += nums[right];

            while (sum >= target) {
                int windowLength = right - left + 1;
                min = Math.min(min, windowLength);
                sum -= nums[left++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};

        System.out.println(minSubArrayLen(target, nums));
    }
}
