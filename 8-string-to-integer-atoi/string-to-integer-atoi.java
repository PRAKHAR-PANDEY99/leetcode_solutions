class Solution {

    static String atoi(String s, int c, String h, int j) {

        if (c == s.length())
            return h;

        // skip spaces only before number starts
        else if (s.charAt(c) == ' ' && h.length() == 0) {
            c++;
            return atoi(s, c, h, j);
        }

        // minus sign
        else if (s.charAt(c) == '-' && j == 0 && h.length() == 0) {
            h = h + '-';
            c++;
            j = 1;
            return atoi(s, c, h, j);
        }

        // plus sign
        else if (s.charAt(c) == '+' && j == 0 && h.length() == 0) {
            h = h + '+';
            c++;
            j = 1;
            return atoi(s, c, h, j);
        }

        // digit
        else if (Character.isDigit(s.charAt(c))) {
            h = h + s.charAt(c);
            c++;
            j = 1;
            return atoi(s, c, h, j);
        }

        // stop
        else {
            return h;
        }
    }


    public int myAtoi(String s) {

        String ans = atoi(s, 0, "", 0);

        if (ans.length() == 0 || ans.equals("-") || ans.equals("+"))
            return 0;

        boolean neg = ans.charAt(0) == '-';

        int start = (neg || ans.charAt(0) == '+') ? 1 : 0;

        long num = 0;

        for (int i = start; i < ans.length(); i++) {

            int digit = ans.charAt(i) - '0';

            if (num > (Integer.MAX_VALUE - digit) / 10) {
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            num = num * 10 + digit;
        }

        return neg ? (int)(-num) : (int)num;
    }
}