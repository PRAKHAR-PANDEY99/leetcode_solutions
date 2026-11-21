class Solution {
    ArrayList<Integer>[] adj;
    HashMap<Character,Integer> map=new HashMap<>();
    int[] par;
    int[] ans;

    void dfs(int node,String s){
        char ch=s.charAt(node);
        int old=map.getOrDefault(ch,-1);

        if(old!=-1){
            par[node]=old;
        }

        map.put(ch,node);

        for(int child:adj[node]){
            dfs(child,s);
        }

        if(old==-1)map.remove(ch);
        else map.put(ch,old);
    }

    void dfs2(int node,ArrayList<Integer>[] adj2){
        ans[node]=1;

        for(int child:adj2[node]){
            dfs2(child,adj2);
            ans[node]+=ans[child];
        }
    }

    public int[] findSubtreeSizes(int[] parent,String s) {
        int n=parent.length;

        adj=new ArrayList[n];
        for(int i=0;i<n;i++)adj[i]=new ArrayList<>();

        for(int i=1;i<n;i++){
            adj[parent[i]].add(i);
        }

        par=parent.clone();

        dfs(0,s);

        ArrayList<Integer>[] adj2=new ArrayList[n];
        for(int i=0;i<n;i++)adj2[i]=new ArrayList<>();

        for(int i=1;i<n;i++){
            adj2[par[i]].add(i);
        }

        ans=new int[n];
        dfs2(0,adj2);

        return ans;
    }
}