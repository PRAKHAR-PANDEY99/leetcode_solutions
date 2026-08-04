class Solution {
    public List<Integer> findMissingElements(int[] nums) {
       Arrays.sort(nums);
       List<Integer> list=new ArrayList<>();
       int c=nums[0];
       int i=0;
       while(i<nums.length){
        if(c!=nums[i]){
            list.add(c);
            c=c+1;
        }
        else{
            i++;
            c++;
        }
       }
       return list;
    }
}