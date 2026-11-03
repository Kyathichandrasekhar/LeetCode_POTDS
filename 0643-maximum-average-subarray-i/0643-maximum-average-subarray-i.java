class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // Constant Sliding Window
        int l = 0;
        int r = k-1;
        double maxSum = 0;
        double sum = 0;

        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }

        maxSum = sum;

        while(r < nums.length-1) {
            sum += nums[r+1];
            sum -= nums[l];

            l++;
            r++;

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum/k;
    }
}