class Solution {
    boolean ans=false;
    boolean dfs(String s,List<String> dict,int i,Boolean[] dp){
        if(i==s.length()){
            return true;
        }
        if(dp[i]!=null){
            return dp[i];
        }
        boolean ans=false;
        for(int j=0;j<dict.size();j++){
            if(s.length()>=i+dict.get(j).length()){
            if(s.substring(i,i+dict.get(j).length()).equals(dict.get(j))){
                if(dfs(s,dict,i+dict.get(j).length(),dp)==true){
                    return true;
                }
            
            }
            }
        }
        return dp[i]=ans;
 
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp=new Boolean[s.length()];
        boolean ans=dfs(s,wordDict,0,dp);
        return ans;
        
    }
}