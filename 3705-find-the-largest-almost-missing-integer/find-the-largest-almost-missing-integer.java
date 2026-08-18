class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int max=-1;
        if(k>1 && k<nums.length){
            if(map.get(nums[0])==1){
                max=Math.max(max,nums[0]);
            }
            if(map.get(nums[nums.length-1])==1){
                max=Math.max(max,nums[nums.length-1]);
            }
        }
        else if(k==1){
            for(int i=0;i<nums.length;i++){
                if(map.get(nums[i])==1){
                    max=Math.max(nums[i],max);
                }
            }
        }
        else if(k==nums.length){
            for(int o=0;o<k;o++){
                max=Math.max(nums[o],max);
            }
        }
        return max;
    }
}