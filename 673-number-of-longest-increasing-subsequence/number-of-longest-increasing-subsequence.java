class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;

        int[] dp=new int[n];
        int[] count=new int[n];

        for(int i=0;i<n;i++){
            dp[i]=1;
            count[i]=1;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    int current=dp[j]+1;

                    if(current>dp[i]){
                        dp[i]=current;
                        count[i]=count[j];
                    }
                    else if(current==dp[i]){
                        count[i]+=count[j];
                    }
                }
            }
        }

        int maxLen=0;
        for(int i=0;i<n;i++){
            maxLen=Math.max(maxLen,dp[i]);
        }

        int ans=0;
        for(int i=0;i<n;i++){
            if(dp[i]==maxLen){
                ans+=count[i];
            }
        }

        return ans;
    }
}