package dynamicProgramming;

public class LC70 {
    public int climbStairs(int n) {
        int[] dp = {0, 1, 2};

        if (n <= 2)
            return dp[n];
        int prevPrev = 1, prev = 2;
        for (int i = 3; i <= n; i++) {
            int temp = prevPrev + prev;
            prevPrev = prev;
            prev = temp;
        }

        return prev;
    }
}
