class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = Integer.MIN_VALUE;
        while(left<right){
            int width = right-left;
            int height1 = Math.min(height[left],height[right]);
            int water = width*height1;
            maxArea = Math.max(water,maxArea);
            if(height[left]<=height[right]){
                left++;
            }else{
                right--;
            }
           
        }
        return maxArea;
    }
}