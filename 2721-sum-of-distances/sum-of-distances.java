class Solution {
    public long[] distance(int[] nums) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                map.put(nums[i], new ArrayList<>());
                map.get(nums[i]).add(i);
            }
        }

        long[] ans = new long[nums.length];

        for(int j=0;j<nums.length;j++){
            if(map.get(nums[j]) != null && map.get(nums[j]).size()==1){
                ans[j]=0;
            }
            else if(map.get(nums[j])==null){
                int c=1;
            }
            else{
                List<Long> list=new ArrayList<>();
                List<Integer> list1=map.get(nums[j]);

                long sum=0;
                for(int k=0;k<list1.size();k++){
                    sum = sum + list1.get(k);
                    list.add(sum);    
                }

                for(int h=0;h<list1.size();h++){
                    long left = 0;
                    if(h > 0){
                        left = (long)list1.get(h) * h - list.get(h-1);
                    }

                    long right = (sum - list.get(h)) 
                               - (long)list1.get(h) * (list1.size() - h - 1);

                    long a = left + right;

                    ans[list1.get(h)] = a;
                    map.put(nums[j], new ArrayList<>());
                }
            }
        }
        return ans;
    }
}