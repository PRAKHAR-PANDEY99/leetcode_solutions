class Solution {
    public int longestOnes(int[] nums, int k) {
        int c=0;
        int max=0;
        int len=0;
        int l=0;
        int r=0;
        int count=0;
        while(r<nums.length){
            if(nums[r]==0) c++;
            if(c>k){
                if(nums[l]==0){
                    c--;
                }
                l++;
            }
            if(c<=k){
                len=r-l+1;
                max=Math.max(max,len);
                
            }
            r++;
        }
        return max;
    }
}