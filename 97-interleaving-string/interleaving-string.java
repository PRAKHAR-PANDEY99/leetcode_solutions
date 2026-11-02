
class Solution {
    boolean fn(int i,int j,int k,String s1,String s2,String s3,Boolean[][][] dp){
        if(k==s3.length()){
            return i==s1.length() && j==s2.length();
        }
        if(dp[i][j][k]!=null) return dp[i][j][k];
        boolean takes1=false;
        boolean takes2=false;
        if(i<s1.length() && s3.charAt(k)==s1.charAt(i)){
            takes1=fn(i+1,j,k+1,s1,s2,s3,dp);
        }
        if(j<s2.length() && s3.charAt(k)==s2.charAt(j)){
            takes2=fn(i,j+1,k+1,s1,s2,s3,dp);
        }
        return dp[i][j][k]=takes1 || takes2;
    }
    public boolean isInterleave(String s1,String s2,String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        Boolean[][][] dp=new Boolean[s1.length()+1][s2.length()+1][s3.length()+1];
        return fn(0,0,0,s1,s2,s3,dp);
    }
}
