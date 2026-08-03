import java.util.*;

class Solution {
    class Pair {
        int row;
        int col;
        int effort;

        Pair(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.effort, b.effort)
        );

        int[][] dis = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }

        dis[0][0] = 0;
        pq.offer(new Pair(0, 0, 0));

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!pq.isEmpty()) {
            Pair pp = pq.poll();

            int row = pp.row;
            int col = pp.col;
            int effort = pp.effort;

            if (row == n - 1 && col == m - 1) {
                return effort;
            }

            for (int i = 0; i < 4; i++) {
                int rr = row + dr[i];
                int cc = col + dc[i];

                if (rr >= 0 && rr < n && cc >= 0 && cc < m) {

                    int diff = Math.abs(heights[row][col] - heights[rr][cc]);

                    int newEffort = Math.max(effort, diff);

                    if (newEffort < dis[rr][cc]) {
                        dis[rr][cc] = newEffort;
                        pq.offer(new Pair(rr, cc, newEffort));
                    }
                }
            }
        }

        return 0;
    }
}