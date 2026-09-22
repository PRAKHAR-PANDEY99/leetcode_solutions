class Solution {
    int count(int n,int[] dp) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int total = 0;
        for (int i = 1; i <= n; i++) {
            int left = count(i - 1,dp);
            int right = count(n - i,dp);
            total += left * right;
        }
        return dp[n]=total;
    }
    public int numTrees(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return count(n,dp);
    }
}