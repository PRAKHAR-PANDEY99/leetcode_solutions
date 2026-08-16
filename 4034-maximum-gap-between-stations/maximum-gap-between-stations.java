class Solution {
    public int maximumGap(String skill, String station) {
        int[] left = new int[skill.length()];

        int j = 0;
        for (int i = 0; i < skill.length(); i++) {
            while (station.charAt(j) != skill.charAt(i)) {
                j++;
            }
            left[i] = j;
            j++;
        }

        int ans = 0;
        int k = skill.length() - 1;

        for (int i = station.length() - 1; i >= 0 && k >= 0; i--) {
            if (station.charAt(i) == skill.charAt(k)) {
                if (k > 0) {
                    ans = Math.max(ans, i - left[k - 1]);
                }
                k--;
            }
        }

        return ans;
    }
}