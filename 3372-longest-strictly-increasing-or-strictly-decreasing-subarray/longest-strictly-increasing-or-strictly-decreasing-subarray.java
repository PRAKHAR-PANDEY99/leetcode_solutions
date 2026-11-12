
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int c1=1;
        int c2=1;
        int max1=1;
        int max2=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                c2++;
                c1=1;
                max2=Math.max(max2,c2);
            }
            else if(nums[i]>nums[i-1]){
                c1++;
                c2=1;
                max1=Math.max(max1,c1);
            }
            else{
                c1=1;
                c2=1;
            }
        }
        return Math.max(max1,max2);
    }
}
