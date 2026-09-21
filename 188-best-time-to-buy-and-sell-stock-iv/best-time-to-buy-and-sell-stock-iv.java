class Solution {
    int  sum(int[] prices,int i,int buy,int k,int kcheck,int[][][] dp){
        if(k==kcheck){
            return 0;
        }
        if(i==prices.length){
            return 0;
        }
        if(dp[i][buy][k]!=-1){
            return dp[i][buy][k];
        }
        int profit=0;
        if(buy==1){
            profit=Math.max(-prices[i]+sum(prices,i+1,0,k,kcheck,dp),sum(prices,i+1,1,k,kcheck,dp));
        }
        else{
            profit=Math.max(prices[i]+sum(prices,i+1,1,k+1,kcheck,dp),sum(prices,i+1,0,k,kcheck,dp));
        }
        return dp[i][buy][k]=profit;
    }
    public int maxProfit(int k, int[] prices) {
        int[][][] dp=new int[prices.length][2][k];
        for(int i=0;i<prices.length;i++){
            Arrays.fill(dp[i][0],-1);
            Arrays.fill(dp[i][1],-1);
        }
        int ans=sum(prices,0,1,0,k,dp);
        return ans;
        
    }
}