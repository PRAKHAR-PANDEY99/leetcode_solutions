class Solution {
    int climb(int n,int[] dp){
        if(n==1) return dp[1]=1;
        if(n==2) return dp[2]=2;
        if(dp[n]!=0) return dp[n];
        return dp[n]=climb(n-1,dp)+climb(n-2,dp);
    }
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        return climb(n,dp);
        

        
    }
}