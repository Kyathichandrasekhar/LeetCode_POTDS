class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int min = Integer.MAX_VALUE;

        for (int k = l; k <= r; k++) {
            int sum = 0;

            for (int i = 0; i < k; i++) {
                sum += nums.get(i);
            }

            if (sum > 0) {
                min = Math.min(sum, min);
            }

            int left = 0;

            while (left + k < nums.size()) {
                sum -= nums.get(left);
                sum += nums.get(left + k);
                left++;

                if (sum > 0) {
                    min = Math.min(sum, min);
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
