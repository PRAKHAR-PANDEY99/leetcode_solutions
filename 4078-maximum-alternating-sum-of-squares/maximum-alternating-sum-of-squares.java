class Solution {
    public long maxAlternatingSum(int[] nums) {
        int[] arr=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=Math.abs(nums[i]);
        }
        Arrays.sort(arr);
        long ans=0;
        for(int j=(nums.length/2);j<nums.length;j++){
            ans=ans+(long)(arr[j]*arr[j]);
        }
        for(int i=0;i<nums.length/2;i++){
            ans=ans-(long)(arr[i]*arr[i]);
        }
        return ans;
        
    }
}