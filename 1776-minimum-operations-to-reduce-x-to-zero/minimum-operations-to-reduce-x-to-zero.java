import java.util.*;

class Solution {
    public int minOperations(int[] nums, int x) {

        HashMap<Integer, Integer> map2 = new HashMap<>();

        int n = nums.length;
        int sum = 0;

        map2.put(0, n);

        for (int i = n - 1; i >= 0; i--) {
            sum += nums[i];
            map2.put(sum, i);
        }
        sum = 0;
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum == x) {
                count = Math.min(count, i + 1);
            }
            int sume = x - sum;
            if (map2.containsKey(sume) && map2.get(sume) > i) {
                int t = i + 1 + n - map2.get(sume);
                count = Math.min(count, t);
            }
        }
        sum = 0;

for (int i = n - 1; i >= 0; i--) {
    sum += nums[i];

    if (sum == x) {
        count = Math.min(count, n - i);
    }
}
        return count == Integer.MAX_VALUE ? -1 : count;
    }
}