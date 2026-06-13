class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            else if(map.containsKey(nums[i]) && map.get(nums[i])==1){
                map.put(nums[i],2);
            }
            else if(map.containsKey(nums[i]) && map.get(nums[i])==2){
                map.remove(nums[i]);
            }

        }
int key = map.keySet().iterator().next();
return key;
        
    }
}