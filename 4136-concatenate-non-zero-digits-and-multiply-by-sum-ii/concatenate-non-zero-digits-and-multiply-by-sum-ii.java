class Solution {

    static final int MOD = 1000000007;

    public int[] sumAndMultiply(String s, int[][] queries) {

        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        HashMap<Integer, Integer> prefixCount = new HashMap<>();
        HashMap<Integer, Long> prefixValue = new HashMap<>();
        int n = s.length();
        long[] pow10 = new long[n + 1];
        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }
        int sum = 0;
        int cnt = 0;
        long value = 0;

        for (int i = 0; i < n; i++) {

            int d = s.charAt(i) - '0';

            if (d != 0) {
                value = (value * 10 + d) % MOD;
                sum += d;
                cnt++;
            }
            prefixSum.put(i, sum);
            prefixCount.put(i, cnt);
            prefixValue.put(i, value);
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            int digitSum;
            int digits;
            long x;

            if (l == 0) {
                digitSum = prefixSum.get(r);
                digits = prefixCount.get(r);
                x = prefixValue.get(r);
            } else {
                digitSum = prefixSum.get(r) - prefixSum.get(l - 1);
                digits = prefixCount.get(r) - prefixCount.get(l - 1);

                x = (prefixValue.get(r)
                        - (prefixValue.get(l - 1) * pow10[digits]) % MOD
                        + MOD) % MOD;
            }

            ans[i] = (int) ((x * digitSum) % MOD);
        }

        return ans;
    }
}