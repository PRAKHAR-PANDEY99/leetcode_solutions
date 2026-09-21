class Solution {
    int sum(int[] prices,int i,int buy,int[][] dp,int fee){
        if(i==prices.length){
            return 0;
        }
        if(dp[i][buy]!=-1){
            return dp[i][buy];
        }
        int profit=0;
        if(buy==1){
            profit=Math.max(-prices[i]+sum(prices,i+1,0,dp,fee),0+sum(prices,i+1,1,dp,fee));
        }
        else{
            profit=Math.max(prices[i]-fee+sum(prices,i+1,1,dp,fee),0+sum(prices,i+1,0,dp,fee));
        }
        return dp[i][buy]=profit;
    }
    public int maxProfit(int[] prices, int fee) {
        int[][] dp=new int[prices.length][2];
        for(int i=0;i<prices.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=sum(prices,0,1,dp,fee);

        return ans;
    }
}