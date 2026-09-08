class Solution {
    int sum(int[] nums, int target, int i, int[][] dp, int offset) {
        if(i==nums.length-1){
            if(target==0 && nums[i]==0) return 2;
            else if(target-nums[i]==0 || target+nums[i]==0) return 1;
            return 0;
        }
        int index = target + offset;
        if (dp[i][index] != Integer.MIN_VALUE) {
            return dp[i][index];
        }
        int takePositive = 0;
        int takeNegative = 0;
        takePositive = sum(nums, target - nums[i], i + 1, dp, offset);
        takeNegative = sum(nums, target + nums[i], i + 1, dp, offset);
        return dp[i][index] = takePositive + takeNegative;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        if (Math.abs(target) > sum) {
            return 0;
        }
        int offset = sum-target;
        int[][] dp = new int[nums.length][2 * sum + 1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        int ans = sum(nums, target, 0, dp, offset);
        return ans;
    }
}

