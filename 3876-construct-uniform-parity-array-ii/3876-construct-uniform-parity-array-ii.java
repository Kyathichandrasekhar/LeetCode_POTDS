class Solution {
    public boolean uniformArray(int[] nums1) {
       
        Arrays.sort(nums1);
        int n = nums1.length;
        if (n == 1) {
            return true;
        }
        int par = nums1[0] % 2;
        int min = nums1[0];

        for (int i = 0; i < n; i++) {
            int curr=nums1[i];
            if(curr%2==par)
            {
                continue;
            }
            if((curr-min)%2!=par)
            {
                return false;
            }
        }

        return true; 
    }
}