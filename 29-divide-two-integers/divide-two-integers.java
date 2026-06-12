class Solution {
    public int divide(int dividend, int divisor) {

        boolean t = true;
        if (dividend < 0 && divisor > 0) t = false;
        if (dividend > 0 && divisor < 0) t = false;

        if (dividend == divisor) return 1;
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        if (divisor == 1) return dividend;
        if (divisor == -1) return -dividend;

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        long ans = 0;

        while (n >= d) {
            int c = 0;
            while (n >= (d << (c + 1))) {
                c++;
            }

            ans += (1L << c);
            n -= (d << c);
        }

        if (t) return (int) ans;
        return (int) -ans;
    }
}