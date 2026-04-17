class Solution {
    static int[] leftMax(Stack<Integer> st,int[] arr,int [] nums){
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nums[i]=-1;
                st.push(i);
            }
            else{
                nums[i]=st.peek();
            }
            st.push(i); 
        }
        return nums;
    }
    static int[] rightMax(Stack<Integer> st,int[] arr,int [] nums2){
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nums2[i]=arr.length;
                st.push(i);
            }
            else{
                nums2[i]=st.peek();
            }
            st.push(i); 
        }
        return nums2;
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        Stack<Integer> st2=new Stack<>();
        int [] nums1=new int[heights.length];
        int [] nums2=new int[heights.length];
        nums1=leftMax(st,heights,nums1);
        nums2=rightMax(st2,heights,nums2);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            int a=(i-nums1[i])*heights[i];
            int b=(nums2[i]-i) *heights[i];
            int c=a+b-heights[i];
            max=Math.max(max,c);
        }
        return max;

        
    }
}