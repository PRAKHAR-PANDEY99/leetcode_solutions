class Solution {
    public int totalFruit(int[] fruits) {
        int first = -1, second = -1;
        int lastCount = 0;
        int curr = 0;
        int max = 0;

        for (int x : fruits) {
            if (x == first || x == second) {
                curr++;
            } else {
                curr = lastCount + 1;
            }

            if (x == second) {
                lastCount++;
            } else {
                lastCount = 1;
            }

            if (x != second) {
                first = second;
                second = x;
            }

            max = Math.max(max, curr);
        }

        return max;
    }
}