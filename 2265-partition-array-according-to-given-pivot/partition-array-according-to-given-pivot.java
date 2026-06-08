class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        List<Integer> list3=new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot){
                list.add(nums[i]);
            }
            else if(nums[i]==pivot){
                list2.add(nums[i]);   
            }
            else{
                list3.add(nums[i]);
            }

        }
        list4.addAll(list);
        list4.addAll(list2);
        list4.addAll(list3);
        for (int j = 0; j < list4.size(); j++) {
            nums[j]=list4.get(j);
            }   
        return nums;
    }
}