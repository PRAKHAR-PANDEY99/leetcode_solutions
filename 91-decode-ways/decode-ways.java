import java.util.Arrays;

class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);

        return f(0, s, dp);
    }

    public int f(int i, String s, int[] dp) {
        if (i == s.length()) {
            return 1;
        }

        if (s.charAt(i) == '0') {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }
        int ways = 0;
        ways += f(i + 1, s, dp);
        if (i + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(i, i + 2));
            if (num >= 10 && num <= 26) {
                ways += f(i + 2, s, dp);
            }
        }
        return dp[i] = ways;
    }
}