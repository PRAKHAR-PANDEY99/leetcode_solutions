class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        Stack<Integer> st=new Stack<>();
        for(int i=nums2.length-1;i>=0;i--){
            if(!st.isEmpty() && nums2[i]<st.peek()){
                map.put(nums2[i],st.peek());
                st.push(nums2[i]);
            }
            else if(st.isEmpty()){
                st.push(nums2[i]);
                map.put(nums2[i],-1);
            }
            else if(!st.isEmpty() && nums2[i]>st.peek()){
                while(!st.isEmpty() && nums2[i]>st.peek()){
                    st.pop();
                }
                if(st.isEmpty()){
                    st.push(nums2[i]);
                    map.put(nums2[i],-1);
                }
                else{
                    map.put(nums2[i],st.peek());
                    st.push(nums2[i]);

                }

            }
        }
        int[] arr=new int[nums1.length];
        for(int j=0;j<nums1.length;j++){
            arr[j]=map.get(nums1[j]);
        }
        return arr;
        
    }
}