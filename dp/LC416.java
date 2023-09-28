package dp;

public class LC416 {
    public boolean canPartition(int[] nums) {
        int target = 0;
        for (int item : nums)
            target += item;

        if (target % 2 != 0)
            return false;

        target /= 2;

        int[] dp = new int[target + 1];

        for (int i = 0; i < nums.length; i++) {// 遍历物品
            for (int j = target; j >= nums[i]; j--)// 遍历背包
                dp[j] = Math.max(dp[j], nums[i] + dp[j - nums[i]]);

            if (dp[target] == target)
                return true;
        }

        return dp[target] == target;
    }
}
