class Solution {
    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Prefix sum before the array starts

        int sum = 0;
        int cnt = 0;

        for (int num : nums) {

            sum += num;

            // Previous prefix needed to form sum k
            int rem = sum - k;

            cnt += map.getOrDefault(rem, 0);

            // Store frequency of current prefix sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return cnt;
    }
}