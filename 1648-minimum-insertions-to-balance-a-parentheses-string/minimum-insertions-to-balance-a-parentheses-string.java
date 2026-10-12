
class Solution {
    public int minInsertions(String s) {
        Stack<Character> st=new Stack<>();
        int c=0;

        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='(') {
                st.push('(');
            }
            else {
                if(i+1<s.length() && s.charAt(i+1)==')') {
                    if(st.isEmpty()) {
                        c++;
                    }
                    else {
                        st.pop();
                    }
                    i++;
                }
                else {
                    if(st.isEmpty()) {
                        c+=2;
                    }
                    else {
                        c++;
                        st.pop();
                    }
                }
            }
        }

        return c+st.size()*2;
    }
}
