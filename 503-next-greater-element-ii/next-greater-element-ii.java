class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int [] arr=new int[nums.length];
        Stack<Integer> st=new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            st.push(nums[i]); 
        }
        for(int i=nums.length-1;i>=0;i--){
            if(!st.isEmpty() && nums[i]<st.peek()){
                int o=nums[i];
                nums[i]=st.peek();
                st.push(o);
            }
            else if(st.isEmpty()){
                st.push(nums[i]);
                nums[i]=-1;
            }
            else if(!st.isEmpty() && nums[i]>=st.peek()){
                while(!st.isEmpty() && nums[i]>=st.peek()){
                    st.pop();
                }
                if(st.isEmpty()){
                    st.push(nums[i]);
                    nums[i]=-1;
                }
                else{
                    int k=nums[i];
                    nums[i]=st.peek();
                    st.push(k);
                    

                }

            }
        }
        return nums;
        
    }
}