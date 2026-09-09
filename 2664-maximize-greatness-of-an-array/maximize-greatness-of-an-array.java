class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int j=1;
        int c=0;
        while(i<nums.length && j<nums.length){
            if(nums[i]<nums[j]){
                i++;
                c++;
                j++;
            }
            else if(nums[i]==nums[j]){
                j++;
            }
            else{
                i++;
            }

        }
        return c;
        
    }
}