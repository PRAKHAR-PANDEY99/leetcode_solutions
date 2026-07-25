class Solution {
    public int maxProduct(int n) {
        char[] arr = String.valueOf(n).toCharArray();

        int max = -1;
        int secondMax = -1;

        for (char c : arr) {
            int digit = c - '0';

            if (digit > max) {
                secondMax = max;
                max = digit;
            } else if (digit > secondMax) {
                secondMax = digit;
            }
        }

        return max * secondMax;
    }
}