class Solution {
    class Pair {
        int row;
        int col;
        int dist;

        Pair(int row,int col,int dist) {
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
    public int maxDistance(int[][] grid) {
        Queue<Pair> q=new LinkedList<>();
        int [][] vis=new int[grid.length][grid.length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[i][j]==1){
                    vis[i][j]=1;
                    q.offer(new Pair(i,j,0));
                }
            }
        }
        int[] row={-1,0,1,0};
        int[] col={0,1,0,-1};
        int dist=-1;
        while(!q.isEmpty()){
            Pair pp=q.poll();
            int r=pp.row;
            int c=pp.col;
            dist=Math.max(dist,pp.dist);
            for(int k=0;k<4;k++){
                int rr=r+row[k];
                int cc=c+col[k];
                if(rr>=0 && rr<grid.length && cc>=0 && cc<grid.length  && vis[rr][cc]!=1){
                    q.offer(new Pair(rr,cc,pp.dist+1));
                    vis[rr][cc]=1;
                }
            }

        }
        if(dist==0){
            return -1;
        }
        return dist;
    }
        
    }
