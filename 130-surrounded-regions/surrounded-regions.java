class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public void solve(char[][] board) {
        Queue<Pair> q=new LinkedList<>();
        int m=board.length;
        int n=board[0].length;
        char[][] vis=new char[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                vis[i][j]='X';
                if( board[i][j]=='O' &&  i==0){
                    q.offer(new Pair(i,j));
                }
                else if(i>0 && i!=m-1 && j==0 && board[i][j]=='O' ){
                    q.offer(new Pair(i,j));
                }
                else if(i>0 && i!=m-1 && j==n-1 && board[i][j]=='O' ){
                    q.offer(new Pair(i,j));

                }
                else if(i==m-1 && board[i][j]=='O' ){
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
            vis[r][c]='O';
            for(int j=0;j<4;j++){
                int rr = r + dr[j];
                int cc = c + dc[j];

                if (rr >= 0 && rr < m &&
                    cc >= 0 && cc < n &&
                    vis[rr][cc] == 'X' && board[rr][cc]=='O'){
                        vis[rr][cc]='O';
                        q.offer(new Pair(rr,cc));

                    }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j]=vis[i][j];
            }
        }
        return;

    }
}