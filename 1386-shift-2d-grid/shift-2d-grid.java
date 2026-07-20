class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;
        int total = n * m;

        k %= total;
        List<Integer> list = new ArrayList<>();

        for (int[] row : grid) {
            for (int num : row) {
                list.add(num);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < m; j++) {

                int newIndex = i * m + j;
                int oldIndex = (newIndex - k + total) % total;

                row.add(list.get(oldIndex));
            }

            ans.add(row);
        }

        return ans;
    }
}