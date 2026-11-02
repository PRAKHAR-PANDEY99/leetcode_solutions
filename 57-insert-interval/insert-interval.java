class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list=new ArrayList<>();
        int m=newInterval[0];
        int n=newInterval[1];
        int i=0;
        while(i<intervals.length && intervals[i][1]<m){
            list.add(intervals[i]);
            i++;
        }
        while(i<intervals.length && intervals[i][0]<=n){
            m=Math.min(m,intervals[i][0]);
            n=Math.max(n,intervals[i][1]);
            i++;
        }
        list.add(new int[]{m,n});
        while(i<intervals.length){
            list.add(intervals[i]);
            i++;
        }
        return list.toArray(new int[list.size()][]);
    }
}