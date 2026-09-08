class Solution {
    public int smallestEqual(int[] nums) {
        int small = Integer.MAX_VALUE;
        for(int i =0;i<nums.length;i++){
            if(i%10==nums[i]){
                small = Math.min(small,i);
            }
        }
        if(small < Integer.MAX_VALUE){
            return small;
        }
        return -1;
    }
}