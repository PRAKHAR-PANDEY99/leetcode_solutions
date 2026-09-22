class Solution {

    int binarySearch(int[] dp, int len, int num) {
        int low = 0;
        int high = len;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (dp[mid] < num) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for (int num : nums) {

            if (len == 0 || num > dp[len - 1]) {
                dp[len] = num;
                len++;
            } else {
                int index = binarySearch(dp, len, num);
                dp[index] = num;
            }
        }

        return len;
    }
}