class Solution {
    int fn(int m,int n,int[][] dp){
        if(m==0 && n==0) return 1;
        if(m<0 || n<0) return 0;
        int row=m-1;
        int col=n-1;
        if(dp[m][n]!=-1){
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
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
    return 0;
}
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<obstacleGrid.length;i++){
            for(int j=0;j<obstacleGrid[0].length;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }
            }
        }
        int ans=fn(m-1,n-1,dp);
        return ans;
        
    }
}