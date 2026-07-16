class Solution {

    long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public long gcdSum(int[] nums) {
        long max = nums[0];
        long[] pre = new long[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
            long ans = gcd(nums[i], max);
            pre[i] = ans;
        }

        Arrays.sort(pre);

        int j = 0;
        int k = pre.length - 1;
        long finall = 0;

        while (j < k) {
            long anss = gcd(pre[j], pre[k]);
            finall += anss;
            j++;
            k--;
        }

        return finall;
    }
}