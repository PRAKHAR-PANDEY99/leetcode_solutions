class Solution {
    class Pair{
        int node;
        int dist;
        Pair(int node,int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            int first=times[i][0];
            int second=times[i][1];
            int dis=times[i][2];
            adj.get(first).add(new Pair(second,dis));
        }
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->a.dist-b.dist);
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        q.offer(new Pair(k,0));
        while(!q.isEmpty()){
            Pair pp=q.poll();
            int node=pp.node;
            int distance=pp.dist;
            for(Pair it: adj.get(node)){
                if(dist[it.node]>distance+it.dist){
                    dist[it.node]=distance+it.dist;
                    q.offer(new Pair(it.node,distance+it.dist));
                }
            }
        }
        int max=-1;
        for(int i=1;i<=n;i++){
            if(max<dist[i]){
                max=dist[i];
            }

        }
        if(max==Integer.MAX_VALUE) return -1;
        return max;
        
    }
}