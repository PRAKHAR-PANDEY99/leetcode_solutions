
class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        Arrays.sort(citations);
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            q.add(citations[i]);
        }
        int[] c=new int[n+1];
        for(int i=1;i<=n;i++){
            while(q.peek()!=null && q.peek()<i){
                q.poll();
            }
            c[i]=q.size();
        }

        int max=0;
        for(int i=1;i<=n;i++){
            if(c[i]>=i){
                max=Math.max(max,i);
            }
        }

        return max;
    }
}
