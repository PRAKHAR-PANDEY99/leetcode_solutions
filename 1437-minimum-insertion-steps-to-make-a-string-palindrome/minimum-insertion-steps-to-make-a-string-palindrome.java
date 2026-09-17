class Solution {
    int sum(String s,int i,int j,int[][] dp){
        if(i>=j){
             return dp[i][j]=0;
        }
        if(i>=s.length() || j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int LeftTake=0;
        int RightTake=0;
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]=sum(s,i+1,j-1,dp);
        }
        else{
            LeftTake=sum(s,i+1,j,dp);
            RightTake=sum(s,i,j-1,dp);
            return dp[i][j]=1+Math.min(LeftTake,RightTake);
        }
    }
    public int minInsertions(String s) {
        int[][] dp=new int[s.length()+1][s.length()+1];
        for(int i=0;i<s.length();i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=sum(s,0,s.length()-1,dp);

        return ans;
    }
}