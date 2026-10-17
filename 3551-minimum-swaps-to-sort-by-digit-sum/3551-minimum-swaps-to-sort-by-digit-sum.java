class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int digSum = 0;

            while (num > 0) {
                digSum += num % 10;
                num /= 10;
            }

            map.put(nums[i], digSum);
        }

        // Sort numbers by digit sum, then by number
        ArrayList<Integer> list = new ArrayList<>(map.keySet());

        list.sort((a, b) -> {
            if (!map.get(a).equals(map.get(b))) {
                return Integer.compare(map.get(a), map.get(b));
            }
            return Integer.compare(a, b);
        });

        // Store each number's final sorted position
        HashMap<Integer, Integer> rank = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            rank.put(list.get(i), i);
        }

        // Find each number's target position
        int[] home = new int[n];

        for (int i = 0; i < n; i++) {
            home[i] = rank.get(nums[i]);
        }

        // Count minimum swaps using cycle-based swapping
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            while (home[i] != i) {
                int j = home[i];

                home[i] = home[j];
                home[j] = j;

                swaps++;
            }
        }

        return swaps;
    }
}