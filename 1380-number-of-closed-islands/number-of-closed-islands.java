class Solution {
    class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        Queue<Pair> q = new LinkedList<>();
        int area = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0 && vis[i][j] == 0) {

                    boolean closed = true;

                    q.add(new Pair(i, j));
                    vis[i][j] = 1;
                    while (!q.isEmpty()) {
                        Pair p = q.poll();
                        if (p.row == 0 || p.row == m - 1 ||
                            p.col == 0 || p.col == n - 1) {
                            closed = false;
                        }
                        for (int k = 0; k < 4; k++) {
                            int nr = p.row + dr[k];
                            int nc = p.col + dc[k];
                            if (nr >= 0 && nr < m &&
                                nc >= 0 && nc < n &&
                                grid[nr][nc] == 0 &&
                                vis[nr][nc] == 0) {
                                q.add(new Pair(nr, nc));
                                vis[nr][nc] = 1;
                            }
                        }
                    }
                    if (closed) {
                        area++;
                    }
                }
            }
        }
        return area;
    }
}