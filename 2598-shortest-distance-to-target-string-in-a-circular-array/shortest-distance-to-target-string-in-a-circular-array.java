class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;

        int i = startIndex;
        int j = startIndex;

        int leftDist = Integer.MAX_VALUE;
        int rightDist = Integer.MAX_VALUE;

        // 🔹 Reverse (left)
        int step = 0;
        while (step < n) {
            if (words[i].equals(target)) {
                leftDist = step;
                break;
            }
            i--;
            if (i < 0) i = n - 1;
            step++;
        }

        // 🔹 Forward (right)
        step = 0;
        while (step < n) {
            if (words[j].equals(target)) {
                rightDist = step;
                break;
            }
            j++;
            if (j == n) j = 0;
            step++;
        }

        int ans = Math.min(leftDist, rightDist);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}