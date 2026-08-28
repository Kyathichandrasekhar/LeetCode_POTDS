class Solution {
    // Function to get the Kth largest element 
    public int findKthLargest(int[] nums, int k) {
        
        // Min-heap data structure
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // Add the first K elements in the Min-heap
        for(int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        
        // Process the rest of the elements 
        for(int i = k; i < nums.length; i++) {
            // Check if a new larger element is found
            if(nums[i] > pq.peek()) {
                
                pq.poll(); // remove the smallest from the min-heap
                
                // Add the current element to the min-heap
                pq.add(nums[i]);
            }
        }
        
        return pq.peek(); // Return the kth largest element 
    }
}