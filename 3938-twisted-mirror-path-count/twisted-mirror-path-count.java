class Solution {
    int mod=1000000007;

    int fn(int i,int j,int[][] grid,int pos,int[][][] dp){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length){
            return 0;
        }
        if(i==grid.length-1 && j==grid[0].length-1){
            return 1;
        }
        if(dp[i][j][pos]!=-1){
            return dp[i][j][pos];
        }

        int right=0;
        int down=0;

        if(grid[i][j]==1 && pos==0){
            down=fn(i+1,j,grid,1,dp);
        }
        else if(grid[i][j]==1 && pos==1){
            right=fn(i,j+1,grid,0,dp);
        }
        else{
            down=fn(i+1,j,grid,1,dp);
            right=fn(i,j+1,grid,0,dp);
        }

        return dp[i][j][pos]=(down+right)%mod;
    }

    public int uniquePaths(int[][] grid) {
        int[][][] dp=new int[grid.length+1][grid[0].length+1][3];

        for(int i=0;i<=grid.length;i++){
            for(int j=0;j<=grid[0].length;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }

        return fn(0,0,grid,2,dp);
    }
}