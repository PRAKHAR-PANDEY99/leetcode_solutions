class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q=new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<stones.length;i++){

            q.offer(stones[i]);
        }
        while(q.size()>=1){
            if(q.size()==1){
                return q.poll();
            }
            int max=q.poll();
            int a=q.poll();
            if(max==a){
                continue;
            }
            else{
                q.offer(max-a);
            }
              
        }
        return 0;

        
    }
}