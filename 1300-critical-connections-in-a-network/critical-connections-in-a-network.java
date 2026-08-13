class Solution {
    int t = 0;
    void dfs(int node, int parent, List<List<Integer>> adj, int[] time, int[] lowtime, int[] vis, List<List<Integer>> list) {
        vis[node] = 1;
        time[node] = lowtime[node] = t++;
        for (int it : adj.get(node)) {
            if (it == parent) continue;
            if (vis[it] == 0) {
                dfs(it, node, adj, time, lowtime, vis, list);
                lowtime[node] = Math.min(lowtime[node], lowtime[it]);
                if (lowtime[it] > time[node]) {
                    list.add(Arrays.asList(node, it)); // edge is a bridge
                }
            } else {
                lowtime[node] = Math.min(lowtime[node], time[it]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] time = new int[n];
        int[] lowtime = new int[n];
        int[] vis = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> it : connections) {
            int f = it.get(0);
            int s = it.get(1);
            adj.get(f).add(s);
            adj.get(s).add(f);
        }

        List<List<Integer>> list = new ArrayList<>();
        dfs(0, -1, adj, time, lowtime, vis, list);
        return list;
    }
}
