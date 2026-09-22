class Solution {
    int len(int[] nums,int i,int prev,int[][] dp,int prevInd){
        if(i==nums.length){
            return 0;
        }
        int take=0;
        int nottake=0;
        if(dp[i][prevInd+1]!=-1){
            return dp[i][prevInd+1];
        }
        if(nums[i]>prev){
            take=Math.max(1+len(nums,i+1,nums[i],dp,i),len(nums,i+1,prev,dp,prevInd));
        }
        else{
            nottake=len(nums,i+1,prev,dp,prevInd);
        }
        return dp[i][prevInd+1]=Math.max(take,nottake);
    }
    public int lengthOfLIS(int[] nums) {
        int[][] dp=new int[nums.length][nums.length+1];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=len(nums,0,Integer.MIN_VALUE,dp,-1);
        return ans;
        
    }
}