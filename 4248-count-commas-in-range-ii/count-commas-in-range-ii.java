class Solution {
    public long countCommas(long n) {
        long total = 0;
        long start = 1000;
        while (start <= n) {
            long end = start * 10 - 1;
            if (end > n) {
                end = n;
            }
            long digits = String.valueOf(start).length();
            long comma = (digits - 1) / 3;
            long numbers = end - start + 1;
            total += numbers * comma;
            start *= 10;
        }
        return total;
    }
}