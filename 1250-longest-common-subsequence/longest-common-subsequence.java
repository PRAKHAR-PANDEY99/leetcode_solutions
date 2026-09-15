class Solution {
    // int sub(String s1,String s2,int i1,int i2,int[][] dp){
    //     if(i1<0 || i2<0) return 0;
    //     if(dp[i1][i2]!=-1){
    //         return dp[i1][i2];
    //     }
    //     if(s1.charAt(i1)==s2.charAt(i2)){
    //         return dp[i1][i2]=1+sub(s1,s2,i1-1,i2-1,dp);
    //     }
    //     return dp[i1][i2]=Math.max(sub(s1,s2,i1-1,i2,dp),sub(s1,s2,i1,i2-1,dp));
    // }
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int[] prev=new int[m+1];
        int[] curr=new int[m+1];
        for(int i=0;i<=m;i++){
            prev[i]=0;  
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    curr[j]=1+prev[j-1];
                } 
                 else{
                    curr[j]=Math.max(prev[j],curr[j-1]);
                }
            }
            prev=curr;
            curr = new int[m + 1];
        }
        return prev[m];

        
    }
}