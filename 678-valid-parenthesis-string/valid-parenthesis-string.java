class Solution {
    public boolean checkValidString(String s) {

        Stack<Integer> st = new Stack<>();
        Stack<Integer> ste = new Stack<>();  

        for(int i = 0; i < s.length(); i++) {

            char x = s.charAt(i);

            if(x == '(') {
                st.push(i);
            }
            else if(x == '*') {
                ste.push(i);
            }
            else {

                if(!st.isEmpty()) {
                    st.pop();
                }
                else if(!ste.isEmpty()) {
                    ste.pop();
                }
                else {
                    return false;
                }
            }
        }
        while(!st.isEmpty() && !ste.isEmpty()) {

            if(st.pop() > ste.pop()) {
                return false;
            }
        }

        return st.isEmpty();
    }
}