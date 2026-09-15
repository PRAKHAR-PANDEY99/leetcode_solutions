class Solution {
    int sub(String s1,String s2,int i1,int i2,int[][] dp){
        if(i1<0 || i2<0) return 0;
        if(dp[i1][i2]!=-1){
            return dp[i1][i2];
        }
        if(s1.charAt(i1)==s2.charAt(i2)){
            return dp[i1][i2]=1+sub(s1,s2,i1-1,i2-1,dp);
        }
        return dp[i1][i2]=Math.max(sub(s1,s2,i1-1,i2,dp),sub(s1,s2,i1,i2-1,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=sub(text1,text2,text1.length()-1,text2.length()-1,dp);
        return ans;
        
    }
}