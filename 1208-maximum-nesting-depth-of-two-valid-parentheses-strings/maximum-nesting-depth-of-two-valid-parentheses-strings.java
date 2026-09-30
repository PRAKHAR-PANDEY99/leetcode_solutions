class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        Stack<Integer> st=new Stack<>();
        st.push(0);
        int[] nums=new int[seq.length()];
        nums[0]=0;

        for(int i=1;i<seq.length();i++){
            if(seq.charAt(i)=='(' && st.peek()==0){
                st.push(1);
                nums[i]=1;
            }
            else if(seq.charAt(i)=='(' && st.peek()==1){
                st.push(0);
                nums[i]=0;
            }
            else if(seq.charAt(i)==')' && st.peek()==1){
                nums[i]=1;
                st.pop();
            }
            else if(seq.charAt(i)==')' && st.peek()==0){
                nums[i]=0;
                if(st.size()>1){
                    st.pop();
                }
            }
        }

        return nums;
    }
}