class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int ans = 0;

        for(int i=1;i*i<=n;i++){
            if(n%i==0){
            if(isValid(nums,sorted,i)){
                ans+=i;
            }
            int other = n / i;
            if(other !=i && isValid(nums,sorted,other)){
                ans+=other;
            }
                
                
            }      
        }
        return ans;
    }

    private boolean isValid(int[] nums, int[] sorted,int k){
        int n = nums.length;
        for(int i=0;i<n;i+=k){
            List<Integer> g1 = new ArrayList<>();
            for(int j = i;j<i+k;j++){
                g1.add(nums[j]);
            }

            Collections.sort(g1);
            for(int j = i;j<i+k;j++){
                if(!g1.get(j-i).equals(sorted[j])){
                    return false;
                }
            }
            int des = 0;
            for(int j =i;j<i+k;j++){
                int next = i+(j-i+1)%k;
                if(nums[j]>nums[next]){
                    des++;
                }
            }
            if(des>1){
                return false;
            }
        }
        return true;
    }
}