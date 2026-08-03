class Solution {
    class Pair{
        int row;
        int col;
        int dist;
        Pair(int row,int col,int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<Pair> q= new LinkedList<>();
        if(grid[0][0]==1){
            return -1;
        }
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1,  0,  1, -1, 1, -1, 0, 1};
        q.add(new Pair(0,0,1));
        
        int[][] vis=new int[grid.length][grid.length];
        vis[0][0]=2;
        while(!q.isEmpty()){
            Pair pp=q.poll();
            int r=pp.row;
            int c=pp.col;
            if(r==grid.length-1 && c==grid.length-1){
                return pp.dist;
            }
            for(int i=0;i<8;i++){
                int rr= r+dr[i];
                int cc=c+dc[i];
                if(rr>=0 && rr<grid.length && cc>=0 && cc<grid.length && vis[rr][cc]!=2){
                    if(grid[rr][cc]==0){
                        q.offer(new Pair(rr,cc,pp.dist+1));
                        vis[rr][cc]=2;
                    }

                }
            }
        }
        return -1;

        
    }
}