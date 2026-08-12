import java.util.*;

class Solution {

    int findUPar(int node, ArrayList<Integer> parent) {
        if (parent.get(node) == node)
            return node;

        int ulp = findUPar(parent.get(node), parent);
        parent.set(node, ulp);
        return ulp;
    }

    void unionBySize(int u, int v, ArrayList<Integer> size, ArrayList<Integer> parent) {
        int ulp_u = findUPar(u, parent);
        int ulp_v = findUPar(v, parent);

        if (ulp_u == ulp_v)
            return;

        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }

    public int largestIsland(int[][] grid) {

        int n = grid.length;

        ArrayList<Integer> parent = new ArrayList<>();
        ArrayList<Integer> size = new ArrayList<>();

        for (int i = 0; i < n * n; i++) {
            parent.add(i);
            size.add(1);
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                if (grid[row][col] == 0)
                    continue;

                int node = row * n + col;

                for (int k = 0; k < 4; k++) {
                    int newRow = row + dr[k];
                    int newCol = col + dc[k];

                    if (newRow >= 0 && newRow < n &&
                        newCol >= 0 && newCol < n &&
                        grid[newRow][newCol] == 1) {

                        int adjNode = newRow * n + newCol;
                        unionBySize(node, adjNode, size, parent);
                    }
                }
            }
        }

        int ans = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                if (grid[row][col] == 1)
                    continue;

                HashSet<Integer> set = new HashSet<>();

                for (int k = 0; k < 4; k++) {
                    int newRow = row + dr[k];
                    int newCol = col + dc[k];

                    if (newRow >= 0 && newRow < n &&
                        newCol >= 0 && newCol < n &&
                        grid[newRow][newCol] == 1) {

                        int parentNode = findUPar(newRow * n + newCol, parent);
                        set.add(parentNode);
                    }
                }

                int totalSize = 1;

                for (int parentNode : set) {
                    totalSize += size.get(parentNode);
                }

                ans = Math.max(ans, totalSize);
            }
        }
        for (int i = 0; i < n * n; i++) {
            ans = Math.max(ans, size.get(findUPar(i, parent)));
        }

        return ans;
    }
}