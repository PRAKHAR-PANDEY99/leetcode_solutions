class Solution {
    public int countCommas(int n) {
        String s = String.valueOf(n);
        int c = 1;

        if (s.length() < 4) {
            return 0;
        }
        else if (n >= 1000 && n < 10000) {
            return n - 999;
        }
        else if (n >= 10000 && n < 100000) {
            return 9000 + (n - 9999);
        }
        else {
            return 99000 + (n - 99999);
        }
    }
}