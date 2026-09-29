class Solution {
    boolean dfs(char[][] grid,int row,int col,int c,Boolean[][][] dp){
        if(c<0){
            return false;
        }

        if(row==0 && col==0){
            if(grid[row][col]==')'){
                c++;
            }
            else{
                c--;
            }
            return c==0;
        }

        if(row<0 || col<0){
            return false;
        }

        if(dp[row][col][c]!=null){
            return dp[row][col][c];
        }

        boolean up=false;
        boolean left=false;

        if(grid[row][col]==')'){
            up=dfs(grid,row-1,col,c+1,dp);
            left=dfs(grid,row,col-1,c+1,dp);
        }
        else{
            up=dfs(grid,row-1,col,c-1,dp);
            left=dfs(grid,row,col-1,c-1,dp);
        }

        dp[row][col][c]=up || left;

        return dp[row][col][c];
    }

    public boolean hasValidPath(char[][] grid) {
        Boolean[][][] dp=new Boolean[grid.length][grid[0].length][grid.length+grid[0].length];

        boolean ans=dfs(grid,grid.length-1,grid[0].length-1,0,dp);

        return ans;
    }
}