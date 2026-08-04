class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        int min = nums[0];
        int max = nums[0];

        // Store elements in HashSet and find min & max
        for (int num : nums) {
            set.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // Find missing numbers
        for (int i = min + 1; i < max; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }

        return list;
    }
}