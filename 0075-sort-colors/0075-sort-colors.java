class Solution {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {
        int l = 0;
        int mid = 0;
        int r = nums.length - 1;

        while (mid <= r) {
            if (nums[mid] == 0) {
                swap(nums, l, mid);
                l++;
                mid++;
            }
            else if (nums[mid] == 1) {
                mid++;
            }
            else {
                swap(nums, mid, r);
                r--;
            }
        }
    }
}