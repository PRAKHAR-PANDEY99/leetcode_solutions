class Solution {
    int fn(int m,int n,int[][] dp){
        if(m==0 && n==0) return 1;
        if(m<0 || n<0) return 0;
        int row=m-1;
        int col=n-1;
        if(dp[m][n]!=0){
            return dp[m][n];
        }
        int left=fn(m,col,dp);
        if(m>=0 && col>=0){
            dp[m][col]=left;
        }
        int right=fn(row,n,dp);
        if(row>=0 && n>=0){
            dp[row][n]=right;
        }
        dp[m][n]=left+right;
        return dp[m][n];
    }
    
    public int uniquePaths(int m, int n) {
       int[][] dp=new int[m][n];
       int ans=fn(m-1,n-1,dp);
       return ans;
        
    }
}