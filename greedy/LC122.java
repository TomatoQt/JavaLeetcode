package greedy;

public class LC122 {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0; i + 1 < prices.length; i++) {
            int expProfit = prices[i + 1] - prices[i];
            if (expProfit > 0)
                sum += expProfit;
        }

        return sum;
    }
}
