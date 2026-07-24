class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int numEnclaves(int[][] grid) {
         Queue<Pair> q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        int[][] vis=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                vis[i][j]=0;
                if( grid[i][j]==1 &&  i==0){
                    q.offer(new Pair(i,j));
                }
                else if(i>0 && i!=m-1 && j==0 && grid[i][j]==1){
                    q.offer(new Pair(i,j));
                }
                else if(i>0 && i!=m-1 && j==n-1 && grid[i][j]==1){
                    q.offer(new Pair(i,j));

                }
                else if(i==m-1 && grid[i][j]==1){
                    q.offer(new Pair(i,j));
                }
        }
        }
        int[] dr={1,-1,0,0};
        int [] dc={0,0,-1,1};
        while(!q.isEmpty()){
            Pair pp=q.poll();
            int r=pp.row;
            int c=pp.col;
            vis[r][c]=1;
            for(int j=0;j<4;j++){
                int rr = r + dr[j];
                int cc = c + dc[j];

                if (rr >= 0 && rr < m &&
                    cc >= 0 && cc < n &&
                    vis[rr][cc] == 0 && grid[rr][cc]==1){
                        vis[rr][cc]=1;
                        q.offer(new Pair(rr,cc));

                    }
            }
        }
        int c=0;
        int c1=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    c1=c1+1;
                }
                if(vis[i][j]==1){
                    c=c+1;
                }
            }
        }
        return c1-c;
        
    }
}