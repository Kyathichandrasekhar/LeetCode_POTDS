class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;

        int[][][] dp = new int[n + 1][2][3];

        for (int i = n - 1; i >= 0; i--) {

            for (int buy = 0; buy <= 1; buy++) {

                for (int cap = 1; cap <= 2; cap++) {

                    if (buy == 1) {

                        int buyStock =
                            -prices[i] + dp[i + 1][0][cap];

                        int skip =
                            dp[i + 1][1][cap];

                        dp[i][buy][cap] =
                            Math.max(buyStock, skip);

                    } else {

                        int sellStock =
                            prices[i] + dp[i + 1][1][cap - 1];

                        int hold =
                            dp[i + 1][0][cap];

                        dp[i][buy][cap] =
                            Math.max(sellStock, hold);
                    }
                }
            }
        }

        return dp[0][1][2];
    }
}