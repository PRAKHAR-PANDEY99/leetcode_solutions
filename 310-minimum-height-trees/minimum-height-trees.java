class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        if(n==1){
            return new ArrayList<>(Arrays.asList(0));
        }
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int [] dg=new int[n];
        for(int i=0;i<edges.length;i++){
            int f=edges[i][0];
            int s=edges[i][1];
            adj.get(f).add(s);
            adj.get(s).add(f);
            dg[f]++;
            dg[s]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(dg[i]==1){
                q.offer(i);
            }
        }
        int rem=n;
        while(rem>2){
            int s=q.size();
            rem=rem-s;
            for(int i=0;i<s;i++){
                int p=q.poll();
                for(int j:adj.get(p)){
                    dg[j]--;
                    if(dg[j]==1){
                        q.offer(j);
                    }

                }
            }
        }
        List<Integer> l=new ArrayList<>();
        while(!q.isEmpty()){
            l.add(q.poll());
        }
        return l;

    }
}