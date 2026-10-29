class Solution {
    int fn(int r1,int c1, int r2,int c2,int[][] grid,int[][][][] dp){
        if(r1==grid.length-1 && r2==grid.length-1 && c1>=0 && c1<grid[0].length && c2>=0 && c2<grid[0].length){
            if(c1==c2){
                return grid[r1][c1];
            }
            else{
                return grid[r1][c1]+grid[r2][c2];
            }
        }
        if(r1>=grid.length ||   c1<0 || c1>=grid[0].length || r2>=grid.length || c2<0 || c2>=grid[0].length ){
            return 0;
        }
        if(dp[r1][c1][r2][c2]!=-1){
            return dp[r1][c1][r2][c2];
        }
        int a=0;
        int max=0;
        for(int move1=-1;move1<=1;move1++){
            for(int move2=-1;move2<=1;move2++){
            int r11=r1+1;
            int c11=c1+move1;
            int c22=c2+move2;
            if(c1==c2){
                a=grid[r1][c1]+fn(r1+1,c11,r2+1,c22,grid,dp);
            }
            else{
                a=grid[r1][c1]+grid[r2][c2]+fn(r1+1,c11,r2+1,c22,grid,dp);
            }
            max=Math.max(a,max);
            }
        } 
        return dp[r1][c1][r2][c2]=max;  
    }
    public int cherryPickup(int[][] grid) {
        int[][][][] dp=new int[grid.length][grid[0].length][grid.length][grid[0].length];
        

for(int i=0;i<grid.length;i++){
    for(int j=0;j<grid[0].length;j++){
        for(int k=0;k<grid.length;k++){
            Arrays.fill(dp[i][j][k],-1);
        }
    }
}
//Questio Checl
        
        int ans=fn(0,0,0,grid[0].length-1,grid,dp);
        return ans;
    }
        
    }








