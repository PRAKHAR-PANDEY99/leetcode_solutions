class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> dir=new ArrayList<>();
        List<List<Integer>> und=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        for(int i=0;i<n;i++){
            dir.add(new ArrayList<>());
            und.add(new ArrayList<>());
        }
        for(int i=0;i<connections.length;i++){
            int f=connections[i][0];
            int s=connections[i][1];
            dir.get(f).add(s);
            und.get(f).add(s);
            und.get(s).add(f);
        }
        int[] vis=new int[n];
        vis[0]=1;
        int c=0;
        while(!q.isEmpty()){
            int node=q.poll();
            for(int i:dir.get(node)){
                if(vis[i]!=1){
                    c++;
                }
               
            }
            for(int i:und.get(node)){
                if(vis[i]!=1){
                    q.offer(i);
                    vis[i]=1;
                }
            }

        }
        return c;
        
    }
}