class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st=new Stack<>();
        int c1=0;
        int c2=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push('(');
            }
            else{
                if(st.isEmpty()){
                    c1++;
                }
                else{
                    st.pop();
                }
            }
        }
        return c1+st.size();

        
    }
}