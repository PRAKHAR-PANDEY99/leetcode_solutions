class Solution {
    public int[] singleNumber(int[] nums) {
        int b1=0;
        int b2=0;
        int xor=0;
        for(int i=0;i<nums.length;i++){
            xor=xor^nums[i];
        }
        int rightmost=(xor & xor-1)^xor;
        for(int j=0;j<nums.length;j++){
            if((nums[j] & rightmost)!=0){
                b1=b1^nums[j];
            }
            else{
                b2=b2^nums[j];
            }

        }
        return new int[]{b1,b2};
        
        
    }
}