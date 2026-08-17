class Solution {
    Boolean jump(int i, int[] stones, int k, Boolean[][] dp) {

        if (k <= 0) return false;

        if (i == stones.length - 1) return true;

        if (dp[i][k] != null) {
            return dp[i][k];
        }

        Boolean a = false;
        Boolean b = false;
        Boolean c = false;

        int newjump = k;
        int newjump1 = k - 1;
        int newjump2 = k + 1;

        for (int j = i + 1; j < stones.length; j++) {

            if (stones[j] == stones[i] + newjump) {
                a = jump(j, stones, newjump, dp);
            }

            if (newjump1 > 0 && stones[j] == stones[i] + newjump1) {
                b = jump(j, stones, newjump1, dp);
            }

            if (stones[j] == stones[i] + newjump2) {
                c = jump(j, stones, newjump2, dp);
            }

            if (a || b || c) {
                return dp[i][k] = true;
            }
        }

        return dp[i][k] = false;
    }

    public Boolean canCross(int[] stones) {

        if (stones.length < 2 || stones[1] != 1) {
            return false;
        }

        Boolean[][] dp = new Boolean[stones.length][stones.length + 1];

        return jump(1, stones, 1, dp);
    }
}