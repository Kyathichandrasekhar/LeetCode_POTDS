class Solution {
    public long countSubarrays(int[] nums, int k, int m) {

        return solve(nums, k, m, k) - solve(nums, k, m, k + 1);
    }

    public long solve(int[] nums, int k, int m, int p) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int l = 0;
        int j = 0;
        long count = 0;

        for (int r = 0; r < nums.length; r++) {

            int x = nums[r];

            map.put(x, map.getOrDefault(x, 0) + 1);

            if (map.get(x) == m) {
                j++;
            }

            while (map.size() >= p && j >= k) {

                int y = nums[l];

                map.put(y, map.get(y) - 1);

                if (map.get(y) == m - 1) {
                    j--;
                }

                if (map.get(y) == 0) {
                    map.remove(y);
                }

                l++;
            }

            count += l;
        }

        return count;
    }
}
