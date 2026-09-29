class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int []in=new int[n];
        for(int i=0;i<edges.size();i++){
            int f=edges.get(i).get(0);
            int s=edges.get(i).get(1);
            in[s]++;
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(in[i]==0){
                ans.add(i);            }

        }
        return ans;
        
    }
}