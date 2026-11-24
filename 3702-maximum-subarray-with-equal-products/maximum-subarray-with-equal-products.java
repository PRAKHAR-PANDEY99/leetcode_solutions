
class Solution {
    public int maxLength(int[] nums) {
        int ans=0;

        for(int i=0;i<nums.length;i++){
            long prod=1;
            long lcm=1;
            long gcd=0;

            for(int j=i;j<nums.length;j++){
                prod*=nums[j];

                gcd=gcd(gcd,nums[j]);

                lcm=(lcm*nums[j])/gcd(lcm,nums[j]);

                if(prod==lcm*gcd){
                    ans=Math.max(ans,j-i+1);
                }
            }
        }

        return ans;
    }

    public long gcd(long a,long b){
        while(b!=0){
            long temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}
