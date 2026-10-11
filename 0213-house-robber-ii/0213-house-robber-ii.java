class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int dp[] = new int[n];
        int dp2[] = new int[n];

        // Case 1: Exclude the last house
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        // Case 2: Exclude the first house
        dp2[1] = nums[1];

        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 2] + nums[i], dp2[i - 1]);
        }

        return Math.max(dp[n - 2], dp2[n - 1]);
    }
}