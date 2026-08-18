class Solution {
    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int prev = nums[0];
        int prev2 = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length - 1; i++) {
            int take = nums[i];

            if (i > 1) {
                take = take + prev2;
            }

            int nottake = prev;

            int curr = Math.max(take, nottake);

            prev2 = prev;
            prev = curr;
        }

        max = Math.max(max, prev);
        prev = nums[1];
        prev2 = 0;

        for (int i = 2; i < nums.length; i++) {
            int take = nums[i];

            if (i > 1) {
                take = take + prev2;
            }

            int nottake = prev;

            int curr = Math.max(take, nottake);

            prev2 = prev;
            prev = curr;
        }

        return Math.max(max, prev);
    }
}