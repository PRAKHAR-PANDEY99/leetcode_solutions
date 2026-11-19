class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int ans1= nums[nums.length-1]-nums[2];
        int ans2=nums[nums.length-3]-nums[0];
        int ans=nums[nums.length-2]-nums[1];
        ans1= Math.min(ans1,ans2);
        return Math.min(ans1,ans);

    }
}