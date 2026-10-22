class Solution {
    public int removeElement(int[] nums, int val) {
        // we have to manipulate the given nums and return
        int k =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[k] = nums[i];
                k++;                
            }
        }
        return k;
    }
}