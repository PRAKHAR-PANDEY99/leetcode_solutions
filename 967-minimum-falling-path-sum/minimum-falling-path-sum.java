class Solution {
    int fn(int i,int j,int[][] matrix,int[][] dp){
        if(j<0 || j>=matrix[0].length){
            return 1000000000;
        }

        if(dp[i][j]!=Integer.MAX_VALUE){
            return dp[i][j];
        }

        if(i==matrix.length-1){
            return dp[i][j]=matrix[i][j];
        }

        int s1=matrix[i][j]+fn(i+1,j-1,matrix,dp);
        int s2=matrix[i][j]+fn(i+1,j,matrix,dp);
        int s3=matrix[i][j]+fn(i+1,j+1,matrix,dp);

        int sum=Math.min(s1,s2);
        sum=Math.min(sum,s3);

        return dp[i][j]=sum;
    }

    public int minFallingPathSum(int[][] matrix){
        int n=matrix.length;
        int[][] dp=new int[n][n];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

        int ans=Integer.MAX_VALUE;

        for(int j=0;j<n;j++){
            ans=Math.min(ans,fn(0,j,matrix,dp));
        }

        return ans;
    }
}