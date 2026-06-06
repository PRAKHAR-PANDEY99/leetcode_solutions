class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum=0;
        for(int i=0;i<k;i++){
            sum=sum+cardPoints[i];
        }
        int l=cardPoints.length-1;
        int max=sum;
        for(int j=k-1;j>=0;j--){
            sum=sum-cardPoints[j]+cardPoints[l];
            l--;
            max=Integer.max(max,sum);  
        }
        return max;
        
    }
}