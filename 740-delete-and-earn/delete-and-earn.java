class Solution {
    int fn(int i,int[] points,int[] dp){
        if(i>=points.length){
            return 0;
        }

        if(dp[i]!=-1){
            return dp[i];
        }

        int take=points[i]+fn(i+2,points,dp);
        int nottake=fn(i+1,points,dp);

        return dp[i]=Math.max(take,nottake);
    }

    public int deleteAndEarn(int[] nums){
        int max=0;
        for(int n:nums){
            max=Math.max(max,n);
        }

        int[] points=new int[max+1];

        for(int n:nums){
            points[n]+=n;
        }

        int[] dp=new int[max+1];
        Arrays.fill(dp,-1);

        return fn(1,points,dp);
    }
}