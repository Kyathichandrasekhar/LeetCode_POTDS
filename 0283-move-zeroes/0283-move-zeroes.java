class Solution {
    public void swap(int l, int r, int[] nums) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public void moveZeroes(int[] nums) {
        int l = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(l, i, nums);
                l++;
            }
        }
    }
}
