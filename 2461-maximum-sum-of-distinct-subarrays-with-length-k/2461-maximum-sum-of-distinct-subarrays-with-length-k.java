class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int l = 0;
        long sum = 0;
        long maxSum = 0;

        HashSet<Integer> set = new HashSet<>();

        for (int r = 0; r < nums.length; r++) {

            while (set.contains(nums[r])) {
                sum -= nums[l];
                set.remove(nums[l]);
                l++;
            }

            sum += nums[r];
            set.add(nums[r]);

            if (r - l + 1 > k) {
                sum -= nums[l];
                set.remove(nums[l]);
                l++;
            }

            if (r - l + 1 == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}