class Solution {
    class Pair {
        int node, row, col;
        Pair(int node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> Integer.compare(a.node, b.node));
        q.offer(new Pair(grid[0][0], 0, 0));
        boolean[][] vis = new boolean[n][n];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {-1, 0, 1, 0};

        while (!q.isEmpty()) {
            Pair pp = q.poll();
            int node = pp.node, row = pp.row, col = pp.col;
            if (row == n - 1 && col == n - 1) return node;
            if (vis[row][col]) continue;
            vis[row][col] = true;

            for (int k = 0; k < 4; k++) {
                int rr = row + dr[k], cc = col + dc[k];
                if (rr >= 0 && rr < n && cc >= 0 && cc < n && !vis[rr][cc]) {
                    q.offer(new Pair(Math.max(node, grid[rr][cc]), rr, cc));
                }
            }
        }
        return -1;
    }
}
