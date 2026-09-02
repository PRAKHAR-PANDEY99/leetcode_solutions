class Solution {
    class Pair{
        int n;
        int freq;
        Pair(int n , int freq){
            this.n=n;
            this.freq=freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<Integer> list=new ArrayList<>();
        // for(int key:map.keySet()){
        //     if(map.get(key)>=k){
        //         list.add(key);
        //     }
        // }
       PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for(int key: map.keySet()){
            q.offer(new Pair(key,map.get(key)));
        }
        int i=0;
        while(!q.isEmpty()){
            if(i==k){
                break;
            }
            Pair pp=q.poll();
            list.add(pp.n);
            i=i+1;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();

        
    }
}