class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int countIslands(int[][] grid, int k) {
        int[][] vis=new int[grid.length][grid[0].length];
        int count=0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]!=0 && vis[i][j]==0){
                    vis[i][j]=1;
                    long sum=grid[i][j];
                    q.offer(new Pair(i,j));
                    while(!q.isEmpty()){
                        Pair p=q.poll();
                        int row=p.row;
                        int col=p.col;
                        for(int kk=0;kk<4;kk++){
                            int r=row+dr[kk];
                            int c=col+dc[kk];
                            if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && vis[r][c]!=1 && grid[r][c]!=0){
                                q.offer(new Pair(r,c));
                                vis[r][c]=1;
                                sum=sum+grid[r][c];
                            }
                        }
                    }
                    if(sum%k==0){
                        count=count+1;
                    }

                }
                
            }
        }
        return count;
    
    }
}