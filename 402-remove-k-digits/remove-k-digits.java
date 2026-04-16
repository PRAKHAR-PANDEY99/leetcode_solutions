import java.util.*;

class Solution {
    public String removeKdigits(String num, int k) {

        Stack<Integer> st = new Stack<>();

        if (k >= num.length()) {
            return "0";
        }

        st.push(num.charAt(0) - '0');

        for (int i = 1; i < num.length(); i++) {
            int cur = num.charAt(i) - '0';
            while (!st.isEmpty() && k > 0 && st.peek() > cur) {
                st.pop();
                k--;
            }

            st.push(cur);
        }
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for (int x : st) {
            sb.append(x);
        }
        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }

        String res = sb.substring(i);

        return res.length() == 0 ? "0" : res;
    }
}