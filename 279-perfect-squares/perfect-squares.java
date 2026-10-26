class Solution {
    int fn(int n,int[] dp){
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int min=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            if(n-(i*i)<=n){
                int count=1+fn(n-(i*i),dp);
                min=Math.min(min,count);
            }
        }
        if(min==Integer.MAX_VALUE){
            return dp[n]=0;
        }
        return dp[n]=min;

    }
    public int numSquares(int n){
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        int ans=fn(n,dp);
        return ans;
        
    }
}