package dp;

import java.util.Arrays;

public class LC96 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;

        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j <= i; j++)
                dp[i] += dp[j - 1] * dp[i - j];

        return dp[n];
    }
}
