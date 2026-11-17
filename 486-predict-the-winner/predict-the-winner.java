class Solution {
    int fn(int i,int j,int[] nums){
        if(i>j){
            return 0;
        }
        if(i==j) return nums[i];
        int takei=0;
        int takej=0;
        int takei1=nums[i]+fn(i+2,j,nums);
        int takei2=nums[i]+fn(i+1,j-1,nums);
        takei=Math.min(takei1,takei2);
        int takej1=nums[j]+fn(i,j-2,nums);
        int takej2=nums[j]+fn(i+1,j-1,nums);
        takej=Math.min(takej1,takej2);
        return Math.max(takei,takej);

        
    }

    public boolean predictTheWinner(int[] nums) {
        int sum=0;
        if(nums.length<3){
            return true;
        }
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
        }
        int ans=fn(0,nums.length-1,nums);
        if(ans>=(sum-ans)){
            return true;
        }
        else return false;
        
    }
}