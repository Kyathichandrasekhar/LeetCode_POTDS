class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = 1;
        int count = 0;
        Arrays.sort(nums);
        while(r<n){
            if(nums[l]==nums[r]){
                count = nums[l];
            }
            l++;
            r++;
        }
        return count;
    }
}