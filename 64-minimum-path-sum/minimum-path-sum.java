class Solution {
    int fn(int[][] grid, int m, int n, int[][] dp) {
        if (m == 0 && n == 0) {
            return grid[0][0];
        }

        if (m < 0 || n < 0) {
            return (int) 1e9;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        int up = fn(grid, m - 1, n, dp);
        int left = fn(grid, m, n - 1, dp);

        dp[m][n] = grid[m][n] + Math.min(up, left);

        return dp[m][n];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return fn(grid, m - 1, n - 1, dp);
    }
}