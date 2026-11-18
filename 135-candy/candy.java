
class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int[] cnd=new int[n];
        Arrays.fill(cnd,1);
        PriorityQueue<int[]> pq=new PriorityQueue<>(
            (a,b)->Integer.compare(a[0],b[0])
        );
        for(int i=0;i<n;i++){
            pq.offer(new int[]{ratings[i],i});
        }
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int id=curr[1];
            if(id>0 && id<n-1 && ratings[id]>ratings[id-1] && ratings[id]>ratings[id+1]){
                cnd[id]=Math.max(cnd[id-1],cnd[id+1])+1;
            }
            else if(id>0 && ratings[id]>ratings[id-1]){
                cnd[id]=cnd[id-1]+1;
            }
            else if(id<n-1 && ratings[id]>ratings[id+1]){
                cnd[id]=cnd[id+1]+1;
            }
        }
        int sum=0;
        for(int c:cnd){
            sum+=c;
        }
        return sum;
    }
}
