class Solution {
    public double angleClock(int hour, int minutes) {
        double x = minutes / 12.0;

        if (hour == 12) {
            hour = 0;
        }

        double hourPosition = (hour * 5.0) + x;

        double diff = Math.abs(hourPosition - minutes);

        double angle = diff * 6.0;

        if (angle > 180) {
            angle = 360 - angle;
        }

        return angle;
    }
}