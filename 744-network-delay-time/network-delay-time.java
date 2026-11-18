class Solution {
    class Pair{
        int node;
        int dist;

        Pair(int node,int dist){
            this.node=node;
            this.dist=dist;
        }
    }

    void dfs(int i,int d,List<List<Pair>> adj,int[] dist){
        if(d>=dist[i]) return;

        dist[i]=d;

        for(Pair p:adj.get(i)){
            dfs(p.node,d+p.dist,adj,dist);
        }
    }

    public int networkDelayTime(int[][] times,int n,int k) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] t:times){
            adj.get(t[0]).add(new Pair(t[1],t[2]));
        }
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dfs(k,0,adj,dist);
        int ans=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            ans=Math.max(ans,dist[i]);
        }

        return ans;
    }
}