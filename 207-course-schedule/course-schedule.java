class Solution {
    public boolean dfs(int node,
                        ArrayList<ArrayList<Integer>> adj,
                       boolean[] vis,
                       boolean[] pathVis)
    {
        vis[node] = true;
        pathVis[node] = true;

        for(Integer it : adj.get(node))
        {
            if(!vis[it])
            {
                if(dfs(it, adj, vis, pathVis))
                    return true;
            }
            else if(pathVis[it])
            {
                return true;
            }
        }

        pathVis[node] = false;

        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        for(int[] edge : prerequisites)
        {
            adj.get(edge[0]).add(edge[1]);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++)
        {
            if(!vis[i])
            {
                if(dfs(i, adj, vis, pathVis))
                    return false;
            }
        }

        return true;
    }
}