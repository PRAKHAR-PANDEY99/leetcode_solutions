import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        if (reservedSeats.length == 0) {
            return 2 * n;
        }

        Arrays.sort(reservedSeats, (a, b) -> Integer.compare(a[0], b[0]));

        HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        int prevRow = reservedSeats[0][0];

        ans += (prevRow - 1) * 2;

        for (int i = 0; i < reservedSeats.length; i++) {

            if (reservedSeats[i][0] != prevRow) {

                boolean left = !set.contains(2) && !set.contains(3)
                        && !set.contains(4) && !set.contains(5);

                boolean middle = !set.contains(4) && !set.contains(5)
                        && !set.contains(6) && !set.contains(7);

                boolean right = !set.contains(6) && !set.contains(7)
                        && !set.contains(8) && !set.contains(9);

                if (left && right) {
                    ans += 2;
                } else if (left || middle || right) {
                    ans += 1;
                }

                int currRow = reservedSeats[i][0];

                ans += (currRow - prevRow - 1) * 2;

                set.clear();
                prevRow = currRow;
            }

            set.add(reservedSeats[i][1]);
        }

        boolean left = !set.contains(2) && !set.contains(3)
                && !set.contains(4) && !set.contains(5);

        boolean middle = !set.contains(4) && !set.contains(5)
                && !set.contains(6) && !set.contains(7);

        boolean right = !set.contains(6) && !set.contains(7)
                && !set.contains(8) && !set.contains(9);

        if (left && right) {
            ans += 2;
        } else if (left || middle || right) {
            ans += 1;
        }

        ans += (n - prevRow) * 2;

        return ans;
    }
}