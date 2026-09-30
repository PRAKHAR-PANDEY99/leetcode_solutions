class Solution {
    class Pair{
        int i;
        int d;
        Pair(int i,int d){
            this.i=i;
            this.d=d;
        }
    }
    public long maximumImportance(int n, int[][] roads) {
        long ans=0;
        int [] d=new int[n];
        for(int i=0;i<roads.length;i++){
            int f=roads[i][0];
            int s=roads[i][1];
            d[f]++;
            d[s]++;
        }
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->b.d-a.d);
        for(int  i=0;i<n;i++){
            q.offer(new Pair(i,d[i]));
        }
        
        HashMap<Integer,Integer> map=new HashMap<>();
        int l=n;
        while(!q.isEmpty()){
            Pair p=q.poll();
            int f=p.i;
            int s=p.d;
            map.put(f,l);
            l--;
        }
        for(int i=0;i<roads.length;i++){
            int f=roads[i][0];
            int s=roads[i][1];
            ans=ans+map.get(f)+map.get(s);

        }
        return ans;
        
    }
}