class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Character> st=new Stack<>();
        Stack<Integer> st2=new Stack<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push('(');
                st2.push(0);
            }
            else{
                st.pop();

                int a=st2.pop();

                if(a==0){
                    a=1;
                }
                else{
                    a=a*2;
                }

                if(!st2.isEmpty()){
                    int b=st2.pop();
                    st2.push(b+a);
                }
                else{
                    st2.push(a);
                }
            }
        }

        return st2.pop();
    }
}