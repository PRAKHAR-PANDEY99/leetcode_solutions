class Solution {
    int sum(int[] nums,int target,int i){
        if(i==nums.length && target==0){
            return 1;
        }
        if(i==nums.length){
            return 0;
        }
        int takePositive=0;
        int takeNegative=0;
        takePositive=sum(nums,target-nums[i],i+1);
        takeNegative=sum(nums,target+nums[i],i+1);
        return takePositive+takeNegative;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int ans=sum(nums,target,0);
        return ans;
        
    }
}