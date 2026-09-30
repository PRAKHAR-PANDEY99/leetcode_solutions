class Solution {
    void dfs(int i,List<List<Integer>> adj,int[] vis,HashSet<Integer> set){
        if(vis[i]==1) return;

        set.add(i);
        vis[i]=1;

        for(int j:adj.get(i)){
            dfs(j,adj,vis,set);
        }
    }

    public long countPairs(int n,int[][] edges){
        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int f=edges[i][0];
            int s=edges[i][1];

            adj.get(f).add(s);
            adj.get(s).add(f);
        }

        long ans=0;
        int[] vis=new int[n];
        int nn=n;

        for(int i=0;i<n;i++){
            if(vis[i]!=1){
                HashSet<Integer> set=new HashSet<>();

                dfs(i,adj,vis,set);

                int s=set.size();

                ans=ans+(long)s*(nn-s);

                nn=nn-s;
            }
        }

        return ans;
    }
}