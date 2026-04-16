import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        // build map
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        List<Integer> ans = new ArrayList<>();

        for (int j = 0; j < queries.length; j++) {
            int idx = queries[j];
            List<Integer> list = map.get(nums[idx]);

            // if only one occurrence
            if (list.size() == 1) {
                ans.add(-1);
                continue;
            }

            // binary search to find position of idx in list
            int low = 0, high = list.size() - 1;
            int pos = -1;

            while (low <= high) {
                int mid = (low + high) / 2;

                if (list.get(mid) == idx) {
                    pos = mid;
                    break;
                } else if (list.get(mid) < idx) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            int minDist = Integer.MAX_VALUE;
int n = nums.length;

// left neighbor
int left = list.get((pos - 1 + list.size()) % list.size());
int diff1 = Math.abs(idx - left);
minDist = Math.min(minDist, Math.min(diff1, n - diff1));

// right neighbor
int right = list.get((pos + 1) % list.size());
int diff2 = Math.abs(idx - right);
minDist = Math.min(minDist, Math.min(diff2, n - diff2));
            ans.add(minDist);
        }

        return ans;
    }
}