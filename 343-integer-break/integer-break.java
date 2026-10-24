class Solution {
    int fn(int n,int k,int[] dp){
        if(n==0){
            return 1;
        }

        if(dp[n]!=0){
            return dp[n];
        }

        int max=0;

        for(int i=1;i<=n;i++){
            if(n-i==0 && k==0){
                continue;
            }

            max=Math.max(max,i*fn(n-i,k+1,dp));
        }

        return dp[n]=max;
    }

    public int integerBreak(int n){
        return fn(n,0,new int[n+1]);
    }
}