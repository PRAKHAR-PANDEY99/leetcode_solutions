class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
        }
        if(sum%2!=0) return false;
        int target=sum/2;
        boolean[][] dp=new boolean[nums.length][target+1];
        for(int i=0;i<nums.length;i++){
            dp[i][0]=true;
        }
        if(nums[0]<=target){
            dp[0][nums[0]]=true;
        }
        for(int i=1;i<nums.length;i++){
            for(int targett=1;targett<=target;targett++){
                boolean Nottake=dp[i-1][targett];
                boolean take=false;
                if(nums[i]<=targett){
                    take=dp[i-1][targett-nums[i]];
                }
                dp[i][targett]=Nottake || take;
            }
        }
        return dp[nums.length-1][target];
    }
}