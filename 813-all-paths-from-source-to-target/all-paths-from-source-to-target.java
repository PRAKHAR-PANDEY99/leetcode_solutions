class Solution {
    void dfs(int[][] graph,int i,List<Integer> path,List<List<Integer>> list){
        path.add(i);
        if(i==graph.length-1){
            list.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }
        for(int j:graph[i]){
            dfs(graph,j,path,list);
        }
        path.remove(path.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list=new ArrayList<>();
        dfs(graph,0,new ArrayList<>(),list);
        return list;


        
    }
}