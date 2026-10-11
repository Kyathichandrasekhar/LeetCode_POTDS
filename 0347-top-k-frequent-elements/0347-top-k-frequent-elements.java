class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer> list = new ArrayList<>();

        for (int i : map.keySet()) {
            list.add(i);
        }

        Integer arr[] = list.toArray(new Integer[0]);

        Arrays.sort(arr, (a, b) -> map.get(b) - map.get(a));

        int ans[] = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }

        return ans;
    }
}
