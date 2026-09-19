class Solution {
    boolean dfs(String s,String p,int i,int j,Boolean[][] dp){
        if(j==p.length() && i==s.length()){
                return true;
            }
        if(j==p.length() && i!=s.length()){
            return false;
        }
        if(i == s.length()){
    for(int k=j;k<p.length();k++){
        if(p.charAt(k) != '*'){
            return false;
        }
    }
    return true;
}
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        boolean match=false;
        boolean not2=false;
        boolean not3=false;
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
            match=dfs(s,p,i+1,j+1,dp);
            return dp[i][j]=match;
        }
        else if(p.charAt(j)=='*'){
            not2=dfs(s,p,i,j+1,dp);
            not3=dfs(s,p,i+1,j,dp);
            return  dp[i][j]=not2 || not3;

        }
        else{
            return dp[i][j]=false;
        }

    }
    public boolean isMatch(String s, String p) {
        Boolean[][] dp=new Boolean[s.length()][p.length()];
        boolean ans=dfs(s,p,0,0,dp);
        return ans;
        
    }
}