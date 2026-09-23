class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int n = words.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int prev = i - 1; prev >= -1; prev--) {

                int notTake = dp[i + 1][prev + 1];

                int take = 0;

                if (prev == -1 || valid(words[prev], words[i])) {
                    take = 1 + dp[i + 1][i + 1];
                }

                dp[i][prev + 1] = Math.max(take, notTake);
            }
        }

        return dp[0][0];
    }

    boolean valid(String s, String t) {
        if (t.length() != s.length() + 1) {
            return false;
        }

        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }

            j++;
        }

        return i == s.length();
    }
}