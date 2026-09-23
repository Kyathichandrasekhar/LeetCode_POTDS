class Solution {
    public int minOperations(int[] nums, int x) {

        int n = nums.length;

        int total = 0;

        for (int i = 0; i < n; i++) {
            total += nums[i];
        }

        int target = total - x;

        if (target < 0) {
            return -1;
        }

        if (target == 0) {
            return n;
        }

        int l = 0;
        int sum = 0;
        int maxLength = -1;

        for (int r = 0; r < n; r++) {

            sum += nums[r];

            while (sum > target) {
                sum = sum - nums[l];
                l++;
            }

            if (sum == target) {
                maxLength = Math.max(maxLength, r - l + 1);
            }
        }

        if (maxLength == -1) {
            return -1;
        }

        return n - maxLength;
    }
}