class Solution {
    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int max = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    q.add(new Pair(i, j));
                    vis[i][j] = 1;
                    int area = 0;
                    while (!q.isEmpty()) {
                        Pair p = q.poll();
                        area++;
                        for (int k = 0; k < 4; k++) {
                            int nr = p.row + dr[k];
                            int nc = p.col + dc[k];
                            if (nr >= 0 && nr < m &&
                                nc >= 0 && nc < n &&
                                grid[nr][nc] == 1 &&
                                vis[nr][nc] == 0) {
                                q.add(new Pair(nr, nc));
                                vis[nr][nc] = 1;
                            }
                        }
                    }
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }
}