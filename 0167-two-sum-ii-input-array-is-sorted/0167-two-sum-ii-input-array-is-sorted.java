class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int sum = 0;
        int l =0;
        int r =numbers.length-1;
        while(l<r){
            sum = numbers[l]+numbers[r];

            if(sum==target){
                return new int[]{l + 1, r + 1};
            }

            if(sum<target){
                sum = sum - numbers[l];
                l++;
            }else{
                sum = sum - numbers[r];
                r--;
            }
        }
        return new int[]{};
    }
}