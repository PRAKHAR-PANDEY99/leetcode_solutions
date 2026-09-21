class Solution {
    int max(int[] prices,int i,int buy,int c,int[][][] dp){
        if(c==2){
            return 0;
        }
        if(i==prices.length){
            return 0;
        }
        if(dp[i][buy][c]!=-1){
            return dp[i][buy][c];
        }
        int profit=0;
        if(buy==1){
            profit=Math.max(-prices[i]+max(prices,i+1,0,c,dp),max(prices,i+1,1,c,dp));

        }
        else{
            profit=Math.max(prices[i]+max(prices,i+1,1,c+1,dp),max(prices,i+1,0,c,dp));
        }
        return dp[i][buy][c]=profit;
    }
    public int maxProfit(int[] prices) {
        int[][][] dp=new int[prices.length][2][2];
        for(int i=0;i<prices.length;i++){
            Arrays.fill(dp[i][0],-1);
            Arrays.fill(dp[i][1],-1);
        }
        int ans=max(prices,0,1,0,dp);
        return ans;
        
    }
}