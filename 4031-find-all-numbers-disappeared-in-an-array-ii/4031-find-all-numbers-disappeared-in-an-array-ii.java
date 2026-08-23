class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        boolean[] pre = new boolean[upper + 1];

        for(int num : nums){
            if(num>=lower && num<= upper){
                 pre[num] = true;
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        int i = lower;

        while(i<=upper){
            if(pre[i]){
                i++;
                continue;
            }
            int start = i;

            while(i<=upper && !pre[i]){
                i++;
            }

            int end = i-1;
            ans.add(Arrays.asList(start,end));
        }
        return ans;
    }
}