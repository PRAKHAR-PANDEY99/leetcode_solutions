class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<nums.length-k+1;i++){
            pq.add(nums[i]);    
        }
        for(int j=nums.length-k+1;j<nums.length;j++){
            if(nums[j]<pq.peek()){
                pq.poll();
                pq.add(nums[j]);
            }
        }
        return pq.peek();
        
    }
}