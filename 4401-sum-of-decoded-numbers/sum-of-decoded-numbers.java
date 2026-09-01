
class Solution {

    public int sumDecoded(long[] nums) {
        long sum = 0;
        long MOD = 1000000007L;
        for (int i = 0; i < nums.length; i++) {
            long wid = nums[i] % 10;
            int length = String.valueOf(nums[i]).length();
            long upto = 1;
            for (int j = 0; j < length - wid; j++) {
                upto *= 10;
            }
            long num = nums[i] / 10;
            long last = nums[i] % upto;
            last = last / 10;
            long first = nums[i] / upto;
            long ans = power(first, last, MOD);
            sum = (sum + ans) % MOD;
        }

        return (int) sum;
    }

    public long power(long first, long last, long MOD) {

        long ans = 1;

        while (last > 0) {

            if (last % 2 == 1) {
                ans = (ans * first) % MOD;
            }

            first = (first * first) % MOD;
            last = last / 2;
        }

        return ans;
    }
}
