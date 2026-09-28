class Solution {
    void dfs(List<List<Integer>> adj,int i,int[] vis,int[] ans,int[] quiet){
        if(vis[i]==1) return;

        vis[i]=1;

        int min=i;

        for(int j:adj.get(i)){
            dfs(adj,j,vis,ans,quiet);

            if(quiet[ans[j]]<quiet[min]){
                min=ans[j];
            }
        }

        ans[i]=min;
    }

    public int[] loudAndRich(int[][] richer,int[] quiet){
        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<quiet.length;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<richer.length;i++){
            int f=richer[i][0];
            int s=richer[i][1];

            adj.get(s).add(f);
        }

        int[] ans=new int[quiet.length];
        int[] vis=new int[quiet.length];

        for(int i=0;i<quiet.length;i++){
            if(vis[i]!=1){
                dfs(adj,i,vis,ans,quiet);
            }
        }

        return ans;
    }
}