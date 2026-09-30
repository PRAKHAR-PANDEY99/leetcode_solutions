class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        int[]indegree=new int[n];

        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int f=edges[i][0];
            int s=edges[i][1];

            indegree[s]++;
            adj.get(s).add(f);
        }

        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        List<Integer> order=new ArrayList<>();

        // Topological order
        while(!q.isEmpty()){
            int curr=q.poll();
            order.add(curr);

            // Original outgoing edges are needed for topo
            for(int[] edge:edges){
                if(edge[0]==curr){
                    int next=edge[1];
                    indegree[next]--;

                    if(indegree[next]==0){
                        q.offer(next);
                    }
                }
            }
        }

        List<Set<Integer>> temp=new ArrayList<>();
        for(int i=0;i<n;i++){
            temp.add(new HashSet<>());
        }
        for(int curr:order){
            for(int j:adj.get(curr)){
                temp.get(curr).add(j);
                temp.get(curr).addAll(temp.get(j));
            }
        }

        List<List<Integer>> ans=new ArrayList<>();

        for(int i=0;i<n;i++){
            List<Integer> l=new ArrayList<>(temp.get(i));
            Collections.sort(l);
            ans.add(l);
        }

        return ans;
    }
}