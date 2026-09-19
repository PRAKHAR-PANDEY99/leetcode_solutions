class Solution {
    int sum(String s,String t,int i,int j,int[][] dp){
        if(i==s.length() || j==t.length()){
            if(j==t.length()){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int take1=0;
        int take2=0;
        int nottake=0;
        if(s.charAt(i)==t.charAt(j)){
            take1=sum(s,t,i+1,j+1,dp);
            take2=sum(s,t,i+1,j,dp);
            return  dp[i][j]=take1+take2;
        }
        else{
            nottake=sum(s,t,i+1,j,dp);
            return dp[i][j]=nottake;
        }
    }
    public int numDistinct(String s, String t) {
        int[][] dp=new int[s.length()][t.length()];
        for(int i=0;i<s.length();i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=sum(s,t,0,0,dp);
        return ans;
           
    }
}