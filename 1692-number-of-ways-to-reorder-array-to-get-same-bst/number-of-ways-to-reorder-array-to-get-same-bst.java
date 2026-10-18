import java.util.*;

class Solution {
    static final long MOD=1000000007;
    long[][] dp;

    public int numOfWays(int[] nums) {
        int n=nums.length;
        dp=new long[n+1][n+1];

        for(int i=0;i<=n;i++){
            dp[i][0]=1;
            dp[i][i]=1;

            for(int j=1;j<i;j++){
                dp[i][j]=(dp[i-1][j-1]+dp[i-1][j])%MOD;
            }
        }

        ArrayList<Integer> arr=new ArrayList<>();
        for(int x:nums) arr.add(x);

        return (int)((solve(arr)-1+MOD)%MOD);
    }
    long solve(ArrayList<Integer> nums) {
        int n=nums.size();
        if(n<=2) return 1;
        int root=nums.get(0);
        ArrayList<Integer> left=new ArrayList<>();
        ArrayList<Integer> right=new ArrayList<>();
        for(int i=1;i<n;i++){
            if(nums.get(i)<root) left.add(nums.get(i));
            else right.add(nums.get(i));
        }
        long leftWays=solve(left);
        long rightWays=solve(right);
        long interleavings=dp[n-1][left.size()];
        return (((leftWays*rightWays)%MOD)*interleavings)%MOD;
    }
}