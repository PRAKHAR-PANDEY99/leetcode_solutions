class Solution {
    int sum(int[] nums,int target,int i,int[][] dp){
        if(target==0){
            return 0;
        }
        if(i==nums.length){
            return Integer.MAX_VALUE;
        }
        if(dp[i][target]!=-1){
            return dp[i][target];
        }
        int take=Integer.MAX_VALUE;
        if(nums[i]<=target){
            int t=sum(nums,target-nums[i],i,dp);
            if(t!=Integer.MAX_VALUE){
                take=1+t;
            }
            else{
                take=Integer.MAX_VALUE;
            }
        }
        int nottake=sum(nums,target,i+1,dp);
        return dp[i][target]=Math.min(take,nottake);

    }
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int min=sum(coins,amount,0,dp);
        if(min==Integer.MAX_VALUE){
            return -1;
        }
        return min;
        
    }
}