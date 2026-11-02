class Solution {
    int fn(int i,int j,int count,int end1,int end2,int k,int[][] grid,int[][] vis){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==-1 || vis[i][j]==1){
            return 0;
        }
        if(i==end1 && j==end2){
            return count==k ? 1 : 0;
        }
        vis[i][j]=1;
        int up=0;
        int down=0;
        int left=0;
        int right=0;
        if(i-1>=0 && vis[i-1][j]!=1 && grid[i-1][j]!=-1){
            up=fn(i-1,j,count+1,end1,end2,k,grid,vis);
        }
        if(i+1<grid.length && vis[i+1][j]!=1 && grid[i+1][j]!=-1){
            down=fn(i+1,j,count+1,end1,end2,k,grid,vis);
        }
        if(j-1>=0 && vis[i][j-1]!=1 && grid[i][j-1]!=-1){
            left=fn(i,j-1,count+1,end1,end2,k,grid,vis);
        }
        if(j+1<grid[0].length && vis[i][j+1]!=1 && grid[i][j+1]!=-1){
            right=fn(i,j+1,count+1,end1,end2,k,grid,vis);
        }
        vis[i][j]=0;
        return left+up+right+down;
    }

    public int uniquePathsIII(int[][] grid) {
        int k=0;
        int s1=0;
        int s2=0;
        int end1=0;
        int end2=0;

        int[][] vis=new int[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    s1=i;
                    s2=j;
                    k++;
                }
                else if(grid[i][j]==0){
                    k++;
                }
                else if(grid[i][j]==2){
                    end1=i;
                    end2=j;
                    k++;
                }
            }
        }
        return fn(s1,s2,1,end1,end2,k,grid,vis);
    }
}