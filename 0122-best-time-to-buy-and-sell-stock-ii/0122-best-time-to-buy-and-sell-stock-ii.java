class Solution {
    public int maxprofit(int i, int buy, int arr[], int dp[][]) {

        int n = arr.length;

        if (i == n) {
            return 0;
        }

        // Already calculated?
        if (dp[i][buy] != -1) {
            return dp[i][buy];
        }

        int profit;

        if (buy == 1) {

            int take = -arr[i] + maxprofit(i + 1, 0, arr, dp);
            int skip = maxprofit(i + 1, 1, arr, dp);

            profit = Math.max(take, skip);

        } else {

            int sell = arr[i] + maxprofit(i + 1, 1, arr, dp);
            int hold = maxprofit(i + 1, 0, arr, dp);

            profit = Math.max(sell, hold);
        }

        // Store the result
        dp[i][buy] = profit;

        return profit;
    }

    public int maxProfit(int[] prices) {

        int n = prices.length;

        int dp[][] = new int[n][2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return maxprofit(0, 1, prices, dp);
    }
}