class Solution {
    boolean sum(int[] nums,int i,int target,int[][] dp){
        if(target==0) return true;
        if(i==0) return nums[i]==target;
        boolean t=false;
        boolean nt=false;
        if(dp[i][target]!=-1){
            return dp[i][target]==1;
        }
        nt=sum(nums,i-1,target,dp);
        if(target>=nums[i]){
            t=sum(nums,i-1,target-nums[i],dp);
        }
        dp[i][target]=(t || nt) ? 1:0;
        return (t || nt);
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        int[][] dp=new int[nums.length][sum/2+1];
        int target=sum/2;
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i],-1);
        }
        boolean ans=sum(nums,nums.length-1,target,dp);
        return ans;

        
    }
}