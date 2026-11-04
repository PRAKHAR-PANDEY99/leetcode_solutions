class Solution {
    int fn(int target,int[] nums,int[] dp){

        if(target==0){
            return 1;
        }

        if(dp[target]!=-1){
            return dp[target];
        }

        int count=0;

        for(int i=0;i<nums.length;i++){
            if(target>=nums[i]){
                count+=fn(target-nums[i],nums,dp);
            }
        }

        return dp[target]=count;
    }
    public int combinationSum4(int[] nums,int target) {
        int[] dp=new int[target+1];
        Arrays.fill(dp,-1);
        return fn(target,nums,dp);
    }
}