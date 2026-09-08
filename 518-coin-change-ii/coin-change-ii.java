class Solution {
    int sum(int[] nums,int target,int i,int[][] dp,int sum){
        if(target==0){
            return 1;
        }
        if(target>sum) return 0;
        if(i==nums.length){
            return 0;
        }
        if(dp[i][target]!=-1){
            return dp[i][target];
        }
        int take=0;
        int nottake=0;
        if(nums[i]<=target){
            take=sum(nums,target-nums[i],i,dp,sum);
        }
        nottake=sum(nums,target,i+1,dp,sum);
        return dp[i][target]=take+nottake;

    }
    public int change(int amount, int[] coins) {
        int sum=0;
        for(int i=0;i<coins.length;i++){
            sum=sum+coins[i];
        }
        int[][] dp=new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=sum(coins,amount,0,dp,amount);
        return ans;

        
    }
}