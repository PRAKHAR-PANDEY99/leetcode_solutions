class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0];
        int x2 = rec1[2];
        int y1 = rec1[1];
        int y2 = rec1[3];

        boolean x = false;
        boolean y = false;

        if (rec2[0] < x2 && rec2[2] > x1) {
            x = true;
        }

        if (rec2[1] < y2 && rec2[3] > y1) {
            y = true;
        }

        return x && y;
    }
}