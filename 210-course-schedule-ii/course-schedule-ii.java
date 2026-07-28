import java.util.*;

class Solution {

    boolean dfs(int node, ArrayList<ArrayList<Integer>> adj,
                boolean[] vis, boolean[] pathVis,
                ArrayList<Integer> ans) {

        vis[node] = true;
        pathVis[node] = true;

        for (int it : adj.get(node)) {

            if (!vis[it]) {
                if (dfs(it, adj, vis, pathVis, ans))
                    return true;
            }
            else if (pathVis[it]) {
                return true; // cycle exists
            }
        }

        // store after completing all dependencies
        ans.add(node);

        pathVis[node] = false;

        return false;
    }


    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }


        // prerequisite -> course
        for (int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]);
        }


        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];

        ArrayList<Integer> ans = new ArrayList<>();


        for (int i = 0; i < numCourses; i++) {

            if (!vis[i]) {

                if (dfs(i, adj, vis, pathVis, ans)) {
                    return new int[0]; // cycle exists
                }

            }
        }


        // reverse because DFS gives reverse topological order
        Collections.reverse(ans);


        int[] result = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}