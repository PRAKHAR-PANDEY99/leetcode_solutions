class Solution {
    int[][] dp;

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        dp = new int[words.length][words.length + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, -1, words);
    }

    int solve(int i, int prev, String[] words) {
        if (i == words.length) {
            return 0;
        }

        if (dp[i][prev + 1] != -1) {
            return dp[i][prev + 1];
        }

        int notTake = solve(i + 1, prev, words);

        int take = 0;

        if (prev == -1 || valid(words[prev], words[i])) {
            take = 1 + solve(i + 1, i, words);
        }

        return dp[i][prev + 1] = Math.max(take, notTake);
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