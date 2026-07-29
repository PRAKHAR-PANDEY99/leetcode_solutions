class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] incoming=new int[numCourses];
        List<List<Integer>> adj=new ArrayList<>();
        for(int j=0;j<numCourses;j++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites)
        {
            adj.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            for(Integer it: adj.get(i)){
                incoming[it]++;
            }
        }
        int[] ans=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(incoming[i]==0){
                q.offer(i);
            }
        }
        int index=0;
        while(!q.isEmpty()){
            int node=q.poll();
            ans[index++]=node;
            for(int it:adj.get(node)){
                incoming[it]--;
                if(incoming[it]==0){
                    q.offer(it);
                }
            }
            
        }
        if(index==numCourses) return ans;
        return new int[0];
        
    }
}