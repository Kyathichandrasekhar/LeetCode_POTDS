class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        Map<Integer, Queue<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; ) {
            int j = i;
            while (j + 1 < n && sorted[j + 1] - sorted[j] <= limit)
                j++;

            Queue<Integer> q = new LinkedList<>();
            for (int k = i; k <= j; k++)
                q.add(sorted[k]);

            for (int k = i; k <= j; k++)
                map.put(sorted[k], q);

            i = j + 1;
        }

        for (int i = 0; i < n; i++)
            nums[i] = map.get(nums[i]).poll();

        return nums;
    }
}