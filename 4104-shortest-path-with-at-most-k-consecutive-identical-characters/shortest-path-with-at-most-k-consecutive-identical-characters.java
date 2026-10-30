
class Solution {
    class Pair{
        int node;
        int dist;
        Pair(int node,int dist){
            this.node=node;
            this.dist=dist;
        }
    }

    class Pair2{
        int node;
        int dist;
        int freq;
        Pair2(int node,int dist,int freq){
            this.node=node;
            this.dist=dist;
            this.freq=freq;
        }
    }
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<List<Pair>> adj=new ArrayList<>();
        if(n==1) return 0;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0;i<edges.length;i++){
            int j=edges[i][0];
            int kk=edges[i][1];
            int d=edges[i][2];

            adj.get(j).add(new Pair(kk,d));
        }
        PriorityQueue<Pair2> q=new PriorityQueue<>((a,b)->Integer.compare(a.dist,b.dist));
        int[][] distt=new int[n][k+1];
        for(int i=0;i<n;i++){
            Arrays.fill(distt[i],Integer.MAX_VALUE);
        }
        distt[0][1]=0;
        q.offer(new Pair2(0,0,1));
        while(!q.isEmpty()){
            Pair2 p=q.poll();

            int node=p.node;
            int dist=p.dist;
            int freq=p.freq;
            if(dist!=distt[node][freq]) continue;
            char c=labels.charAt(node);
            for(Pair pp:adj.get(node)){
                int nodenew=pp.node;
                int distnew=pp.dist;
                char cc=labels.charAt(nodenew);
                int newFreq;
                if(c==cc){
                    newFreq=freq+1;
                }
                else{
                    newFreq=1;
                }
                if(newFreq<=k){
                    if(distt[nodenew][newFreq]>dist+distnew){
                        distt[nodenew][newFreq]=dist+distnew;
                        q.offer(new Pair2(nodenew,dist+distnew,newFreq));
                    }
                }
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            ans=Math.min(ans,distt[n-1][i]);
        }
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}
