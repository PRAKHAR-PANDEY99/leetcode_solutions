class Solution {
    public int maxProduct(int[] nums) {
        int first=Integer.MIN_VALUE;
        int second=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>first){
                second=first;
                first=nums[i];
            }
            else if(nums[i]>second){
                second=nums[i];
            }
        }
        return ((first-1)*(second-1));
        
    }
}