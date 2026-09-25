public class Solution {
    public int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // balance 0 before the array starts
        map.put(0, -1);

        int zeroCount = 0;
        int oneCount = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {

            // Count 0s and 1s
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                oneCount++;
            }

            // Difference between number of 1s and 0s
            int balance = oneCount - zeroCount;

            // Same balance appeared before
            if (map.containsKey(balance)) {

                int oldIndex = map.get(balance);

                int length = i - oldIndex;

                maxLen = Math.max(maxLen, length);

            } else {

                // Store FIRST occurrence
                map.put(balance, i);
            }
        }

        return maxLen;
    }
}