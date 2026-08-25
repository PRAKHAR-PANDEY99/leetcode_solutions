class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        for(int i =0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int l=2;
        int first=k;
        while(set.contains(first)){
            first=k*l;
            l++;
        }
        return first;
        
    }
}