class Solution {
    boolean palindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    int fn(int i,String s,int[] dp){
        if(i==s.length()){
            return -1;
        }

        if(dp[i]!=-1){
            return dp[i];
        }

        int min=Integer.MAX_VALUE;

        for(int k=i;k<s.length();k++){
            if(palindrome(s,i,k)){
                int an=1+fn(k+1,s,dp);
                min=Math.min(an,min);
            }
        }

        return dp[i]=min;
    }
    public int minCut(String s) {
        int[] dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return fn(0,s,dp);
    }
}