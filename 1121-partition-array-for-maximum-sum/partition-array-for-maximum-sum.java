class Solution {
    int fn(int i,int kk,int[] arr,int[] dp){
        if(i>=arr.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int maxi=Integer.MIN_VALUE;
        int max=0;
        int c=0;
        for(int k=i;k<i+kk;k++){
            c++;
            if(k<arr.length){
                max=Math.max(max,arr[k]);
            int maxii=max*c+fn(k+1,kk,arr,dp);
            maxi=Math.max(maxii,maxi);

            }

        }
        return  dp[i]=maxi;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[]dp=new int[arr.length];
        Arrays.fill(dp,-1);
        int ans=fn(0,k,arr,dp);
        return ans; 
    }
}