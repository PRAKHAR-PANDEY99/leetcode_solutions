class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        boolean t = false;
        for (int num : nums) {
            xor ^= num;
            if (num != 0) {
                t = true;
            }
        }
        if (xor != 0) {
            return nums.length;
        }

        if (!t) {
            return 0;
        }
        return nums.length - 1;
    }
}