class Solution {
    class Pair{
        int node;
        int dist;
        int stops;
        Pair(int node,int dist,int stops){
            this.node=node;
            this.dist=dist;
            this.stops=stops;
        }
    }
    class Pair2{
        int node;
        int dist;
        Pair2(int node,int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair2>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            int first=flights[i][0];
            int second=flights[i][1];
            int dist=flights[i][2];
            adj.get(first).add(new Pair2(second,dist));

        }
        Queue<Pair> q=new LinkedList<>();
        int[] dis=new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        q.offer(new Pair(src,0,0));
        while(!q.isEmpty()){
            Pair pp=q.poll();
            int distance=pp.dist;
            int stop=pp.stops;
            for(Pair2 it: adj.get(pp.node)) {
                if(dis[it.node]>it.dist+distance && stop<=k){
                    dis[it.node]=it.dist+distance;
                     q.offer(new Pair(it.node,it.dist+distance,stop+1));
                }

            }
        }
        if(dis[dst]!=Integer.MAX_VALUE){
            return dis[dst];
        }
        return -1;
        
    }
}