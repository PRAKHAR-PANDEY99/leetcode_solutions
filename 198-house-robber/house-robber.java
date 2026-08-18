class Solution {
    int  fn(int ind,int[] nums,int[] dp){
        if(ind==0) return nums[ind];
        if(ind<0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int pic=nums[ind]+fn(ind-2,nums,dp);
        int notpic=fn(ind-1,nums,dp);
        return dp[ind]=Math.max(pic,notpic);
    }
    public int rob(int[] nums) {
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp, -1);
        int sum=fn(nums.length-1,nums,dp);
        dp[0]=nums[0];
        
        return sum;
        
    }
}