class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] nums=arr.clone();
        Arrays.sort(nums);
        int i=0;
        int c=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        HashMap<Integer,Integer> map2=new HashMap<>();
        while(i<arr.length){
            if(arr[i]!=nums[i]){
                if(map2.containsKey(arr[i])){
                    map2.put(arr[i],map2.get(arr[i])-1);
                    if(map2.get(arr[i])==0) map2.remove(arr[i]);
                }
                else{
                    map.put(arr[i],map.getOrDefault(arr[i],0)+1);
                }

                if(map.containsKey(nums[i])){
                    map.put(nums[i],map.get(nums[i])-1);
                    if(map.get(nums[i])==0) map.remove(nums[i]);
                }
                else{
                    map2.put(nums[i],map2.getOrDefault(nums[i],0)+1);
                }
            }
            else if(arr[i]==nums[i] && map.isEmpty() && map2.isEmpty()){
                c++;
            }
            if(arr[i]!=nums[i] && map.isEmpty() && map2.isEmpty()){
                c++;
            }

            i++;
        }
        return c;
    }
}