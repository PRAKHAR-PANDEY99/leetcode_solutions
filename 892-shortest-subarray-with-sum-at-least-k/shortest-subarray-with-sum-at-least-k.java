class Solution {
    class Pair{
        int su;
        int id;
        Pair(int su,int id){
            this.su=su;
            this.id=id;
        }

    }
    public int shortestSubarray(int[] nums, int k) {
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->a.su-b.su);
        int sum=0;
        int minlen=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            if(sum>=k){
                minlen=Math.min(minlen,i+1);
            }
            int rem=sum-k;
            Pair kk;
            if(!q.isEmpty()){
                kk=q.peek();
            
            if(kk.su<=rem){
                while(!q.isEmpty() && q.peek().su<=rem){
                    minlen=Math.min(minlen,i-q.poll().id);
                }
            }
            }
            q.offer(new Pair(sum,i));
            

        }
        if(minlen==Integer.MAX_VALUE){
            return -1;
        }
        return minlen;
        
    }
}