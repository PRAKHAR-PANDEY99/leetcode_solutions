class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int numIslands(char[][] grid) {
        Queue<Pair> q=new LinkedList<>();
        int c1=0;
        int[] dr={1,-1,0,0};
        int[] dc={0,0,-1,1};
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    c1=c1+1;
                    grid[i][j]='0';
                    q.add(new Pair(i,j));
                        while(!q.isEmpty()){
                            Pair pp=q.poll();
                            int r=pp.row;
                            int c=pp.col;
                            for(int k=0;k<4;k++){
                                int rr=r+dr[k];
                                int cc=c+dc[k];
                                if (rr >= 0 && rr < grid.length && cc >= 0 && cc < grid[0].length && grid[rr][cc]=='1'){
                                    grid[rr][cc]='0';
                                    q.add(new Pair(rr,cc));
                                }
                            }

                        }
                }
            }
        }
        return c1;

        
    }
}