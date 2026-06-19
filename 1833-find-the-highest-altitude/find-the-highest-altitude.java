class Solution {
    public int largestAltitude(int[] gain) {
        int c=0;
        int max=0;
        for(int i=0;i<gain.length;i++){
            c=c+gain[i];
            max=Integer.max(c,max);
        }
        return max;
        
    }
}