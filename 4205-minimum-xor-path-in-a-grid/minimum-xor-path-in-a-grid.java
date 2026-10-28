import java.util.*;

class Solution {
    boolean[][][] dp;

    boolean[] fn(int[][] grid,int i,int j){
        if(i>=grid.length || j>=grid[0].length){
            return new boolean[1024];
        }

        if(dp[i][j]!=null){
            return dp[i][j];
        }
        boolean[] ans=new boolean[1024];

        if(i==grid.length-1 && j==grid[0].length-1){
            ans[grid[i][j]]=true;
            return dp[i][j]=ans;
        }

        boolean[] right=fn(grid,i,j+1);
        boolean[] down=fn(grid,i+1,j);

        for(int k=0;k<1024;k++){
            if(right[k]){
                ans[grid[i][j]^k]=true;
            }
            if(down[k]){
                ans[grid[i][j]^k]=true;
            }
        }

        dp[i][j]=ans;
        return ans;
    }

    public int minCost(int[][] grid){
        dp=new boolean[grid.length][grid[0].length][];

        boolean[] ans=fn(grid,0,0);

        for(int i=0;i<1024;i++){
            if(ans[i]){
                return i;
            }
        }

        return 0;
    }
}