class Solution {
    int count(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        int total = 0;
        for (int i = 1; i <= n; i++) {
            int left = count(i - 1);
            int right = count(n - i);
            total += left * right;
        }
        return total;
    }
    public int numTrees(int n) {
        return count(n);
    }
}