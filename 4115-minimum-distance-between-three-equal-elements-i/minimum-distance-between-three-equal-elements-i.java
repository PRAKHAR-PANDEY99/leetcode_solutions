import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        HashMap<Integer, String> map1 = new HashMap<>();

        for (int j = 0; j < nums.length; j++) {
            if (map.get(nums[j]) >= 3) {
                if (map1.containsKey(nums[j])) {
                    map1.put(nums[j], map1.get(nums[j]) + "," + j);
                } else {
                    map1.put(nums[j], "" + j);
                }
            }
        }

        int max = Integer.MAX_VALUE;

        for (int k = 0; k < nums.length; k++) {
            if (map1.containsKey(nums[k])) {
                String s = map1.get(nums[k]);

                if (s.split(",").length >= 3) {
                    int val = chk(s);
                    max = Math.min(max, val);
                }
            }
        }

        return max == Integer.MAX_VALUE ? -1 : max;
    }

   static int chk(String s) {
    String[] parts = s.split(",");
    int min = Integer.MAX_VALUE;

    for (int i = 0; i <= parts.length - 3; i++) {
        int a = Integer.parseInt(parts[i]);
        int c = Integer.parseInt(parts[i + 2]);
        min = Math.min(min, c - a);
    }

    return min * 2;
   }
}