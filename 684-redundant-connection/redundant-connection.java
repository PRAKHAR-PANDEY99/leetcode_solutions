class Solution {
    class DSU {
        int[] parent;
        int[] size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];

            for(int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if(parent[x] == x) {
                return x;
            }

            return parent[x] = find(parent[x]);
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if(pa == pb) return;

            if(size[pa] < size[pb]) {
                parent[pa] = pb;
                size[pb] += size[pa];
            } else {
                parent[pb] = pa;
                size[pa] += size[pb];
            }
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;

        DSU dsu = new DSU(n);

        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            if(dsu.find(a) == dsu.find(b)) {
                return edge;
            }

            dsu.union(a, b);
        }

        return new int[]{};
    }
}