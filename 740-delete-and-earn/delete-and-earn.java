class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int max=0;

        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+n);
            max=Math.max(max,n);
        }
        int[] dp=new int[max+1];
        dp[1]=map.getOrDefault(1,0);
        for(int i=2;i<=max;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+map.getOrDefault(i,0));
        }

        return dp[max];
    }
}