class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int l = 0, count = 0, last = 0;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            if (map.get(nums[i]) == 1) {
                last = 0;
            }

            while (map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }

            while (map.size() == k && map.get(nums[l]) > 1) {
                map.put(nums[l], map.get(nums[l]) - 1);
                l++;
                last++;
            }

            if (map.size() == k) {
                count += last + 1;
            }
        }

        return count;
    }
}