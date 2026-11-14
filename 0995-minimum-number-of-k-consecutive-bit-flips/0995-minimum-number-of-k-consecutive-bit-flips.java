class Solution {
    public int minKBitFlips(int[] nums, int k) {

        int n = nums.length;
        int[] temp = new int[n];

        int flips = 0;
        int activeFlips = 0;

        for (int i = 0; i < n; i++) {

            // Remove flips that ended before this index
            if (i >= k) {
                activeFlips -= temp[i - k];
            }

            // Check effective value
            if ((nums[i] + activeFlips) % 2 == 0) {

                // Cannot perform a complete k-length flip
                if (i + k > n) {
                    return -1;
                }

                temp[i] = 1;
                activeFlips++;
                flips++;
            }
        }

        return flips;
    }
}