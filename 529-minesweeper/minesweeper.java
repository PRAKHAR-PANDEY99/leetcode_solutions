
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m=board.length;
        int n=board[0].length;
        int r=click[0];
        int c=click[1];
        if(board[r][c]=='M'){
            board[r][c]='X';
            return board;
        }
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{r,c});
        board[r][c]='V';
        int[][] dir={{-1,-1},{-1,0},{-1,1},
        {0,-1},{0,1},{1,-1},{1,0},{1,1}};
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int x=curr[0];
            int y=curr[1];
            int count=0;
            List<int[]> list=new ArrayList<>();
            for(int[] d:dir){
                int nr=x+d[0];
                int nc=y+d[1];
                if(nr>=0 && nr<m && nc>=0 && nc<n){
                    if(board[nr][nc]=='M'){
                        count++;
                    }
                    else if(board[nr][nc]=='E'){
                        list.add(new int[]{nr,nc});
                    }
                }
            }
            if(count==0){
                board[x][y]='B';
                for(int[] cell:list){
                    int nr=cell[0];
                    int nc=cell[1];
                    board[nr][nc]='V';
                    q.offer(new int[]{nr,nc});
                }
            }
            else{
                board[x][y]=(char)('0'+count);
            }
        }
        return board;
    }
}
