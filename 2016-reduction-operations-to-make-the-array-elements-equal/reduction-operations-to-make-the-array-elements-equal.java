class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int i=nums.length-1;
        int g=0;
        int c=1;
        while(i>0){
            if(nums[i]==nums[i-1]){
                c=c+1;
    
            }
            else{ 
                g=g+c;
                c=c+1;
            }
            i--;

        }
        return g;
        
    }
}