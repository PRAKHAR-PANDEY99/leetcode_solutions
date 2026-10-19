class Solution {
    class Pair {
        int i;
        int j;

        Pair(int i,int j) {
            this.i=i;
            this.j=j;
        }
    }

    public int[] lastVisitedCell(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int[][] vis=new int[m][n];
        Queue<Pair> q=new LinkedList<>();

        q.add(new Pair(0,0));
        vis[0][0]=1;

        while(!q.isEmpty()) {
            Pair p=q.poll();
            int i=p.i;
            int j=p.j;
            char c=grid[i][j];

            int ni=i;
            int nj=j;

            if(c=='U') {
                ni=i-1;
            }
            else if(c=='D') {
                ni=i+1;
            }
            else if(c=='L') {
                nj=j-1;
            }
            else if(c=='R') {
                nj=j+1;
            }

            if(ni<0 || ni>=m || nj<0 || nj>=n) {
                return new int[]{i,j};
            }

            if(vis[ni][nj]==1) {
                return new int[]{i,j};
            }

            vis[ni][nj]=1;
            q.offer(new Pair(ni,nj));
        }

        return new int[]{-1,-1};
    }
}