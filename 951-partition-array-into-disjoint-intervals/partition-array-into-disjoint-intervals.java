
class Solution {
    public int partitionDisjoint(int[] nums) {
        int n=nums.length;

        int[] max1=new int[n];
        int[] min2=new int[n];

        int m=nums[0];
        int m1=nums[n-1];

        for(int i=0;i<n;i++){
            max1[i]=Math.max(m,nums[i]);
            m=Math.max(m,nums[i]);
        }

        for(int i=n-1;i>=0;i--){
            min2[i]=Math.min(m1,nums[i]);
            m1=Math.min(m1,nums[i]);
        }

        for(int i=0;i<n-1;i++){
            if(max1[i]<=min2[i+1]){
                return i+1;
            }
        }

        return -1;
    }
}
