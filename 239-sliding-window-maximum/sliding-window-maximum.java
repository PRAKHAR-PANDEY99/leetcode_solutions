class Solution {
    static List<Integer> max(int [] nums, int k){
        List<Integer> list=new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            if(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.removeFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(i>=k-1) list.add(nums[dq.peekFirst()]);
        }
        return list;
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list=max(nums,k);
        int [] arr=new int [nums.length-k+1];
        for(int i=0;i<arr.length;i++){
            arr[i]=list.get(i);
        }
        return arr;
       
        
    }
}