class Solution {
    public int removeDuplicates(int[] nums) {
        int c=1;
        int count=0;
        int prev=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==prev){
                c=c+1;
                if(c>2){
                    count++;
                    nums[i]=Integer.MAX_VALUE;
                }
            }
            else{
                c=1;
                prev=nums[i];

            }

        }
        Arrays.sort(nums);
        return nums.length-count;
        
    }
}