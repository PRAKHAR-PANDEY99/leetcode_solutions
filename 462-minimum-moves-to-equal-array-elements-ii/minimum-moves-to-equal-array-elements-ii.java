class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid=nums.length/2;
        int mid2=0;
        if(nums.length%2==0){
            mid2=mid-1;
        }
        int min=0;
        int min2=0;
        for(int i=0;i<nums.length;i++){
            int a=Math.abs(nums[i]-nums[mid]);
            int b=Math.abs(nums[i]-nums[mid2]);
            min=min+a;
            min2=min2+b;
        }
        if(mid2==0){
            return min;
        }
        else{
            return Math.min(min,min2);
        }
        
    }
}