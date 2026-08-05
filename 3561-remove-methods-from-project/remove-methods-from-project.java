class Solution {
    void dfs(int node,int[] vis,List<List<Integer>> adj){
        vis[node]=1;
        for(int it:adj.get(node)){
            if(vis[it]!=1){
                dfs(it,vis,adj);
            }
            
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<invocations.length;i++){
            int first=invocations[i][0];
            int second=invocations[i][1];
            adj.get(first).add(second);
        }
        int[] vis=new int[n];
        List<Integer> list=new ArrayList<>();
        dfs(k,vis,adj);
        int c=0;
        for(int i=0;i<vis.length;i++){
            if(vis[i]==0){
                for(int it:adj.get(i)){
                    if(vis[it]==1){
                        c=1;
                        break;
                        
                    }
                }
            }
        }
        if(c==1){
            for(int i=0;i<n;i++){
                list.add(i);
            }
        }
        if(c==1){
            return list;
        }
        for(int i=0;i<vis.length;i++){
            if(vis[i]==0){
                list.add(i);
            }

        }
        return list;
        

        
    }
}